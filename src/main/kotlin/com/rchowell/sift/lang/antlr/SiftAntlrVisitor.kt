package com.rchowell.sift.lang.antlr

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.execution.logical.expressions.LogicalLiteralExpr
import com.rchowell.sift.execution.logical.expressions.LogicalLtExpr
import com.rchowell.sift.execution.logical.transforms.LogicalScan
import com.rchowell.sift.execution.logical.transforms.LogicalSelection
import com.rchowell.sift.lang.parsers.InvalidSyntaxException

/**
 * Sift antlr visitor
 *
 * @property env
 * @property state optional initial state, useful for testing individual visits
 * @constructor Create empty Sift antlr visitor
 */
class SiftAntlrVisitor(
    private val env: Environment,
    private val state: SiftVisitorBuildState = SiftVisitorBuildState()
) : SiftBaseVisitor<SiftVisitorBuildState>() {

    private fun err(message: String): Throwable = InvalidSyntaxException(message)

    // ---------------------
    //  Relation Productions
    // ----------------------

    override fun visitRelId(ctx: SiftParser.RelIdContext): SiftVisitorBuildState {
        val id = ctx.ID()?.text ?: throw err("missing relation identifier")
        val source = env.getSource(id)
        state.push(LogicalScan(source, listOf()))
        return state
    }

    // ------------
    //  Transforms
    // ------------

    override fun visitTransformSelect(ctx: SiftParser.TransformSelectContext): SiftVisitorBuildState {
        super.visit(ctx.select().expr())
        val input = state.transform()
        val expr = state.expr()
        state.push(LogicalSelection(input, expr))
        return state
    }

    // -------------
    //  Expressions
    // -------------

    override fun visitIntLitExpr(ctx: SiftParser.IntLitExprContext): SiftVisitorBuildState {
        val v = Integer.valueOf(ctx.INT()?.text!!)
        state.push(LogicalLiteralExpr(v))
        return state
    }

    override fun visitStringLitExpr(ctx: SiftParser.StringLitExprContext): SiftVisitorBuildState {
        val v = ctx.STRING()?.text!!
        state.push(LogicalLiteralExpr(v))
        return state
    }

    override fun visitComparisonExpr(ctx: SiftParser.ComparisonExprContext): SiftVisitorBuildState {
        super.visit(ctx.expr(0)) // lhs
        super.visit(ctx.expr(1)) // rhs
        val rhs = state.expr()
        val lhs = state.expr()
        when (ctx.op.type) {
            SiftLexer.LT -> state.push(LogicalLtExpr(lhs, rhs))
            SiftLexer.LTE -> state.push(LogicalLtExpr(lhs, rhs))
            SiftLexer.EQ -> state.push(LogicalLtExpr(lhs, rhs))
            SiftLexer.GT -> state.push(LogicalLtExpr(lhs, rhs))
            SiftLexer.GTE -> state.push(LogicalLtExpr(lhs, rhs))
        }
        return state
    }
}
