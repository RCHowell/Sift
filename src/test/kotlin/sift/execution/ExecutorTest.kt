package sift.execution

import org.junit.jupiter.api.Test
import sift.source.MemSource
import sift.types.Batch
import sift.types.BoolVectorColumn
import sift.types.Column
import sift.types.Field
import sift.types.NumVectorColumn
import sift.types.Schema
import sift.types.StringVectorColumn
import sift.types.Type

internal class ExecutorTest {

    @Test
    fun sift() {
        val source = MemSource(
            identifier = "Dogs",
            schema = Schema(
                listOf(
                    Field("name", Type.String),
                    Field("age", Type.Num),
                    Field("isMale", Type.Bool),
                )
            ),
            data = listOf(
                Batch(
                    listOf(
                        StringVectorColumn(
                            Column.Factory.string(
                                listOf(
                                    "Buddy",
                                    "Redbeard",
                                    "Daisy",
                                    "Ro",
                                    "Balto",
                                    "Mochi",
                                )
                            )
                        ),
                        NumVectorColumn(
                            Column.Factory.numeric(
                                listOf(
                                    13.0,
                                    11.0,
                                    3.0,
                                    2.0,
                                    15.0,
                                    2.0,
                                )
                            )
                        ),
                        BoolVectorColumn(
                            Column.Factory.boolean(
                                listOf(
                                    false,
                                    true,
                                    false,
                                    false,
                                    true,
                                    false,
                                )
                            )
                        )
                    )
                )
            )
        )
        val env = Environment()
        env.registerSource(source)

        // Execute the query
        Executor.sift(env, "'Dogs' |> SELECT age < 10 |> PROJECT 'Good gorl, ' + name -> greeting")
    }
}