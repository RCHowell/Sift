package sift.execution.physical.expressions

import sift.types.Batch
import sift.types.Column

/**
 * Literal expression simple returns the column
 *
 * @property col
 * @constructor Create empty Literal expr
 */
class LiteralExpr(val col: Column) : Expression {
    override fun eval(batch: Batch): Column = col
}
