package com.rchowell.sift.lang.antlr

import com.rchowell.sift.execution.logical.LogicalExpr
import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.execution.logical.transforms.LogicalScan
import com.rchowell.sift.execution.logical.transforms.LogicalSelection
import java.util.Stack
import kotlin.reflect.KClass

/**
 * Visitor build state is used by the parser to generate the parsed
 *  logical plan. This idea came from wanting to remove all query
 *  building logic out of the visitor, as well as using this as the input
 *  and output of the visitor for easy testing of individual visitor methods.
 *
 * @constructor Create empty Query builder
 */
class SiftVisitorBuildState {

    private val transforms = Stack<LogicalTransform>()
    private val exprs = Stack<LogicalExpr>()

    /**
     * Returns the top-most transformation
     */
    fun query(): LogicalTransform = transforms.pop()

    fun push(expr: LogicalExpr) {
        exprs.push(expr)
    }

    fun expr(): LogicalExpr = exprs.pop()

    // Ehhhh
    fun <T : LogicalTransform> push(transform: KClass<T>) {
        when (transform) {
            LogicalSelection::class -> transforms.push(
                LogicalSelection(
                    input = transforms.pop(),
                    expr = exprs.pop(),
                )
            )
        }
    }

    fun push(scan: LogicalScan) {
        transforms.push(scan)
    }
}
