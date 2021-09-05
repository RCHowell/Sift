package sift.source

import sift.types.Batch
import sift.types.Schema

class MemSource(
    override val identifier: String,
    override val schema: Schema,
    private val data: List<Batch>
) : Source {

    override fun init() {}

    override fun close() {}

    /**
     * Scan finds the column indices for the given field identifiers
     *  and returns a sequence of [Batch] objects for the selected columns
     *
     * @param identifiers
     * @return
     */
    override fun scan(identifiers: List<String>): Sequence<Batch> {
        val selectedSchema = schema.select(identifiers)
        return data.asSequence().map { batch ->
            Batch(selectedSchema, selectedSchema.fieldIndexes.values.map { i -> batch.columns[i] })
        }
    }

    // TODO a nice Factory constructor
}
