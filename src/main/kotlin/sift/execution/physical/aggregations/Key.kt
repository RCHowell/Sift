package sift.execution.physical.aggregations

class Key(val values: List<Any?>) {

    companion object {
        val EMPTY = Key(listOf())
    }



    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Key
        if (values != other.values) return false
        return true
    }

    override fun hashCode(): Int {
        return values.hashCode()
    }

    override fun toString(): String = values.joinToString("-")
}

