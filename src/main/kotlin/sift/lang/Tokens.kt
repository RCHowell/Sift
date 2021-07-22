package sift.lang

enum class TokenType {
    KEYWORD,
    IDENTIFIER,
    OPERATOR,
    LITERAL,
    PIPE,
    LEFT_PAREN,
    RIGHT_PAREN,
    MAPSTO,
    COMMA;
}

enum class KEYWORDS {
    SELECT,
    PROJECT,
    GROUP,
    SORT,
    LIMIT,
    DISTINCT,
}

class Token<T : Any>(val type: TokenType, val value: T? = null) {

    companion object {

        /**
         * Bag operators
         */
        val BAGOPS = setOf(
            "X", "CROSS",
            "U", "UNION",
            "\\", "DIFF",
            "&", "INTERSECT",
        )

        /**
         * K e y w o r d s
         */
        val KEYWORDS = setOf(
            "SELECT",
            "PROJECT",
            "GROUP",
            "SORT",
            "LIMIT",
            "DISTINCT",
            "AS",
            "BY",
            "ON",
            "OUTER",
            "LEFT",
            "RIGHT",
        ).union(BAGOPS)

        /**
         * O p e r a t o r s
         */
        val OPERATORS = setOf(
            "=", "!=", "<", "<=", ">=", ">", "~",
            "||", "&&",
            "+", "-", "*", "/",
        )

        /**
         * S y m b o l s
         */
        val SYMBOLS = mapOf(
            "|>" to TokenType.PIPE,
            "," to TokenType.COMMA,
            "(" to TokenType.LEFT_PAREN,
            ")" to TokenType.RIGHT_PAREN
        )

        val BOOLEANS = setOf("TRUE", "FALSE", "UNKNOWN")
    }

    override fun toString(): String = "TOKEN($type, $value)"
}
