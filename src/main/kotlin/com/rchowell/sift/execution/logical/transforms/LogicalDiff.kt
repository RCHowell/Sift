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
        assert(rhs.schema.subsetOf(lhs.schema)) {
            // But really? Need to look into this
            "Schema of right-side relation must be a subset of left-side relation in bag difference"
        }
        schema = lhs.schema
    }

    override fun pretty(): String = buildString {
        append('(').append(lhs.pretty()).append(')')
        append("\n-\n")
        append('(').append(rhs.pretty()).append(')')
    }

    override fun toString(): String = "DIFF"
}
