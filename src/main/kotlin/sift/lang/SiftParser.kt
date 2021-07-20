package sift.lang

import sift.execution.logical.LogicalPlan

/**
 * SiftParser transforms a list of tokens into a query plan
 *
 * @constructor Create empty Sift parser
 */
interface SiftParser {

    fun parse(tokens: List<Token<*>>): LogicalPlan
}
