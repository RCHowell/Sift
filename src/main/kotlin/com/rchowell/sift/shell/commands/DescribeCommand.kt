package com.rchowell.sift.shell.commands

import com.rchowell.sift.language.v0.antlr.SiftCompiler
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters
import picocli.CommandLine.ParentCommand

/**
 * Describes the given query
 */
@Command(name = "describe")
class DescribeCommand : Runnable {

    @ParentCommand
    lateinit var root: DebugGroup

    @Parameters(description = ["sift query"])
    lateinit var query: String

    override fun run() {
        try {
            val compiler = SiftCompiler(root.context.env)
            val description = compiler.describe(query)
            println(description)
        } catch (e: Exception) {
            println(e)
        }
    }
}
