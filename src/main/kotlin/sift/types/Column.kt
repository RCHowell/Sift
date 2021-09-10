package sift.types

import org.apache.arrow.memory.RootAllocator
import org.apache.arrow.vector.BitVector
import org.apache.arrow.vector.FieldVector
import org.apache.arrow.vector.Float8Vector
import org.apache.arrow.vector.VarCharVector
import kotlin.math.max

/**
 * Wrap of an Arrow vector
 *
 * @property vector
 * @constructor Create empty Arrow column
 */
sealed class Column {

    abstract operator fun get(row: Int): Any?

    abstract fun filter(mask: BoolColumn): Column

    abstract val size: Int

    /**
     * Factory for concise [Column] creation
     */
    object Factory {

        fun boolean(values: List<Boolean>): BoolColumn = boolean(values.size, values)

        fun boolean(capacity: Int = 0, values: List<Boolean>): BoolColumn =
            BoolVectorColumn(VectorFactory.boolean(capacity, values))

        fun string(values: List<String>): StringColumn = string(values.size, values)

        fun string(capacity: Int = 0, values: List<String>): StringColumn =
            StringVectorColumn(VectorFactory.string(capacity, values))

        fun numeric(values: List<Double>): NumColumn = numeric(values.size, values)

        fun numeric(capacity: Int = 0, values: List<Double>): NumColumn =
            NumVectorColumn(VectorFactory.numeric(capacity, values))
    }

    /**
     * Factory for concise [FieldVector] creation
     */
    object VectorFactory {

        fun boolean(values: List<Boolean>): BitVector = boolean(values.size, values)

        fun boolean(capacity: Int = 0, values: List<Boolean> = listOf()): BitVector {
            val vector = BitVector("v", RootAllocator(Long.MAX_VALUE))
            vector.setInitialCapacity(max(capacity, values.size))
            vector.allocateNew()
            for (i in values.indices) {
                vector[i] = if (values[i]) 1 else 0
            }
            vector.valueCount = values.size
            return vector
        }

        fun numeric(values: List<Double>): Float8Vector = numeric(values.size, values)

        fun numeric(capacity: Int = 0, values: List<Double> = listOf()): Float8Vector {
            val vector = Float8Vector("v", RootAllocator(Long.MAX_VALUE))
            vector.setInitialCapacity(max(capacity, values.size))
            vector.allocateNew()
            for (i in values.indices) {
                vector[i] = values[i]
            }
            vector.valueCount = values.size
            return vector
        }

        fun string(values: List<String>): VarCharVector = string(values.size, values)

        fun string(capacity: Int = 0, values: List<String> = listOf()): VarCharVector {
            val vector = VarCharVector("v", RootAllocator(Long.MAX_VALUE))
            //            vector.setInitialCapacity(max(capacity, values.size))
            vector.allocateNew()
            for (i in values.indices) {
                vector[i] = values[i].toByteArray() // UTF-8
            }
            vector.valueCount = values.size
            return vector
        }
    }
}

abstract class BoolColumn : Column() {

    abstract override fun get(row: Int): Int
}

class BoolVectorColumn(val vector: BitVector) : BoolColumn() {

    override fun get(row: Int): Int = vector[row]

    override val size: Int
        get() = vector.valueCount

    override fun filter(mask: BoolColumn): BoolColumn {
        var vals = 0
        val dupe = VectorFactory.boolean(vector.valueCapacity)
        for (i in 0 until vector.valueCount) {
            if (mask[i] == 1) dupe[vals++] = vector[i]
        }
        dupe.valueCount = vals
        return BoolVectorColumn(dupe)
    }

    override fun toString(): String = vector.toString()
}

class BoolLiteralColumn(val value: Boolean, override val size: Int) : BoolColumn() {

    override fun get(row: Int): Int = if (value) 1 else 0

    override fun filter(mask: BoolColumn): Column {
        TODO("Not yet implemented")
    }
}

abstract class NumColumn : Column() {

    abstract override fun get(row: Int): Double
}

class NumVectorColumn(val vector: Float8Vector) : NumColumn() {

    override val size: Int
        get() = vector.valueCount

    override fun get(row: Int): Double = vector[row]

    override fun filter(mask: BoolColumn): NumColumn {
        var vals = 0
        val dupe = VectorFactory.numeric(vector.valueCapacity)
        for (i in 0 until vector.valueCount) {
            if (mask[i] == 1) dupe[vals++] = vector[i]
        }
        dupe.valueCount = vals
        return NumVectorColumn(dupe)
    }

    override fun toString(): String = vector.toString()
}

class NumLiteralColumn(val value: Double, override val size: Int) : NumColumn() {

    override fun get(row: Int): Double = value

    override fun filter(mask: BoolColumn): Column {
        TODO("Not yet implemented")
    }
}

abstract class StringColumn() : Column() {

    abstract override fun get(row: Int): ByteArray
}

class StringVectorColumn(val vector: VarCharVector) : StringColumn() {

    override val size: Int
        get() = vector.valueCount

    override fun get(row: Int): ByteArray = vector.get(row)

    override fun filter(mask: BoolColumn): StringColumn {
        var vals = 0
        val dupe = VectorFactory.string(vector.valueCapacity)
        for (i in 0 until vector.valueCount) {
            if (mask[i] == 1) dupe[vals++] = vector[i]
        }
        dupe.valueCount = vals
        return StringVectorColumn(dupe)
    }

    override fun toString(): String = vector.toString()
}

class StringLiteralColumn(val value: ByteArray, override val size: Int) : StringColumn() {

    override fun get(row: Int): ByteArray = value

    override fun filter(mask: BoolColumn): Column {
        TODO("Not yet implemented")
    }
}
