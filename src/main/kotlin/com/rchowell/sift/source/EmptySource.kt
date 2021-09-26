package com.rchowell.sift.source

import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Schema

class EmptySource(
    override val identifier: String,
    override val schema: Schema,
) : Source {

    override fun init() {}

    override fun close() {}

    override fun scan(identifiers: List<String>): Sequence<Batch> = emptySequence()

    override fun toString(): String = "EmptySource '$identifier'"
}
