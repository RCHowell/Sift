package sift.execution.logical.expressions

enum class BinaryOp(private val s: String) {
    EQ("=="),
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
}

enum class UnaryOp(private val s: String) {
    INC("++"),
    DEC("--"),
    NOT("!"),
}

enum class AggOp {
    MIN,
    MAX,
    SUM,
    COUNT,
    AVG;
}
