// Generated from Sift.g4 by ANTLR 4.9.2

   package com.rchowell.sift.lang.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SiftParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, PIPE=5, MAPS=6, LP=7, RP=8, COMMA=9, SQUOTE=10, 
		EQ=11, GT=12, LT=13, GTE=14, LTE=15, AND=16, OR=17, MIN=18, MAX=19, SUM=20, 
		AVG=21, COUNT=22, SELECT=23, PROJECT=24, GROUP=25, SORT=26, LIMIT=27, 
		DISTINCT=28, ON=29, AS=30, BY=31, OUTER=32, LEFT=33, RIGHT=34, ASC=35, 
		DESC=36, TRUE=37, FALSE=38, JOIN=39, CROSS=40, UNION=41, DIFF=42, INTERSECT=43, 
		ID=44, STRING=45, INT=46, WS=47;
	public static final int
		RULE_query = 0, RULE_relation = 1, RULE_transform = 2, RULE_select = 3, 
		RULE_project = 4, RULE_group = 5, RULE_sort = 6, RULE_limit = 7, RULE_distinct = 8, 
		RULE_expr = 9, RULE_func = 10, RULE_agg = 11, RULE_alias = 12, RULE_ids = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "relation", "transform", "select", "project", "group", "sort", 
			"limit", "distinct", "expr", "func", "agg", "alias", "ids"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'X'", "'U'", "'-'", "'&'", "'|>'", "'->'", "'('", "')'", "','", 
			"'''", "'='", "'>'", "'<'", "'>='", "'<='", "'&&'", "'||'", "'MIN'", 
			"'MAX'", "'SUM'", "'AVG'", "'COUNT'", "'SELECT'", "'PROJECT'", "'GROUP'", 
			"'SORT'", "'LIMIT'", "'DISTINCT'", "'ON'", "'AS'", "'BY'", "'OUTER'", 
			"'LEFT'", "'RIGHT'", "'ASC'", "'DESC'", "'TRUE'", "'FALSE'", "'JOIN'", 
			"'CROSS'", "'UNION'", "'DIFF'", "'INTERSECT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "PIPE", "MAPS", "LP", "RP", "COMMA", "SQUOTE", 
			"EQ", "GT", "LT", "GTE", "LTE", "AND", "OR", "MIN", "MAX", "SUM", "AVG", 
			"COUNT", "SELECT", "PROJECT", "GROUP", "SORT", "LIMIT", "DISTINCT", "ON", 
			"AS", "BY", "OUTER", "LEFT", "RIGHT", "ASC", "DESC", "TRUE", "FALSE", 
			"JOIN", "CROSS", "UNION", "DIFF", "INTERSECT", "ID", "STRING", "INT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Sift.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SiftParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QueryContext extends ParserRuleContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public List<TerminalNode> PIPE() { return getTokens(SiftParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(SiftParser.PIPE, i);
		}
		public List<TransformContext> transform() {
			return getRuleContexts(TransformContext.class);
		}
		public TransformContext transform(int i) {
			return getRuleContext(TransformContext.class,i);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			relation(0);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(29);
				match(PIPE);
				setState(30);
				transform();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	 
		public RelationContext() { }
		public void copyFrom(RelationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelIdContext extends RelationContext {
		public TerminalNode ID() { return getToken(SiftParser.ID, 0); }
		public RelIdContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitRelId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelSubqueryContext extends RelationContext {
		public TerminalNode LP() { return getToken(SiftParser.LP, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode RP() { return getToken(SiftParser.RP, 0); }
		public RelSubqueryContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitRelSubquery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelJoinContext extends RelationContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode JOIN() { return getToken(SiftParser.JOIN, 0); }
		public TerminalNode ON() { return getToken(SiftParser.ON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<AliasContext> alias() {
			return getRuleContexts(AliasContext.class);
		}
		public AliasContext alias(int i) {
			return getRuleContext(AliasContext.class,i);
		}
		public TerminalNode OUTER() { return getToken(SiftParser.OUTER, 0); }
		public TerminalNode LEFT() { return getToken(SiftParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(SiftParser.RIGHT, 0); }
		public RelJoinContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitRelJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelIntersectContext extends RelationContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode INTERSECT() { return getToken(SiftParser.INTERSECT, 0); }
		public RelIntersectContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitRelIntersect(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelCrossContext extends RelationContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode CROSS() { return getToken(SiftParser.CROSS, 0); }
		public RelCrossContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitRelCross(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelDiffContext extends RelationContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode DIFF() { return getToken(SiftParser.DIFF, 0); }
		public RelDiffContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitRelDiff(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelUnionContext extends RelationContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode UNION() { return getToken(SiftParser.UNION, 0); }
		public RelUnionContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitRelUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		return relation(0);
	}

	private RelationContext relation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationContext _localctx = new RelationContext(_ctx, _parentState);
		RelationContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_relation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new RelIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(37);
				match(ID);
				}
				break;
			case LP:
				{
				_localctx = new RelSubqueryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(LP);
				setState(39);
				query();
				setState(40);
				match(RP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(71);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new RelCrossContext(new RelationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relation);
						setState(44);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(45);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==CROSS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(46);
						relation(5);
						}
						break;
					case 2:
						{
						_localctx = new RelUnionContext(new RelationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relation);
						setState(47);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(48);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==UNION) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(49);
						relation(4);
						}
						break;
					case 3:
						{
						_localctx = new RelDiffContext(new RelationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relation);
						setState(50);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(51);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==DIFF) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(52);
						relation(3);
						}
						break;
					case 4:
						{
						_localctx = new RelIntersectContext(new RelationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relation);
						setState(53);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(54);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==INTERSECT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(55);
						relation(2);
						}
						break;
					case 5:
						{
						_localctx = new RelJoinContext(new RelationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relation);
						setState(56);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(58);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AS) {
							{
							setState(57);
							alias();
							}
						}

						setState(61);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OUTER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
							{
							setState(60);
							_la = _input.LA(1);
							if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OUTER) | (1L << LEFT) | (1L << RIGHT))) != 0)) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
						}

						setState(63);
						match(JOIN);
						setState(64);
						relation(0);
						setState(66);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AS) {
							{
							setState(65);
							alias();
							}
						}

						{
						setState(68);
						match(ON);
						setState(69);
						expr(0);
						}
						}
						break;
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TransformContext extends ParserRuleContext {
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public ProjectContext project() {
			return getRuleContext(ProjectContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public SortContext sort() {
			return getRuleContext(SortContext.class,0);
		}
		public LimitContext limit() {
			return getRuleContext(LimitContext.class,0);
		}
		public DistinctContext distinct() {
			return getRuleContext(DistinctContext.class,0);
		}
		public TransformContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transform; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitTransform(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransformContext transform() throws RecognitionException {
		TransformContext _localctx = new TransformContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_transform);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				select();
				}
				break;
			case PROJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				project();
				}
				break;
			case GROUP:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				group();
				}
				break;
			case SORT:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				sort();
				}
				break;
			case LIMIT:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				limit();
				}
				break;
			case DISTINCT:
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				distinct();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SiftParser.SELECT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(SELECT);
			setState(85);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProjectContext extends ParserRuleContext {
		public TerminalNode PROJECT() { return getToken(SiftParser.PROJECT, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SiftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SiftParser.COMMA, i);
		}
		public ProjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_project; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitProject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectContext project() throws RecognitionException {
		ProjectContext _localctx = new ProjectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_project);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(PROJECT);
			setState(88);
			func();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(89);
				match(COMMA);
				setState(90);
				func();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(SiftParser.GROUP, 0); }
		public List<AggContext> agg() {
			return getRuleContexts(AggContext.class);
		}
		public AggContext agg(int i) {
			return getRuleContext(AggContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SiftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SiftParser.COMMA, i);
		}
		public TerminalNode BY() { return getToken(SiftParser.BY, 0); }
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(GROUP);
			setState(97);
			agg();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(98);
				match(COMMA);
				setState(99);
				agg();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BY) {
				{
				setState(105);
				match(BY);
				setState(106);
				ids();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SortContext extends ParserRuleContext {
		public Token order;
		public TerminalNode SORT() { return getToken(SiftParser.SORT, 0); }
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public TerminalNode ASC() { return getToken(SiftParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SiftParser.DESC, 0); }
		public SortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitSort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortContext sort() throws RecognitionException {
		SortContext _localctx = new SortContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sort);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(SORT);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(110);
				ids();
				}
			}

			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(113);
				((SortContext)_localctx).order = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((SortContext)_localctx).order = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(SiftParser.LIMIT, 0); }
		public TerminalNode INT() { return getToken(SiftParser.INT, 0); }
		public LimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitLimit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LimitContext limit() throws RecognitionException {
		LimitContext _localctx = new LimitContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_limit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(LIMIT);
			setState(117);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DistinctContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(SiftParser.DISTINCT, 0); }
		public DistinctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distinct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitDistinct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DistinctContext distinct() throws RecognitionException {
		DistinctContext _localctx = new DistinctContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_distinct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(DISTINCT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdentExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(SiftParser.ID, 0); }
		public IdentExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitIdentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLitExprContext extends ExprContext {
		public TerminalNode INT() { return getToken(SiftParser.INT, 0); }
		public IntLitExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitIntLitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLitExprContext extends ExprContext {
		public TerminalNode STRING() { return getToken(SiftParser.STRING, 0); }
		public StringLitExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitStringLitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(SiftParser.LT, 0); }
		public TerminalNode LTE() { return getToken(SiftParser.LTE, 0); }
		public TerminalNode EQ() { return getToken(SiftParser.EQ, 0); }
		public TerminalNode GT() { return getToken(SiftParser.GT, 0); }
		public TerminalNode GTE() { return getToken(SiftParser.GTE, 0); }
		public ComparisonExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitComparisonExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(SiftParser.AND, 0); }
		public TerminalNode OR() { return getToken(SiftParser.OR, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuotedExprContext extends ExprContext {
		public TerminalNode LP() { return getToken(SiftParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(SiftParser.RP, 0); }
		public QuotedExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitQuotedExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new IdentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(122);
				match(ID);
				}
				break;
			case INT:
				{
				_localctx = new IntLitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(INT);
				}
				break;
			case STRING:
				{
				_localctx = new StringLitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(STRING);
				}
				break;
			case LP:
				{
				_localctx = new QuotedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(LP);
				setState(126);
				expr(0);
				setState(127);
				match(RP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(137);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ComparisonExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(132);
						((ComparisonExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GT) | (1L << LT) | (1L << GTE) | (1L << LTE))) != 0)) ) {
							((ComparisonExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(133);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(135);
						((BoolExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((BoolExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(136);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	 
		public FuncContext() { }
		public void copyFrom(FuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProjMapContext extends FuncContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MAPS() { return getToken(SiftParser.MAPS, 0); }
		public TerminalNode ID() { return getToken(SiftParser.ID, 0); }
		public ProjMapContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitProjMap(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProjIdentContext extends FuncContext {
		public TerminalNode ID() { return getToken(SiftParser.ID, 0); }
		public ProjIdentContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitProjIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_func);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new ProjMapContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				expr(0);
				setState(143);
				match(MAPS);
				setState(144);
				match(ID);
				}
				break;
			case 2:
				_localctx = new ProjIdentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggContext extends ParserRuleContext {
		public Token op;
		public TerminalNode LP() { return getToken(SiftParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(SiftParser.RP, 0); }
		public TerminalNode MIN() { return getToken(SiftParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(SiftParser.MAX, 0); }
		public TerminalNode SUM() { return getToken(SiftParser.SUM, 0); }
		public TerminalNode AVG() { return getToken(SiftParser.AVG, 0); }
		public TerminalNode COUNT() { return getToken(SiftParser.COUNT, 0); }
		public TerminalNode MAPS() { return getToken(SiftParser.MAPS, 0); }
		public TerminalNode ID() { return getToken(SiftParser.ID, 0); }
		public AggContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitAgg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggContext agg() throws RecognitionException {
		AggContext _localctx = new AggContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_agg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			((AggContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << MAX) | (1L << SUM) | (1L << AVG) | (1L << COUNT))) != 0)) ) {
				((AggContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(150);
			match(LP);
			setState(151);
			expr(0);
			setState(152);
			match(RP);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MAPS) {
				{
				setState(153);
				match(MAPS);
				setState(154);
				match(ID);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(SiftParser.AS, 0); }
		public TerminalNode ID() { return getToken(SiftParser.ID, 0); }
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(AS);
			setState(158);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SiftParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SiftParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SiftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SiftParser.COMMA, i);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitIds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(ID);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(161);
				match(COMMA);
				setState(162);
				match(ID);
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return relation_sempred((RelationContext)_localctx, predIndex);
		case 9:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean relation_sempred(RelationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		case 4:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u00ab\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\7\2\"\n\2\f\2\16"+
		"\2%\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3-\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\3\5\3@\n\3\3\3\3\3\3\3\5\3E\n"+
		"\3\3\3\3\3\3\3\7\3J\n\3\f\3\16\3M\13\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4U\n"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6\3\7\3\7\3\7\3\7"+
		"\7\7g\n\7\f\7\16\7j\13\7\3\7\3\7\5\7n\n\7\3\b\3\b\5\br\n\b\3\b\5\bu\n"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0084"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008c\n\13\f\13\16\13\u008f\13"+
		"\13\3\f\3\f\3\f\3\f\3\f\5\f\u0096\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009e"+
		"\n\r\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u00a6\n\17\f\17\16\17\u00a9\13"+
		"\17\3\17\2\4\4\24\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\13\4\2\3\3"+
		"**\4\2\4\4++\4\2\5\5,,\4\2\6\6--\3\2\"$\3\2%&\3\2\r\21\3\2\22\23\3\2\24"+
		"\30\2\u00b8\2\36\3\2\2\2\4,\3\2\2\2\6T\3\2\2\2\bV\3\2\2\2\nY\3\2\2\2\f"+
		"b\3\2\2\2\16o\3\2\2\2\20v\3\2\2\2\22y\3\2\2\2\24\u0083\3\2\2\2\26\u0095"+
		"\3\2\2\2\30\u0097\3\2\2\2\32\u009f\3\2\2\2\34\u00a2\3\2\2\2\36#\5\4\3"+
		"\2\37 \7\7\2\2 \"\5\6\4\2!\37\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$"+
		"\3\3\2\2\2%#\3\2\2\2&\'\b\3\1\2\'-\7.\2\2()\7\t\2\2)*\5\2\2\2*+\7\n\2"+
		"\2+-\3\2\2\2,&\3\2\2\2,(\3\2\2\2-K\3\2\2\2./\f\6\2\2/\60\t\2\2\2\60J\5"+
		"\4\3\7\61\62\f\5\2\2\62\63\t\3\2\2\63J\5\4\3\6\64\65\f\4\2\2\65\66\t\4"+
		"\2\2\66J\5\4\3\5\678\f\3\2\289\t\5\2\29J\5\4\3\4:<\f\7\2\2;=\5\32\16\2"+
		"<;\3\2\2\2<=\3\2\2\2=?\3\2\2\2>@\t\6\2\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2"+
		"AB\7)\2\2BD\5\4\3\2CE\5\32\16\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\7\37\2"+
		"\2GH\5\24\13\2HJ\3\2\2\2I.\3\2\2\2I\61\3\2\2\2I\64\3\2\2\2I\67\3\2\2\2"+
		"I:\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\5\3\2\2\2MK\3\2\2\2NU\5\b\5"+
		"\2OU\5\n\6\2PU\5\f\7\2QU\5\16\b\2RU\5\20\t\2SU\5\22\n\2TN\3\2\2\2TO\3"+
		"\2\2\2TP\3\2\2\2TQ\3\2\2\2TR\3\2\2\2TS\3\2\2\2U\7\3\2\2\2VW\7\31\2\2W"+
		"X\5\24\13\2X\t\3\2\2\2YZ\7\32\2\2Z_\5\26\f\2[\\\7\13\2\2\\^\5\26\f\2]"+
		"[\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\13\3\2\2\2a_\3\2\2\2bc\7\33\2"+
		"\2ch\5\30\r\2de\7\13\2\2eg\5\30\r\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3"+
		"\2\2\2im\3\2\2\2jh\3\2\2\2kl\7!\2\2ln\5\34\17\2mk\3\2\2\2mn\3\2\2\2n\r"+
		"\3\2\2\2oq\7\34\2\2pr\5\34\17\2qp\3\2\2\2qr\3\2\2\2rt\3\2\2\2su\t\7\2"+
		"\2ts\3\2\2\2tu\3\2\2\2u\17\3\2\2\2vw\7\35\2\2wx\7\60\2\2x\21\3\2\2\2y"+
		"z\7\36\2\2z\23\3\2\2\2{|\b\13\1\2|\u0084\7.\2\2}\u0084\7\60\2\2~\u0084"+
		"\7/\2\2\177\u0080\7\t\2\2\u0080\u0081\5\24\13\2\u0081\u0082\7\n\2\2\u0082"+
		"\u0084\3\2\2\2\u0083{\3\2\2\2\u0083}\3\2\2\2\u0083~\3\2\2\2\u0083\177"+
		"\3\2\2\2\u0084\u008d\3\2\2\2\u0085\u0086\f\b\2\2\u0086\u0087\t\b\2\2\u0087"+
		"\u008c\5\24\13\t\u0088\u0089\f\7\2\2\u0089\u008a\t\t\2\2\u008a\u008c\5"+
		"\24\13\b\u008b\u0085\3\2\2\2\u008b\u0088\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\25\3\2\2\2\u008f\u008d\3\2\2"+
		"\2\u0090\u0091\5\24\13\2\u0091\u0092\7\b\2\2\u0092\u0093\7.\2\2\u0093"+
		"\u0096\3\2\2\2\u0094\u0096\7.\2\2\u0095\u0090\3\2\2\2\u0095\u0094\3\2"+
		"\2\2\u0096\27\3\2\2\2\u0097\u0098\t\n\2\2\u0098\u0099\7\t\2\2\u0099\u009a"+
		"\5\24\13\2\u009a\u009d\7\n\2\2\u009b\u009c\7\b\2\2\u009c\u009e\7.\2\2"+
		"\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\31\3\2\2\2\u009f\u00a0"+
		"\7 \2\2\u00a0\u00a1\7.\2\2\u00a1\33\3\2\2\2\u00a2\u00a7\7.\2\2\u00a3\u00a4"+
		"\7\13\2\2\u00a4\u00a6\7.\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\35\3\2\2\2\u00a9\u00a7\3\2\2"+
		"\2\25#,<?DIKT_hmqt\u0083\u008b\u008d\u0095\u009d\u00a7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}