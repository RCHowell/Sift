package sift.execution.physical.sifterators

import sift.execution.physical.expressions.PredicateExpr
import sift.types.Batch

/**
 * Selection evaluates a bool expression and uses the results to filter the next result.
 * Seems expensive to filter with columns versus rows.
 *
 * @property input
 * @property predicate
 * @constructor Create empty Selection
 */
class Selection(val input: Sifterator, val predicate: PredicateExpr) : Sifterator {

    override fun open() {
        input.open()
    }

    override fun next(): Batch? {
        val batch = input.next() ?: return null
        val mask = predicate.eval(batch)
        val cols = batch.columns.map { it.filter(mask) }
        return Batch(cols)
    }

    override fun close() {
        input.close()
    }
}
