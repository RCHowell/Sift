package sift.execution.logical.plans

import sift.execution.logical.LogicalPlan
import sift.types.Schema

class LogicalSort(
    private val input: LogicalPlan,
    private val fields: List<String>,
) : LogicalPlan {

    override val schema: Schema = input.schema

    override fun inputs(): List<LogicalPlan> = listOf(input)

    override fun pretty(): String = if (fields.isEmpty()) "ORDER" else "ORDER BY ${fields.joinToString()}"
}
