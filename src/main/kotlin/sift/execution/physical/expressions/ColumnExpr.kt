package sift.execution.physical.expressions

import sift.types.Batch
import sift.types.Column

class ColumnExpr(val i: Int) : Expression {

    override fun eval(batch: Batch): Column {
        return batch.columns[i]
    }
}
