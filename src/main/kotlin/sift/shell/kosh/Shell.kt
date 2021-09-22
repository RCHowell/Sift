package sift.shell.kosh

import org.fusesource.jansi.AnsiConsole
import org.jline.console.impl.Builtins
import org.jline.console.impl.SystemRegistryImpl
import org.jline.reader.EndOfFileException
import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.reader.MaskingCallback
import org.jline.reader.UserInterruptException
import org.jline.reader.impl.DefaultParser
import org.jline.terminal.TerminalBuilder
import picocli.CommandLine
import picocli.shell.jline3.PicocliCommands
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Shell is the marriage of JLine (shell), Picocli, and Jansi
 *  with the goal of removing boilerplate from Java/Kotlin shell applications.
 *
 * This is comes from the JLine+shell example
 * https://github.com/remkop/picocli/tree/master/picocli-shell-jline3
 */
class Shell(
    private val prompt: String = ">",
    private val rightPrompt: String? = null,
    private val root: RootCommand,
    builtins: Set<Builtins.Command> = setOf(
        Builtins.Command.COLORS,
        Builtins.Command.HISTORY,
        Builtins.Command.TTOP,
    ),
) {

    // TODO configurable working directory
    private val workDir: Path = Paths.get(System.getProperty("user.dir"))

    private val builtins = Builtins(builtins, workDir, null, null)

    private val parser = DefaultParser()

    /**
     * Starts the shell and waits for commands
     */
    fun run() {
        AnsiConsole.systemInstall()
        try {

            // Create a CommandRegistry for the shell from our Picocli commands
            val commandFactory = PicocliCommands.PicocliCommandsFactory()
            // TODO use own factory to override the command grouping name which is the class name
            val commandsRegistry = PicocliCommands(CommandLine(root, commandFactory))

            TerminalBuilder.builder().build().use { terminal ->

                // Add the builtin and user commands to the composite registry
                val commands = SystemRegistryImpl(parser, terminal, { workDir }, null)
                commands.setCommandRegistries(builtins, commandsRegistry)

                // Worth making configurable?
                val reader: LineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(commands.completer())
                    .parser(parser)
                    .variable(LineReader.LIST_MAX, 50)
                    .build()
                builtins.setLineReader(reader)

                // Setup output of the root command
                root.out = reader.terminal.writer()
                commandFactory.setTerminal(terminal)

                // TODO figure out how I want to toggle the tailtip because I really like this feature
                // https://github.com/remkop/picocli/blob/master/picocli-shell-jline3/src/test/java/picocli/shell/jline3/example/Example.java#L167-L170

                // Main Shell Loop
                var line: String?
                while (true) {
                    try {
                        commands.cleanUp()
                        line = reader.readLine(prompt, rightPrompt, null as MaskingCallback?, null)
                        commands.execute(line)
                    } catch (e: UserInterruptException) {
                        // Ignore
                    } catch (e: EndOfFileException) {
                        return
                    } catch (e: Exception) {
                        commands.trace(e)
                    }
                }
            }
        } catch (t: Throwable) {
            t.printStackTrace()
        } finally {
            AnsiConsole.systemUninstall()
        }
    }
}
