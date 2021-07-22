package sift.execution.logical.expressions

import sift.execution.logical.LogicalExpr
import sift.execution.logical.LogicalPlan
import sift.types.Field
import sift.types.Type

class UnknownAggregateFunction(name: String) : Exception("unknown aggregate $name")

/**
 * Aggregation expressions to be implemented by various physical aggregation expressions.
 *
 * @property op
 * @property input
 * @constructor Create empty Logical agg expr
 */
sealed class LogicalAggregateExpr(
    val op: AggOp,
    val input: LogicalExpr,
) : LogicalExpr {
    override fun toString(): String = "$op($input)"
    override fun toField(input: LogicalPlan): Field = Field(op.name, this.input.toField(input).type)

    companion object {

        fun get(name: String, vararg args: LogicalExpr): LogicalExpr = when (name) {
            "MIN" -> LogicalMinExpr(args[0])
            "MAX" -> LogicalMaxExpr(args[0])
            "SUM" -> LogicalSumExpr(args[0])
            "AVG" -> LogicalAvgExpr(args[0])
            "COUNT" -> LogicalCountExpr(args[0])
            else -> throw UnknownAggregateFunction(name)
        }
    }
}

class LogicalMinExpr(input: LogicalExpr) : LogicalAggregateExpr(AggOp.MIN, input)

class LogicalMaxExpr(input: LogicalExpr) : LogicalAggregateExpr(AggOp.MAX, input)

class LogicalSumExpr(input: LogicalExpr) : LogicalAggregateExpr(AggOp.SUM, input)

class LogicalCountExpr(input: LogicalExpr) : LogicalAggregateExpr(AggOp.COUNT, input) {
    override fun toField(input: LogicalPlan): Field = Field(op.name, Type.Num)
}

class LogicalAvgExpr(input: LogicalExpr) : LogicalAggregateExpr(AggOp.AVG, input)
