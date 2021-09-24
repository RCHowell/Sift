package com.rchowell.sift.execution.physical.sifterators

import org.junit.jupiter.api.Test
import com.rchowell.sift.execution.physical.aggregations.AvgAccumulator
import com.rchowell.sift.execution.physical.aggregations.CountAccumulator
import com.rchowell.sift.execution.physical.aggregations.MaxAccumulator
import com.rchowell.sift.execution.physical.aggregations.MinAccumulator
import com.rchowell.sift.execution.physical.aggregations.SumAccumulator
import com.rchowell.sift.source.MemSource
import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Column
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.NumVectorColumn
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type

class AggregationTest {

    @Test
    fun aggregates() {
        val n = 1..100
        val schema = Schema(listOf(Field("xs", Type.Num)))
        val xs = Column.VectorFactory.numeric(n.map { it.toDouble() })
        val source = MemSource(
            identifier = "Foo",
            schema = Schema(listOf(Field("x", Type.Num))),
            data = listOf(Batch(schema, listOf(NumVectorColumn(xs))))
        )
        val aggregation = Aggregation(
            input = Scan(source, listOf("x")),
            aggregations = listOf(
                SumAccumulator(0),
                MinAccumulator(0),
                MaxAccumulator(0),
                CountAccumulator(0),
                AvgAccumulator(0),
            ),
            groups = listOf(),
            schema = Schema(
                listOf(
                    Field("sum", Type.Num),
                    Field("min", Type.Num),
                    Field("max", Type.Num),
                    Field("count", Type.Num),
                    Field("avg", Type.Num),
                )
            )
        )
        aggregation.open()
        val batch = aggregation.next()
        println(batch)
    }
}
