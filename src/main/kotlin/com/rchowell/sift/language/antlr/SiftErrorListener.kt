package com.rchowell.sift.language.antlr

import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.misc.ParseCancellationException

/**
 * https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4
 *
 * @constructor Create empty Sift error listener
 */
class SiftErrorListener : BaseErrorListener() {
    override fun syntaxError(
        recognizer: Recognizer<*, *>,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        e: RecognitionException?
    ) {
        var sourceName: String = recognizer.inputStream.sourceName
        if (sourceName.isNotEmpty()) {
            sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine)
        }
        val message = sourceName + "line " + line + ":" + charPositionInLine + " " + msg
        throw ParseCancellationException(message)
    }

    companion object {
        var INSTANCE = SiftErrorListener()
    }
}
