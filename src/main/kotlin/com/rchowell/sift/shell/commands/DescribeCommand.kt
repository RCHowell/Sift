package com.rchowell.sift.shell.commands

import com.rchowell.sift.lang.antlr.SiftCompiler
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters
import picocli.CommandLine.ParentCommand

/**
 * Describes the given query
 *  - Tokens
 *  - AST
 *  - Logical Plan
 */
@Command(name = "describe")
class DescribeCommand : Runnable {

    @ParentCommand
    lateinit var root: SiftRootCommand

    @Parameters(description = ["sift query"])
    lateinit var query: String

    override fun run() {
        try {
            val compiler = SiftCompiler(root.context.env)
            println(query)
            val trimmed = query.trim('"')
            println(trimmed)
            val description = compiler.describe(trimmed)
            println(description)
        } catch (e: Exception) {
            println(e)
        }
    }
}
