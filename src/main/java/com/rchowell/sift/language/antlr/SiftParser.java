// Generated from Sift.g4 by ANTLR 4.9.2

   package com.rchowell.sift.language.antlr;

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
		PIPE=1, MAPS=2, LP=3, RP=4, COMMA=5, SQUOTE=6, EQ=7, GT=8, LT=9, GTE=10, 
		LTE=11, AND=12, OR=13, PLUS=14, MINUS=15, MULT=16, DIV=17, MOD=18, MIN=19, 
		MAX=20, SUM=21, AVG=22, COUNT=23, SELECT=24, PROJECT=25, GROUP=26, SORT=27, 
		LIMIT=28, DISTINCT=29, ON=30, AS=31, BY=32, OUTER=33, LEFT=34, RIGHT=35, 
		ASC=36, DESC=37, TRUE=38, FALSE=39, JOIN=40, CROSS=41, UNION=42, DIFF=43, 
		INTERSECT=44, ID=45, ID_QUOTED=46, STRING=47, INT=48, WS=49, UNRECOGNIZED=50;
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
			null, "'|>'", "'->'", "'('", "')'", "','", "'''", "'='", "'>'", "'<'", 
			"'>='", "'<='", "'&&'", "'||'", "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PIPE", "MAPS", "LP", "RP", "COMMA", "SQUOTE", "EQ", "GT", "LT", 
			"GTE", "LTE", "AND", "OR", "PLUS", "MINUS", "MULT", "DIV", "MOD", "MIN", 
			"MAX", "SUM", "AVG", "COUNT", "SELECT", "PROJECT", "GROUP", "SORT", "LIMIT", 
			"DISTINCT", "ON", "AS", "BY", "OUTER", "LEFT", "RIGHT", "ASC", "DESC", 
			"TRUE", "FALSE", "JOIN", "CROSS", "UNION", "DIFF", "INTERSECT", "ID", 
			"ID_QUOTED", "STRING", "INT", "WS", "UNRECOGNIZED"
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
		public TerminalNode ID_QUOTED() { return getToken(SiftParser.ID_QUOTED, 0); }
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
	public static class RelBagOpContext extends RelationContext {
		public Token op;
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode UNION() { return getToken(SiftParser.UNION, 0); }
		public TerminalNode CROSS() { return getToken(SiftParser.CROSS, 0); }
		public TerminalNode DIFF() { return getToken(SiftParser.DIFF, 0); }
		public TerminalNode INTERSECT() { return getToken(SiftParser.INTERSECT, 0); }
		public RelBagOpContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitRelBagOp(this);
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
			case ID_QUOTED:
				{
				_localctx = new RelIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(37);
				match(ID_QUOTED);
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
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(62);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new RelBagOpContext(new RelationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relation);
						setState(44);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(45);
						((RelBagOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CROSS) | (1L << UNION) | (1L << DIFF) | (1L << INTERSECT))) != 0)) ) {
							((RelBagOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(46);
						relation(2);
						}
						break;
					case 2:
						{
						_localctx = new RelJoinContext(new RelationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relation);
						setState(47);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(49);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AS) {
							{
							setState(48);
							alias();
							}
						}

						setState(52);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OUTER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
							{
							setState(51);
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

						setState(54);
						match(JOIN);
						setState(55);
						relation(0);
						setState(57);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AS) {
							{
							setState(56);
							alias();
							}
						}

						{
						setState(59);
						match(ON);
						setState(60);
						expr(0);
						}
						}
						break;
					}
					} 
				}
				setState(66);
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
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				select();
				}
				break;
			case PROJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				project();
				}
				break;
			case GROUP:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				group();
				}
				break;
			case SORT:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				sort();
				}
				break;
			case LIMIT:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				limit();
				}
				break;
			case DISTINCT:
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
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
			setState(75);
			match(SELECT);
			setState(76);
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
			setState(78);
			match(PROJECT);
			setState(79);
			func();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(80);
				match(COMMA);
				setState(81);
				func();
				}
				}
				setState(86);
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
			setState(87);
			match(GROUP);
			setState(88);
			agg();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(89);
				match(COMMA);
				setState(90);
				agg();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BY) {
				{
				setState(96);
				match(BY);
				setState(97);
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
			setState(100);
			match(SORT);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(101);
				ids();
				}
			}

			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(104);
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
			setState(107);
			match(LIMIT);
			setState(108);
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
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(DISTINCT);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(111);
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
	public static class FuncExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(SiftParser.ID, 0); }
		public TerminalNode LP() { return getToken(SiftParser.LP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RP() { return getToken(SiftParser.RP, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SiftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SiftParser.COMMA, i);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitFuncExpr(this);
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
	public static class SubExprContext extends ExprContext {
		public TerminalNode LP() { return getToken(SiftParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(SiftParser.RP, 0); }
		public SubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitSubExpr(this);
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
		public TerminalNode LT() { return getToken(SiftParser.LT, 0); }
		public TerminalNode LTE() { return getToken(SiftParser.LTE, 0); }
		public TerminalNode EQ() { return getToken(SiftParser.EQ, 0); }
		public TerminalNode GT() { return getToken(SiftParser.GT, 0); }
		public TerminalNode GTE() { return getToken(SiftParser.GTE, 0); }
		public TerminalNode AND() { return getToken(SiftParser.AND, 0); }
		public TerminalNode OR() { return getToken(SiftParser.OR, 0); }
		public TerminalNode MULT() { return getToken(SiftParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(SiftParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SiftParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(SiftParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SiftParser.MINUS, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SiftVisitor ) return ((SiftVisitor<? extends T>)visitor).visitBoolExpr(this);
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
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(115);
				match(ID);
				setState(116);
				match(LP);
				setState(117);
				expr(0);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(118);
					match(COMMA);
					setState(119);
					expr(0);
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
				match(RP);
				}
				break;
			case 2:
				{
				_localctx = new IdentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new IntLitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(INT);
				}
				break;
			case 4:
				{
				_localctx = new StringLitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new SubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				match(LP);
				setState(131);
				expr(0);
				setState(132);
				match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(148);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(136);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(137);
						((BoolExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GT) | (1L << LT) | (1L << GTE) | (1L << LTE))) != 0)) ) {
							((BoolExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(138);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(140);
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
						setState(141);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(143);
						((BoolExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((BoolExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(144);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(146);
						((BoolExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((BoolExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(147);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new ProjMapContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				expr(0);
				setState(154);
				match(MAPS);
				setState(155);
				match(ID);
				}
				break;
			case 2:
				_localctx = new ProjIdentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
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
			setState(160);
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
			setState(161);
			match(LP);
			setState(162);
			expr(0);
			setState(163);
			match(RP);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MAPS) {
				{
				setState(164);
				match(MAPS);
				setState(165);
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
			setState(168);
			match(AS);
			setState(169);
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
			setState(171);
			match(ID);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(172);
				match(COMMA);
				setState(173);
				match(ID);
				}
				}
				setState(178);
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
			return precpred(_ctx, 1);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u00b6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\7\2\"\n\2\f\2\16"+
		"\2%\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3-\n\3\3\3\3\3\3\3\3\3\3\3\5\3\64\n"+
		"\3\3\3\5\3\67\n\3\3\3\3\3\3\3\5\3<\n\3\3\3\3\3\3\3\7\3A\n\3\f\3\16\3D"+
		"\13\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4L\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6"+
		"U\n\6\f\6\16\6X\13\6\3\7\3\7\3\7\3\7\7\7^\n\7\f\7\16\7a\13\7\3\7\3\7\5"+
		"\7e\n\7\3\b\3\b\5\bi\n\b\3\b\5\bl\n\b\3\t\3\t\3\t\3\n\3\n\5\ns\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\7\13{\n\13\f\13\16\13~\13\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0089\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0097\n\13\f\13\16\13\u009a\13"+
		"\13\3\f\3\f\3\f\3\f\3\f\5\f\u00a1\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a9"+
		"\n\r\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u00b1\n\17\f\17\16\17\u00b4\13"+
		"\17\3\17\2\4\4\24\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\n\3\2+.\3\2"+
		"#%\3\2&\'\3\2\t\r\3\2\16\17\3\2\22\24\3\2\20\21\3\2\25\31\2\u00c5\2\36"+
		"\3\2\2\2\4,\3\2\2\2\6K\3\2\2\2\bM\3\2\2\2\nP\3\2\2\2\fY\3\2\2\2\16f\3"+
		"\2\2\2\20m\3\2\2\2\22p\3\2\2\2\24\u0088\3\2\2\2\26\u00a0\3\2\2\2\30\u00a2"+
		"\3\2\2\2\32\u00aa\3\2\2\2\34\u00ad\3\2\2\2\36#\5\4\3\2\37 \7\3\2\2 \""+
		"\5\6\4\2!\37\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%#\3\2\2"+
		"\2&\'\b\3\1\2\'-\7\60\2\2()\7\5\2\2)*\5\2\2\2*+\7\6\2\2+-\3\2\2\2,&\3"+
		"\2\2\2,(\3\2\2\2-B\3\2\2\2./\f\3\2\2/\60\t\2\2\2\60A\5\4\3\4\61\63\f\4"+
		"\2\2\62\64\5\32\16\2\63\62\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\67\t"+
		"\3\2\2\66\65\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7*\2\29;\5\4\3\2:<\5"+
		"\32\16\2;:\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\7 \2\2>?\5\24\13\2?A\3\2\2\2"+
		"@.\3\2\2\2@\61\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\5\3\2\2\2DB\3\2"+
		"\2\2EL\5\b\5\2FL\5\n\6\2GL\5\f\7\2HL\5\16\b\2IL\5\20\t\2JL\5\22\n\2KE"+
		"\3\2\2\2KF\3\2\2\2KG\3\2\2\2KH\3\2\2\2KI\3\2\2\2KJ\3\2\2\2L\7\3\2\2\2"+
		"MN\7\32\2\2NO\5\24\13\2O\t\3\2\2\2PQ\7\33\2\2QV\5\26\f\2RS\7\7\2\2SU\5"+
		"\26\f\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\13\3\2\2\2XV\3\2\2\2"+
		"YZ\7\34\2\2Z_\5\30\r\2[\\\7\7\2\2\\^\5\30\r\2][\3\2\2\2^a\3\2\2\2_]\3"+
		"\2\2\2_`\3\2\2\2`d\3\2\2\2a_\3\2\2\2bc\7\"\2\2ce\5\34\17\2db\3\2\2\2d"+
		"e\3\2\2\2e\r\3\2\2\2fh\7\35\2\2gi\5\34\17\2hg\3\2\2\2hi\3\2\2\2ik\3\2"+
		"\2\2jl\t\4\2\2kj\3\2\2\2kl\3\2\2\2l\17\3\2\2\2mn\7\36\2\2no\7\62\2\2o"+
		"\21\3\2\2\2pr\7\37\2\2qs\5\34\17\2rq\3\2\2\2rs\3\2\2\2s\23\3\2\2\2tu\b"+
		"\13\1\2uv\7/\2\2vw\7\5\2\2w|\5\24\13\2xy\7\7\2\2y{\5\24\13\2zx\3\2\2\2"+
		"{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\7\6\2"+
		"\2\u0080\u0089\3\2\2\2\u0081\u0089\7/\2\2\u0082\u0089\7\62\2\2\u0083\u0089"+
		"\7\61\2\2\u0084\u0085\7\5\2\2\u0085\u0086\5\24\13\2\u0086\u0087\7\6\2"+
		"\2\u0087\u0089\3\2\2\2\u0088t\3\2\2\2\u0088\u0081\3\2\2\2\u0088\u0082"+
		"\3\2\2\2\u0088\u0083\3\2\2\2\u0088\u0084\3\2\2\2\u0089\u0098\3\2\2\2\u008a"+
		"\u008b\f\13\2\2\u008b\u008c\t\5\2\2\u008c\u0097\5\24\13\f\u008d\u008e"+
		"\f\n\2\2\u008e\u008f\t\6\2\2\u008f\u0097\5\24\13\13\u0090\u0091\f\t\2"+
		"\2\u0091\u0092\t\7\2\2\u0092\u0097\5\24\13\n\u0093\u0094\f\b\2\2\u0094"+
		"\u0095\t\b\2\2\u0095\u0097\5\24\13\t\u0096\u008a\3\2\2\2\u0096\u008d\3"+
		"\2\2\2\u0096\u0090\3\2\2\2\u0096\u0093\3\2\2\2\u0097\u009a\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\25\3\2\2\2\u009a\u0098\3\2\2"+
		"\2\u009b\u009c\5\24\13\2\u009c\u009d\7\4\2\2\u009d\u009e\7/\2\2\u009e"+
		"\u00a1\3\2\2\2\u009f\u00a1\7/\2\2\u00a0\u009b\3\2\2\2\u00a0\u009f\3\2"+
		"\2\2\u00a1\27\3\2\2\2\u00a2\u00a3\t\t\2\2\u00a3\u00a4\7\5\2\2\u00a4\u00a5"+
		"\5\24\13\2\u00a5\u00a8\7\6\2\2\u00a6\u00a7\7\4\2\2\u00a7\u00a9\7/\2\2"+
		"\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\31\3\2\2\2\u00aa\u00ab"+
		"\7!\2\2\u00ab\u00ac\7/\2\2\u00ac\33\3\2\2\2\u00ad\u00b2\7/\2\2\u00ae\u00af"+
		"\7\7\2\2\u00af\u00b1\7/\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\35\3\2\2\2\u00b4\u00b2\3\2\2"+
		"\2\27#,\63\66;@BKV_dhkr|\u0088\u0096\u0098\u00a0\u00a8\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}