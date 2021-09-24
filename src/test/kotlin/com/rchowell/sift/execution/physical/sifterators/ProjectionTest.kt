package com.rchowell.sift.execution.physical.sifterators

import org.junit.jupiter.api.Test
import com.rchowell.sift.execution.physical.expressions.AddExpr
import com.rchowell.sift.execution.physical.expressions.ColumnExpr
import com.rchowell.sift.execution.physical.expressions.MulExpr
import com.rchowell.sift.source.MemSource
import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Column
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.NumVectorColumn
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type

class ProjectionTest {

    @Test
    fun foo() {
        val xs = Column.VectorFactory.numeric(listOf(1.0, 2.0, 3.0))
        val ys = Column.VectorFactory.numeric(listOf(2.0, 4.0, 6.0))
        val zs = Column.VectorFactory.numeric(listOf(3.0, 5.0, 9.0))
        val schema = Schema(
            listOf(
                Field("x", Type.Num),
                Field("y", Type.Num),
                Field("z", Type.Num),
            )
        )
        val source = MemSource(
            identifier = "Foo",
            schema = schema,
            data = listOf(
                Batch(
                    schema,
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
            input = Scan(source, listOf("x", "y", "z")),
            schema = Schema(
                listOf(
                    Field("x", Type.Num),
                )
            )
        )
        projection.open()
        val batch = projection.next()
    }
}
