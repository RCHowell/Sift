package sift.source

import sift.types.Batch
import sift.types.Schema

/**
 * CSV source
 *
 * @property path
 * @property mapping
 * @constructor Create empty Csv source
 */
class CsvSource(
    override val identifier: String,
    override val schema: Schema,
    val path: String,
    val mapping: Map<String, Int>,
) : Source {

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }

    override fun scan(identifiers: List<String>): Sequence<Batch> {
        TODO("Not yet implemented")
    }
}
