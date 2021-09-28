package com.rchowell.sift.shell

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.shell.commands.SiftRootCommand
import com.rchowell.sift.shell.data.pets
import com.rchowell.sift.shell.kosh.Shell

fun main(args: Array<String>) {

    // Initialize Shell Context
    val env = Environment(
        sources = listOf(pets)
    )
    val context = Context(env)

    val name = System.getProperty("user.name")

    val shell = Shell(
        prompt = "$name-> ",
        root = SiftRootCommand(context),
    )
    shell.run()
}
