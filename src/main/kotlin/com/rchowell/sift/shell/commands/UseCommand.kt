package com.rchowell.sift.shell.commands

import picocli.CommandLine.Command
import picocli.CommandLine.Parameters
import picocli.CommandLine.ParentCommand

/**
 * Command to set the relation source for repeated queries
 */
@Command(
    name = "use",
    mixinStandardHelpOptions = true
)
class UseCommand : Runnable {

    @ParentCommand
    lateinit var root: SiftRootCommand

    @Parameters(
        description = ["Relation name"]
    )
    lateinit var relation: String

    override fun run() {
        try {
            root.context.useRelation(relation)
        } catch (e: Exception) {
            println("unknown relation")
            println(e)
        }
    }
}
