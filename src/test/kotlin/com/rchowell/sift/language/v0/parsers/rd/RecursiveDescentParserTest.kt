package com.rchowell.sift.language.v0.parsers.rd

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.language.v0.lexers.DirectCodedLexer
import com.rchowell.sift.source.EmptySource
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type

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
            |> PROJECT age, height / 12 -> feet, height % 12 -> inches
            |> GROUP MAX(age) -> OldestAtHeight BY feet
            |> LIMIT 3
        """.trimIndent()
        val tokens = lexer.tokenize(query)
        val plan = parser.parse(tokens)
        println(plan.pretty())
    }
}
