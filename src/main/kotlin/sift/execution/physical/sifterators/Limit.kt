package sift.execution.physical.sifterators

import sift.types.Batch

/**
 * Limit will return a single [Batch] with [limit] number of records.
 *
 */
class Limit(val input: Sifterator, val limit: Int) : Sifterator {

    var sent = 0

    override val schema = input.schema

    override fun open() {
        input.open()
    }

    // TODO
    override fun next(): Batch? {
        if (sent >= limit) return null
        // TODO build vectors of size N
        while (sent < limit) {
            val batch = input.next() ?: break
            sent += 10
        }
        // TODO
        return input.next()
    }

    override fun close() {
        input.close()
    }

}