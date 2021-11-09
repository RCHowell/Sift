package com.rchowell.sift.types

import de.vandermeer.asciitable.AsciiTable
import org.apache.arrow.vector.BitVector
import org.apache.arrow.vector.Float8Vector
import org.apache.arrow.vector.ValueVector
import org.apache.arrow.vector.VarCharVector
import java.util.PriorityQueue

/**
 * A Batch holds many records from one or more columns
 * See KQuery RecordBatch
 *
 * @property schema has metadata for the columns
 * @property cols is the list of columns
 * @constructor Create empty Batch
 */
class Batch(
    val schema: Schema,
    val columns: List<Column>
) {
    /**
     * The number of records in the batch
     */
    val records: Int
        get() = columns.first().size

    override fun toString(): String {
        val table = AsciiTable()
        table.addRule()

        val fields = schema.fields.map { it.identifier }
        table.addRow(fields)
        table.addRule()

        for (i in 0 until records) {
            val values = columns.map {
                when (val v = it[i]) {
                    is ByteArray -> v.toString(Charsets.UTF_8)
                    is Double -> "%.2f".format(v)
                    else -> v.toString()
                }
            }
            table.addRow(values)
            table.addRule()
        }
        return table.render()
    }

    // Sorting with Columnar data isn't fun. I should have some row abstraction.
    // I'm going to try to create a heap which holds each row's current index
    // Then I will construct the output columns using the heap's order.
    // Should be O(n*log(n)) with another O(n) for writing the new results.

    /**
     * Creates a row comparator for this batch from the given fields.
     * Consider testing/tuning
     *
     * @param fields
     * @return
     */
    fun comparator(fields: List<String>): Comparator<Int> = Comparator { r1, r2 ->
        fields.forEach {
            val col = schema.fieldIndexes[it]!!
            val v1 = columns[col][r1]
            val v2 = columns[col][r2]
            val v = when (v1) {
                is ByteArray -> v1.toString(Charsets.UTF_8).compareTo((v2 as ByteArray).toString(Charsets.UTF_8))
                is Double -> v1.compareTo(v2 as Double)
                is Int -> {
                    // sort true before false?
                    val v = v1 xor (v2 as Int)
                    if (v1 == 1) -v else v
                }
                else -> 0
            }
            if (v != 0) return@Comparator v
        }
        0
    }

    fun sort(fields: List<String>): Batch {
        val heap = PriorityQueue(records, comparator(fields))
        for (i in 0 until records) {
            heap.add(i)
        }
        val vectors = empty(schema, records)
        // r2d2? There's probably an Arrow RecordSet shuffle or maybe there should be?
        var r2 = 0 // (w)rite to
        var d2 = heap.poll() // data to write
        while (d2 != null) {
            columns.forEachIndexed { i, column ->
                when (column) {
                    is StringColumn -> (vectors[i] as VarCharVector)[r2] = column[d2]
                    is NumColumn -> (vectors[i] as Float8Vector)[r2] = column[d2]
                    is BoolColumn -> (vectors[i] as BitVector)[r2] = column[d2]
                }
            }
            r2 += 1
            d2 = heap.poll()
        }
        vectors.valueCount(records)
        return fromVectors(schema, vectors)
    }

    companion object {

        /**
         * Constructs an empty [Batch] from the given schema
         */
        fun empty(schema: Schema, capacity: Int): List<ValueVector> {
            val vectors = mutableListOf<ValueVector>()
            schema.fields.map {
                when (it.type) {
                    Type.Bool -> vectors.add(Column.VectorFactory.boolean(capacity))
                    Type.Num -> vectors.add(Column.VectorFactory.numeric(capacity))
                    Type.String -> vectors.add(Column.VectorFactory.string(capacity))
                }
            }
            return vectors
        }

        fun List<ValueVector>.valueCount(values: Int) {
            this.forEach { it.valueCount = values }
        }

        fun fromVectors(schema: Schema, vectors: List<ValueVector>): Batch {
            val columns = vectors.map {
                when (it) {
                    is BitVector -> BoolVectorColumn(it)
                    is VarCharVector -> StringVectorColumn(it)
                    is Float8Vector -> NumVectorColumn(it)
                    else -> throw IllegalStateException("unsupported vector type $it")
                }
            }
            return Batch(schema, columns)
        }
    }
}

operator fun ValueVector.set(row: Int, value: Any?) {
    when (this) {
        is BitVector -> this[row] = value as Int
        is Float8Vector -> this[row] = value as Double
        is VarCharVector -> this[row] = value as ByteArray
    }
}
