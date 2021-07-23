package sift.execution

import sift.source.InvalidSourceException
import sift.source.Source

class Environment {

    private val sources = mutableMapOf<String, Source>()

    fun registerSource(source: Source) {
        sources[source.identifier] = source
    }

    fun getSource(identifier: String): Source = sources[identifier] ?: throw InvalidSourceException(identifier)
}
