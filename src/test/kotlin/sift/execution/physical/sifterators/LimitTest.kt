package sift.execution.physical.sifterators

import org.junit.jupiter.api.Test
import sift.source.MemSource
import sift.types.Batch
import sift.types.Column
import sift.types.Field
import sift.types.Schema
import sift.types.Type

internal class LimitTest {

    @Test
    internal fun basic() {
        val schema = Schema(
            listOf(
                Field("string", Type.String),
                Field("num", Type.Num),
                Field("bool", Type.Bool),
            )
        )
        val scan = Scan(
            source = MemSource(
                "Foo",
                schema = schema,
                data = listOf(
                    Batch(
                        schema = schema,
                        columns = listOf(
                            Column.Factory.string(listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")),
                            Column.Factory.numeric(listOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)),
                            Column.Factory.boolean(
                                listOf(
                                    true,
                                    true,
                                    true,
                                    true,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false,
                                    false
                                )
                            ),
                        ),
                    ),
                ),
            ),
            fields = listOf("string", "num", "bool")
        )
        val limit = 7
        val limitSifterator = Limit(scan, limit)
        limitSifterator.open()
        var batch = limitSifterator.next()
        while (batch != null) {
            println(batch)
            batch = limitSifterator.next()
        }
    }
}
