package sift.shell.commands

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
            val sources = buildString {
                root.context.env.sourceMap.keys.forEach {
                    append(it).append("\n")
                }
            }
            println(sources)
        } catch (e: Exception) {
            println("unknown relation")
            println(e)
        }
    }
}
