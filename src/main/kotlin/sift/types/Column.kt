package sift.types

import org.apache.arrow.vector.types.pojo.ArrowType

/**
 * Column is a wrapper around an Arrow FieldVector.
 * See the KQuery project's ColumnVector.
 *
 * @constructor Create empty Column
 */
interface Column {
    val type: ArrowType
    val size: Int

    /**
     * Array-like access convention
     *
     * @param row
     */
    fun get(row: Int): Any?
}
