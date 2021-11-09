package com.rchowell.sift.execution.physical.sifterators

import com.rchowell.sift.source.MemSource
import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Column
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type
import org.junit.jupiter.api.Test

class DistinctTest {

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
                            Column.Factory.string(listOf("a", "a", "a", "a", "b", "b")),
                            Column.Factory.numeric(listOf(1.0, 1.0, 2.0, 2.0, 1.0, 1.0)),
                            Column.Factory.boolean(
                                listOf(
                                    true,
                                    true,
                                    true,
                                    false,
                                    false,
                                    false,
                                )
                            ),
                        ),
                    ),
                ),
            ),
            fields = listOf("string", "num", "bool")
        )
        val op = Distinct(scan, listOf(0))
        op.open()
        var batch = op.next()
        while (batch != null) {
            println(batch)
            batch = op.next()
        }
    }
}
