package com.rchowell.sift.execution.physical.expressions

import org.junit.jupiter.api.Test
import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Column
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.NumVectorColumn
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type

internal class PhysicalAddExprTest {

    @Test
    fun eval() {
        val schema = Schema(listOf(
            Field("xs", Type.Num),
            Field("ys", Type.Num),
        ))
        val xs = Column.VectorFactory.numeric(3)
        xs[0] = 1.0
        xs[1] = 2.0
        xs[2] = 3.0
        xs.valueCount = 3
        val ys = Column.VectorFactory.numeric(3)
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
