package com.rchowell.sift.execution.physical.expressions

import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Column

class ColumnExpr(val i: Int) : Expression {

    override fun eval(batch: Batch): Column {
        return batch.columns[i]
    }
}
