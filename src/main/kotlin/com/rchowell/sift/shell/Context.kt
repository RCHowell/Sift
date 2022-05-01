package com.rchowell.sift.shell

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.source.Source

/**
 * Holds shell context to share state between commands
 */
class Context(
    val env: Environment
) {

    var source: Source? = null

    var value: String? = null

    /**
     * Sets the context's [Source]
     */
    fun useRelation(id: String) {
        source = env.getSource(id)
    }
}
