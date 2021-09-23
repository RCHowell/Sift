package sift.shell.kosh

import picocli.CommandLine

/**
 * Command for grouping subcommands which simply prints usage
 */
abstract class CommandGroup : Runnable {
    override fun run() {
        println(CommandLine(this).usageMessage)
    }
}