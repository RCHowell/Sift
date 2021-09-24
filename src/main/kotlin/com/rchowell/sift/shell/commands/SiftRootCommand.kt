package com.rchowell.sift.shell.commands

import picocli.CommandLine
import picocli.shell.jline3.PicocliCommands
import com.rchowell.sift.shell.Context
import com.rchowell.sift.shell.kosh.RootCommand

/**
 * Top-level command for Sift shell.
 */
@CommandLine.Command(
    subcommands = [
        PicocliCommands.ClearScreen::class,
        CommandLine.HelpCommand::class,
        SiftCommand::class,
        UseCommand::class,
        RelationsCommand::class,
    ]
)
class SiftRootCommand(val context: Context) : RootCommand()
