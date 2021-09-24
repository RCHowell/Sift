package com.rchowell.sift.execution.physical.sifterators

import com.rchowell.sift.execution.physical.expressions.PredicateBinaryExpr
import com.rchowell.sift.types.Batch

/**
 * Selection evaluates a bool expression and uses the results to filter the next result.
 * Seems expensive to filter with columns versus rows.
 *
 * @property input
 * @property predicateBinary
 * @constructor Create empty Selection
 */
class Selection(
    val input: Sifterator,
    val predicateBinary: PredicateBinaryExpr // TODO change to just predicate
) : Sifterator {

    override val schema = input.schema

    override fun open() {
        input.open()
    }

    override fun next(): Batch? {
        val batch = input.next() ?: return null
        val mask = predicateBinary.eval(batch)
        val cols = batch.columns.map { it.filter(mask) }
        return Batch(schema, cols)
    }

    override fun close() {
        input.close()
    }
}
