package com.rchowell.sift.lang.antlr

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.execution.logical.LogicalTransform
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.Tree
import org.antlr.v4.runtime.tree.Trees
import java.io.ByteArrayInputStream

class SiftCompiler(private val env: Environment) {

    fun compile(query: String): LogicalTransform {
        val tokens = lex(query)
        val parser = SiftParser(tokens)
        val tree = parser.query()
        val state = SiftVisitorBuildState(env)
        val visitor = SiftAntlrVisitor(state)
        visitor.visit(tree)
        return state.query()
    }

    fun describe(query: String, verbose: Boolean = false): QueryDescription {
        val tokens = lex(query)
        if (verbose) {
            tokens.tokens.forEach {
                val type = SiftLexer.VOCABULARY.getDisplayName(it.type)
                println(String.format("%s: %s\n", type, it.text))
            }
        }
        val parser = SiftParser(tokens)
        val tree = parser.query()
        if (verbose) println(tree.format(parser))
        val state = SiftVisitorBuildState(env)
        val visitor = SiftAntlrVisitor(state)
        visitor.visit(tree)
        if (verbose) println(state.query().pretty())
        return QueryDescription(
            tokens.tokens,
            parser,
            tree,
            state.query()
        )
    }

    fun lex(query: String): CommonTokenStream {
        val input = ByteArrayInputStream(query.toByteArray(Charsets.UTF_8))
        val lexer = SiftLexer(CharStreams.fromStream(input))
        return CommonTokenStream(lexer)
    }

    data class QueryDescription(
        val tokens: List<Token>,
        val parser: SiftParser,
        val ast: SiftParser.QueryContext,
        val plan: LogicalTransform,
    ) {
        override fun toString(): String = buildString {
            append("==== Tokens ====\n")
            tokens.forEach {
                val type = SiftLexer.VOCABULARY.getDisplayName(it.type)
                append(String.format("%s: %s\n", type, it.text))
            }
            append("==== Tree ====\n")
            append(ast.format(parser)).append('\n')
            append("==== Plan ====\n")
            append(plan.pretty())
        }
    }
}

fun Tree.format(parser: SiftParser, indent: Int = 0): String = buildString {
    val tree = this@format
    val prefix = "  ".repeat(indent)
    append(prefix)
    append(Trees.getNodeText(tree, parser))
    if (tree.childCount != 0) {
        append(" (\n")
        for (i in 0 until tree.childCount) {
            append(tree.getChild(i).format(parser, indent + 1))
            append("\n")
        }
        append(prefix).append(")")
    }
}