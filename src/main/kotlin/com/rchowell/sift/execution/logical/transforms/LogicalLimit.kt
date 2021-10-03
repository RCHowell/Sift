package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.types.Schema

/**
 * LogicalLimit simply limits results to the first `n`.
 * This operation isn't discussed in the extended relation algebra of DSTCB, but is simple enough to include
 *
 * SORT field ASC |> LIMIT 10  # sorts all rows by `field` then takes the first 10
 * LIMIT 10 |> SORT field ASC  # returns the first 10 rows from the input, then sorts only those 10 rows
 *
 * @property input
 * @property limit
 * @constructor Create empty Logical limit
 */
class LogicalLimit(
    val input: LogicalTransform,
    val n: Int,
) : LogicalTransform() {

    override val schema: Schema = input.schema

    override fun inputs(): List<LogicalTransform> = listOf(input)

    override fun toString(): String = "LIMIT $n"
}
