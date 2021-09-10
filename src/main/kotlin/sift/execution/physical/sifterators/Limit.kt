package sift.execution.physical.sifterators

import org.apache.arrow.vector.BitVector
import org.apache.arrow.vector.Float8Vector
import org.apache.arrow.vector.ValueVector
import org.apache.arrow.vector.VarCharVector
import sift.types.Batch
import sift.types.Batch.Companion.valueCount
import sift.types.BoolVectorColumn
import sift.types.Column
import sift.types.NumVectorColumn
import sift.types.StringVectorColumn
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
        // Columns of the batch
        val cols = mutableListOf<Column>()
        vectors.forEach {
            when (it) {
                is Float8Vector -> cols.add(NumVectorColumn(it))
                is BitVector -> cols.add(BoolVectorColumn(it))
                is VarCharVector -> cols.add(StringVectorColumn(it))
            }
        }
        return Batch(schema, cols)
    }

    override fun close() {
        input.close()
    }
}

private operator fun ValueVector.set(row: Int, value: Any?) {
    when (this) {
        is BitVector -> this[row] = value as Int
        is Float8Vector -> this[row] = value as Double
        is VarCharVector -> this[row] = value as ByteArray
    }
}
