package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.types.Schema

class LogicalUnion(
    val lhs: LogicalTransform,
    val rhs: LogicalTransform,
) : LogicalTransform() {

    override lateinit var schema: Schema

    override fun inputs(): List<LogicalTransform> = listOf(lhs, rhs)

    init {
        assert(lhs.schema == rhs.schema) {
            "Relations in union do not share a schema"
        }
        schema = lhs.schema
    }

    override fun pretty(): String = buildString {
        append('(').append(lhs.pretty()).append(')')
        append("\nU\n")
        append('(').append(rhs.pretty()).append(')')
    }

    override fun toString(): String = "UNION"
}
