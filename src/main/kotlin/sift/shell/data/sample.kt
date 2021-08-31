package sift.shell.data

import sift.source.MemSource
import sift.types.Batch
import sift.types.Column
import sift.types.Field
import sift.types.NumVectorColumn
import sift.types.Schema
import sift.types.StringVectorColumn
import sift.types.Type

val pets = MemSource(
    identifier = "Pets",
    schema = Schema(
        listOf(
            Field("Name", Type.String),
            Field("Age", Type.Num),
            Field("Gender", Type.String),
            Field("Weight", Type.Num),
            Field("Type", Type.String),
            Field("Breed", Type.String),
        )
    ),
    data = listOf(
        Batch(
            columns = listOf(
                StringVectorColumn(Column.Factory.string(listOf("Ramona", "Mochi", "Cali", "Gretchen", "Cooper", "Eleanor"))),
                NumVectorColumn(Column.Factory.numeric(listOf(2.0, 2.0, 7.0, 13.0, 6.0, 5.0))),
                StringVectorColumn(Column.Factory.string(listOf("F", "F", "F", "F", "M", "F"))),
                NumVectorColumn(Column.Factory.numeric(listOf(8.0, 45.0, 30.0, 50.0, 30.0, 24.0))),
                StringVectorColumn(Column.Factory.string(listOf("Cat", "Dog", "Dog", "Dog", "Dog", "Dog"))),
                StringVectorColumn(Column.Factory.string(listOf("Mini Coon", "Samoyed", "Vizsla", "English Bulldog", "Beagle", "Cocker Spaniel"))),
            )
        )
    )
)

// TODO dd some more mini data sources
