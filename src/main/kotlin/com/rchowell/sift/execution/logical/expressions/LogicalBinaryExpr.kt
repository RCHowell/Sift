package com.rchowell.sift.execution.logical.expressions

import com.rchowell.sift.execution.logical.LogicalExpr
import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.execution.logical.expressions.BinaryOp.ADD
import com.rchowell.sift.execution.logical.expressions.BinaryOp.AND
import com.rchowell.sift.execution.logical.expressions.BinaryOp.DIV
import com.rchowell.sift.execution.logical.expressions.BinaryOp.EQ
import com.rchowell.sift.execution.logical.expressions.BinaryOp.GT
import com.rchowell.sift.execution.logical.expressions.BinaryOp.GTE
import com.rchowell.sift.execution.logical.expressions.BinaryOp.LT
import com.rchowell.sift.execution.logical.expressions.BinaryOp.LTE
import com.rchowell.sift.execution.logical.expressions.BinaryOp.MOD
import com.rchowell.sift.execution.logical.expressions.BinaryOp.MULT
import com.rchowell.sift.execution.logical.expressions.BinaryOp.NEQ
import com.rchowell.sift.execution.logical.expressions.BinaryOp.OR
import com.rchowell.sift.execution.logical.expressions.BinaryOp.SUB
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Type

/**
 * Representation of binary expressions for
 *  - Comparison
 *  - Boolean Expressions
 *  - Math Expressions
 *
 * @property op Operator
 * @property lhs Left-hand side
 * @property rhs Right-hand side
 * @constructor Create empty Logical binary expr
 */
abstract class LogicalBinaryExpr(
    val op: BinaryOp,
    val lhs: LogicalExpr,
    val rhs: LogicalExpr,
) : LogicalExpr {
    override fun toString(): String = "$lhs $op $rhs"

    companion object {

        fun get(op: BinaryOp, lhs: LogicalExpr, rhs: LogicalExpr): LogicalExpr = when (op) {
            EQ -> LogicalEqExpr(lhs, rhs)
            NEQ -> LogicalNeqExpr(lhs, rhs)
            LT -> LogicalLtExpr(lhs, rhs)
            LTE -> LogicalLteExpr(lhs, rhs)
            GT -> LogicalGtExpr(lhs, rhs)
            GTE -> LogicalGteExpr(lhs, rhs)
            AND -> LogicalAndExpr(lhs, rhs)
            OR -> LogicalOrExpr(lhs, rhs)
            ADD -> LogicalAddExpr(lhs, rhs)
            SUB -> LogicalSubExpr(lhs, rhs)
            MULT -> LogicalMulExpr(lhs, rhs)
            DIV -> LogicalDivExpr(lhs, rhs)
            MOD -> LogicalModExpr(lhs, rhs)
        }
    }
}

/**
 * Binary expressions that return a Bool
 */
sealed class LogicalBooleanBinaryExpr(
    op: BinaryOp,
    lhs: LogicalExpr,
    rhs: LogicalExpr,
) : LogicalBinaryExpr(op, lhs, rhs) {
    override fun toField(input: LogicalTransform): Field = Field(op.name, Type.Bool)
}

class LogicalEqExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(EQ, lhs, rhs)

class LogicalNeqExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(NEQ, lhs, rhs)

class LogicalLtExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(LT, lhs, rhs)

class LogicalLteExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(LTE, lhs, rhs)

class LogicalGtExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(GT, lhs, rhs)

class LogicalGteExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(GTE, lhs, rhs)

class LogicalAndExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(AND, lhs, rhs)

class LogicalOrExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(OR, lhs, rhs)

/**
 * Binary expressions that return a Num
 */
sealed class LogicalMathBinaryExpr(
    op: BinaryOp,
    lhs: LogicalExpr,
    rhs: LogicalExpr,
) : LogicalBinaryExpr(op, lhs, rhs) {
    override fun toField(input: LogicalTransform): Field = Field(op.name, Type.Num)
}

class LogicalAddExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(ADD, lhs, rhs)

class LogicalSubExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(SUB, lhs, rhs)

class LogicalMulExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(MULT, lhs, rhs)

class LogicalDivExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(DIV, lhs, rhs)

class LogicalModExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(MOD, lhs, rhs)
