package com.rchowell.sift.shell.commands

import de.vandermeer.asciitable.AsciiTable
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment
import picocli.CommandLine.Command
import picocli.CommandLine.ParentCommand

/**
 * Command to list relations in the environment
 */
@Command(
    name = "list",
    aliases = ["ls"],
    mixinStandardHelpOptions = true,
)
class ListCommand : Runnable {

    @ParentCommand
    lateinit var root: SiftRootCommand

    override fun run() {
        try {
            root.context.env.sourceMap.values.forEach { source ->
                val table = AsciiTable()
                table.addRule()
                val r = table.addRow(null, source.identifier)
                r.setPadding(1)
                r.setTextAlignment(TextAlignment.CENTER)
                table.addRule()
                table.addRow("Field", "Type")
                table.addRule()
                source.schema.fields.forEach { field ->
                    table.addRow(" ● ${field.identifier}", " ○ ${field.type}")
                    table.addRule()
                }
                println(table.render())
                println()
            }
        } catch (e: Exception) {
            println("unknown relation")
            println(e)
        }
    }
}
