package sift.shell

import sift.shell.commands.SiftRootCommand
import sift.shell.kosh.Shell

fun main(args: Array<String>) {
    val shell = Shell(
        prompt = "-> ",
        root = SiftRootCommand(),
    )
    shell.run()
}
