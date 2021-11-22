package com.rchowell.sift.shell

import com.rchowell.sift.language.v0.antlr.SiftCompiler
import com.rchowell.sift.language.v0.antlr.SiftLexer
import com.rchowell.sift.language.v0.antlr.SiftParser
import org.antlr.v4.runtime.CommonTokenStream
import org.jline.reader.Highlighter
import org.jline.reader.LineReader
import org.jline.utils.AttributedString
import org.jline.utils.AttributedStringBuilder
import org.jline.utils.AttributedStyle
import org.jline.utils.AttributedStyle.BLUE
import org.jline.utils.AttributedStyle.BOLD
import org.jline.utils.AttributedStyle.CYAN
import org.jline.utils.AttributedStyle.DEFAULT
import org.jline.utils.AttributedStyle.GREEN
import org.jline.utils.AttributedStyle.MAGENTA
import org.jline.utils.AttributedStyle.RED
import java.util.regex.Pattern

class SiftHighlighter : Highlighter {

    private val keywords = SiftCompiler.keywords()

    override fun highlight(reader: LineReader?, buffer: String?): AttributedString {
        var tokens: CommonTokenStream? = null
        val builder = AttributedStringBuilder()
        var error = false
        try {
            tokens = SiftCompiler.lex(buffer ?: "")
            val parser = SiftParser(tokens)
            parser.removeErrorListeners()
            parser.query() // builds the token stream
        } catch (e: Exception) {
            error = true
        }
        if (tokens == null) {
            builder.styled(ERROR, buffer)
            return builder.toAttributedString()
        }
        tokens.tokens.forEach {
            when {
                (error || it.type == SiftLexer.UNRECOGNIZED) -> {
                    error = true
                    builder.styled(ERROR, it.text)
                }
                isKeyword(it.text) -> builder.styled(KEYWORD, it.text)
                it.type == SiftLexer.PIPE -> builder.styled(KEYWORD, it.text)
                it.type == SiftLexer.ID -> builder.styled(IDENTIFIER, it.text)
                it.type == SiftLexer.STRING -> builder.styled(STRING, it.text)
                it.type == SiftLexer.INT -> builder.styled(NUMBER, it.text)
                it.type == SiftLexer.EOF -> {}
                else -> builder.append(it.text)
            }
        }
        return builder.toAttributedString()
    }

    override fun setErrorPattern(errorPattern: Pattern?) {
    }

    override fun setErrorIndex(errorIndex: Int) {
    }

    private fun isKeyword(text: String): Boolean = keywords.contains(text.toUpperCase())

    private fun isString(type: Int): Boolean = when (type) {
        SiftLexer.STRING -> true
        else -> false
    }

    private fun isNumber(type: Int): Boolean = when (type) {
        SiftLexer.INT -> true
        else -> false
    }

    private companion object Styles {
        private val KEYWORD: AttributedStyle = BOLD.foreground(MAGENTA)
        private val IDENTIFIER: AttributedStyle = DEFAULT.foreground(CYAN)
        private val STRING: AttributedStyle = DEFAULT.foreground(BLUE)
        private val NUMBER: AttributedStyle = DEFAULT.foreground(GREEN)
        private val ERROR: AttributedStyle = DEFAULT.foreground(RED)
    }
}
