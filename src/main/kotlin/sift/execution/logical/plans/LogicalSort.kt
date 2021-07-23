package sift.execution.logical.plans

import sift.execution.logical.LogicalPlan
import sift.execution.logical.expressions.LogicalIdentifierExpr
import sift.types.Schema

/**
 * LogicalSort describes an ASC or DESC sort based on a list of identifiers
 *
 * @property input
 * @property asc
 * @property fields
 * @constructor Create empty Logical sort
 */
class LogicalSort(
    private val input: LogicalPlan,
    private val asc: Boolean,
    private val fields: List<LogicalIdentifierExpr>,
) : LogicalPlan {

    /**
     * Sorting does not change schema
     */
    override val schema: Schema = input.schema

    override fun inputs(): List<LogicalPlan> = listOf(input)

    override fun toString(): String = buildString {
        append("SORT ")
        if (fields.isNotEmpty()) {
            append(fields.joinToString())
            append(" ")
        }
        if (asc) append("ASC") else append("DESC")
    }
}
