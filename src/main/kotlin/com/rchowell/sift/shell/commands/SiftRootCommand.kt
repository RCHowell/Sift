package com.rchowell.sift.shell.commands

import com.google.inject.Injector
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
        ListCommand::class,
        DebugGroup::class,
        SetCommand.Command::class
    ]
)
class SiftRootCommand(
    val context: Context,
    val injector: Injector,
) : RootCommand()
