package com.rchowell.sift.execution.physical.sifterators

import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Batch.Companion.valueCount
import com.rchowell.sift.types.set
import kotlin.math.min

/**
 * Limit will return a single [Batch] with [limit] number of records.
 *
 */
class Limit(
    val input: Sifterator,
    val limit: Int,
) : Sifterator {

    var sent = 0

    override val schema = input.schema

    override fun open() {
        input.open()
    }

    override fun next(): Batch? {
        if (sent >= limit) return null
        val batch = input.next() ?: return null
        // Could be a [Batch] helper method
        // this makes me want a DataFrame library on top of Arrow
        val values = min(batch.records, limit - sent)
        val vectors = Batch.empty(batch.schema, values)
        for (row in 0 until batch.records) {
            if (sent >= limit) break
            for (col in batch.columns.indices) {
                vectors[col][row] = batch.columns[col][row]
            }
            sent += 1
        }
        vectors.valueCount(values)
        return Batch.fromVectors(schema, vectors)
    }

    override fun close() {
        input.close()
    }
}
