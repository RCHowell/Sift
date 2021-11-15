package com.rchowell.sift.execution.physical.aggregations

import com.rchowell.sift.execution.physical.expressions.Expression

/**
 * All aggregations are implemented as accumulators.
 *
 * @constructor Create empty Agg accumulator
 */
sealed class Accumulator {

    abstract val expr: Expression

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

class SumAccumulator(override val expr: Expression) : Accumulator() {

    var value = 0.0

    override fun new(): Accumulator = SumAccumulator(expr)

    override fun add(v: Double) {
        value += v
    }

    override fun get(): Double = value
}

class MinAccumulator(override val expr: Expression) : Accumulator() {

    var value = Double.MAX_VALUE

    override fun new(): Accumulator = MinAccumulator(expr)

    override fun add(v: Double) {
        if (v < value) value = v
    }

    override fun get(): Double = value
}

class MaxAccumulator(override val expr: Expression) : Accumulator() {

    var value = Double.MIN_VALUE

    override fun new(): Accumulator = MaxAccumulator(expr)

    override fun add(v: Double) {
        if (v > value) value = v
    }

    override fun get(): Double = value
}

class CountAccumulator(override val expr: Expression) : Accumulator() {

    var value = 0.0

    override fun new(): Accumulator = CountAccumulator(expr)

    override fun add(v: Double) {
        value += 1
    }

    override fun get(): Double = value
}

class AvgAccumulator(override val expr: Expression) : Accumulator() {

    var numer = 0.0
    var denom = 0.0

    override fun new(): Accumulator = AvgAccumulator(expr)

    override fun add(v: Double) {
        numer += v
        denom += 1
    }

    override fun get(): Double = numer / denom
}
