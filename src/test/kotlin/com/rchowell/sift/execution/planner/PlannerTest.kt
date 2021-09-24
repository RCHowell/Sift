package com.rchowell.sift.execution.planner

import org.junit.jupiter.api.Test
import com.rchowell.sift.execution.Environment
import com.rchowell.sift.lang.lexers.DirectCodedLexer
import com.rchowell.sift.lang.parsers.rd.RecursiveDescentParser
import com.rchowell.sift.source.EmptySource
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type

internal class PlannerTest {

    @Test
    fun plan() {
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
          'Families' |> SELECT gender = 'Male' |> PROJECT age / 10 -> decades
        """.trimIndent()
        val tokens = lexer.tokenize(query)
        val plan = parser.parse(tokens)
        val physicalPlan = Planner.plan(plan)
        println(physicalPlan)
    }
}
