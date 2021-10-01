package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.types.Schema

class LogicalIntersect(
    val lhs: LogicalTransform,
    val rhs: LogicalTransform,
) : LogicalTransform() {

    override var schema: Schema = Schema.common(lhs.schema, rhs.schema)

    override fun inputs(): List<LogicalTransform> = listOf(lhs, rhs)

    override fun pretty(): String = buildString {
        append('(').append(lhs.pretty()).append(')')
        append("\n&\n")
        append('(').append(rhs.pretty()).append(')')
    }

    override fun toString(): String = "INTERSECT"
}
