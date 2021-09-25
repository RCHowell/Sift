package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.source.Source

/**
 * LogicalScan represents a plan to select fields (given identifiers) from the underlying source.
 *
 * @property source
 * @property identifiers
 * @constructor Create empty Logical scan
 */
class LogicalScan(
    val source: Source,
    val identifiers: List<String> = listOf(),
) : LogicalTransform() {

    /**
     * Schema is derived from the source
     */
    override val schema = source.schema.select(identifiers)

    /**
     * Children
     *
     * @return
     */
    override fun inputs(): List<LogicalTransform> = listOf()

    override fun toString(): String {
        val f = if (identifiers.isEmpty()) "*" else identifiers.joinToString()
        return "SCAN $f FROM $source"
    }
}
