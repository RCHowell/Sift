package sift.execution

import sift.execution.planner.Planner
import sift.lang.lexers.DirectCodedLexer
import sift.lang.parsers.NaiveRecursiveDescentParser

class Executor {

    companion object {

        fun sift(environment: Environment, query: String) {
            val lexer = DirectCodedLexer()
            val parser = NaiveRecursiveDescentParser(environment)
            val logicalPlan = parser.parse(lexer.tokenize(query))
            val physicalPlan = Planner.plan(logicalPlan)
            physicalPlan.open()
            do {
                val batch = physicalPlan.next()
                println(batch)
            } while (batch != null)
        }
    }
}