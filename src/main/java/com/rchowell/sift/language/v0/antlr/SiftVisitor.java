// Generated from Sift.g4 by ANTLR 4.9.3

   package com.rchowell.sift.language.v0.antlr;

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
	 * Visit a parse tree produced by the {@code relBagOp}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelBagOp(SiftParser.RelBagOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relJoin}
	 * labeled alternative in {@link SiftParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelJoin(SiftParser.RelJoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link SiftParser#transform}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransform(SiftParser.TransformContext ctx);
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
	 * Visit a parse tree produced by the {@code identExpr}
	 * labeled alternative in {@link SiftParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentExpr(SiftParser.IdentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link SiftParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(SiftParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLitExpr}
	 * labeled alternative in {@link SiftParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLitExpr(SiftParser.IntLitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLitExpr}
	 * labeled alternative in {@link SiftParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLitExpr(SiftParser.StringLitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link SiftParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(SiftParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SiftParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(SiftParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code projMap}
	 * labeled alternative in {@link SiftParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjMap(SiftParser.ProjMapContext ctx);
	/**
	 * Visit a parse tree produced by the {@code projIdent}
	 * labeled alternative in {@link SiftParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjIdent(SiftParser.ProjIdentContext ctx);
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