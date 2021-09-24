package com.rchowell.sift.shell.commands

import de.vandermeer.asciitable.AsciiTable
import picocli.CommandLine.Command
import picocli.CommandLine.ParentCommand

/**
 * Command to list relations in the environment
 */
@Command(
    name = "relations",
    aliases = ["ls"],
    mixinStandardHelpOptions = true,
)
class RelationsCommand : Runnable {

    @ParentCommand
    lateinit var root: SiftRootCommand

    override fun run() {
        try {
            val table = AsciiTable()
            table.addRule()
            table.addRow("Name", "Type")
            table.addRule()
            root.context.env.sourceMap.forEach {
                table.addRow(it.key, it.value::class.java.name)
                table.addRule()
            }
            println(table.render())
        } catch (e: Exception) {
            println("unknown relation")
            println(e)
        }
    }
}
