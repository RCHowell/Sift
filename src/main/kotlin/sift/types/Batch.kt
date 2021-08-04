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
class Batch(val columns: List<Column>) {
    /**
     * The number of records in the batch
     */
    val records: Int
        get() = columns.first().size

    override fun toString(): String = buildString {
        for (i in 0 until records) {
            val sb = buildString {
                append("| ")
                append(columns.map { it[i] }.joinToString(" | "))
                append(" |")
            }
            append('\n')
            append(sb)
        }
    }

    /**
     * This function returns the column as strings paired with the
     * maximum length (width) to this column.
     */
    private fun maxWidthStrings(col: Column): Pair<Int, List<String>> {
        val max = 0
        val strings = mutableListOf<String>()
        // TODO for pretty printing, I don't care yet
        return Pair(0, listOf())
    }
}
