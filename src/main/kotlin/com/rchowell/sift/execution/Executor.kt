package com.rchowell.sift.execution

import com.rchowell.sift.execution.planner.Planner
import com.rchowell.sift.lang.lexers.DirectCodedLexer
import com.rchowell.sift.lang.parsers.rd.RecursiveDescentParser

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
