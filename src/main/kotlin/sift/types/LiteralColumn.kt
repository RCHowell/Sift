package sift.types

import org.apache.arrow.vector.types.pojo.ArrowType

/**
 * Column which always returns the same value
 *
 * @property value
 * @property type
 * @property size
 * @constructor Create empty Literal column
 */
class LiteralColumn(
    private val value: Any?,
    override val type: ArrowType,
    override val size: Int,
) : Column {

    /**
     * Get returns the literal value
     *
     * @param row index in the column
     * @return the literal value
     */
    override fun get(row: Int): Any? {
        if (row < 0 || row >= size) {
            throw IndexOutOfBoundsException()
        }
        return value
    }
}
