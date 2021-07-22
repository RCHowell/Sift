package sift.lang.parsers

import sift.execution.Environment
import sift.execution.logical.LogicalExpr
import sift.execution.logical.LogicalPlan
import sift.execution.logical.expressions.BinaryOp
import sift.execution.logical.expressions.LogicalBinaryExpr
import sift.execution.logical.expressions.LogicalIdentifierExpr
import sift.execution.logical.expressions.LogicalLiteralExpr
import sift.execution.logical.functions.LogicalFunction
import sift.execution.logical.plans.LogicalScan
import sift.execution.logical.plans.LogicalSelection
import sift.lang.SiftParser
import sift.lang.Token
import sift.lang.TokenType

class InvalidSyntaxException(t: String) : Exception("syntax error: $t")

class RecursiveDescentParser(
    private val env: Environment,
) : SiftParser {

    lateinit var words: Array<Token<*>>
    var pointer = 0

    override fun parse(tokens: List<Token<*>>): LogicalPlan {
        words = tokens.toTypedArray()
        return query()
    }

    private fun query(): LogicalPlan {
        val scan = relationProduction()
        var prev = scan
        var next: LogicalPlan
        while (pointer < words.size) {
            val p = words[pointer++]
            if (p.type != TokenType.PIPE) throw InvalidSyntaxException("expected pipe where $p is")
            next = transform(prev)
            prev = next
        }
        return prev
    }

    private fun relationProduction(): LogicalPlan {
        val word = words[pointer++]
        return when (word.type) {
            TokenType.LEFT_PAREN -> {
                val subQuery = query()
                val rParen = words[pointer++]
                if (rParen.type != TokenType.RIGHT_PAREN) throw InvalidSyntaxException("expected closing paren at $rParen")
                return subQuery
            }
            TokenType.IDENTIFIER -> LogicalScan(source = env.getSource(word.value as String))
            else -> throw InvalidSyntaxException("at relation production: $word")
        }
    }

    private fun transform(input: LogicalPlan): LogicalPlan {
        val word = words[pointer++]
        if (word.type != TokenType.KEYWORD) throw InvalidSyntaxException("Expected keyword")
        return when (word.value.toString()) {
            "SELECT" -> select(input)
            else -> throw InvalidSyntaxException("Unknown transformation $word")
        }
    }

    private fun select(input: LogicalPlan): LogicalPlan =
        LogicalSelection(input, expression())

    private fun expression(): LogicalExpr {
        val word = words[pointer++]
        return when (word.type) {
            TokenType.LEFT_PAREN -> {
                val subExpr = expression()
                val rParen = words[pointer++]
                if (rParen.type != TokenType.RIGHT_PAREN) throw InvalidSyntaxException("expected closing paren at $rParen")
                subExpr
            }
            else -> {
                pointer-- // LEFT_PAREN lookahead did not match
                val fac = factor()
                if (pointer < words.size) {
                    val opToken = words[pointer]
                    if (opToken.type == TokenType.OPERATOR) {
                        pointer++
                        val rhs = expression()
                        val op = BinaryOp.get(opToken.value as String)
                        return LogicalBinaryExpr.get(op, fac, rhs)
                    }
                }
                // just a standalone factor
                fac
            }
        }
    }

    private fun factor(): LogicalExpr {
        val word = words[pointer++]
        return when (word.type) {
            TokenType.LITERAL -> when (word.value) {
                is String -> LogicalLiteralExpr(word.value)
                is Float -> LogicalLiteralExpr(word.value)
                is Int -> LogicalLiteralExpr(word.value)
                is Boolean -> LogicalLiteralExpr(word.value)
                else -> throw InvalidSyntaxException("unknown literal type ${word.value!!::class.java}")
            }
            TokenType.IDENTIFIER -> {
                // look ahead for "("
                val nextIndex = pointer + 1
                if (nextIndex < words.size && words[nextIndex].type != TokenType.LEFT_PAREN) {
                    return LogicalIdentifierExpr(word.value as String)
                }
                pointer++ // skip "("
                val arg = expression()
                val closeParen = words[pointer++]
                if (closeParen.type != TokenType.RIGHT_PAREN) {
                    throw InvalidSyntaxException("invalid ")
                }
                val funcName = word.value as String
                LogicalFunction.get(funcName, arg)
            }
            else -> throw InvalidSyntaxException("invalid factor in expression at $word")
        }
    }
}
