// Generated from Sift.g4 by ANTLR 4.9.2

   package com.rchowell.sift.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SiftParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SiftVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SiftParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(SiftParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relId}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelId(SiftParser.RelIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relSubquery}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelSubquery(SiftParser.RelSubqueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relJoin}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelJoin(SiftParser.RelJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relIntersect}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelIntersect(SiftParser.RelIntersectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relCross}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelCross(SiftParser.RelCrossContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relDiff}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelDiff(SiftParser.RelDiffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relUnion}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelUnion(SiftParser.RelUnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code transformSelect}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformSelect(SiftParser.TransformSelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code transformProject}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformProject(SiftParser.TransformProjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code transformGroup}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformGroup(SiftParser.TransformGroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code transformSort}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformSort(SiftParser.TransformSortContext ctx);
	/**
	 * Visit a parse tree produced by the {@code transformLimit}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformLimit(SiftParser.TransformLimitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code transformDistinct}
	 * labeled alternative in {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformDistinct(SiftParser.TransformDistinctContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(SiftParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#project}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProject(SiftParser.ProjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(SiftParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#sort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSort(SiftParser.SortContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#limit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit(SiftParser.LimitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#distinct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistinct(SiftParser.DistinctContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SiftParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(SiftParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#agg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgg(SiftParser.AggContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlias(SiftParser.AliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#ids}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIds(SiftParser.IdsContext ctx);
}