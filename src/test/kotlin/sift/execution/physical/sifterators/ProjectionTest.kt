package sift.execution.physical.sifterators

import org.junit.jupiter.api.Test
import sift.execution.physical.expressions.AddExpr
import sift.execution.physical.expressions.ColumnExpr
import sift.execution.physical.expressions.MulExpr
import sift.source.MemSource
import sift.types.Batch
import sift.types.Column
import sift.types.Field
import sift.types.NumVectorColumn
import sift.types.Schema
import sift.types.Type

class ProjectionTest {

    @Test
    fun foo() {
        val xs = Column.Factory.numeric(listOf(1.0, 2.0, 3.0))
        val ys = Column.Factory.numeric(listOf(2.0, 4.0, 6.0))
        val zs = Column.Factory.numeric(listOf(3.0, 5.0, 9.0))
        val source = MemSource(
            identifier = "Foo",
            schema = Schema(
                listOf(
                    Field("x", Type.Num),
                    Field("y", Type.Num),
                    Field("z", Type.Num),
                )
            ),
            data = listOf(
                Batch(
                    listOf(
                        NumVectorColumn(xs),
                        NumVectorColumn(ys),
                        NumVectorColumn(zs)
                    )
                )
            )
        )
        val projection = Projection(
            projections = mapOf(
                0 to AddExpr(
                    ColumnExpr(0),
                    ColumnExpr(1),
                ),
                1 to MulExpr(
                    ColumnExpr(2),
                    AddExpr(
                        ColumnExpr(0),
                        ColumnExpr(1),
                    ),
                ),
            ),
            input = Scan(source, listOf("x", "y", "z"))
        )
        projection.open()
        val batch = projection.next()
        println(batch)
    }
}
