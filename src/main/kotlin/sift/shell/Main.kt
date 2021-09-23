package sift.shell

import sift.execution.Environment
import sift.shell.commands.SiftRootCommand
import sift.shell.data.pets
import sift.shell.kosh.Shell

fun main(args: Array<String>) {

    // Initialize Shell Context
    val env = Environment(
        sources = listOf(pets)
    )
    val context = Context(env)

    val shell = Shell(
        prompt = "-> ",
        root = SiftRootCommand(context),
    )
    shell.run()
}
