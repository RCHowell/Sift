package sift.execution.physical.expressions

import sift.types.Batch
import sift.types.Column

interface Expression {
    fun eval(batch: Batch): Column
}
