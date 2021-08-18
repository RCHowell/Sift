package sift.execution.physical.sifterators

import sift.execution.physical.aggregations.Accumulator
import sift.execution.physical.aggregations.Key
import sift.types.Batch
import sift.types.Column
import sift.types.NumVectorColumn
import sift.types.StringVectorColumn

class Aggregation(
    val input: Sifterator,
    val aggregations: Map<Int, Accumulator>,
    val groups: List<Int>,
) : Sifterator {

    val accumulators: Map<Key, Accumulator> = mapOf()

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
    override fun next(): Batch {
        val keys = Column.Factory.string(accumulators.size)
        val vals = Column.Factory.numeric(accumulators.size)
        var i = 0
        val output = accumulators.map { (key, accumulator) ->
            keys[i] = key.toString().toByteArray()
            vals[i] = accumulator.get()
            i++
        }
        keys.valueCount = i
        vals.valueCount = i
        return Batch(listOf(StringVectorColumn(keys), NumVectorColumn(vals)))
    }

    override fun close() {
        input.close()
    }

    fun accumulate(key: Key, batch: Batch, record: Int) {
        val k = Key::class.java
        groups.forEach { group ->
            val accum = accumulators.getOrElse(key, { aggregations[group]!!.new() })
            val v = batch.columns[group][record]
            accum.add(v as Double)
        }
    }
}
