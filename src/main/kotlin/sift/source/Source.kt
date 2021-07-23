package sift.source

import sift.types.Batch
import sift.types.Schema

class InvalidSourceException(id: String) : Exception("Invalid source $id")

/**
 * Provides an interface for loading structured data from various sources
 *
 * @constructor Create empty Source
 */
interface Source {

    /**
     * Identifier for this source
     */
    val identifier: String

    /**
     * Schema for the source
     */
    val schema: Schema

    /**
     * For any initialization work such as opening files or establishing connections
     */
    fun init()

    /**
     * Resource cleanup
     */
    fun close()

    /**
     * Given a list of identifiers, a [Source] will return a sequence of [Batch]s
     *
     * @param identifiers
     * @return
     */
    fun scan(identifiers: List<String>): Sequence<Batch>
}
