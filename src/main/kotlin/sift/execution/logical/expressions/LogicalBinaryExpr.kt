package sift.execution.logical.expressions

import sift.execution.logical.LogicalExpr
import sift.execution.logical.LogicalPlan
import sift.execution.logical.expressions.BinaryOp.*
import sift.types.Field
import sift.types.Type

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
            MULT -> LogicalMultExpr(lhs, rhs)
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
    override fun toField(input: LogicalPlan): Field = Field(op.name, Type.Bool)
}

class LogicalEqExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.EQ, lhs, rhs)

class LogicalNeqExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.NEQ, lhs, rhs)

class LogicalLtExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.LT, lhs, rhs)

class LogicalLteExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.LTE, lhs, rhs)

class LogicalGtExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.GT, lhs, rhs)

class LogicalGteExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.GTE, lhs, rhs)

class LogicalAndExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.AND, lhs, rhs)

class LogicalOrExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.OR, lhs, rhs)

/**
 * Binary expressions that return a Num
 */
sealed class LogicalMathBinaryExpr(
    op: BinaryOp,
    lhs: LogicalExpr,
    rhs: LogicalExpr,
) : LogicalBinaryExpr(op, lhs, rhs) {
    override fun toField(input: LogicalPlan): Field = Field(op.name, Type.Num)
}

class LogicalAddExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.ADD, lhs, rhs)

class LogicalSubExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.SUB, lhs, rhs)

class LogicalMultExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.MULT, lhs, rhs)

class LogicalDivExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.DIV, lhs, rhs)

class LogicalModExpr(lhs: LogicalExpr, rhs: LogicalExpr) : LogicalBooleanBinaryExpr(BinaryOp.MOD, lhs, rhs)
