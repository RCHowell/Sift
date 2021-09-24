package com.rchowell.sift.execution.physical.aggregations

/**
 * All aggregations are implemented as accumulators.
 * As of now, all aggregations are numeric.
 *
 * @constructor Create empty Agg accumulator
 */
sealed class Accumulator {

    abstract val column: Int

    /**
     * Create a new instance of this Accumulator.
     * Done because I couldn't create a new instance given an interface KClass ie no empty constructor
     */
    abstract fun new(): Accumulator

    /**
     * Accumulate one value at a time
     */
    abstract fun add(v: Double)

    /**
     * Returns the current value of the accumulator
     */
    abstract fun get(): Double
}

class SumAccumulator(override val column: Int) : Accumulator() {

    var value = 0.0

    override fun new(): Accumulator = SumAccumulator(column)

    override fun add(v: Double) {
        value += v
    }

    override fun get(): Double = value
}

class MinAccumulator(override val column: Int) : Accumulator() {

    var value = Double.MAX_VALUE

    override fun new(): Accumulator = MinAccumulator(column)

    override fun add(v: Double) {
        if (v < value) value = v
    }

    override fun get(): Double = value
}

class MaxAccumulator(override val column: Int) : Accumulator() {

    var value = Double.MIN_VALUE

    override fun new(): Accumulator = MaxAccumulator(column)

    override fun add(v: Double) {
        if (v > value) value = v
    }

    override fun get(): Double = value
}

class CountAccumulator(override val column: Int) : Accumulator() {

    var value = 0.0

    override fun new(): Accumulator = CountAccumulator(column)

    override fun add(v: Double) {
        value += 1
    }

    override fun get(): Double = value
}

class AvgAccumulator(override val column: Int) : Accumulator() {

    var numer = 0.0
    var denom = 0.0

    override fun new(): Accumulator = AvgAccumulator(column)

    override fun add(v: Double) {
        numer += v
        denom += 1
    }

    override fun get(): Double = numer / denom
}
