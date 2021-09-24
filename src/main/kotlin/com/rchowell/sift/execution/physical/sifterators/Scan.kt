package com.rchowell.sift.execution.physical.sifterators

import com.rchowell.sift.source.Source
import com.rchowell.sift.types.Batch

/**
 * PhysicalScan
 *
 * @property source
 * @property fields
 * @constructor Create empty Physical scan
 */
class Scan(
    val source: Source,
    val fields: List<String>,
) : Sifterator {

    override val schema = source.schema

    lateinit var batches: Iterator<Batch>

    override fun open() {
        source.init()
        batches = source.scan(fields).iterator()
    }

    override fun next(): Batch? {
        return try {
            batches.next()
        } catch (ex: NoSuchElementException) {
            null
        }
    }

    override fun close() {
        source.close()
    }
}
