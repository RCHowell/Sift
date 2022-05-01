package com.rchowell.sift.shell.commands

import com.rchowell.sift.shell.Context
import picocli.CommandLine
import javax.inject.Inject

object SetCommand {

    class Params @Inject constructor(
        val ctx: Context,
    )

    @CommandLine.Command(
        name = "set"
    )
    class Command : Runnable {

        @CommandLine.ParentCommand
        lateinit var root: SiftRootCommand

        @CommandLine.Parameters(
            description = ["value to set"]
        )
        lateinit var value: String

        override fun run() {
            val params = root.injector.getInstance(Params::class.java)
            println("Old value: ${params.ctx.value}")
            params.ctx.value = value
            println("New value: ${params.ctx.value}")
        }
    }
}
