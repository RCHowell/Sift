package sift.execution.logical.expressions

import sift.execution.logical.LogicalExpr

class UndefinedExpression(id: String) : Exception("unknown expression $id")

class LogicalExpressionTable {

    companion object {

        fun get(id: String): LogicalExpr = when(id) {
            "+" -> LogicalAddExpr()
            else -> throw UndefinedExpression(id)
        }

    }
}