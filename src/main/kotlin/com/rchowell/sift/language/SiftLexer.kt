package com.rchowell.sift.language

/**
 * Tokenizes a [String] (ideally a Sift query) into a [Token] list.
 */
interface SiftLexer {
    fun tokenize(input: String): List<Token<*>>
}
