package sift.lang.parsers

import sift.execution.Environment
import sift.lang.lexers.DirectCodedLexer
import sift.source.EmptySource

internal class NaiveRecursiveDescentParserTest {

    @org.junit.jupiter.api.Test
    fun simple() {
        val env = Environment()
        env.registerSource("A", EmptySource("A"))
        val lexer = DirectCodedLexer()
        val parser = NaiveRecursiveDescentParser(env)
        val query = """
            A
            |> SELECT firstName = 'John' && age > 21.0
            |> PROJECT x / 10 -> x, y * 2 -> yeven, z + 3 -> zeee
        """.trimIndent()
        val tokens = lexer.tokenize(query)
        val plan = parser.parse(tokens)
        println(plan.pretty())
    }
}
