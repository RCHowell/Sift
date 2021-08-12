package sift.lang.parsers.rd

import sift.execution.Environment
import sift.execution.logical.LogicalExpr
import sift.execution.logical.LogicalPlan
import sift.execution.logical.expressions.BinaryOp
import sift.execution.logical.expressions.LogicalBinaryExpr
import sift.execution.logical.expressions.LogicalIdentifierExpr
import sift.execution.logical.expressions.LogicalLiteralExpr
import sift.execution.logical.plans.LogicalProjection
import sift.execution.logical.plans.LogicalScan
import sift.execution.logical.plans.LogicalSelection
import sift.lang.SiftParser
import sift.lang.Token
import sift.lang.TokenList
import sift.lang.TokenType
import sift.lang.parsers.InvalidSyntaxException

/**
 * Some improvement upon what I learned in the [NaiveRecursiveDescentParser].
 * Considering not including the environment with the parser so that a [LogicalScan] only holds an identifier to a source
 *
 * @constructor Create empty Recursive descent parser
 */
class RecursiveDescentParser(val environment: Environment) : SiftParser {

    lateinit var words: TokenList
    lateinit var query: LogicalPlan

    override fun parse(tokens: List<Token<*>>): LogicalPlan {
        words = TokenList(tokens)
        return query()
    }

    private fun error(expected: String, got: Any?): InvalidSyntaxException =
        InvalidSyntaxException("expected $expected, got $got at: \"${words.context()}\"")

    /**
     * A query is composed of a relation production and zero or more transformations.
     * Transformations are complete once there are no more pipe operators -- for now that's EOF or )
     *
     * @return
     */
    private fun query(): LogicalPlan {
        var prev = production()
        var curr = prev
        while (words.peek().type == TokenType.PIPE) {
            words.next() // eat the pipe operator
            curr = transform(prev)
            prev = curr
        }
        return curr
    }

    private fun production(): LogicalPlan {
        val word = words.next()
        return when (word.type) {
            // TODO these must be infix
            TokenType.KEYWORD -> {
                when (word.value) {
                    "JOIN" -> TODO()
                    "CROSS" -> TODO()
                    "UNION" -> TODO()
                    "DIFF" -> TODO()
                    "INTERSECT" -> TODO()
                    else -> throw error("relation production", word.value)
                }
            }
            TokenType.LEFT_PAREN -> {
                val subquery = query()
                consume(TokenType.RIGHT_PAREN)
                subquery
            }
            TokenType.LITERAL -> {
                when (word.value) {
                    is String -> LogicalScan(environment.getSource(word.value))
                    else -> throw error("relation identifier must be a string")
                }
            }
            else -> throw error("relation production", word)
        }
    }

    private fun transform(input: LogicalPlan): LogicalPlan {
        val word = words.next()
        if (word.type != TokenType.KEYWORD) throw error("keyword", word.value)
        return when (word.value as String) {
            "SELECT" -> select(input)
            "PROJECT" -> project(input)
            //            "GROUP" -> group(input)
            //            "SORT" -> sort(input)
            //            "LIMIT" -> limit(input)
            //            "DISTINCT" -> distinct(input)
            else -> throw InvalidSyntaxException("Unknown transformation $word")
        }
    }

    private fun select(input: LogicalPlan): LogicalPlan {
        val expression = expression()
        return LogicalSelection(input, expression)
    }

    /**
     * Really think about and test this.
     * - TODO function names
     */
    private fun expression(): LogicalExpr {

        val lhs: LogicalExpr

        // Expressions in parentheses
        if (words.peek().type == TokenType.LEFT_PAREN) {
            consume(TokenType.LEFT_PAREN)
            lhs = expression()
            consume(TokenType.RIGHT_PAREN)
        } else {
            lhs = factor()
        }

        return if (words.peek().type == TokenType.OPERATOR) {
            val op = words.next()
            operator(op.value as String, lhs = lhs, rhs = expression())
        } else {
            lhs
        }
    }

    private fun factor(): LogicalExpr {
        val word = words.next()
        return when (word.type) {
            TokenType.LITERAL -> when (word.value) {
                is String -> LogicalLiteralExpr(word.value)
                is Number -> LogicalLiteralExpr(word.value.toDouble())
                is Boolean -> LogicalLiteralExpr(word.value)
                else -> throw error("literal type", word.javaClass)
            }
            TokenType.IDENTIFIER -> LogicalIdentifierExpr(word.value as String)
            else -> throw error("factor", word)
        }
    }

    private fun operator(op: String, lhs: LogicalExpr, rhs: LogicalExpr): LogicalExpr {
        val binop = BinaryOp.get(op)
        return LogicalBinaryExpr.get(binop, lhs, rhs)
    }

    private fun project(input: LogicalPlan): LogicalPlan {
        val projections = mutableMapOf<LogicalIdentifierExpr, LogicalExpr>()
        while (true) {
            val (expr, ident) = func()
            projections[ident] = expr
            val nextWord = words.peek()
            if (nextWord.type == TokenType.PIPE || nextWord.type == TokenType.EOF) {
                return LogicalProjection(input, projections)
            }
            consume(TokenType.COMMA)
        }
    }

    /**
     * Returns the [LogicalExpr] -> [LogicalIdentifierExpr] pair. Handles the identity projection as well.
     *
     * @return
     */
    private fun func(): Pair<LogicalExpr, LogicalIdentifierExpr> {
        val expr = expression()

        // Shorthand identity projection
        if (expr is LogicalIdentifierExpr && words.peek().type != TokenType.MAPSTO) {
            return Pair(expr, expr)
        }

        // Other than a shorthand identity, functions must use -> symbol
        var word = words.next()
        if (word.type != TokenType.MAPSTO) {
            throw error("->", word.value)
        }

        word = words.next()
        if (word.type != TokenType.IDENTIFIER) {
            throw error("identifier", word)
        }
        return Pair(expr, LogicalIdentifierExpr(word.value as String))
    }

    /**
     * Consumes a Token of the specified type, else throws an error
     */
    private fun consume(type: TokenType) {
        val word = words.next()
        if (word.type != type) throw error(type.toString(), word.value)
    }

}
