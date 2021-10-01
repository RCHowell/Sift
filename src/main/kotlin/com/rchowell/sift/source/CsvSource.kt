package com.rchowell.sift.source

import com.opencsv.CSVReader
import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Batch.Companion.valueCount
import com.rchowell.sift.types.Schema
import org.apache.arrow.vector.BitVector
import org.apache.arrow.vector.Float8Vector
import org.apache.arrow.vector.ValueVector
import org.apache.arrow.vector.VarCharVector
import java.io.File
import java.io.FileReader

/**
 * CSV source readers the given file limiting batches to N records
 *
 * @property path
 * @property mapping
 * @constructor Create empty Csv source
 */
class CsvSource(
    override val identifier: String,
    override val schema: Schema,
    private val path: String,
    private val header: Boolean = false,
    private val batchSize: Int = 10_000,
) : Source {

    lateinit var reader: CSVReader

    override fun init() {
        val file = File(path)
        reader = CSVReader(FileReader(file))
    }

    override fun close() {
        reader.close()
    }

    // TODO only scan specified identifiers
    override fun scan(identifiers: List<String>): Sequence<Batch> = sequence {
        var vecs: List<ValueVector> = Batch.empty(schema, batchSize)
        var row = 0
        if (header) reader.skip(1)
        var record = reader.readNext()
        while (record != null) {
            vecs.forEachIndexed { col, v ->
                when (v) {
                    is VarCharVector -> v[row] = record[col].toByteArray()
                    is BitVector -> v[row] = if (record[col] == "true") 1 else 0
                    is Float8Vector -> {
                        try {
                            v[row] = record[col].toDouble()
                        } catch (e: Throwable) {
                            // nulls?
                            v[row] = -1.0
                        }
                    }
                }
            }
            row++
            if (row == batchSize) {
                vecs.valueCount(row)
                yield(Batch.fromVectors(schema, vecs))
                row = 0
                vecs = Batch.empty(schema, batchSize)
            }
            record = reader.readNext()
        }
        if (row != 0) {
            vecs.valueCount(row)
            yield(Batch.fromVectors(schema, vecs))
        }
    }
}
