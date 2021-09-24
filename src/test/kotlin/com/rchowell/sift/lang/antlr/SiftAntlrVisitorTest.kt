package com.rchowell.sift.lang.antlr

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.shell.data.pets
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.Tree
import org.antlr.v4.runtime.tree.Trees
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class SiftAntlrVisitorTest {

    @Test
    fun test() {
        val env = Environment(listOf(pets))
        val query = """
            Pets
            |> SELECT 100 * 100
        """.trimIndent()
        val input = ByteArrayInputStream(query.toByteArray(Charsets.UTF_8))
        val lexer = SiftLexer(CharStreams.fromStream(input))
        val tokens = CommonTokenStream(lexer)
        val parser = SiftParser(tokens)
        val tree = parser.query()
        println("==== Tokens ====")
        tokens.tokens.forEach {
            val type = SiftLexer.VOCABULARY.getDisplayName(it.type)
            System.out.printf("%s: %s\n", type, it.text)
        }
        println()

        println("==== Tree ====")
        println(tree.format(parser))
        println()

        println("==== Plan ====")
        val visitor = SiftAntlrVisitor(env)
        val plan = visitor.visit(tree)
        println(plan.pretty())
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
