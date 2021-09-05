package sift.execution.physical.expressions

import sift.types.Batch
import sift.types.BoolColumn
import sift.types.BoolVectorColumn
import sift.types.Column
import sift.types.NumColumn
import sift.types.NumVectorColumn
import sift.types.StringColumn
import sift.types.StringVectorColumn

abstract class BinaryExpr(val lhs: Expression, val rhs: Expression) : Expression {

    override fun eval(batch: Batch): Column {
        val lc = lhs.eval(batch)
        val rc = rhs.eval(batch)
        assert(lc.size == rc.size)
        return when {
            (lc is NumColumn && rc is NumColumn) -> {
                val result = Column.Factory.numeric(lc.size)
                for (i in 0 until lc.size) {
                    result[i] = eval(lc[i], rc[i])
                }
                result.valueCount = lc.size
                NumVectorColumn(result)
            }
            (lc is BoolColumn && rc is BoolColumn) -> {
                val result = Column.Factory.boolean(lc.size)
                for (i in 0 until lc.size) {
                    result[i] = eval(lc[i], rc[i])
                }
                result.valueCount = lc.size
                BoolVectorColumn(result)
            }
            (lc is StringColumn && rc is StringColumn) -> {
                val result = Column.Factory.string(lc.size)
                for (i in 0 until lc.size) {
                    result[i] = eval(lc[i], rc[i])
                }
                result.valueCount = lc.size
                StringVectorColumn(result)
            }
            else -> throw Exception("unsupported column type ${lc::class.java}")
        }
    }

    open fun eval(l: Double, r: Double): Double = throw Exception("not implemented for ${this.javaClass}")

    open fun eval(l: Boolean, r: Boolean): Boolean = throw Exception("not implemented for ${this.javaClass}")

    open fun eval(l: String, r: String): String = throw Exception("not implemented for ${this.javaClass}")

    // VarCharVector
    private fun eval(l: ByteArray, r: ByteArray): ByteArray = eval(l.toString(Charsets.UTF_8), r.toString(Charsets.UTF_8)).toByteArray()

    // BitVector
    private fun eval(l: Int, r: Int): Int = if (eval(l == 1, r == 1)) 1 else 0
}

/**
 * ==================
 *  Math Expressions
 * ==================
 */

class AddExpr(lhs: Expression, rhs: Expression) : BinaryExpr(lhs, rhs) {

    override fun eval(l: Double, r: Double): Double = l + r

    override fun eval(l: String, r: String): String = l + r
}

class SubExpr(lhs: Expression, rhs: Expression) : BinaryExpr(lhs, rhs) {

    override fun eval(l: Double, r: Double): Double = l - r
}

class MulExpr(lhs: Expression, rhs: Expression) : BinaryExpr(lhs, rhs) {

    override fun eval(l: Double, r: Double): Double = l * r
}

class DivExpr(lhs: Expression, rhs: Expression) : BinaryExpr(lhs, rhs) {

    // TODO divide by 0; beginning to think expression return values
    // should be nullable which would become SQL NULL
    override fun eval(l: Double, r: Double): Double = l / r
}

class ModExpr(lhs: Expression, rhs: Expression) : BinaryExpr(lhs, rhs) {

    override fun eval(l: Double, r: Double): Double = l % r
}

/**
 * ============
 *  Predicates
 * ============
 */

abstract class PredicateBinaryExpr(val lhs: Expression, val rhs: Expression) : Expression {

    override fun eval(batch: Batch): BoolColumn {
        val lc = lhs.eval(batch)
        val rc = rhs.eval(batch)
        assert(lc.size == rc.size)
        val result = Column.Factory.boolean(lc.size)
        when {
            (lc is NumColumn && rc is NumColumn) -> {
                for (i in 0 until lc.size) result[i] = if (eval(lc[i], rc[i])) 1 else 0
            }
            (lc is BoolColumn && rc is BoolColumn) -> {
                for (i in 0 until lc.size) result[i] = if (eval(lc[i], rc[i])) 1 else 0
            }
            (lc is StringColumn && rc is StringColumn) -> {
                for (i in 0 until lc.size) result[i] = if (eval(lc[i], rc[i])) 1 else 0
            }
            else -> throw Exception("unsupported vector type ${lc::class.java}")
        }
        result.valueCount = lc.size
        return BoolVectorColumn(result)
    }

    open fun eval(l: Double, r: Double): Boolean = throw Exception("not implemented for ${this.javaClass}")

    open fun eval(l: Boolean, r: Boolean): Boolean = throw Exception("not implemented for ${this.javaClass}")

    open fun eval(l: String, r: String): Boolean = throw Exception("not implemented for ${this.javaClass}")

    // BitVector
    private fun eval(l: Int, r: Int): Boolean = eval(l == 1, r == 1)

    // VarCharVector
    private fun eval(l: ByteArray, r: ByteArray): Boolean = eval(l.toString(Charsets.UTF_8), r.toString(Charsets.UTF_8))
}

/**
 * ============================
 *  Boolean Binary Expressions
 * ============================
 */

class AndBinaryExpr(lhs: Expression, rhs: Expression) : PredicateBinaryExpr(lhs, rhs) {
    override fun eval(l: Boolean, r: Boolean): Boolean = l && r
}

class OrBinaryExpr(lhs: Expression, rhs: Expression) : PredicateBinaryExpr(lhs, rhs) {
    override fun eval(l: Boolean, r: Boolean): Boolean = l || r
}

class GtBinaryExpr(lhs: Expression, rhs: Expression) : PredicateBinaryExpr(lhs, rhs) {
    override fun eval(l: Double, r: Double): Boolean = l > r

    override fun eval(l: String, r: String): Boolean = l > r
}

class GteBinaryExpr(lhs: Expression, rhs: Expression) : PredicateBinaryExpr(lhs, rhs) {
    override fun eval(l: Double, r: Double): Boolean = l >= r

    override fun eval(l: String, r: String): Boolean = l >= r
}

class LtBinaryExpr(lhs: Expression, rhs: Expression) : PredicateBinaryExpr(lhs, rhs) {
    override fun eval(l: Double, r: Double): Boolean = l < r

    override fun eval(l: String, r: String): Boolean = l < r
}

class LteBinaryExpr(lhs: Expression, rhs: Expression) : PredicateBinaryExpr(lhs, rhs) {
    override fun eval(l: Double, r: Double): Boolean = l <= r

    override fun eval(l: String, r: String): Boolean = l <= r
}

class EqBinaryExpr(lhs: Expression, rhs: Expression) : PredicateBinaryExpr(lhs, rhs) {
    override fun eval(l: Double, r: Double): Boolean = l == r

    override fun eval(l: Boolean, r: Boolean): Boolean = l == r

    override fun eval(l: String, r: String): Boolean = l == r
}

class NeqBinaryExpr(lhs: Expression, rhs: Expression) : PredicateBinaryExpr(lhs, rhs) {
    override fun eval(l: Double, r: Double): Boolean = l != r

    override fun eval(l: Boolean, r: Boolean): Boolean = l != r

    override fun eval(l: String, r: String): Boolean = l != r
}
