package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.execution.logical.expressions.LogicalIdentifierExpr
import com.rchowell.sift.types.Schema

/**
 * Duplicate elimination extension which converts a bag to a set.
 */
class LogicalDistinct(
    private val input: LogicalTransform,
    private val identifiers: List<LogicalIdentifierExpr>
) : LogicalTransform() {

    override val schema: Schema = input.schema

    override fun inputs(): List<LogicalTransform> = listOf(input)

    fun fields(): List<Int> = identifiers.map {
        schema.fieldIndexes[it.identifier]!!
    }

    override fun toString(): String = "DISTINCT (" + identifiers.joinToString { it.identifier } + ")"
}
