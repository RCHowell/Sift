package sift.execution.physical.sifterators

import org.junit.jupiter.api.Test
import sift.execution.physical.expressions.ColumnExpr
import sift.execution.physical.expressions.GteExpr
import sift.source.MemSource
import sift.types.Batch
import sift.types.Column
import sift.types.Field
import sift.types.NumColumn
import sift.types.Schema
import sift.types.Type

internal class SelectionTest {

    @Test
    operator fun next() {

        val source = MemSource(
            identifier = "Foo",
            schema = Schema(
                listOf(
                    Field("x", Type.Num),
                    Field("y", Type.Num),
                )
            ),
            data = listOf(
                Batch(
                    listOf(
                        NumColumn(Column.Factory.numeric(listOf(1.0, 2.0, 3.0, 4.0))),
                        NumColumn(Column.Factory.numeric(listOf(4.0, 3.0, 2.0, 1.0))),
                    )
                )
            )
        )
        val predicate = GteExpr(
            ColumnExpr(0),
            ColumnExpr(1),
        )
        val selection = Selection(Scan(source, listOf("x", "y")), predicate)
        selection.open()
        val batch = selection.next()
        println(batch)
    }
}
