package sift.execution.logical.functions

import sift.execution.logical.LogicalExpr

class UnknownFunction(name: String) : Exception("unknown function $name")

/**
 * Helper functions such a STRLEN, LOWERCASE, ABS, etc.
 *
 * @constructor Create empty Logical function
 */
sealed class LogicalFunction {

    companion object {

        // TODO add some functions
        fun get(name: String, vararg args: LogicalExpr): LogicalExpr {
            throw UnknownFunction(name)
        }
    }
}
