package sift.execution.physical.sifterators

import org.junit.jupiter.api.Test
import sift.execution.physical.aggregations.AvgAccumulator
import sift.execution.physical.aggregations.CountAccumulator
import sift.execution.physical.aggregations.MaxAccumulator
import sift.execution.physical.aggregations.MinAccumulator
import sift.execution.physical.aggregations.SumAccumulator
import sift.source.MemSource
import sift.types.Batch
import sift.types.Column
import sift.types.Field
import sift.types.NumVectorColumn
import sift.types.Schema
import sift.types.Type

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
