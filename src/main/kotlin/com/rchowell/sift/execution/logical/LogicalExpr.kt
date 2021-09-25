package com.rchowell.sift.execution.logical

import com.rchowell.sift.types.Field

/**
 * Query planning requires expressions to describe the resultant [Field] given a [LogicalTransform].
 * Change to `sealed interface` when using Kotlin 1.5
 *
 * @constructor Create empty Logical expr
 */
interface LogicalExpr {

    /**
     * See class description
     *
     * @param input
     * @return
     */
    fun toField(input: LogicalTransform): Field
}
