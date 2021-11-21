package com.rchowell.sift.language

import com.rchowell.sift.execution.logical.LogicalTransform

/**
 * SiftParser transforms a list of tokens into a query plan
 *
 * @constructor Create empty Sift parser
 */
interface SiftParser {

    fun parse(tokens: List<Token<*>>): LogicalTransform
}
