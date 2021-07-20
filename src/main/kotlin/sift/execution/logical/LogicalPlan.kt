package sift.execution.logical

import sift.types.Schema

/**
 * A logical plan is a transformation which returns a relation.
 * This is taken directly from KQuery.
 *
 * AFAIK a logical plan represents a transformation between the incoming transformations.
 * I'm thinking of logical plans as a chain of mapping functions.
 *
 * @constructor Create empty Logical plan
 */
interface LogicalPlan {

    /**
     * Output schema of this transformation
     */
    val schema: Schema

    /**
     * Inputs of this logical plan. Grove says this will be useful for the visitor pattern, but I'm not there yet.
     */
    fun inputs(): List<LogicalPlan>

    fun pretty(): String {
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
