package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalExpr
import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.execution.logical.expressions.LogicalIdentifierExpr
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema

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
    val input: LogicalTransform,
    val projections: Map<LogicalIdentifierExpr, LogicalExpr>,
) : LogicalTransform() {

    /**
     * Each expression describes its output field, so the Schema produced by this
     * projection is just the combination of all field types when evaluated on the given input plan.
     */
    override val schema: Schema = Schema(projections.entries.map { (k, v) -> Field(k.identifier, v.toField(input).type) })

    override fun inputs(): List<LogicalTransform> = listOf(input)

    override fun toString(): String = buildString {
        append("PROJECT ")
        append(projections.entries.joinToString { (alias, expr) -> "$expr -> $alias" })
    }
}
