package com.rchowell.sift.shell

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.execution.Executor
import com.rchowell.sift.shell.kosh.Runner

/**
 * Execute a query in the environment.
 * Very basic now. I really want vi style editing without
 *  having to worry about escaping quotes. Still trying to
 *  learn about JLine widgets + custom LineReader
 */
class SiftRunner(private val env: Environment) : Runner {

    override fun run(line: String) {
        try {
            Executor.sift(env, line)
        } catch (e: Exception) {
            println(e)
        }
    }
}
