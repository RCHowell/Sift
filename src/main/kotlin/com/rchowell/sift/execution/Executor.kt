package com.rchowell.sift.execution

import com.rchowell.sift.execution.planner.Planner
import com.rchowell.sift.language.v0.antlr.SiftCompiler

class Executor {

    companion object {

        fun sift(environment: Environment, query: String) {
            val compiler = SiftCompiler(environment)
            val logicalPlan = compiler.compile(query)
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
