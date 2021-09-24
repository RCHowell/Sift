package com.rchowell.sift.execution.physical.sifterators

import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Schema

/**
 * Iterator from The Volcano Model. Called Sifterator to avoid naming confusion.
 *
 * Things might get interesting/weird because `next()` returns a [Batch] rather than a row.
 */
interface Sifterator {

    /**
     * Output schema of this transformation
     */
    val schema: Schema

    /**
     * This method starts the process of getting tuples, but does not get a tuple.
     *  It initializes any data structures needed to perform the operation and calls Open()
     *  for any arguments of the operation. p707
     */
    fun open()

    /**
     * Returns the next
     *
     * @return
     */
    fun next(): Batch?

    fun close()
}
