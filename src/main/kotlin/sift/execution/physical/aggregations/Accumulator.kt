package sift.execution.physical.aggregations

/**
 * All aggregations are implemented as accumulators.
 * As of now, all aggregations are numeric.
 *
 * @constructor Create empty Agg accumulator
 */
interface Accumulator {

    /**
     * Create a new instance of this Accumulator.
     * Done because I couldn't create a new instance given an interface KClass ie no empty constructor
     */
    fun new(): Accumulator

    /**
     * Accumulate one value at a time
     */
    fun add(v: Double)

    /**
     * Returns the current value of the accumulator
     */
    fun get(): Double
}
