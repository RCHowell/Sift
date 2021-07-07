package sift.execution.logical.plans

import sift.execution.logical.LogicalPlan
import sift.source.Source

/**
 * LogicalScan represents a plan to select fields (given identifiers) from the underlying source.
 *
 * @property source
 * @property identifiers
 * @constructor Create empty Logical scan
 */
class LogicalScan(
    private val source: Source,
    private val identifiers: List<String>,
) : LogicalPlan {

    /**
     * Schema is derived from the source
     */
    override val schema = source.schema.select(identifiers)

    /**
     * Children
     *
     * @return
     */
    override fun inputs(): List<LogicalPlan> = listOf()

    override fun toString(): String {
        val f = if (identifiers.isEmpty()) "*" else identifiers.joinToString()
        return "SCAN $f"
    }
}
