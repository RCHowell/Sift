package sift.execution.logical

import sift.types.Field

/**
 * Query planning requires expressions to describe the resultant [Field] given a [LogicalPlan].
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
    fun toField(input: LogicalPlan): Field
}
