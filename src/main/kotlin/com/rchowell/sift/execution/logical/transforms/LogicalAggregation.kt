package com.rchowell.sift.execution.logical.transforms

import com.rchowell.sift.execution.logical.LogicalTransform
import com.rchowell.sift.execution.logical.expressions.LogicalAggregateExpr
import com.rchowell.sift.execution.logical.expressions.LogicalIdentifierExpr
import com.rchowell.sift.types.Field
import com.rchowell.sift.types.Schema

/**
 * LogicalAggregation is much like the extend projection, but it includes grouping attributes.
 *
 * Aggregation operators, such as sums or averages, are not operations of relational algebra, but are used
 *  by the grouping operator (described next). Aggregation operators apply to attributes (columns) of a relation
 *
 * Grouping of tuples according to their value in one or more attributes has the effect of partitioning the tuples
 *  of a relation into groups. Aggregation can then be applied to columns within each group, giving us the ability
 *  to express a number of queries that are impossible to express in the classical relational algebra.
 *  The grouping operator, gamma, is an operator that combines the effect of grouping and aggregation. p213
 */
class LogicalAggregation(
    val input: LogicalTransform,
    val aggregations: Map<LogicalIdentifierExpr, LogicalAggregateExpr>,
    val groups: List<LogicalIdentifierExpr>,
) : LogicalTransform() {

    override val schema: Schema
        get() {
            val fields = mutableListOf<Field>()
            // schema derived from groups
            groups.forEach { fields.add(input.schema.find(it.identifier)) }
            // schema derived from aggregated fields
            aggregations.entries.forEach { (alias, expr) ->
                fields.add(Field(alias.identifier, expr.toField(input).type))
            }
            return Schema(fields)
        }

    override fun inputs(): List<LogicalTransform> = listOf(input)

    override fun toString(): String = buildString {
        append("AGGREGATE ")
        append(aggregations.entries.joinToString { (alias, expr) -> "$expr -> $alias" })
        if (groups.isNotEmpty()) {
            append(" BY ")
            append(groups.joinToString())
        }
    }
}
