package com.rchowell.sift.lang.antlr

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.execution.logical.expressions.LogicalLiteralExpr
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

    override fun visitTransformSelect(ctx: SiftParser.TransformSelectContext): SiftVisitorBuildState {
        super.visit(ctx.select().expr())
        state.push(LogicalSelection::class)
        return state
    }

    override fun visitRelId(ctx: SiftParser.RelIdContext?): SiftVisitorBuildState {
        val id = ctx?.ID()?.text ?: throw err("missing relation identifier")
        val source = env.getSource(id)
        state.push(LogicalScan(source, listOf()))
        return state
    }

    override fun visitIntLitExpr(ctx: SiftParser.IntLitExprContext): SiftVisitorBuildState {
        val v = ctx.INT()?.text
        val value = Integer.valueOf(v)
        state.push(LogicalLiteralExpr(value))
        return state
    }
}
