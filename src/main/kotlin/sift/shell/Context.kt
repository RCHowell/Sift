package sift.shell

import sift.execution.Environment
import sift.source.Source

/**
 * Holds shell context to share state between commands
 */
class Context(
    val env: Environment
) {

    var source: Source? = null

    /**
     * Sets the context's [Source]
     */
    fun useRelation(id: String) {
        source = env.getSource(id)
    }
}
