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
 * This is taken directly from KQuery.
 *
 * I may change this to use pipe redirects `|>` like Elixir to represent a series of transformations
 *
 * @param plan
 * @param indent
 * @return
 */
fun format(plan: LogicalPlan, indent: Int = 0): String {
    val b = StringBuilder()
    repeat(0.until(indent).count()) { b.append("\t") }
    b.append(plan.toString()).append("\n")
    plan.inputs().forEach { b.append(format(it, indent + 1)) }
    return b.toString()
}
