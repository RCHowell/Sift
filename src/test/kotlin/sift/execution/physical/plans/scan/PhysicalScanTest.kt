package sift.execution.physical.plans.scan

import org.apache.arrow.memory.RootAllocator
import org.apache.arrow.vector.BitVector
import org.junit.jupiter.api.Test
import sift.source.MemSource
import sift.types.ArrowColumn
import sift.types.Batch
import sift.types.Schema

internal class PhysicalScanTest {

    @Test
    fun simple() {
        val allocator = RootAllocator(Long.MAX_VALUE)
        val bv = BitVector("foo", allocator)
        bv.allocateNew(3)
        bv[0] = 1
        bv[1] = 1
        bv[2] = 0
        bv.valueCount = 3
        val source = MemSource(
            identifier = "Foo",
            schema = Schema(
                listOf()
            ),
            data = listOf(
                Batch(
                    listOf(
                        ArrowColumn(bv)
                    )
                )
            )
        )
        val physicalScan = PhysicalScan(source, listOf("foo"))
        physicalScan.open()
        val b = physicalScan.next()
        println(b)
    }
}
