package com.rchowell.sift.execution.physical.sifterators

import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Batch.Companion.valueCount
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.set
import org.apache.commons.lang3.builder.HashCodeBuilder

/**
 * Duplicate elimination for the given keys
 *
 * @property input
 * @property fields columns to keep distinct values
 * @constructor Create empty Distinct
 */
class Distinct(
    val input: Sifterator,
    val fields: List<Int>,
) : Sifterator {

    private val seen: MutableSet<Int> = mutableSetOf()

    override val schema: Schema = input.schema.project(fields)

    override fun open() {
        input.open()
    }

    override fun next(): Batch? {
        val batch = input.next() ?: return null
        val vectors = Batch.empty(schema, batch.records)
        var records = 0
        for (row in 0 until batch.records) {
            val hashBuilder = HashCodeBuilder()
            fields.forEach {
                hashBuilder.append(batch.columns[it][row])
            }
            val hash = hashBuilder.build() ?: -1
            if (!seen.contains(hash)) {
                for (c in fields.indices) {
                    vectors[c][records] = batch.columns[fields[c]][row]
                }
                seen.add(hash)
                records += 1
            }
        }
        vectors.valueCount(records)
        return Batch.fromVectors(schema, vectors)
    }

    override fun close() {
        input.close()
    }
}
