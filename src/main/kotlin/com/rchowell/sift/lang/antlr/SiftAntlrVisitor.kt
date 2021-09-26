package com.rchowell.sift.lang.antlr

import com.rchowell.sift.execution.logical.expressions.LogicalAggregateExpr
import com.rchowell.sift.execution.logical.expressions.LogicalAndExpr
import com.rchowell.sift.execution.logical.expressions.LogicalEqExpr
import com.rchowell.sift.execution.logical.expressions.LogicalGtExpr
import com.rchowell.sift.execution.logical.expressions.LogicalGteExpr
import com.rchowell.sift.execution.logical.expressions.LogicalIdentifierExpr
import com.rchowell.sift.execution.logical.expressions.LogicalLiteralExpr
import com.rchowell.sift.execution.logical.expressions.LogicalLtExpr
import com.rchowell.sift.execution.logical.expressions.LogicalLteExpr
import com.rchowell.sift.execution.logical.expressions.LogicalOrExpr
import com.rchowell.sift.execution.logical.transforms.LogicalAggregation
import com.rchowell.sift.execution.logical.transforms.LogicalDistinct
import com.rchowell.sift.execution.logical.transforms.LogicalLimit
import com.rchowell.sift.execution.logical.transforms.LogicalProjection
import com.rchowell.sift.execution.logical.transforms.LogicalScan
import com.rchowell.sift.execution.logical.transforms.LogicalSelection
import com.rchowell.sift.execution.logical.transforms.LogicalSort

/**
 * The visitor builds a [LogicalPlan] starting from the provided [SiftVisitorBuildState]
 *
 * @property env
 * @property state optional initial state, useful for testing individual visits
 * @constructor Create empty Sift antlr visitor
 */
class SiftAntlrVisitor(private val state: SiftVisitorBuildState) : SiftBaseVisitor<Unit>() {

    // -----------
    //  Relations
    // -----------

    override fun visitRelId(ctx: SiftParser.RelIdContext) {
        val id = ctx.ID()?.text!!
        val source = state.source(id)
        state.push(LogicalScan(source, listOf()))
    }

    // ------------
    //  Transforms
    // ------------

    override fun visitSelect(ctx: SiftParser.SelectContext) {
        visit(ctx.expr())
        val input = state.transform()
        val expr = state.expr()
        state.push(LogicalSelection(input, expr))
    }

    override fun visitProject(ctx: SiftParser.ProjectContext) {
        ctx.func().forEach { visit(it) }
        val projections = state.projections()
        val input = state.transform()
        state.push(LogicalProjection(input, projections))
    }

    override fun visitLimit(ctx: SiftParser.LimitContext) {
        val n = Integer.valueOf(ctx.INT()?.text!!)
        val input = state.transform()
        state.push(LogicalLimit(input, n))
    }

    override fun visitDistinct(ctx: SiftParser.DistinctContext) {
        val input = state.transform()
        state.push(LogicalDistinct(input))
    }

    override fun visitSort(ctx: SiftParser.SortContext) {
        val input = state.transform()
        val fields = when (val ids = ctx.ids()) {
            null -> emptyList()
            else -> ids.ID().map { LogicalIdentifierExpr(it.text) }
        }
        val asc = when (val order = ctx.order) {
            null -> true
            else -> when (order.type) {
                SiftLexer.ASC -> true
                else -> false
            }
        }
        state.push(LogicalSort(input, fields, asc))
    }

    override fun visitGroup(ctx: SiftParser.GroupContext) {
        ctx.agg().forEach { visit(it) }
        val input = state.transform()
        val aggs = state.aggregations()
        val groups = when (val ids = ctx.ids()) {
            null -> emptyList()
            else -> ids.ID().map { LogicalIdentifierExpr(it.text) }
        }
        state.push(LogicalAggregation(input, aggs, groups))
    }

    // ---------------------------
    //  Expressions and Functions
    // ---------------------------

    override fun visitIntLitExpr(ctx: SiftParser.IntLitExprContext) {
        val v = Integer.valueOf(ctx.INT()?.text!!)
        state.push(LogicalLiteralExpr(v))
    }

    override fun visitStringLitExpr(ctx: SiftParser.StringLitExprContext) {
        val v = ctx.STRING()?.text!!
        state.push(LogicalLiteralExpr(v))
    }

    override fun visitIdentExpr(ctx: SiftParser.IdentExprContext) {
        val id = ctx.ID()?.text!!
        val expr = LogicalIdentifierExpr(id)
        state.push(expr)
    }

    override fun visitComparisonExpr(ctx: SiftParser.ComparisonExprContext) {
        visit(ctx.expr(1)) // rhs
        visit(ctx.expr(0)) // lhs
        val rhs = state.expr()
        val lhs = state.expr()
        when (ctx.op.type) {
            SiftLexer.LT -> state.push(LogicalLtExpr(lhs, rhs))
            SiftLexer.LTE -> state.push(LogicalLteExpr(lhs, rhs))
            SiftLexer.EQ -> state.push(LogicalEqExpr(lhs, rhs))
            SiftLexer.GT -> state.push(LogicalGtExpr(lhs, rhs))
            SiftLexer.GTE -> state.push(LogicalGteExpr(lhs, rhs))
        }
    }

    override fun visitBoolExpr(ctx: SiftParser.BoolExprContext) {
        visit(ctx.expr(1)) // rhs
        visit(ctx.expr(0)) // lhs
        val rhs = state.expr()
        val lhs = state.expr()
        when (ctx.op.type) {
            SiftLexer.AND -> state.push(LogicalAndExpr(lhs, rhs))
            SiftLexer.OR -> state.push(LogicalOrExpr(lhs, rhs))
        }
    }

    override fun visitProjIdent(ctx: SiftParser.ProjIdentContext) {
        val id = ctx.ID()?.text!!
        val expr = LogicalIdentifierExpr(id)
        state.push(expr, expr)
    }

    override fun visitProjMap(ctx: SiftParser.ProjMapContext) {
        visit(ctx.expr())
        val id = ctx.ID()?.text!!
        val alias = LogicalIdentifierExpr(id)
        val expr = state.expr()
        state.push(alias, expr)
    }

    override fun visitAgg(ctx: SiftParser.AggContext) {
        visit(ctx.expr())
        val agg = ctx.op.text!!
        val expr = state.expr()
        val aggExpr = LogicalAggregateExpr.get(agg, expr)
        val id = ctx.ID()
        val alias = if (id != null) id.text else state.generateIdentifier()
        state.push(LogicalIdentifierExpr(alias), aggExpr)
    }
}
