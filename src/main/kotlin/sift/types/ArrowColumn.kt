package sift.types

import org.apache.arrow.vector.BitVector
import org.apache.arrow.vector.FieldVector
import org.apache.arrow.vector.Float8Vector
import org.apache.arrow.vector.VarCharVector
import org.apache.arrow.vector.types.pojo.ArrowType
import java.lang.IllegalStateException

/**
 * Wraps an Arrow FieldVector with the simpler [Column] interface
 *
 * @property fieldVector
 * @constructor Create empty Arrow column
 */
class ArrowColumn(private val fieldVector: FieldVector) : Column {

    override val type: ArrowType
        get() = when (fieldVector) {
            is BitVector -> Type.Bool.arrow
            is Float8Vector -> Type.Num.arrow
            is VarCharVector -> Type.String.arrow
            //            is TinyIntVector -> NumType.arrow
            //            is SmallIntVector -> NumType.arrow
            //            is IntVector -> NumType.arrow
            //            is BigIntVector -> NumType.arrow
            //            is Float4Vector -> NumType.arrow
            else -> throw IllegalStateException()
        }

    override val size: Int
        get() = fieldVector.valueCount

    override fun get(row: Int): Any? {
        if (fieldVector.isNull(row)) {
            return null
        }
        return when (fieldVector) {
            is BitVector -> fieldVector.get(row) == 1
            is Float8Vector -> fieldVector.get(row)
            is VarCharVector -> {
                val bytes = fieldVector.get(row)
                if (bytes == null) {
                    null
                } else {
                    String(bytes)
                }
            }
            //            is TinyIntVector -> fieldVector.get(i)
            //            is SmallIntVector -> fieldVector.get(i)
            //            is IntVector -> fieldVector.get(i)
            //            is BigIntVector -> fieldVector.get(i)
            //            is Float4Vector -> fieldVector.get(i)
            else -> throw IllegalStateException()
        }
    }

}