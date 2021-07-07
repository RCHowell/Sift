package sift.types

/**
 * A Batch holds many records from one or more columns
 * See KQuery RecordBatch
 *
 * Note that a [Batch] is entirely separated from a [Schema].
 * Columns have indexes, not identifiers. I may want to change this.
 *
 * @property cols is the list of columns
 * @constructor Create empty Batch
 */
class Batch(
    private val cols: List<Column>
) {
    /**
     * The number of records in the batch
     */
    val records: Int
        get() = cols.first().size

    /**
     * The number of columns in the batch
     */
    val columns: Int
        get() = cols.size

    fun column(i: Int): Column = cols[i]
}
