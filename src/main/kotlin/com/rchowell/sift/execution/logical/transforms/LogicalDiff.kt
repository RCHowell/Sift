package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.types.Schema

class LogicalDiff(
    val lhs: LogicalTransform,
    val rhs: LogicalTransform,
) : LogicalTransform() {

    override lateinit var schema: Schema

    override fun inputs(): List<LogicalTransform> = listOf(lhs, rhs)

    init {
        schema = lhs.schema
    }

    override fun pretty(): String = buildString {
        append('(').append(lhs.pretty()).append(')')
        append("\n-\n")
        append('(').append(rhs.pretty()).append(')')
    }

    override fun toString(): String = "DIFF"
}
