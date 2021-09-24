package com.rchowell.sift.execution.logical.plans

import com.rchowell.sift.execution.logical.LogicalPlan
import com.rchowell.sift.types.Schema

/**
 * Duplicate elimination extension of The Relation Algebra which converts a bag to a set.
 */
class LogicalDistinct(private val input: LogicalPlan) : LogicalPlan() {

    override val schema: Schema = input.schema

    override fun inputs(): List<LogicalPlan> = listOf(input)

    override fun pretty(): String = "DISTINCT"
}
