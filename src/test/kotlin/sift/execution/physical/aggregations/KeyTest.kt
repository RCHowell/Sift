package sift.execution.physical.aggregations

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class KeyTest {

    @Test
    fun testEquals() {
        val key1 = Key(listOf(1.0, 1, "Dog".toByteArray()))
        val key2 = Key(listOf(1.0, 1, "Dog".toByteArray()))
        val key3 = Key(listOf(1.0, 1, "Cat".toByteArray()))
        val key4 = Key(listOf(1.0, 0, "Dog".toByteArray()))
        assertTrue { key1 == key2 }
        assertFalse { key1 == key3 }
        assertFalse { key1 == key4 }
    }
}
