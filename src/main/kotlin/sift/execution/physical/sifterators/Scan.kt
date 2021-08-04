package sift.execution.physical.sifterators

import sift.source.Source
import sift.types.Batch

/**
 * PhysicalScan
 *
 * @property source
 * @property fields
 * @constructor Create empty Physical scan
 */
class Scan(
    val source: Source,
    val fields: List<String>
) : Sifterator {

    lateinit var batches: Iterator<Batch>

    override fun open() {
        source.init()
        batches = source.scan(fields).iterator()
    }

    override fun next(): Batch = batches.next()

    override fun close() {
        source.close()
    }
}
