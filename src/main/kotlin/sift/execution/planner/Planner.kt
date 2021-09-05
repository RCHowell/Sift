package sift.execution.planner

import sift.execution.logical.LogicalExpr
import sift.execution.logical.LogicalPlan
import sift.execution.logical.expressions.BinaryOp
import sift.execution.logical.expressions.LogicalAddExpr
import sift.execution.logical.expressions.LogicalAndExpr
import sift.execution.logical.expressions.LogicalAvgExpr
import sift.execution.logical.expressions.LogicalBinaryExpr
import sift.execution.logical.expressions.LogicalBooleanBinaryExpr
import sift.execution.logical.expressions.LogicalCountExpr
import sift.execution.logical.expressions.LogicalDivExpr
import sift.execution.logical.expressions.LogicalEqExpr
import sift.execution.logical.expressions.LogicalGtExpr
import sift.execution.logical.expressions.LogicalGteExpr
import sift.execution.logical.expressions.LogicalIdentifierExpr
import sift.execution.logical.expressions.LogicalLiteralExpr
import sift.execution.logical.expressions.LogicalLtExpr
import sift.execution.logical.expressions.LogicalLteExpr
import sift.execution.logical.expressions.LogicalMaxExpr
import sift.execution.logical.expressions.LogicalMinExpr
import sift.execution.logical.expressions.LogicalModExpr
import sift.execution.logical.expressions.LogicalMulExpr
import sift.execution.logical.expressions.LogicalNeqExpr
import sift.execution.logical.expressions.LogicalOrExpr
import sift.execution.logical.expressions.LogicalSubExpr
import sift.execution.logical.expressions.LogicalSumExpr
import sift.execution.logical.plans.LogicalAggregation
import sift.execution.logical.plans.LogicalDistinct
import sift.execution.logical.plans.LogicalJoin
import sift.execution.logical.plans.LogicalLimit
import sift.execution.logical.plans.LogicalProjection
import sift.execution.logical.plans.LogicalScan
import sift.execution.logical.plans.LogicalSelection
import sift.execution.logical.plans.LogicalSort
import sift.execution.physical.aggregations.AvgAccumulator
import sift.execution.physical.aggregations.CountAccumulator
import sift.execution.physical.aggregations.MaxAccumulator
import sift.execution.physical.aggregations.MinAccumulator
import sift.execution.physical.aggregations.SumAccumulator
import sift.execution.physical.expressions.AddExpr
import sift.execution.physical.expressions.AndBinaryExpr
import sift.execution.physical.expressions.ColumnExpr
import sift.execution.physical.expressions.DivExpr
import sift.execution.physical.expressions.EqBinaryExpr
import sift.execution.physical.expressions.Expression
import sift.execution.physical.expressions.GtBinaryExpr
import sift.execution.physical.expressions.GteBinaryExpr
import sift.execution.physical.expressions.LiteralExpr
import sift.execution.physical.expressions.LtBinaryExpr
import sift.execution.physical.expressions.LteBinaryExpr
import sift.execution.physical.expressions.ModExpr
import sift.execution.physical.expressions.MulExpr
import sift.execution.physical.expressions.NeqBinaryExpr
import sift.execution.physical.expressions.OrBinaryExpr
import sift.execution.physical.expressions.PredicateBinaryExpr
import sift.execution.physical.expressions.SubExpr
import sift.execution.physical.sifterators.Aggregation
import sift.execution.physical.sifterators.Projection
import sift.execution.physical.sifterators.Scan
import sift.execution.physical.sifterators.Selection
import sift.execution.physical.sifterators.Sifterator
import sift.types.Schema

class Planner {

    companion object {

        /**
         * Constructs a [Sifterator] to execute the [LogicalPlan].
         */
        fun plan(plan: LogicalPlan): Sifterator = when (plan) {
            is LogicalAggregation -> {
                val input = plan.inputs().first()
                val inPlan = plan(input)
                val aggregations = plan.aggregations.map { (identity, agg) ->
                    val column = col(input.schema, agg.input as LogicalIdentifierExpr)
                    when (agg) {
                        is LogicalMinExpr -> MinAccumulator(column)
                        is LogicalMaxExpr -> MaxAccumulator(column)
                        is LogicalSumExpr -> SumAccumulator(column)
                        is LogicalCountExpr -> CountAccumulator(column)
                        is LogicalAvgExpr -> AvgAccumulator(column)
                    }
                }
                val groups = plan.groups.map { id -> col(input.schema, id) }
                Aggregation(inPlan, aggregations, groups, plan.schema)
            }
            is LogicalProjection -> {
                val input = plan.inputs().first()
                val inPlan = plan(plan.inputs().first())
                val projs = mutableMapOf<Int, Expression>()
                plan.projections.forEach { (identity, expr) ->
                    val column = col(plan.schema, identity)
                    projs[column] = expression(expr, input.schema)
                }
                Projection(inPlan, projs, plan.schema)
            }
            is LogicalScan -> Scan(plan.source, plan.identifiers)
            is LogicalSelection -> {
                val input = plan.inputs().first()
                val inPlan = plan(plan.inputs().first())
                val predicate = predicate(plan.expr, input.schema)
                Selection(inPlan, predicate)
            }
            is LogicalSort -> TODO()
            is LogicalDistinct -> TODO()
            is LogicalJoin -> TODO()
            is LogicalLimit -> TODO()
            else -> invalid("plan", plan)
        }

        private fun expression(expr: LogicalExpr, schema: Schema): Expression = when (expr) {
            is LogicalIdentifierExpr -> ColumnExpr(schema.fieldIndexes[expr.identifier]!!)
            is LogicalLiteralExpr<*> -> LiteralExpr(expr.v)
            is LogicalBinaryExpr -> {
                val lhs = expression(expr.lhs, schema)
                val rhs = expression(expr.rhs, schema)
                when (expr) {
                    is LogicalEqExpr -> EqBinaryExpr(lhs, rhs)
                    is LogicalNeqExpr -> NeqBinaryExpr(lhs, rhs)
                    is LogicalLtExpr -> LtBinaryExpr(lhs, rhs)
                    is LogicalLteExpr -> LteBinaryExpr(lhs, rhs)
                    is LogicalGtExpr -> GtBinaryExpr(lhs, rhs)
                    is LogicalGteExpr -> GteBinaryExpr(lhs, rhs)
                    is LogicalAndExpr -> AndBinaryExpr(lhs, rhs)
                    is LogicalOrExpr -> OrBinaryExpr(lhs, rhs)
                    is LogicalAddExpr -> AddExpr(lhs, rhs)
                    is LogicalSubExpr -> SubExpr(lhs, rhs)
                    is LogicalMulExpr -> MulExpr(lhs, rhs)
                    is LogicalDivExpr -> DivExpr(lhs, rhs)
                    is LogicalModExpr -> ModExpr(lhs, rhs)
                    else -> invalid("binary expression", expr)
                }
            }
            else -> invalid("expression", expr)
        }

        private fun predicate(expr: LogicalExpr, schema: Schema): PredicateBinaryExpr {
            if (expr !is LogicalBinaryExpr) throw IllegalStateException()
            val lhs = expression(expr.lhs, schema)
            val rhs = expression(expr.rhs, schema)
            return when (expr) {
                is LogicalBooleanBinaryExpr -> when (expr.op) {
                    BinaryOp.EQ -> EqBinaryExpr(lhs, rhs)
                    BinaryOp.NEQ -> NeqBinaryExpr(lhs, rhs)
                    BinaryOp.LT -> LtBinaryExpr(lhs, rhs)
                    BinaryOp.LTE -> LteBinaryExpr(lhs, rhs)
                    BinaryOp.GT -> GtBinaryExpr(lhs, rhs)
                    BinaryOp.GTE -> GteBinaryExpr(lhs, rhs)
                    BinaryOp.AND -> AndBinaryExpr(lhs, rhs)
                    BinaryOp.OR -> OrBinaryExpr(lhs, rhs)
                    else -> invalid("predicate", expr)
                }
                else -> invalid("predicate", expr)
            }
        }

        private fun invalid(expectedType: String, actualType: Any): Nothing =
            throw IllegalStateException("provided $actualType is not a valid $expectedType")

        private fun col(schema: Schema, id: LogicalIdentifierExpr): Int =
            schema.fieldIndexes[id.identifier] ?: invalid("field reference", id)
    }
}
