package com.rchowell.sift.execution.logical.expressions

import com.rchowell.sift.execution.logical.LogicalExpr
import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Type

/**
 * Representation of a literal
 */
class LogicalLiteralExpr<T : Any>(val v: T) : LogicalExpr {

    var type: Type = when (v) {
        is Boolean -> Type.Bool
        is Number -> Type.Num
        is String -> Type.String
        else -> throw IllegalArgumentException("unsupported type ${v::class.java.name}")
    }

    override fun toField(input: LogicalTransform): Field = Field(v.toString(), type)

    override fun toString(): String = v.toString()
}
