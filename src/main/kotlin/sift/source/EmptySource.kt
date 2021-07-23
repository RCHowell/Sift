package sift.source

import sift.types.Batch
import sift.types.Schema

class EmptySource(
    override val identifier: String,
    override val schema: Schema,
) : Source {

    override fun init() {}

    override fun close() {}

    /** Reads in the full */
    override fun scan(identifiers: List<String>): Sequence<Batch> = emptySequence()

    override fun toString(): String = "EmptySource '$identifier'"
}
