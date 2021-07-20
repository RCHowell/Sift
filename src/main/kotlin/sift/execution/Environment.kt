package sift.execution

import sift.source.InvalidSourceException
import sift.source.Source

class Environment {

    private val sources = mutableMapOf<String, Source>()

    fun registerSource(identifier: String, source: Source) {
        sources[identifier] = source
    }

    fun getSource(identifier: String): Source = sources[identifier] ?: throw InvalidSourceException(identifier)
}
