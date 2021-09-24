package com.rchowell.sift.execution.logical.plans

import com.rchowell.sift.execution.logical.LogicalExpr
import com.rchowell.sift.execution.logical.LogicalPlan
import com.rchowell.sift.types.Schema

/**
 * LogicalSelection represents a filter based on the given expression.
 * Separate from the LogicalScan because a filter/selection should be separate from the data source.
 *
 * @property input
 * @property expr
 * @constructor Create empty Logical selection
 */
class LogicalSelection(
    val input: LogicalPlan,
    val expr: LogicalExpr,
) : LogicalPlan() {

    override val schema: Schema = input.schema

    override fun inputs(): List<LogicalPlan> = listOf(input)

    override fun toString(): String = "SELECT $expr"
}
