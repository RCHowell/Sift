package sift.execution.logical.expressions

class UnknownBinaryOp(op: String) : Exception("unknown binary op $op")

enum class BinaryOp(private val s: String) {
    EQ("="),
    NEQ("!="),
    LT("<"),
    LTE("<="),
    GT(">"),
    GTE(">="),
    AND("&&"),
    OR("||"),
    ADD("+"),
    SUB("-"),
    MULT("*"),
    DIV("/"),
    MOD("%");

    override fun toString(): String = this.s

    companion object {

        fun get(op: String) = when (op) {
            "=" -> EQ
            "!=" -> NEQ
            "<" -> LT
            "<=" -> LTE
            ">" -> GT
            ">=" -> GTE
            "&&" -> AND
            "||" -> OR
            "+" -> ADD
            "-" -> SUB
            "*" -> MULT
            "/" -> DIV
            "%" -> MOD
            else -> throw UnknownBinaryOp(op)
        }
    }
}

enum class AggOp {
    MIN,
    MAX,
    SUM,
    COUNT,
    AVG;
}
