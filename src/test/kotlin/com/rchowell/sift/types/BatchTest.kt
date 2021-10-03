package com.rchowell.sift.types

import org.junit.jupiter.api.Test

// Not really looking forward to the day of writing real tests
internal class BatchTest {

    private val batch = Batch(
        schema = Schema(
            listOf(
                Field("a", Type.Num),
                Field("b", Type.String),
                Field("c", Type.Bool),
            )
        ),
        columns = listOf(
            Column.Factory.numeric(listOf(3.0, 2.0, 1.0)),
            Column.Factory.string(listOf("abc", "xyz", "abc")),
            Column.Factory.boolean(listOf(true, true, false)),
        )
    )

    @Test
    internal fun singleFieldComparator() {
        val a = batch.comparator(listOf("a"))
        assert(a.compare(0, 1) > 0) // 3.0 > 2.0
        assert(a.compare(0, 2) > 0) // 3.0 > 1.0
        assert(a.compare(1, 2) > 0) // 2.0 > 1.0

        val b = batch.comparator(listOf("b"))
        assert(b.compare(0, 1) < 0) // abc sorts before xzy
        assert(b.compare(0, 2) == 0)
        assert(b.compare(1, 2) > 0) // xzy sorts after abc

        val c = batch.comparator(listOf("c"))
        assert(c.compare(0, 1) == 0)
        assert(c.compare(0, 2) < 0) // true before false
        assert(c.compare(1, 2) < 0) // true before false
    }

    @Test
    internal fun multiFieldComparison() {
        val comp = batch.comparator(listOf("b", "a"))
        assert(comp.compare(0, 1) < 0) // abc sorts before xyz
        assert(comp.compare(0, 2) > 0) // abc = abc, 3 > 1
        assert(comp.compare(1, 2) > 0) // xyz sorts after abc
    }
}
