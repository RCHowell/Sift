package sift.shell.commands

import com.rchowell.kosch.Command
import com.rchowell.kosch.Opt
import org.apache.commons.cli.CommandLine
import sift.execution.Environment
import sift.execution.Executor

class SiftCommand(val env: Environment) : Command() {

    override val name = "sift"
    override val help = "run a Sift query"
    override val opts = listOf(
        Opt(
            alias = "q",
            name = "query",
            required = true,
            isFlag = false,
            usage = "a sift query",
            type = String::class.java,
        ),
    )

    /**
     * Attempt to execute the query in the environment
     */
    override fun run(args: CommandLine) {
        val query = args.getOptionValue("q")
        assert(query != null)
        Executor.sift(env, query)
    }
}
