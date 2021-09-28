package com.rchowell.sift.shell.commands

import com.rchowell.sift.shell.Context
import com.rchowell.sift.shell.kosh.CommandGroup
import picocli.CommandLine
import picocli.CommandLine.Command

@Command(
    name = "debug",
    description = ["Collection of query compiler debug commands"],
    subcommands = [DescribeCommand::class],
)
class DebugGroup : CommandGroup() {

    @CommandLine.ParentCommand
    lateinit var root: SiftRootCommand

    val context: Context
        get() = root.context
}
