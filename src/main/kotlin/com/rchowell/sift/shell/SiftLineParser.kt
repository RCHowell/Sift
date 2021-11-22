package com.rchowell.sift.shell

import org.jline.reader.EOFError
import org.jline.reader.ParsedLine
import org.jline.reader.Parser
import org.jline.reader.Parser.ParseContext.ACCEPT_LINE
import org.jline.reader.Parser.ParseContext.UNSPECIFIED
import org.jline.reader.impl.DefaultParser

class SiftLineParser : Parser {

    // Special commands
    var commands: Set<String> = emptySet()

    private val default = DefaultParser()
    private val nonTerminal = setOf(ACCEPT_LINE, UNSPECIFIED)

    override fun parse(rawLine: String?, cursor: Int, context: Parser.ParseContext?): ParsedLine {
        val line = rawLine ?: ""
        val command = line.trim().split(" ").first()
        if (command.isEmpty() || commands.contains(command) || context == Parser.ParseContext.COMPLETE) {
            return default.parse(rawLine, cursor, context)
        }
        if (nonTerminal.contains(context) && !line.endsWith("\n")) {
            throw EOFError(-1, -1, null)
        }
        return DefaultParser().parse(rawLine, cursor, context)
    }
}
