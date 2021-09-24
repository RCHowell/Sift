package com.rchowell.sift.execution.physical.aggregations

import org.apache.commons.lang3.builder.HashCodeBuilder

class Key(val values: List<Any?>) {

    companion object {
        val EMPTY = Key(listOf())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Key
        return compareValues(other.values)
    }

    /**
     * Use String value of ByteArray rather than the reference
     */
    override fun hashCode(): Int {
        val hashcode = HashCodeBuilder()
        values.forEach {
            when (it) {
                is ByteArray -> hashcode.append(it.toString(Charsets.UTF_8))
                else -> hashcode.append(it)
            }
        }
        return hashcode.build()
    }

    override fun toString(): String = values.joinToString("-")

    private fun compareValues(other: List<Any?>): Boolean {
        if (values.size != other.size) return false
        for (i in values.indices) {
            val thisVal = values[i]
            val thatVal = other[i]
            if (thisVal != thatVal) {
                // Compare ByteArray as String
                if (thisVal is ByteArray && thatVal is ByteArray) {
                    val v1 = thisVal.toString(Charsets.UTF_8)
                    val v2 = thatVal.toString(Charsets.UTF_8)
                    if (v1 != v2) {
                        return false
                    }
                } else {
                    return false
                }
            }
        }
        return true
    }
}
