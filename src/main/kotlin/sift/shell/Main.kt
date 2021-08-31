package sift.shell

import com.rchowell.kosch.Command
import com.rchowell.kosch.Shell
import sift.execution.Environment
import sift.shell.commands.SiftCommand
import sift.shell.data.pets

fun main() {

    // Our execution environment
    val env = Environment()

    // Load the sample data for now until I have sources and load commands
    env.registerSource(pets)

    val shell = Shell(
        commands = listOf<Command>(
            SiftCommand(env),
        ),
        greeting = "Sift Shell"
    )
    shell.run()
}
