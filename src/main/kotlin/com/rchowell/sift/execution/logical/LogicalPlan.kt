package com.rchowell.sift.execution.logical

import com.rchowell.sift.types.Schema

/**
 * A logical plan is a transformation which returns a relation.
 * This is taken directly from KQuery.
 *
 * AFAIK a logical plan represents a transformation between the incoming transformations.
 * I'm thinking of logical plans as a chain of mapping functions.
 *
 * Change to `sealed interface` when the project migrates from kotlin 1.4 to 1.5
 *
 * @constructor Create empty Logical plan
 */
abstract class LogicalPlan {

    /**
     * Output schema of this transformation
     */
    abstract val schema: Schema

    /**
     * Inputs of this logical plan. Grove says this will be useful for the visitor pattern, but I'm not there yet.
     * Why not a value?
     */
    abstract fun inputs(): List<LogicalPlan>

    open fun pretty(): String {
        return format(this)
    }
}

/**
 * Format returns the series of transformations nested.
 *
 * @param plan
 * @param indent
 * @return
 */
fun format(plan: LogicalPlan, indent: Int = 0): String = buildString {
    val prefix = "  ".repeat(indent)
    append(prefix).append(plan)
    if (plan.inputs().isNotEmpty()) {
        append(" {").append("\n")
        plan.inputs().forEach { append(format(it, indent + 1)).append("\n") }
        append(prefix).append("}")
    } else {
        append(" {}")
    }
}
