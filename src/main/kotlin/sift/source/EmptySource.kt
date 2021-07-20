package sift.source

import sift.types.Batch
import sift.types.Schema

class EmptySource(val relationName: String) : Source {

    /** No Schema */
    override val schema: Schema = Schema(listOf())

    /** Reads in the full */
    override fun scan(identifiers: List<String>): Sequence<Batch> = emptySequence()

    override fun toString(): String = "EmptySource '$relationName'"
}
