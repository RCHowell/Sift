package com.rchowell.sift.lang.antlr

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.source.EmptySource
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type
import org.junit.jupiter.api.Test

class SiftAntlrTest {

    @Test
    fun test() {
        val source = EmptySource(
            identifier = "Test",
            schema = Schema(
                listOf(
                    Field("a", Type.Num),
                    Field("b", Type.String),
                    Field("c", Type.Bool),
                )
            )
        )
        val env = Environment(listOf(source))
        val query = """
            Test
            |> SELECT a > 100 && b = "foo"
            |> DISTINCT
            |> PROJECT a, b, c > 50 -> Old
            |> GROUP SUM(a), AVG(b) -> x
            |> SORT x DESC
            |> LIMIT 50
        """.trimIndent()
        val compiler = SiftCompiler(env)
        compiler.describe(query, verbose = true)
    }
}
