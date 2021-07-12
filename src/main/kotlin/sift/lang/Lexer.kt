package sift.lang

/**
 * Tokenizes a [String] (ideally a Sift query) into a [Token] list.
 */
interface Lexer {
    fun tokenize(input: String): List<Token<*>>
}
