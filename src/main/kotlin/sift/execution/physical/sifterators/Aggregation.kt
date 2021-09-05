package sift.execution.physical.sifterators

import sift.execution.physical.aggregations.Accumulator
import sift.execution.physical.aggregations.Key
import sift.types.Batch
import sift.types.Column
import sift.types.NumVectorColumn
import sift.types.Schema
import sift.types.StringVectorColumn

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
        val keys = Column.Factory.string(accumulators.size)
        val valueVecs = aggregations.map { Column.Factory.numeric(accumulators.size) }
        var row = 0 // there is a row for each key
        accumulators.forEach { (key, accumulator) ->
            keys[row] = key.toString().toByteArray() // TODO have a column for each key
            for (acc in accumulator.indices) {
                valueVecs[acc][row] = accumulator[acc].get()
            }
            row++
        }
        keys.valueCount = row
        val valueColumns = valueVecs.map {
            it.valueCount = row
            NumVectorColumn(it)
        }
        return Batch(schema, listOf(StringVectorColumn(keys)) + valueColumns)
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
