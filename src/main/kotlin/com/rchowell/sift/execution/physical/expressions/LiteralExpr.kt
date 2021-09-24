package com.rchowell.sift.execution.physical.expressions

import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.BoolLiteralColumn
import com.rchowell.sift.types.Column
import com.rchowell.sift.types.NumLiteralColumn
import com.rchowell.sift.types.StringLiteralColumn

/**
 * Literal expression simple returns the column
 *
 * @property col
 * @constructor Create empty Literal expr
 */
class LiteralExpr(val v: Any) : Expression {
    override fun eval(batch: Batch): Column = when (v) {
        is Boolean -> BoolLiteralColumn(v, batch.records)
        is Number -> NumLiteralColumn(v.toDouble(), batch.records)
        is String -> StringLiteralColumn(v.toByteArray(), batch.records)
        else -> throw IllegalStateException("invalid type ${v.javaClass} in literal expression")
    }
}
