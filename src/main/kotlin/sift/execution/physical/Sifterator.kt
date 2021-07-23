package sift.execution.physical

import sift.types.Batch

/**
 * Iterator from The Volcano Model. Called Sifterator to avoid naming confusion.
 */
interface Sifterator {

    /**
     * This method starts the process of getting tuples, but does not get a tuple.
     *  It initializes any data structures needed to perform the operation and calls Open()
     *  for any arguments of the operation. p707
     */
    fun open()

    fun next(): Batch

    fun close()
}
