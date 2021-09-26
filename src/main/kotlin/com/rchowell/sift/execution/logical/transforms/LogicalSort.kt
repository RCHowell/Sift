package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.execution.logical.expressions.LogicalIdentifierExpr
import com.rchowell.sift.types.Schema

/**
 * LogicalSort describes an ASC or DESC sort based on a list of identifiers
 *
 * @property input
 * @property asc
 * @property fields
 * @constructor Create empty Logical sort
 */
class LogicalSort(
    private val input: LogicalTransform,
    private val fields: List<LogicalIdentifierExpr>,
    private val asc: Boolean,
) : LogicalTransform() {

    /**
     * Sorting does not change schema
     */
    override val schema: Schema = input.schema

    override fun inputs(): List<LogicalTransform> = listOf(input)

    override fun toString(): String = buildString {
        append("SORT ")
        if (fields.isNotEmpty()) {
            append(fields.joinToString())
            append(" ")
        }
        if (asc) append("ASC") else append("DESC")
    }
}
