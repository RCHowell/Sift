package com.rchowell.sift.types

/**
 * Field simply holds identifiers and values
 *
 * @property identifier
 * @property type
 * @constructor Create empty Field
 */
data class Field(val identifier: String, val type: Type) {

    /**
     * The Arrow representation of the field
     */
    val arrow: org.apache.arrow.vector.types.pojo.Field
        get() = org.apache.arrow.vector.types.pojo.Field(
            identifier,
            org.apache.arrow.vector.types.pojo.FieldType(true, type.arrow, null),
            listOf()
        )
}
