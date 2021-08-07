package sift.execution.logical.plans

import sift.execution.logical.LogicalPlan
import sift.execution.logical.expressions.LogicalAggregateExpr
import sift.execution.logical.expressions.LogicalIdentifierExpr
import sift.types.Field
import sift.types.Schema

/**
 * LogicalAggregation is much like the extend projection, but it includes grouping attributes.
 *
 * Aggregation operators, such as sums or averages, are not operations of relational algebra, but are used
 *  by the grouping operator (described next). Aggregation operators apply to attributes (columns) of a relation
 *
 * Grouping of tuples according to their value in one or more attributes has the effect of partitioning the tuples
 *  of a relation into “groups.” Aggregation can then be applied to columns within each group, giving us the ability
 *  to express a number of queries that are impossible to express in the classical relational algebra.
 *  The grouping operator, gamma, is an operator that combines the effect of grouping and aggregation. p213
 */
class LogicalAggregation(
     val input: LogicalPlan,
    private val aggs: Map<LogicalIdentifierExpr, LogicalAggregateExpr>,
    private val groups: List<LogicalIdentifierExpr>,
) : LogicalPlan() {

    override val schema: Schema = Schema(
        aggs.entries.map { (alias, expr) ->
            Field(alias.identifier, expr.toField(input).type)
        }
    )

    override fun inputs(): List<LogicalPlan> = listOf(input)

    override fun toString(): String = buildString {
        append("AGGREGATE ")
        append(aggs.entries.joinToString { (alias, expr) -> "$expr -> $alias" })
        if (groups.isNotEmpty()) {
            append(" BY ")
            append(groups.joinToString())
        }
    }
}
