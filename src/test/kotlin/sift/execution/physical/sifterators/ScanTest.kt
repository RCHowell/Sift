package sift.execution.physical.sifterators

import org.apache.arrow.memory.RootAllocator
import org.apache.arrow.vector.BitVector
import org.junit.jupiter.api.Test
import sift.source.MemSource
import sift.types.Batch
import sift.types.BoolVectorColumn
import sift.types.Field
import sift.types.Schema
import sift.types.Type

internal class ScanTest {

    @Test
    fun simple() {
        val allocator = RootAllocator(Long.MAX_VALUE)
        val bv = BitVector("", allocator)
        val schema = Schema(
            listOf(
                Field(
                    "foo",
                    type = Type.Bool,
                )
            )
        )
        bv.allocateNew(3)
        bv[0] = 1
        bv[1] = 1
        bv[2] = 0
        bv.valueCount = 3
        val source = MemSource(
            identifier = "Foo",
            schema = schema,
            data = listOf(
                Batch(
                    schema,
                    listOf(
                        BoolVectorColumn(bv)
                    )
                )
            )
        )
        val physicalScan = Scan(source, listOf("foo"))
        physicalScan.open()
        val b = physicalScan.next()
        println(b)
    }
}
