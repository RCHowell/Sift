package sift.execution.physical.sifterators

import org.junit.jupiter.api.Test
import sift.execution.physical.expressions.ColumnExpr
import sift.execution.physical.expressions.GtBinaryExpr
import sift.execution.physical.expressions.GteBinaryExpr
import sift.execution.physical.expressions.LiteralExpr
import sift.execution.physical.expressions.MulExpr
import sift.source.MemSource
import sift.types.Batch
import sift.types.Column
import sift.types.Field
import sift.types.NumVectorColumn
import sift.types.Schema
import sift.types.Type

internal class SelectionTest {

    @Test
    operator fun next() {

        val schema = Schema(
            listOf(
                Field("a", Type.Num),
                Field("b", Type.Num),
            )
        )
        val source = MemSource(
            identifier = "Foo",
            schema = schema,
            data = listOf(
                Batch(
                    schema,
                    listOf(
                        NumVectorColumn(Column.VectorFactory.numeric(listOf(1.0, 2.0, 3.0, 4.0, 8.0, 1.0))),
                        NumVectorColumn(Column.VectorFactory.numeric(listOf(4.0, 3.0, 2.0, 1.0, 3.0, 2.0))),
                    )
                )
            )
        )

        val sifter = Selection(
            input = Projection(
                input = Selection(
                    input = Scan(source, listOf("a", "b")),
                    GteBinaryExpr(ColumnExpr(0), ColumnExpr(1)),
                ),
                projections = mapOf(
                    0 to MulExpr(ColumnExpr(0), ColumnExpr(1)),
                    1 to MulExpr(ColumnExpr(0), ColumnExpr(1)) // TODO fix how Selection changes output schema
                ),
                schema = schema,
            ),
            predicateBinary = GtBinaryExpr(
                lhs = ColumnExpr(0),
                rhs = LiteralExpr(5)
            ),
        )

        // run it
        sifter.open()
        val batch = sifter.next()
        println(batch)
    }
}
