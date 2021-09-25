package com.rchowell.sift.lang.antlr

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.shell.data.pets
import org.junit.jupiter.api.Test

class SiftAntlrTest {

    @Test
    fun test() {
        val env = Environment(listOf(pets))
        val query = """
            Pets
            |> SELECT 100
        """.trimIndent()
        val compiler = SiftCompiler(env)
        compiler.describe(query)
    }
}
