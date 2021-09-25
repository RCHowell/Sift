package com.rchowell.sift.execution.planner

import com.rchowell.sift.execution.logical.LogicalExpr
import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.execution.logical.expressions.BinaryOp
import com.rchowell.sift.execution.logical.expressions.LogicalAddExpr
import com.rchowell.sift.execution.logical.expressions.LogicalAndExpr
import com.rchowell.sift.execution.logical.expressions.LogicalAvgExpr
import com.rchowell.sift.execution.logical.expressions.LogicalBinaryExpr
import com.rchowell.sift.execution.logical.expressions.LogicalBooleanBinaryExpr
import com.rchowell.sift.execution.logical.expressions.LogicalCountExpr
import com.rchowell.sift.execution.logical.expressions.LogicalDivExpr
import com.rchowell.sift.execution.logical.expressions.LogicalEqExpr
import com.rchowell.sift.execution.logical.expressions.LogicalGtExpr
import com.rchowell.sift.execution.logical.expressions.LogicalGteExpr
import com.rchowell.sift.execution.logical.expressions.LogicalIdentifierExpr
import com.rchowell.sift.execution.logical.expressions.LogicalLiteralExpr
import com.rchowell.sift.execution.logical.expressions.LogicalLtExpr
import com.rchowell.sift.execution.logical.expressions.LogicalLteExpr
import com.rchowell.sift.execution.logical.expressions.LogicalMaxExpr
import com.rchowell.sift.execution.logical.expressions.LogicalMinExpr
import com.rchowell.sift.execution.logical.expressions.LogicalModExpr
import com.rchowell.sift.execution.logical.expressions.LogicalMulExpr
import com.rchowell.sift.execution.logical.expressions.LogicalNeqExpr
import com.rchowell.sift.execution.logical.expressions.LogicalOrExpr
import com.rchowell.sift.execution.logical.expressions.LogicalSubExpr
import com.rchowell.sift.execution.logical.expressions.LogicalSumExpr
import com.rchowell.sift.execution.logical.transforms.LogicalAggregation
import com.rchowell.sift.execution.logical.transforms.LogicalDistinct
import com.rchowell.sift.execution.logical.transforms.LogicalJoin
import com.rchowell.sift.execution.logical.transforms.LogicalLimit
import com.rchowell.sift.execution.logical.transforms.LogicalProjection
import com.rchowell.sift.execution.logical.transforms.LogicalScan
import com.rchowell.sift.execution.logical.transforms.LogicalSelection
import com.rchowell.sift.execution.logical.transforms.LogicalSort
import com.rchowell.sift.execution.physical.aggregations.AvgAccumulator
import com.rchowell.sift.execution.physical.aggregations.CountAccumulator
import com.rchowell.sift.execution.physical.aggregations.MaxAccumulator
import com.rchowell.sift.execution.physical.aggregations.MinAccumulator
import com.rchowell.sift.execution.physical.aggregations.SumAccumulator
import com.rchowell.sift.execution.physical.expressions.AddExpr
import com.rchowell.sift.execution.physical.expressions.AndBinaryExpr
import com.rchowell.sift.execution.physical.expressions.ColumnExpr
import com.rchowell.sift.execution.physical.expressions.DivExpr
import com.rchowell.sift.execution.physical.expressions.EqBinaryExpr
import com.rchowell.sift.execution.physical.expressions.Expression
import com.rchowell.sift.execution.physical.expressions.GtBinaryExpr
import com.rchowell.sift.execution.physical.expressions.GteBinaryExpr
import com.rchowell.sift.execution.physical.expressions.LiteralExpr
import com.rchowell.sift.execution.physical.expressions.LtBinaryExpr
import com.rchowell.sift.execution.physical.expressions.LteBinaryExpr
import com.rchowell.sift.execution.physical.expressions.ModExpr
import com.rchowell.sift.execution.physical.expressions.MulExpr
import com.rchowell.sift.execution.physical.expressions.NeqBinaryExpr
import com.rchowell.sift.execution.physical.expressions.OrBinaryExpr
import com.rchowell.sift.execution.physical.expressions.PredicateBinaryExpr
import com.rchowell.sift.execution.physical.expressions.SubExpr
import com.rchowell.sift.execution.physical.sifterators.Aggregation
import com.rchowell.sift.execution.physical.sifterators.Projection
import com.rchowell.sift.execution.physical.sifterators.Scan
import com.rchowell.sift.execution.physical.sifterators.Selection
import com.rchowell.sift.execution.physical.sifterators.Sifterator
import com.rchowell.sift.types.Schema

class Planner {

    companion object {

        /**
         * Constructs a [Sifterator] to execute the [LogicalTransform].
         */
        fun plan(transform: LogicalTransform): Sifterator = when (transform) {
            is LogicalAggregation -> {
                val input = transform.inputs().first()
                val inPlan = plan(input)
                val aggregations = transform.aggregations.map { (identity, agg) ->
                    val column = col(input.schema, agg.input as LogicalIdentifierExpr)
                    when (agg) {
                        is LogicalMinExpr -> MinAccumulator(column)
                        is LogicalMaxExpr -> MaxAccumulator(column)
                        is LogicalSumExpr -> SumAccumulator(column)
                        is LogicalCountExpr -> CountAccumulator(column)
                        is LogicalAvgExpr -> AvgAccumulator(column)
                    }
                }
                val groups = transform.groups.map { id -> col(input.schema, id) }
                Aggregation(inPlan, aggregations, groups, transform.schema)
            }
            is LogicalProjection -> {
                val input = transform.inputs().first()
                val inPlan = plan(transform.inputs().first())
                val projs = mutableMapOf<Int, Expression>()
                transform.projections.forEach { (identity, expr) ->
                    val column = col(transform.schema, identity)
                    projs[column] = expression(expr, input.schema)
                }
                Projection(inPlan, projs, transform.schema)
            }
            is LogicalScan -> Scan(transform.source, transform.identifiers)
            is LogicalSelection -> {
                val input = transform.inputs().first()
                val inPlan = plan(transform.inputs().first())
                val predicate = predicate(transform.expr, input.schema)
                Selection(inPlan, predicate)
            }
            is LogicalSort -> TODO()
            is LogicalDistinct -> TODO()
            is LogicalJoin -> TODO()
            is LogicalLimit -> TODO()
            else -> invalid("plan", transform)
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
