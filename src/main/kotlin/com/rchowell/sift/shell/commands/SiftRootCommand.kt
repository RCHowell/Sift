package com.rchowell.sift.shell.commands

import com.rchowell.sift.shell.Context
import com.rchowell.sift.shell.kosh.RootCommand
import picocli.CommandLine.Command
import picocli.CommandLine.HelpCommand
import picocli.shell.jline3.PicocliCommands.ClearScreen

/**
 * Top-level command for Sift shell.
 */
@Command(
    subcommands = [
        ClearScreen::class,
        HelpCommand::class,
        UseCommand::class,
        ListCommand::class,
        DebugGroup::class,
    ]
)
class SiftRootCommand(val context: Context) : RootCommand()
