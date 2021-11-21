package com.rchowell.sift.language.antlr

import com.rchowell.sift.execution.Environment
import com.rchowell.sift.source.EmptySource
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema
import com.rchowell.sift.types.Type
import org.junit.jupiter.api.Test

class SiftAntlrTest {

    private val dogs = EmptySource(
        identifier = "Dogs",
        schema = Schema(listOf(Field("age", Type.Num)))
    )
    private val cats = EmptySource(
        identifier = "Cats",
        schema = Schema(listOf(Field("age", Type.Num)))
    )
    private val env = Environment(listOf(dogs, cats))
    private val compiler = SiftCompiler(env)

    @Test
    fun test() {
        val source = EmptySource(
            identifier = "Test",
            schema = Schema(
                listOf(
                    Field("a", Type.Num),
                    Field("b", Type.String),
                    Field("c", Type.Bool),
                )
            )
        )
        val env = Environment(listOf(source))
        val query = """
            Test
            |> SELECT a > 100 && b = "foo"
            |> DISTINCT
            |> PROJECT a, b, c > 50 -> Old
            |> GROUP SUM(a), AVG(b) -> x
            |> SORT x DESC
            |> LIMIT 50
        """.trimIndent()
        val compiler = SiftCompiler(env)
        compiler.describe(query, verbose = true)
    }

    @Test
    fun cross() {
        val query = """
            (Dogs X Cats) |> SELECT Age > 2
        """.trimIndent()
        compiler.describe(query, verbose = true)
    }

    @Test
    fun union() {
        val query = """
            (Dogs U Cats) |> SELECT Age > 2
        """.trimIndent()
        compiler.describe(query, verbose = true)
    }

    @Test
    fun diff() {
        val query = """
            (Dogs - Cats) |> SELECT Age > 2
        """.trimIndent()
        compiler.describe(query, verbose = true)
    }

    @Test
    fun intersect() {
        val query = """
            (`Dogs` & `Cats`) |> SELECT Age > 2
        """.trimIndent()
        compiler.describe(query, verbose = true)
    }

    @Test
    fun lexer() {
        val tokens = SiftCompiler.lex("`Cats` |> SELECT Age > 0")
        val parser = SiftParser(tokens)
        val tree = parser.query()
        println("--------------")
        tokens.tokens.forEach {
            println(it)
        }
    }

    @Test
    fun keywords() {
        val keywords = SiftCompiler.keywords()
        keywords.forEach { println(it) }
    }
}
