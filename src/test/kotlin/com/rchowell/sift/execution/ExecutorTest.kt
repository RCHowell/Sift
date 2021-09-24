package com.rchowell.sift.execution

import org.junit.jupiter.api.Test
import com.rchowell.sift.shell.data.pets

internal class ExecutorTest {

    @Test
    fun sift() {
        val env = Environment()
        env.registerSource(pets)

        // Execute the query
        Executor.sift(
            env,
            """
           'Pets'
             |> GROUP MAX(Weight) -> Thiccest BY Gender, Type
            """.trimIndent()
        )
    }
}
