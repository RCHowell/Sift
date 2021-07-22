package sift.lang.lexers

internal class DirectCodedLexerTest {

    @org.junit.jupiter.api.Test
    fun tokenizeMostLanguageConstructs() {
        val lexer = DirectCodedLexer()
        val query = """
            ('A' X 'B') U ('C' & 'D')
            |> PROJECT x, y, z
            |> SELECT ((x > y) && (z < y)) || (x == z)
            |> PROJECT x / 10 -> x, y * 2 -> yeven, z + 3 -> zeee
            |> GROUP SUM(x), AVG(y), MIN(z) BY yeven, zeee
        """.trimIndent()
        val tokens = lexer.tokenize(query)
        for (t in tokens) {
            println(t)
        }
    }
}
