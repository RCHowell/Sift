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
    COMMA,
    EOF;
}

enum class KEYWORDS {
    SELECT,
    PROJECT,
    GROUP,
    SORT,
    LIMIT,
    DISTINCT,
}

enum class PRODUCTIONS {
    JOIN,
    CROSS,
    UNION,
    DIFF,
    INTERSECT,
}

class Token<T : Any>(val type: TokenType, val value: T? = null) {

    companion object {

        /**
         * Bag operators
         */
        val PRODUCTIONS = setOf(
            "JOIN",
            "CROSS",
            "UNION",
            "DIFF",
            "INTERSECT",
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
            "ASC",
            "DESC",
        ).union(PRODUCTIONS)

        /**
         * O p e r a t o r s
         */
        val OPERATORS = setOf(
            "=", "!=", "<", "<=", ">=", ">", "~",
            "||", "&&", "%",
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

/**
 * TokenList is a helper class for parsers to abstract processing the list of tokens from a Lexer
 *
 * @constructor Create empty Token list
 */
class TokenList(val tokens: List<Token<*>>) {

    var pointer = 0

    fun reset() {
        pointer = 0
    }

    /**
     * Returns the latest token without advancing the pointer
     */
    fun peek(): Token<*> = tokens[pointer]

    /**
     * Returns the latest token and advances the pointer
     */
    fun next(): Token<*> = tokens[pointer++]

    /**
     * Returns some context around the current token
     */
    fun context(n: Int = 3): String = buildString {
        for (i in (pointer - n) until (pointer + n)) {
            if (i == pointer - 1) {
                append(">>")
                append(tokens[i].value)
                append("<< ")
                continue
            }
            if (i > 0 && i < tokens.size) {
                append(tokens[i].value)
            }
            append(" ")
        }
    }
}
