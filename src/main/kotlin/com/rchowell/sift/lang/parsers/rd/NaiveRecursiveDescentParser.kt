package com.rchowell.sift.lang.parsers

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.execution.logical.LogicalExpr
import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.execution.logical.expressions.BinaryOp
import com.rchowell.sift.execution.logical.expressions.LogicalAggregateExpr
import com.rchowell.sift.execution.logical.expressions.LogicalBinaryExpr
import com.rchowell.sift.execution.logical.expressions.LogicalIdentifierExpr
import com.rchowell.sift.execution.logical.expressions.LogicalLiteralExpr
import com.rchowell.sift.execution.logical.functions.LogicalFunction
import com.rchowell.sift.execution.logical.transforms.LogicalAggregation
import com.rchowell.sift.execution.logical.transforms.LogicalDistinct
import com.rchowell.sift.execution.logical.transforms.LogicalLimit
import com.rchowell.sift.execution.logical.transforms.LogicalProjection
import com.rchowell.sift.execution.logical.transforms.LogicalScan
import com.rchowell.sift.execution.logical.transforms.LogicalSelection
import com.rchowell.sift.execution.logical.transforms.LogicalSort
import com.rchowell.sift.lang.SiftParser
import com.rchowell.sift.lang.Token
import com.rchowell.sift.lang.TokenType

class InvalidSyntaxException(t: String) : Exception("syntax error: $t")

class NaiveRecursiveDescentParser(
    private val env: Environment,
) : SiftParser {

    lateinit var words: Array<Token<*>>
    var pointer = 0

    override fun parse(tokens: List<Token<*>>): LogicalTransform {
        words = tokens.toTypedArray()
        return query()
    }

    private fun query(): LogicalTransform {
        val scan = relationProduction()
        var prev = scan
        var next: LogicalTransform
        while (pointer < words.size) {
            val p = words[pointer++]
            if (p.type != TokenType.PIPE) throw InvalidSyntaxException("expected pipe where $p is")
            next = transform(prev)
            prev = next
        }
        return prev
    }

    private fun relationProduction(): LogicalTransform {
        val word = words[pointer++]
        return when (word.type) {
            TokenType.LEFT_PAREN -> {
                val subQuery = query()
                val rParen = words[pointer++]
                if (rParen.type != TokenType.RIGHT_PAREN) throw InvalidSyntaxException("expected closing paren at $rParen")
                subQuery
            }
            TokenType.LITERAL -> {
                if (word.value is String) {
                    LogicalScan(source = env.getSource(word.value))
                } else {
                    throw InvalidSyntaxException("non-string literal is not a relation")
                }
            }
            else -> throw InvalidSyntaxException("at relation production: $word")
        }
    }

    private fun transform(input: LogicalTransform): LogicalTransform {
        val word = words[pointer++]
        if (word.type != TokenType.KEYWORD) throw InvalidSyntaxException("Expected keyword")
        return when (word.value.toString()) {
            "SELECT" -> select(input)
            "PROJECT" -> project(input)
            "GROUP" -> group(input)
            "SORT" -> sort(input)
            "LIMIT" -> limit(input)
            "DISTINCT" -> LogicalDistinct(input)
            else -> throw InvalidSyntaxException("Unknown transformation $word")
        }
    }

    private fun select(input: LogicalTransform): LogicalTransform =
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
                    throw InvalidSyntaxException("expected closing paren at $word")
                }
                val funcName = word.value as String
                LogicalFunction.get(funcName, arg)
            }
            else -> throw InvalidSyntaxException("invalid factor in expression at $word")
        }
    }

    private fun project(input: LogicalTransform): LogicalTransform {
        val projections = mutableMapOf<LogicalIdentifierExpr, LogicalExpr>()
        while (true) {
            val (fExpr, fProj) = func()
            projections[fProj] = fExpr
            if (pointer >= words.size || words[pointer].type != TokenType.COMMA) {
                return LogicalProjection(input, projections)
            }
            pointer++
        }
    }

    private fun func(): Pair<LogicalExpr, LogicalIdentifierExpr> {
        val expr = expression()
        if (words[pointer].type != TokenType.MAPSTO) throw InvalidSyntaxException("expected ->")
        pointer++
        val alias = words[pointer++]
        if (alias.type != TokenType.IDENTIFIER) throw InvalidSyntaxException("projection key must be an identifier")
        return Pair(expr, LogicalIdentifierExpr(alias.value as String))
    }

    private fun group(input: LogicalTransform): LogicalTransform {
        val aggs = aggs()
        val groups = mutableListOf<LogicalIdentifierExpr>()
        if (pointer < words.size) {
            val nextWord = words[pointer]
            if (nextWord.type == TokenType.KEYWORD && nextWord.value == "BY") {
                pointer++
                groups.addAll(ids())
            }
        }
        return LogicalAggregation(input, aggs, groups)
    }

    private fun aggs(): Map<LogicalIdentifierExpr, LogicalAggregateExpr> {
        val aggs = mutableMapOf<LogicalIdentifierExpr, LogicalAggregateExpr>()
        while (true) {
            val (agg, alias) = agg()
            aggs[alias] = agg
            if (pointer >= words.size || words[pointer].type != TokenType.COMMA) {
                break
            }
            pointer++
        }
        return aggs
    }

    private fun agg(): Pair<LogicalAggregateExpr, LogicalIdentifierExpr> {
        val aggFunc = words[pointer++]
        if (aggFunc.type != TokenType.IDENTIFIER) throw InvalidSyntaxException("expected identifier at $aggFunc")
        lParen()
        val expr = expression()
        rParen()
        val agg = LogicalAggregateExpr.get(aggFunc.value as String, expr)
        val alias = alias()
        return Pair(agg, alias)
    }

    private fun lParen() {
        val w = words[pointer++]
        if (w.type != TokenType.LEFT_PAREN) throw InvalidSyntaxException("expected ( at $w")
    }

    private fun rParen() {
        val w = words[pointer++]
        if (w.type != TokenType.RIGHT_PAREN) throw InvalidSyntaxException("expected ) at $w")
    }

    private fun alias(): LogicalIdentifierExpr {
        val asKeyword = words[pointer++]
        if (asKeyword.type != TokenType.MAPSTO) throw InvalidSyntaxException("expected AS at $asKeyword")
        val alias = words[pointer++]
        if (alias.type != TokenType.IDENTIFIER) throw InvalidSyntaxException("expected identifier at $alias")
        return LogicalIdentifierExpr(alias.value as String)
    }

    private fun ids(): Collection<LogicalIdentifierExpr> {
        val ids = mutableListOf<LogicalIdentifierExpr>()
        while (true) {
            val id = words[pointer++]
            if (id.type != TokenType.IDENTIFIER) throw InvalidSyntaxException("expected identifier at $id")
            ids.add(LogicalIdentifierExpr(id.value as String))
            if (pointer >= words.size || words[pointer].type != TokenType.COMMA) {
                break
            }
            pointer++
        }
        return ids
    }

    private fun limit(input: LogicalTransform): LogicalTransform {
        val n = words[pointer++]
        if (n.type != TokenType.LITERAL || n.value !is Int) throw InvalidSyntaxException("expected integer at $n")
        return LogicalLimit(input, n.value)
    }

    private fun sort(input: LogicalTransform): LogicalTransform {
        var asc = true
        var next = words[pointer++]
        val fields = mutableListOf<LogicalIdentifierExpr>()
        if (next.type != TokenType.KEYWORD) throw InvalidSyntaxException("expected keyword at $next")
        if (next.value == "BY") {
            fields.addAll(ids())
            next = words[pointer++]
        }
        asc = when (next.value) {
            "ASC" -> true
            "DESC" -> false
            else -> throw InvalidSyntaxException("at $next")
        }
        return LogicalSort(input, asc, fields)
    }
}
