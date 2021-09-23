package sift.execution

import sift.source.InvalidSourceException
import sift.source.Source

class Environment(
    sources: List<Source> = emptyList()
) {

    val sourceMap: MutableMap<String, Source> = mutableMapOf()

    init {
        sources.forEach { registerSource(it) }
    }

    fun registerSource(source: Source) {
        sourceMap[source.identifier] = source
    }

    fun getSource(identifier: String): Source = sourceMap[identifier] ?: throw InvalidSourceException(identifier)
}
