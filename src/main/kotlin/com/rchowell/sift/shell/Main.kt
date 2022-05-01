package com.rchowell.sift.shell

import com.google.inject.Guice
import com.rchowell.sift.execution.Environment
import com.rchowell.sift.shell.commands.SiftRootCommand
import com.rchowell.sift.shell.kosh.Shell
import com.rchowell.sift.source.CsvSource
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type

fun main(args: Array<String>) {
    val source = CsvSource(
        identifier = "mlb",
        schema = Schema(
            listOf(
                Field("Name", Type.String),
                Field("Team", Type.String),
                Field("Position", Type.String),
                Field("Height", Type.Num),
                Field("Weight", Type.Num),
                Field("Age", Type.Num),
            )
        ),
        path = "/Users/rch/Desktop/mlb_players.csv",
        header = true,
    )
    val env = Environment(
        sources = listOf(source)
    )
    val context = Context(env)
    val injector = Guice.createInjector(ShellModule(context))
    val shell = Shell(
        prompt = "-> ",
        root = SiftRootCommand(context, injector),
        highlighter = SiftHighlighter(),
        runner = SiftRunner(env),
    )
    shell.run()
}
