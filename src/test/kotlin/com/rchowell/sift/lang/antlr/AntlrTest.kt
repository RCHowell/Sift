package com.rchowell.sift.lang.antlr

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class AntlrTest {

    @Test
    fun test() {
        val query = """
            Table
            |> SELECT 100 * 100
        """.trimIndent()
        val input = ByteArrayInputStream(query.toByteArray(Charsets.UTF_8))
        val lexer = SiftLexer(CharStreams.fromStream(input))
        val tokens = CommonTokenStream(lexer)
        val parser = SiftParser(tokens)
        val tree = parser.query()
        tokens.tokens.forEach {
            val type = SiftLexer.VOCABULARY.getDisplayName(it.type)
            System.out.printf("%s: %s\n", type, it.text)
        }
        println(tree.toStringTree(parser))
    }
}
