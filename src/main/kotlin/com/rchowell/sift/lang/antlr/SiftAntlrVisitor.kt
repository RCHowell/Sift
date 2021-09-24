package com.rchowell.sift.lang.antlr

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.execution.logical.LogicalExpr
import com.rchowell.sift.execution.logical.LogicalPlan
import com.rchowell.sift.execution.logical.expressions.LogicalEqExpr
import com.rchowell.sift.execution.logical.expressions.LogicalLiteralExpr
import com.rchowell.sift.execution.logical.plans.LogicalScan
import com.rchowell.sift.execution.logical.plans.LogicalSelection
import com.rchowell.sift.lang.parsers.InvalidSyntaxException

class SiftAntlrVisitor(private val env: Environment) : SiftBaseVisitor<LogicalPlan>() {

    // Visiting expressions sets this
    private var input: LogicalPlan? = null
    private var expr: LogicalExpr? = null

    private fun err(message: String): Throwable = InvalidSyntaxException(message)

    override fun visitQuery(ctx: SiftParser.QueryContext?): LogicalPlan {
        return super.visitQuery(ctx)
    }

    override fun visitTransformSelect(ctx: SiftParser.TransformSelectContext?): LogicalPlan {
        val selectCtx = ctx?.select()
        val expr = super.visitExpr(selectCtx?.expr())
        val plan = LogicalSelection(
            input!!,
            LogicalEqExpr(
                LogicalLiteralExpr<Double>(1.0),
                LogicalLiteralExpr<Double>(1.0),
            )
        )
        input = plan
        return plan
    }

    override fun visitRelId(ctx: SiftParser.RelIdContext?): LogicalPlan {
        val id = ctx?.ID()?.text ?: throw err("missing relation identifier")
        val source = env.getSource(id)
        // TODO list of identifiers
        val plan = LogicalScan(source, listOf())
        input = plan
        return plan
    }
}
