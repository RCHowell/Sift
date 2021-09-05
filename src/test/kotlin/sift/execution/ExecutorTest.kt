package sift.execution

import org.junit.jupiter.api.Test
import sift.shell.data.pets

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
