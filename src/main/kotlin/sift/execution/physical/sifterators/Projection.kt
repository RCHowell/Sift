package sift.execution.physical.sifterators

import sift.execution.physical.expressions.Expression
import sift.types.Batch

/**
 * Projection holds a map of *output* column indexes to expressions.
 *
 * Each [Expression] is evaluated on the input [Batch], and the result is set in the output [Batch]
 *
 * @property projections
 * @property input
 * @constructor Create empty Projection
 */
class Projection(
    val projections: Map<Int, Expression>,
    val input: Sifterator,
) : Sifterator {

    override fun open() {
        input.open()
    }

    override fun next(): Batch? {
        val batch = input.next() ?: return null
        val output = projections.map { (_, v) -> v.eval(batch) }
        return Batch(output)
    }

    override fun close() {
        input.close()
    }
}
