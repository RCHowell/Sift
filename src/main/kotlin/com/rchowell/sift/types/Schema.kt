package com.rchowell.sift.types

/**
 * Holding object for identifier to [Type] mappings
 *
 * Something to keep in mind will be maintaing orderings
 *
 * @property fields
 * @property relation is the relation identifier
 * @constructor Create empty Schema
 */
data class Schema(val fields: List<Field>, val relation: String = "") {

    /**
     * Arrow representation of this Schema
     */
    val arrow: org.apache.arrow.vector.types.pojo.Schema
        get() = org.apache.arrow.vector.types.pojo.Schema(fields.map { it.arrow })

    /**
     * Maps identifiers to their index in the [Field] list
     */
    val fieldIndexes = fields.foldIndexed(mutableMapOf<String, Int>()) { i, m, f ->
        m[f.identifier] = i
        m
    }

    /**
     * Maps identifiers to their [Field]
     */
    private val fieldMap = fields.fold(mutableMapOf<String, Field>()) { m, f ->
        m[f.identifier] = f
        m
    }

    /**
     * Constructs a new schema given field indices
     *
     * @param indices
     * @return
     */
    fun project(indices: List<Int>): Schema {
        return Schema(indices.map { fields[it] }, relation)
    }

    /**
     * Select returns a new schema for the given columns.
     * If the set of identifiers is empty, then return all columns ie `SELECT *`
     *
     * @param identifiers
     * @return
     */
    fun select(identifiers: List<String>): Schema = if (identifiers.isEmpty()) {
        this
    } else {
        Schema(identifiers.filter { it in fieldMap }.map { fieldMap[it]!! })
    }

    /**
     * Finds the [Field] based on the identifier, or throws
     *
     * @param identifier
     * @return
     */
    fun find(identifier: String): Field = fieldMap[identifier] ?: throw Exception("unknown identifier `$identifier`")

    /**
     * Returns true if this is a subset of the other
     *
     * @param other
     * @return
     */
    fun subsetOf(other: Schema): Boolean {
        val set = this.fields.toMutableSet()
        other.fields.forEach { set.remove(it) }
        return set.isEmpty()
    }

    // Helper method though?
    fun combine(other: Schema, relation: String = ""): Schema {
        val combined = mutableListOf<Field>()
        combined.addAll(resolvedFields(this))
        combined.addAll(resolvedFields(other))
        return Schema(combined, relation)
    }

    companion object {

        // Renames all fields in this Schema to use the fully resolved name
        fun resolvedFields(schema: Schema): List<Field> = schema.fields.map {
            Field("${schema.relation}.${it.identifier}", it.type)
        }

        // Returns a combined schema with just the common fields
        fun common(lhs: Schema, rhs: Schema, relation: String = ""): Schema {
            val lfs = lhs.fields.toSet()
            val set = mutableSetOf<Field>()
            rhs.fields.forEach { if (lfs.contains(it)) set.add(it) }
            return Schema(set.toList(), relation)
        }
    }
}
