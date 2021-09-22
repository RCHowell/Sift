package sift.shell.kosh

import java.io.PrintWriter

/**
 * Top-Level must extend root command.
 * This is used for exposing the PrintWriter to other commands
 *
 * @constructor Create empty Root command
 */
abstract class RootCommand : Runnable {
    lateinit var out: PrintWriter
    override fun run() {
        // no-op
    }
}
