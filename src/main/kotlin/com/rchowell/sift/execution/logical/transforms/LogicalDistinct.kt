package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.types.Schema

/**
 * Duplicate elimination extension of The Relation Algebra which converts a bag to a set.
 * // TODO consider other names such as UNIQUE
 */
class LogicalDistinct(private val input: LogicalTransform) : LogicalTransform() {

    override val schema: Schema = input.schema

    override fun inputs(): List<LogicalTransform> = listOf(input)

    override fun toString(): String = "DISTINCT"

    override fun pretty(): String = "DISTINCT"
}