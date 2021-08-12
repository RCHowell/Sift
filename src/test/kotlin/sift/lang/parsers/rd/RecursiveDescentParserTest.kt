package sift.lang.parsers.rd

import sift.execution.Environment
import sift.lang.lexers.DirectCodedLexer
import sift.source.EmptySource
import sift.types.Field
import sift.types.Schema
import sift.types.Type

internal class RecursiveDescentParserTest {

    @org.junit.jupiter.api.Test
    fun simple() {
        val src = EmptySource(
            "Families",
            Schema(
                listOf(
                    Field("firstName", Type.String),
                    Field("lastName", Type.String),
                    Field("gender", Type.String),
                    Field("age", Type.Num)
                )
            )
        )
        val env = Environment()
        env.registerSource(src)
        val lexer = DirectCodedLexer()
        val parser = RecursiveDescentParser(env)
        val query = """
          'Families'
            |> SELECT (gender = 'Male') && (age > 3)
            |> PROJECT gender, height / 12 -> feet, height % 12 -> inches
        """.trimIndent()
        val tokens = lexer.tokenize(query)
        val plan = parser.parse(tokens)
        println(plan.pretty())
    }
}
