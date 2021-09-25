package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalExpr
import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema

enum class JoinType {
    INNER,
    OUTER,
    LEFT,
    RIGHT
}

/**
 * LogicalJoin represents the eight possible joins from natural and theta join conditions.
 *
 * @property lhs Left Relation
 * @property rhs Right Relation
 * @property condition Join condition. If empty, this is the natural join
 * @property type
 * @constructor Create empty Logical join
 */
class LogicalJoin(
    private val lhs: LogicalTransform,
    private val rhs: LogicalTransform,
    private val condition: LogicalExpr?,
    private val type: JoinType,
) : LogicalTransform() {

    /**
     * Schema of a join is the combination of the two schemas
     */
    override val schema: Schema
        get() {
            val fields = mutableSetOf<Field>()
            fields.addAll(lhs.schema.fields)
            fields.addAll(rhs.schema.fields)
            return Schema(fields.toList())
        }

    override fun inputs(): List<LogicalTransform> = listOf(lhs, rhs)

    override fun pretty(): String = if (condition == null) "$type JOIN" else "$type JOIN ON $condition"
}
