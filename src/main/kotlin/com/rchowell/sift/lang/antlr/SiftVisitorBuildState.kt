package com.rchowell.sift.lang.antlr

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.execution.logical.LogicalExpr
import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.execution.logical.expressions.LogicalAggregateExpr
import com.rchowell.sift.execution.logical.expressions.LogicalIdentifierExpr
import java.util.Stack

/**
 * Visitor build state is used by the parser to generate the parsed
 *  logical plan. This idea came from wanting to remove all query
 *  building logic out of the visitor, as well as using this as the input
 *  and output of the visitor for easy testing of individual visitor methods.
 *
 * @constructor Create empty Query builder
 */
class SiftVisitorBuildState(private val env: Environment) {

    private val transforms = Stack<LogicalTransform>()
    private val exprs = Stack<LogicalExpr>()

    // This won't work across scopes
    private val projections = mutableMapOf<LogicalIdentifierExpr, LogicalExpr>()
    private val aggregations = mutableMapOf<LogicalIdentifierExpr, LogicalAggregateExpr>()

    // Would be interesting to have a legitimate id generator
    private var n = 0

    /**
     * top-most transformation
     */
    fun query(): LogicalTransform = transforms.peek()

    fun source(identifier: String) = env.getSource(identifier)

    fun push(expr: LogicalExpr) {
        exprs.push(expr)
    }

    fun push(scan: LogicalTransform) {
        transforms.push(scan)
    }

    fun push(alias: LogicalIdentifierExpr, expr: LogicalExpr) {
        projections[alias] = expr
    }

    fun push(alias: LogicalIdentifierExpr, expr: LogicalAggregateExpr) {
        aggregations[alias] = expr
    }

    fun expr(): LogicalExpr = exprs.pop()

    fun transform(): LogicalTransform = transforms.pop()

    fun projections(): Map<LogicalIdentifierExpr, LogicalExpr> {
        val v = projections.mapValues { it.value }
        projections.clear()
        return v
    }

    fun aggregations(): Map<LogicalIdentifierExpr, LogicalAggregateExpr> {
        val v = aggregations.mapValues { it.value }
        aggregations.clear()
        return v
    }

    fun generateIdentifier() = "v_${n++}"
}
