package sift.execution

import sift.execution.planner.Planner
import sift.lang.lexers.DirectCodedLexer
import sift.lang.parsers.rd.RecursiveDescentParser

class Executor {

    companion object {

        fun sift(environment: Environment, query: String) {
            val lexer = DirectCodedLexer()
            val parser = RecursiveDescentParser(environment)
            val logicalPlan = parser.parse(lexer.tokenize(query))
            val physicalPlan = Planner.plan(logicalPlan)
            physicalPlan.open()
            var batch = physicalPlan.next()
            while (batch != null) {
                println(batch)
                batch = physicalPlan.next()
            }
        }
    }
}
