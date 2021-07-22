package sift.lang.parsers

import sift.execution.Environment
import sift.lang.lexers.DirectCodedLexer
import sift.source.EmptySource

internal class RecursiveDescentParserTest {

    @org.junit.jupiter.api.Test
    fun simple() {
        val env = Environment()
        env.registerSource("A", EmptySource("A"))
        val lexer = DirectCodedLexer()
        val parser = RecursiveDescentParser(env)
        val query = "A |> SELECT firstName = 'John' && age > 21.0"
        val tokens = lexer.tokenize(query)
        val plan = parser.parse(tokens)
        println(plan.pretty())
    }
}
