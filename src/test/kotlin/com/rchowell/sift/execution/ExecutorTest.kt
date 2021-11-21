package com.rchowell.sift.execution

import com.rchowell.sift.shell.data.pets
import org.junit.jupiter.api.Test

internal class ExecutorTest {

    @Test
    fun sift() {
        val env = Environment()
        env.registerSource(pets)

        // Execute the query
        Executor.sift(
            env,
            """
           `Pets`
             |> group MAX(Weight) by Gender, Type
            """.trimIndent()
        )
    }
}
