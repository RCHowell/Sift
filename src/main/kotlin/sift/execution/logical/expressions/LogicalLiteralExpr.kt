package sift.execution.logical.expressions

import sift.execution.logical.LogicalExpr
import sift.execution.logical.LogicalPlan
import sift.types.Field
import sift.types.Type
import java.lang.IllegalArgumentException

/**
 * Representation of a literal
 */
class LogicalLiteralExpr<T : Any>(private val v: T) : LogicalExpr {

    var type: Type = when (v) {
        is Boolean -> Type.Bool
        is Number -> Type.Num
        is String -> Type.String
        else -> throw IllegalArgumentException("unsupported type ${v::class.java.name}")
    }

    override fun toField(input: LogicalPlan): Field = Field(v.toString(), type)

    override fun toString(): String = v.toString()
}
