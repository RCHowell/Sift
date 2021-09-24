package com.rchowell.sift.execution.physical.sifterators

import com.rchowell.sift.execution.physical.expressions.Expression
import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Schema

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
    val input: Sifterator,
    val projections: Map<Int, Expression>,
    override val schema: Schema,
) : Sifterator {

    override fun open() {
        input.open()
    }

    override fun next(): Batch? {
        val batch = input.next() ?: return null
        val output = projections.map { (_, v) -> v.eval(batch) }
        return Batch(schema, output)
    }

    override fun close() {
        input.close()
    }
}
