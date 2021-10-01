package com.rchowell.sift.source

import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type
import org.junit.jupiter.api.Test

internal class CsvSourceTest {

    @Test
    internal fun printAll() {
        val path = "/Users/rch/Desktop/mlb_players.csv"
        val source = CsvSource(
            identifier = "mlb",
            schema = Schema(
                listOf(
                    Field("Name", Type.String),
                    Field("Team", Type.String),
                    Field("Position", Type.String),
                    Field("Height", Type.Num),
                    Field("Weight", Type.Num),
                    Field("Age", Type.Num),
                )
            ),
            path = path,
            header = true,
        )
        source.init()
        source.scan(listOf()).iterator().forEach {
            println(it)
        }
        source.close()
    }
}
