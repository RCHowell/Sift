package sift.execution.physical.expressions

import org.junit.jupiter.api.Test
import sift.types.Batch
import sift.types.Column
import sift.types.Field
import sift.types.NumVectorColumn
import sift.types.Schema
import sift.types.Type

internal class PhysicalAddExprTest {

    @Test
    fun eval() {
        val schema = Schema(listOf(
            Field("xs", Type.Num),
            Field("ys", Type.Num),
        ))
        val xs = Column.Factory.numeric(3)
        xs[0] = 1.0
        xs[1] = 2.0
        xs[2] = 3.0
        xs.valueCount = 3
        val ys = Column.Factory.numeric(3)
        ys[0] = 4.0
        ys[1] = 5.0
        ys[2] = 6.0
        ys.valueCount = 3
        val batch = Batch(schema, listOf(NumVectorColumn(xs), NumVectorColumn(ys)))
        val lhs = ColumnExpr(0)
        val rhs = ColumnExpr(1)
        val expr = AddExpr(lhs, rhs)
        val res = expr.eval(batch)
        println(res)
    }
}
