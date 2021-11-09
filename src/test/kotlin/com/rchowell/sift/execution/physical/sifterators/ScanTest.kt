package com.rchowell.sift.execution.physical.sifterators

import com.rchowell.sift.source.MemSource
import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.BoolVectorColumn
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type
import org.apache.arrow.memory.RootAllocator
import org.apache.arrow.vector.BitVector
import org.junit.jupiter.api.Test

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
