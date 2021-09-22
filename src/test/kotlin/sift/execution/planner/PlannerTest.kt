package sift.execution.planner

import org.junit.jupiter.api.Test
import sift.execution.Environment
import sift.lang.lexers.DirectCodedLexer
import sift.lang.parsers.rd.RecursiveDescentParser
import sift.source.EmptySource
import sift.types.Field
import sift.types.Schema
import sift.types.Type

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
