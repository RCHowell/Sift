package sift.shell

import org.fusesource.jansi.AnsiConsole
import org.jline.console.SystemRegistry
import org.jline.console.impl.Builtins
import org.jline.console.impl.SystemRegistryImpl
import org.jline.keymap.KeyMap
import org.jline.reader.Binding
import org.jline.reader.EndOfFileException
import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.reader.MaskingCallback
import org.jline.reader.Parser
import org.jline.reader.Reference
import org.jline.reader.UserInterruptException
import org.jline.reader.impl.DefaultParser
import org.jline.terminal.TerminalBuilder
import org.jline.widget.TailTipWidgets
import picocli.CommandLine
import picocli.CommandLine.ArgGroup
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.ParentCommand
import picocli.shell.jline3.PicocliCommands
import picocli.shell.jline3.PicocliCommands.PicocliCommandsFactory
import java.io.PrintWriter
import java.nio.file.Paths
import java.util.concurrent.TimeUnit
import java.util.function.Supplier

fun main(args: Array<String>) {
    AnsiConsole.systemInstall()
    try {

        val workDir = Supplier {
            Paths.get(
                System.getProperty("user.dir")
            )
        }

        // set up JLine built-in commands
        val builtins = Builtins(workDir, null, null)
        builtins.rename(Builtins.Command.TTOP, "top")
        builtins.alias("zle", "widget")
        builtins.alias("bindkey", "keymap")

        // set up picocli commands
        val commands = Example.CliCommands()
        val factory = PicocliCommandsFactory()

        // Or, if you have your own factory, you can chain them like this:
        // MyCustomFactory customFactory = createCustomFactory(); // your application custom factory
        // PicocliCommandsFactory factory = new PicocliCommandsFactory(customFactory); // chain the factories
        val cmd = CommandLine(commands, factory)
        val picocliCommands = PicocliCommands(cmd)

        // JLine Parser
        val parser: Parser = DefaultParser()

        TerminalBuilder.builder().build().use { terminal ->
            val systemRegistry: SystemRegistry = SystemRegistryImpl(parser, terminal, workDir, null)
            systemRegistry.setCommandRegistries(builtins, picocliCommands)
            systemRegistry.register("help", picocliCommands)
            val reader: LineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(systemRegistry.completer())
                .parser(parser)
                .variable(LineReader.LIST_MAX, 50) // max tab completion candidates
                .build()
            builtins.setLineReader(reader)
            commands.setReader(reader)
            factory.setTerminal(terminal)
            val widgets =
                TailTipWidgets(reader, systemRegistry::commandDescription, 5, TailTipWidgets.TipType.COMPLETER)
            widgets.enable()
            val keyMap: KeyMap<Binding> = reader.getKeyMaps().get("main")!!
            keyMap.bind(Reference("tailtip-toggle"), KeyMap.alt("s"))
            val prompt = "prompt> "
            val rightPrompt: String? = null

            // Main Shell Loop
            var line: String?
            while (true) {
                try {
                    systemRegistry.cleanUp()
                    line = reader.readLine(prompt, rightPrompt, null as MaskingCallback?, null)
                    systemRegistry.execute(line)
                } catch (e: UserInterruptException) {
                    // Ignore
                } catch (e: EndOfFileException) {
                    return
                } catch (e: Exception) {
                    systemRegistry.trace(e)
                }
            }
        }
    } catch (t: Throwable) {
        t.printStackTrace()
    } finally {
        AnsiConsole.systemUninstall()
    }
}

class Example {

    /**
     * Top-level command that just prints help.
     */
    @Command(
        name = "",
        description = [
            "Example interactive shell with completion and autosuggestions. " +
                "Hit @|magenta <TAB>|@ to see available commands.", "Hit @|magenta ALT-S|@ to toggle tailtips.", ""
        ],
        footer = ["", "Press Ctrl-D to exit."],
        subcommands = [MyCommand::class, PicocliCommands.ClearScreen::class, CommandLine.HelpCommand::class]
    )
    internal class CliCommands : Runnable {
        var out: PrintWriter? = null
        fun setReader(reader: LineReader) {
            out = reader.getTerminal().writer()
        }

        override fun run() {
            out?.println(CommandLine(this).getUsageMessage())
        }
    }

    /**
     * A command with some options to demonstrate completion.
     */
    @Command(
        name = "cmd",
        mixinStandardHelpOptions = true,
        version = ["1.0"],
        description = ["Command with some options to demonstrate TAB-completion.", " (Note that enum values also get completed.)"],
        subcommands = [Nested::class, CommandLine.HelpCommand::class]
    )
    internal class MyCommand : Runnable {
        @Option(
            names = ["-v", "--verbose"],
            description = [
                "Specify multiple -v options to increase verbosity.",
                "For example, `-v -v -v` or `-vvv`"
            ]
        )
        private val verbosity = booleanArrayOf()

        @ArgGroup(exclusive = false)
        private val myDuration = MyDuration()

        internal class MyDuration {
            @Option(names = ["-d", "--duration"], description = ["The duration quantity."], required = true)
            var amount = 0

            @Option(names = ["-u", "--timeUnit"], description = ["The duration time unit."], required = true)
            var unit: TimeUnit? = null
        }

        @ParentCommand
        var parent: CliCommands? = null
        override fun run() {
            if (verbosity.size > 0) {
                parent!!.out!!.printf(
                    "Hi there. You asked for %d %s.%n",
                    myDuration.amount, myDuration.unit
                )
            } else {
                parent!!.out!!.println("hi!")
            }
        }
    }

    @Command(
        name = "nested",
        mixinStandardHelpOptions = true,
        subcommands = [CommandLine.HelpCommand::class],
        description = ["Hosts more sub-subcommands"]
    )
    internal class Nested : Runnable {
        override fun run() {
            println("I'm a nested subcommand. I don't do much, but I have sub-subcommands!")
        }

        @Command(
            mixinStandardHelpOptions = true,
            subcommands = [CommandLine.HelpCommand::class],
            description = ["Multiplies two numbers."]
        )
        fun multiply(
            @Option(names = ["-l", "--left"], required = true) left: Int,
            @Option(names = ["-r", "--right"], required = true) right: Int
        ) {
            System.out.printf("%d * %d = %d%n", left, right, left * right)
        }

        @Command(
            mixinStandardHelpOptions = true,
            subcommands = [CommandLine.HelpCommand::class],
            description = ["Adds two numbers."]
        )
        fun add(
            @Option(names = ["-l", "--left"], required = true) left: Int,
            @Option(names = ["-r", "--right"], required = true) right: Int
        ) {
            System.out.printf("%d + %d = %d%n", left, right, left + right)
        }

        @Command(
            mixinStandardHelpOptions = true,
            subcommands = [CommandLine.HelpCommand::class],
            description = ["Subtracts two numbers."]
        )
        fun subtract(
            @Option(names = ["-l", "--left"], required = true) left: Int,
            @Option(names = ["-r", "--right"], required = true) right: Int
        ) {
            System.out.printf("%d - %d = %d%n", left, right, left - right)
        }
    }
}
