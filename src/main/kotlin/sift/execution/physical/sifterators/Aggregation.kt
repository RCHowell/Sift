package sift.execution.physical.sifterators

import org.apache.arrow.vector.BitVector
import org.apache.arrow.vector.Float8Vector
import org.apache.arrow.vector.ValueVector
import org.apache.arrow.vector.VarCharVector
import sift.execution.physical.aggregations.Accumulator
import sift.execution.physical.aggregations.Key
import sift.types.Batch
import sift.types.BoolVectorColumn
import sift.types.Column
import sift.types.NumVectorColumn
import sift.types.Schema
import sift.types.StringVectorColumn
import sift.types.Type

/**
 * Aggregation Sifterator maintains an accumulator for each aggregation key and processes all input batches
 * before producing the output batch
 *
 * @property input
 * @property aggregations column to accumulator mapping
 * @property groups column values to group by
 * @constructor Create empty Aggregation
 */
class Aggregation(
    val input: Sifterator,
    val aggregations: List<Accumulator>,
    val groups: List<Int>,
    override val schema: Schema,
) : Sifterator {

    private val accumulators: MutableMap<Key, List<Accumulator>> = mutableMapOf()
    private var done = false

    /**
     * DSCB book has Iterators doing full
     * aggregation in the open() method
     */
    override fun open() {
        input.open()
        var batch = input.next()
        while (batch != null) {
            for (i in 0 until batch.records) {
                val values = groups.map { batch!!.columns[it][i] }
                val key = if (values.isEmpty()) Key.EMPTY else Key(values)
                accumulate(key, batch, i)
            }
            batch = input.next()
        }
    }

    /**
     * Next() returns the value of all aggregation accumulators
     */
    override fun next(): Batch? {
        if (done) return null
        done = true

        // Total number of rows in the output batch
        val rowCount = accumulators.size

        // Initialize vectors for each aggregation key, type is derived from the schema
        val keyVectors: List<ValueVector> = groups.indices.map { group ->
            when (schema.fields[group].type) {
                Type.Num -> Column.Factory.numeric(rowCount)
                Type.Bool -> Column.Factory.boolean(rowCount)
                Type.String -> Column.Factory.string(rowCount)
            }
        }

        // Initialize vectors for each aggregation value, type is always numeric
        val valueVectors = aggregations.map { Column.Factory.numeric(rowCount) }

        // Add all values to the output vectors
        accumulators.keys.forEachIndexed { row, key ->

            // Add all aggregation key values to the key vectors
            key.values.forEachIndexed { i, kv ->
                when (val keyVec = keyVectors[i]) {
                    is Float8Vector -> keyVec[row] = kv as Double
                    is BitVector -> keyVec[row] = kv as Int
                    is VarCharVector -> keyVec[row] = kv as ByteArray
                    else -> throw IllegalStateException("unknown key vector type ${keyVec::class.java} for key $kv")
                }
            }

            // Add all aggregated values to the value vectors
            val accumulator = accumulators[key]!!
            accumulator.forEachIndexed { i, acc ->
                valueVectors[i][row] = acc.get()
            }
        }

        // Columns of the batch
        val cols = mutableListOf<Column>()
        keyVectors.forEach {
            it.valueCount = rowCount
            when (it) {
                is Float8Vector -> cols.add(NumVectorColumn(it))
                is BitVector -> cols.add(BoolVectorColumn(it))
                is VarCharVector -> cols.add(StringVectorColumn(it))
            }
        }
        valueVectors.forEach {
            it.valueCount = rowCount
            cols.add(NumVectorColumn(it))
        }
        return Batch(schema, cols)
    }

    override fun close() {
        input.close()
    }

    private fun accumulate(key: Key, batch: Batch, row: Int) {
        var accums = accumulators[key]
        if (accums == null) {
            accums = aggregations.map { it.new() }
            accumulators[key] = accums
        }
        accums.forEach {
            val v = batch.columns[it.column][row]
            it.add(v as Double)
        }
    }
}
