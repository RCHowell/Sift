package sift.execution.logical.plans

import sift.execution.logical.LogicalExpr
import sift.execution.logical.LogicalPlan
import sift.types.Field
import sift.types.Schema

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
    private val lhs: LogicalPlan,
    private val rhs: LogicalPlan,
    private val condition: LogicalExpr?,
    private val type: JoinType,
) : LogicalPlan() {

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

    override fun inputs(): List<LogicalPlan> = listOf(lhs, rhs)

    override fun pretty(): String = if (condition == null) "$type JOIN" else "$type JOIN ON $condition"
}
