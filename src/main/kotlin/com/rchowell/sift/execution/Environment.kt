package com.rchowell.sift.execution

import com.rchowell.sift.source.InvalidSourceException
import com.rchowell.sift.source.Source

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
