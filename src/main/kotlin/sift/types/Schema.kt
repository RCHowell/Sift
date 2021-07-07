package sift.types

import java.sql.SQLException

/**
 * Holding object for identifier to [Type] mappings
 *
 * @property fields
 * @constructor Create empty Schema
 */
data class Schema(val fields: List<Field>) {

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
        return Schema(indices.map { fields[it] })
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
    fun find(identifier: String): Field = fieldMap[identifier] ?: throw SQLException("Unknown identifier `$identifier`")
}
