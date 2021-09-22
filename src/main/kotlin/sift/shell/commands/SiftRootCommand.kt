package sift.shell.commands

import picocli.CommandLine
import picocli.shell.jline3.PicocliCommands
import sift.shell.kosh.RootCommand

/**
 * Top-level command for Sift shell. Add new commands here.
 */
@CommandLine.Command(
    subcommands = [
        PicocliCommands.ClearScreen::class,
        CommandLine.HelpCommand::class,
        MathCommands::class,
    ]
)
class SiftRootCommand : RootCommand()
