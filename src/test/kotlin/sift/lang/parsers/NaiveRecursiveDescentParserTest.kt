package sift.lang.parsers

import sift.execution.Environment
import sift.lang.lexers.DirectCodedLexer
import sift.source.EmptySource
import sift.types.Field
import sift.types.Schema
import sift.types.Type

internal class NaiveRecursiveDescentParserTest {

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
        val parser = NaiveRecursiveDescentParser(env)
        val query = """
          'Families'
            |> SELECT gender = 'Male'
            |> GROUP MIN(age) -> youngest, MAX(age) -> oldest BY lastName
            |> PROJECT oldest - youngest -> gap
            |> SORT BY gap DESC
            |> LIMIT 5
        """.trimIndent()
        val tokens = lexer.tokenize(query)
        val plan = parser.parse(tokens)
        println(plan.pretty())
    }

    @org.junit.jupiter.api.Test
    fun simple2() {
        val src = EmptySource(
            "Foo",
            Schema(
                listOf(
                    Field("A", Type.Num),
                    Field("B", Type.Num),
                )
            )
        )
        val env = Environment()
        env.registerSource(src)
        val lexer = DirectCodedLexer()
        val parser = NaiveRecursiveDescentParser(env)
        val query = """
          'Foo'
            |> SELECT A >= B
            |> PROJECT A * B -> Z
            |> SELECT Z > 5
        """.trimIndent()
        val tokens = lexer.tokenize(query)
        val plan = parser.parse(tokens)
        println(plan.pretty())
    }
}
