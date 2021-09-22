package sift.shell.commands

import picocli.CommandLine
import picocli.CommandLine.Command

/**
 * Example Math commands for exercise
 */
@Command(
    name = "math",
    description = ["Simple math commands"],
    mixinStandardHelpOptions = true,
    subcommands = [CommandLine.HelpCommand::class]
)
class MathCommands : Runnable {

    override fun run() {
        println(CommandLine(this).usageMessage);
    }

    @Command(
        mixinStandardHelpOptions = true,
        subcommands = [CommandLine.HelpCommand::class],
        description = ["Multiplies two numbers."]
    )
    fun multiply(
        @CommandLine.Option(names = ["-l", "--left"], required = true) left: Int,
        @CommandLine.Option(names = ["-r", "--right"], required = true) right: Int
    ) {
        System.out.printf("%d * %d = %d%n", left, right, left * right)
    }

    @Command(
        mixinStandardHelpOptions = true,
        subcommands = [CommandLine.HelpCommand::class],
        description = ["Adds two numbers."]
    )
    fun add(
        @CommandLine.Option(names = ["-l", "--left"], required = true) left: Int,
        @CommandLine.Option(names = ["-r", "--right"], required = true) right: Int
    ) {
        System.out.printf("%d + %d = %d%n", left, right, left + right)
    }

    @Command(
        mixinStandardHelpOptions = true,
        subcommands = [CommandLine.HelpCommand::class],
        description = ["Subtracts two numbers."]
    )
    fun subtract(
        @CommandLine.Option(names = ["-l", "--left"], required = true) left: Int,
        @CommandLine.Option(names = ["-r", "--right"], required = true) right: Int
    ) {
        System.out.printf("%d - %d = %d%n", left, right, left - right)
    }

    @Command(
        mixinStandardHelpOptions = true,
        subcommands = [CommandLine.HelpCommand::class],
        description = ["Divides two numbers."]
    )
    fun divide(
        @CommandLine.Option(names = ["-l", "--left"], required = true) left: Int,
        @CommandLine.Option(names = ["-r", "--right"], required = true) right: Int
    ) {
        if (right == 0) {
            println("undefined")
        } else {
            System.out.printf("%d / %d = %f%n", left, right, left / right.toDouble())
        }
    }
}
