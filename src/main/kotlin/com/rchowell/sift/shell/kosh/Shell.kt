package com.rchowell.sift.shell.kosh

import com.rchowell.sift.shell.SiftLineParser
import org.fusesource.jansi.AnsiConsole
import org.jline.console.impl.Builtins
import org.jline.console.impl.SystemRegistryImpl
import org.jline.reader.Completer
import org.jline.reader.EndOfFileException
import org.jline.reader.Highlighter
import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.reader.UserInterruptException
import org.jline.reader.impl.DefaultHighlighter
import org.jline.terminal.TerminalBuilder
import picocli.CommandLine
import picocli.shell.jline3.PicocliCommands
import java.nio.file.Path
import java.nio.file.Paths

/**
 * https://github.com/remkop/picocli/tree/master/picocli-shell-jline3
 */
class Shell(
    private val prompt: String = "> ",
    private val root: RootCommand,
    private val runner: Runner,
    private val highlighter: Highlighter? = null,
    private val completer: Completer? = null,
    builtins: Set<Builtins.Command> = setOf(
        Builtins.Command.COLORS,
        Builtins.Command.HISTORY,
        Builtins.Command.TTOP,
    ),
) {

    // TODO configurable working directory
    private val workDir: Path = Paths.get(System.getProperty("user.dir"))

    private val builtins = Builtins(builtins, workDir, null, null)

    private val parser = SiftLineParser()

    /**
     * Starts the shell and waits for commands
     */
    fun run() {
        AnsiConsole.systemInstall()
        try {

            val commandFactory = PicocliCommands.PicocliCommandsFactory()
            // TODO use own factory to override the command grouping name which is the class name
            val commandsRegistry = PicocliCommands(CommandLine(root, commandFactory))

            TerminalBuilder.builder().build().use { terminal ->

                // Add the builtin and user commands to the composite registry
                val commands = SystemRegistryImpl(parser, terminal, { workDir }, null)
                commands.setCommandRegistries(builtins, commandsRegistry)

                parser.commands = commands.commandNames()

                // Worth making configurable?
                val reader: LineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(commands.completer())
                    .parser(parser)
                    .highlighter(highlighter ?: DefaultHighlighter())
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
                        line = reader.readLine(prompt)
                        val command = line.split(" ").first()
                        if (commands.commandNames().contains(command)) {
                            commands.execute(line)
                        } else {
                            runner.run(line)
                        }
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
