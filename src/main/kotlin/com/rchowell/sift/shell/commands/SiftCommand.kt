package com.rchowell.sift.shell.commands

import com.rchowell.sift.execution.Executor
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters
import picocli.CommandLine.ParentCommand

/**
 * Execute a query in the environment.
 * Very basic now. I really want vi style editing without
 *  having to worry about escaping quotes. Still trying to
 *  learn about JLine widgets + custom LineReader
 */
@Command(name = "sift")
class SiftCommand : Runnable {

    @ParentCommand
    lateinit var root: SiftRootCommand

    @Parameters(description = ["sift query"])
    lateinit var query: String

    override fun run() {
        try {
            // TODO better way to capture output
            Executor.sift(root.context.env, query)
        } catch (e: Exception) {
            println(e)
        }
    }
}
