// Generated from Sift.g4 by ANTLR 4.9.2

   package com.rchowell.sift.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SiftParser}.
 */
public interface SiftListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SiftParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(SiftParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(SiftParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relId}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelId(SiftParser.RelIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relId}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelId(SiftParser.RelIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relSubquery}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelSubquery(SiftParser.RelSubqueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relSubquery}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelSubquery(SiftParser.RelSubqueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relJoin}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelJoin(SiftParser.RelJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relJoin}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelJoin(SiftParser.RelJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relIntersect}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelIntersect(SiftParser.RelIntersectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relIntersect}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelIntersect(SiftParser.RelIntersectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relCross}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelCross(SiftParser.RelCrossContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relCross}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelCross(SiftParser.RelCrossContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relDiff}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelDiff(SiftParser.RelDiffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relDiff}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelDiff(SiftParser.RelDiffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relUnion}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelUnion(SiftParser.RelUnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relUnion}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelUnion(SiftParser.RelUnionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code transformSelect}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void enterTransformSelect(SiftParser.TransformSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code transformSelect}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void exitTransformSelect(SiftParser.TransformSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code transformProject}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void enterTransformProject(SiftParser.TransformProjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code transformProject}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void exitTransformProject(SiftParser.TransformProjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code transformGroup}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void enterTransformGroup(SiftParser.TransformGroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code transformGroup}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void exitTransformGroup(SiftParser.TransformGroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code transformSort}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void enterTransformSort(SiftParser.TransformSortContext ctx);
	/**
	 * Exit a parse tree produced by the {@code transformSort}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void exitTransformSort(SiftParser.TransformSortContext ctx);
	/**
	 * Enter a parse tree produced by the {@code transformLimit}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void enterTransformLimit(SiftParser.TransformLimitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code transformLimit}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void exitTransformLimit(SiftParser.TransformLimitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code transformDistinct}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void enterTransformDistinct(SiftParser.TransformDistinctContext ctx);
	/**
	 * Exit a parse tree produced by the {@code transformDistinct}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 */
	void exitTransformDistinct(SiftParser.TransformDistinctContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#select}.
	 * @param ctx the parse tree
	 */
	void enterSelect(SiftParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#select}.
	 * @param ctx the parse tree
	 */
	void exitSelect(SiftParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#project}.
	 * @param ctx the parse tree
	 */
	void enterProject(SiftParser.ProjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#project}.
	 * @param ctx the parse tree
	 */
	void exitProject(SiftParser.ProjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(SiftParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(SiftParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#sort}.
	 * @param ctx the parse tree
	 */
	void enterSort(SiftParser.SortContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#sort}.
	 * @param ctx the parse tree
	 */
	void exitSort(SiftParser.SortContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#limit}.
	 * @param ctx the parse tree
	 */
	void enterLimit(SiftParser.LimitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#limit}.
	 * @param ctx the parse tree
	 */
	void exitLimit(SiftParser.LimitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#distinct}.
	 * @param ctx the parse tree
	 */
	void enterDistinct(SiftParser.DistinctContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#distinct}.
	 * @param ctx the parse tree
	 */
	void exitDistinct(SiftParser.DistinctContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SiftParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SiftParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(SiftParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(SiftParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#agg}.
	 * @param ctx the parse tree
	 */
	void enterAgg(SiftParser.AggContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#agg}.
	 * @param ctx the parse tree
	 */
	void exitAgg(SiftParser.AggContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(SiftParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(SiftParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SiftParser#ids}.
	 * @param ctx the parse tree
	 */
	void enterIds(SiftParser.IdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SiftParser#ids}.
	 * @param ctx the parse tree
	 */
	void exitIds(SiftParser.IdsContext ctx);
}