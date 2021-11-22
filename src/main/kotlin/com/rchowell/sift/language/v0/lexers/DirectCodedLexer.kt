package com.rchowell.sift.language.v0.lexers

import com.rchowell.sift.language.SiftLexer
import com.rchowell.sift.language.Token
import com.rchowell.sift.language.TokenType.COMMA
import com.rchowell.sift.language.TokenType.EOF
import com.rchowell.sift.language.TokenType.IDENTIFIER
import com.rchowell.sift.language.TokenType.KEYWORD
import com.rchowell.sift.language.TokenType.LEFT_PAREN
import com.rchowell.sift.language.TokenType.LITERAL
import com.rchowell.sift.language.TokenType.MAPSTO
import com.rchowell.sift.language.TokenType.OPERATOR
import com.rchowell.sift.language.TokenType.PIPE
import com.rchowell.sift.language.TokenType.RIGHT_PAREN

class InvalidTokenException(t: String) : Exception("invalid token $t")

/**
 * Could be better
 */
class DirectCodedLexer : SiftLexer {

    private val idPattern = Regex("[A-Za-z\\-_]")

    operator fun Regex.contains(text: Char): Boolean = this.matches(text.toString())

    /** Used to represent current type being scanned */
    enum class State {
        INIT,
        ID,
        INT,
        FLOAT,
        OP,
        STRING,
        PIPE,
    }

    /**
     * Tokenize character by character
     */
    override fun tokenize(input: String): List<Token<*>> {

        // I/O
        val terminatedInput = input + "\n"
        val chars = terminatedInput.toCharArray().iterator()
        val tokens = mutableListOf<Token<*>>()

        // Tracking
        val buffer = StringBuilder()
        var state = State.INIT

        fun reset() {
            buffer.clear()
            state = State.INIT
        }

        fun add(t: Token<*>) {
            tokens.add(t)
            reset()
        }

        fun invalid(message: String? = null) {
            throw InvalidTokenException(message ?: buffer.toString())
        }

        while (chars.hasNext()) {
            val curr = chars.next()

            // check if we are in an accepting state
            if (curr.isWhitespace()) {
                when (state) {
                    State.ID -> {
                        val v = buffer.toString()
                        if (v in Token.KEYWORDS) {
                            add(Token(KEYWORD, v))
                        } else {
                            when (v) {
                                "TRUE" -> add(Token(LITERAL, true))
                                "FALSE" -> add(Token(LITERAL, false))
                                else -> add(Token(IDENTIFIER, v))
                            }
                        }
                        continue
                    }
                    State.INT -> {
                        val v = buffer.toString().toInt(10)
                        add(Token(LITERAL, v))
                        continue
                    }
                    State.FLOAT -> {
                        val v = buffer.toString().toFloat()
                        add(Token(LITERAL, v))
                        continue
                    }
                    State.OP -> {
                        val v = buffer.toString()
                        if (v == "->") {
                            add(Token(MAPSTO, v))
                        } else {
                            add(Token(OPERATOR, v))
                        }
                        continue
                    }
                    State.INIT -> continue // skip whitespace
                    else -> {
                    }
                }
            }

            // process next character
            when (state) {
                State.INIT -> {
                    if (curr.isWhitespace()) continue

                    // simple comparisons
                    state = when (curr) {
                        '\'' -> {
                            state = State.STRING
                            continue
                        }
                        '(' -> {
                            add(Token(LEFT_PAREN, "("))
                            continue
                        }
                        ')' -> {
                            add(Token(RIGHT_PAREN, ")"))
                            continue
                        }
                        ',' -> {
                            add(Token(COMMA, ","))
                            continue
                        }
                        '|' -> State.PIPE
                        '=' -> State.OP
                        '!' -> State.OP
                        '<' -> State.OP
                        '>' -> State.OP
                        '~' -> State.OP
                        '&' -> State.OP
                        '+' -> State.OP
                        '-' -> State.OP
                        '*' -> State.OP
                        '/' -> State.OP
                        '%' -> State.OP
                        else -> state
                    }

                    // set difference shorthand
                    if (curr == '\\') {
                        if (chars.hasNext() && chars.next().isWhitespace()) {
                            add(Token(KEYWORD, "DIFF"))
                            continue
                        }
                        invalid()
                    }

                    // state/type has been determined; start building the buffer
                    buffer.append(curr)

                    // first 'when' group already matched something
                    if (state != State.INIT) {
                        continue
                    }

                    when {
                        curr.isDigit() -> {
                            state = State.INT
                        }
                        curr in idPattern -> {
                            state = State.ID
                        }
                        else -> {
                            invalid()
                        }
                    }
                }
                State.PIPE -> {
                    when (curr) {
                        '|' -> add(Token(OPERATOR, "||"))
                        '>' -> add(Token(PIPE, "|>"))
                        else -> invalid()
                    }
                }
                State.ID -> {
                    when (curr) {
                        ',' -> {
                            add(Token(IDENTIFIER, buffer.toString()))
                            add(Token(COMMA, ","))
                        }
                        '(' -> {
                            add(Token(IDENTIFIER, buffer.toString()))
                            add(Token(LEFT_PAREN, "("))
                        }
                        ')' -> {
                            when (val v = buffer.toString()) {
                                "TRUE" -> add(Token(LITERAL, true))
                                "FALSE" -> add(Token(LITERAL, false))
                                else -> add(Token(IDENTIFIER, v))
                            }
                            add(Token(RIGHT_PAREN, ")"))
                        }
                        else -> {
                            if (curr !in idPattern) {
                                invalid("combining $buffer with $curr")
                            }
                            buffer.append(curr)
                        }
                    }
                }
                State.INT -> {
                    when {
                        curr == '.' -> state = State.FLOAT
                        curr == ')' -> {
                            add(Token(LITERAL, buffer.toString().toInt(10)))
                            add(Token(RIGHT_PAREN, ")"))
                        }
                        !curr.isDigit() -> invalid()
                    }
                    buffer.append(curr)
                }
                State.FLOAT -> {
                    if (!curr.isDigit()) invalid()
                    buffer.append(curr)
                }
                State.OP -> {
                    // TODO
                    buffer.append(curr)
                }
                State.STRING -> {
                    if (curr == '\'' && buffer.last() != '\\') {
                        add(Token(LITERAL, buffer.toString()))
                        continue
                    }
                    // everything is allowed in string literals for now
                    // this will likely cause problems
                    buffer.append(curr)
                }
            }
        }
        tokens.add(Token<String>(EOF))
        return tokens
    }
}
