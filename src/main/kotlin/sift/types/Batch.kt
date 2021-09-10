package sift.types

import de.vandermeer.asciitable.AsciiTable
import org.apache.arrow.vector.ValueVector

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
            val vals = columns.map {
                when (val v = it[i]) {
                    is ByteArray -> v.toString(Charsets.UTF_8)
                    is Double -> "%.2f".format(v)
                    else -> v.toString()
                }
            }
            table.addRow(vals)
            table.addRule()
        }
        return table.render()
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
    }
}
