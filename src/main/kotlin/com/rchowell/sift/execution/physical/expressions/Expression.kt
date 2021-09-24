package com.rchowell.sift.execution.physical.expressions

import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Column

interface Expression {
    fun eval(batch: Batch): Column
}
