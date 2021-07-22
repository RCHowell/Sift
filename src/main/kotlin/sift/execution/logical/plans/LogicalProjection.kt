package sift.execution.logical.plans

import sift.execution.logical.LogicalExpr
import sift.execution.logical.LogicalPlan
import sift.types.Schema

/**
 * Extended projection gives additional power to the projection operator.
 *  In addition to projecting out some columns, in its generalized form it can perform computations involving
 *  the columns of its argument relation to produce new columns. p213
 *
 * @property input
 * @property expr
 * @constructor Create empty Logical projection
 */
class LogicalProjection(
    private val input: LogicalPlan,
    private val projs: Map<String, LogicalExpr>,
) : LogicalPlan {

    /**
     * From Andy Grove's KQuery. Each expression describes its output field, so the Schema produced by this
     * projection is just the combination of all field types when evaluated on the given input plan.
     */
    override val schema: Schema = Schema(projs.entries.map { (k, v) -> v.toField(input) })

    override fun inputs(): List<LogicalPlan> = listOf(input)

    override fun toString(): String = buildString {
        append("PROJECT")
        projs.entries.forEach { (k, v) -> append(" (").append(v).append(" AS ").append(k).append(") ") }
    }
}
