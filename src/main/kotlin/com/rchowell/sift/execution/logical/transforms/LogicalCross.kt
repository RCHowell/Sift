package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.types.Schema

class LogicalCross(
    val lhs: LogicalTransform,
    val rhs: LogicalTransform,
) : LogicalTransform() {

    override var schema: Schema = lhs.schema.combine((rhs.schema))

    override fun inputs(): List<LogicalTransform> = listOf(lhs, rhs)

    override fun pretty(): String = buildString {
        append('(').append(lhs.pretty()).append(')')
        append("\nX\n")
        append('(').append(rhs.pretty()).append(')')
    }

    override fun toString(): String = "CROSS"
}
