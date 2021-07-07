package sift.execution.logical.expressions

import sift.execution.logical.LogicalExpr
import sift.execution.logical.LogicalPlan
import sift.types.Field

/**
 * Simple expression representing a reference to some column in the data source.
 *
 * @property identifier
 * @constructor Create empty Logical column expr
 */
class LogicalIdentifierExpr(private val identifier: String) : LogicalExpr {

    /**
     * Returns the [Field] information if found, else throw an exception because this is an invalid column reference.
     *
     * @param input
     * @return
     */
    override fun toField(input: LogicalPlan): Field = input.schema.find(identifier)

    override fun toString(): String = "#$identifier"
}
