package com.rchowell.sift.shell.data

import com.rchowell.sift.source.MemSource
import com.rchowell.sift.types.Batch
import com.rchowell.sift.types.Column
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.NumVectorColumn
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.StringVectorColumn
import com.rchowell.sift.types.Type

val petSchema = Schema(
    listOf(
        Field("Name", Type.String),
        Field("Age", Type.Num),
        Field("Gender", Type.String),
        Field("Weight", Type.Num),
        Field("Type", Type.String),
        Field("Breed", Type.String),
    )
)

val pets = MemSource(
    identifier = "Pets",
    schema = petSchema,
    data = listOf(
        Batch(
            petSchema,
            columns = listOf(
                StringVectorColumn(
                    Column.VectorFactory.string(
                        listOf(
                            "Ramona",
                            "Mochi",
                            "Cali",
                            "Gretchen",
                            "Cooper",
                            "Eleanor",
                            "Huckleberry",
                            "Madman Mochi"
                        )
                    )
                ),
                NumVectorColumn(Column.VectorFactory.numeric(listOf(2.0, 2.0, 7.0, 13.0, 6.0, 5.0, 7.0, 3.0))),
                StringVectorColumn(Column.VectorFactory.string(listOf("F", "F", "F", "F", "M", "F", "M", "M"))),
                NumVectorColumn(Column.VectorFactory.numeric(listOf(8.0, 45.0, 30.0, 50.0, 30.0, 24.0, 20.0, 14.0))),
                StringVectorColumn(Column.VectorFactory.string(listOf("Cat", "Dog", "Dog", "Dog", "Dog", "Dog", "Cat", "Cat"))),
                StringVectorColumn(
                    Column.VectorFactory.string(
                        listOf(
                            "Mini Coon",
                            "Samoyed",
                            "Vizsla",
                            "English Bulldog",
                            "Beagle",
                            "Cocker Spaniel",
                            "Medium Coon",
                            "Unknown"
                        )
                    )
                ),
            )
        )
    )
)

// TODO dd some more mini data sources
