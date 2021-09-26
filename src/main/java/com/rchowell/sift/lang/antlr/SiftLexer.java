// Generated from Sift.g4 by ANTLR 4.9.2

   package com.rchowell.sift.lang.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SiftLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "PIPE", "MAPS", "LP", "RP", "COMMA", 
			"SQUOTE", "EQ", "GT", "LT", "GTE", "LTE", "AND", "OR", "MIN", "MAX", 
			"SUM", "AVG", "COUNT", "SELECT", "PROJECT", "GROUP", "SORT", "LIMIT", 
			"DISTINCT", "ON", "AS", "BY", "OUTER", "LEFT", "RIGHT", "ASC", "DESC", 
			"TRUE", "FALSE", "JOIN", "CROSS", "UNION", "DIFF", "INTERSECT", "ID", 
			"STRING", "INT", "WS"
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


	public SiftLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Sift.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0135\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3"+
		" \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$"+
		"\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3("+
		"\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,"+
		"\3,\3,\3,\3,\3,\3,\3-\6-\u0118\n-\r-\16-\u0119\3.\3.\6.\u011e\n.\r.\16"+
		".\u011f\3.\7.\u0123\n.\f.\16.\u0126\13.\3.\3.\3/\6/\u012b\n/\r/\16/\u012c"+
		"\3\60\6\60\u0130\n\60\r\60\16\60\u0131\3\60\3\60\2\2\61\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61\3\2\7\6\2//C\\aac|\4\2C\\c|\5\2\62;C\\"+
		"c|\3\2\62;\5\2\13\f\17\17\"\"\2\u0139\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5c\3\2\2\2\7e\3\2\2\2\tg\3"+
		"\2\2\2\13i\3\2\2\2\rl\3\2\2\2\17o\3\2\2\2\21q\3\2\2\2\23s\3\2\2\2\25u"+
		"\3\2\2\2\27w\3\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35}\3\2\2\2\37\u0080\3\2"+
		"\2\2!\u0083\3\2\2\2#\u0086\3\2\2\2%\u0089\3\2\2\2\'\u008d\3\2\2\2)\u0091"+
		"\3\2\2\2+\u0095\3\2\2\2-\u0099\3\2\2\2/\u009f\3\2\2\2\61\u00a6\3\2\2\2"+
		"\63\u00ae\3\2\2\2\65\u00b4\3\2\2\2\67\u00b9\3\2\2\29\u00bf\3\2\2\2;\u00c8"+
		"\3\2\2\2=\u00cb\3\2\2\2?\u00ce\3\2\2\2A\u00d1\3\2\2\2C\u00d7\3\2\2\2E"+
		"\u00dc\3\2\2\2G\u00e2\3\2\2\2I\u00e6\3\2\2\2K\u00eb\3\2\2\2M\u00f0\3\2"+
		"\2\2O\u00f6\3\2\2\2Q\u00fb\3\2\2\2S\u0101\3\2\2\2U\u0107\3\2\2\2W\u010c"+
		"\3\2\2\2Y\u0117\3\2\2\2[\u011b\3\2\2\2]\u012a\3\2\2\2_\u012f\3\2\2\2a"+
		"b\7Z\2\2b\4\3\2\2\2cd\7W\2\2d\6\3\2\2\2ef\7/\2\2f\b\3\2\2\2gh\7(\2\2h"+
		"\n\3\2\2\2ij\7~\2\2jk\7@\2\2k\f\3\2\2\2lm\7/\2\2mn\7@\2\2n\16\3\2\2\2"+
		"op\7*\2\2p\20\3\2\2\2qr\7+\2\2r\22\3\2\2\2st\7.\2\2t\24\3\2\2\2uv\7)\2"+
		"\2v\26\3\2\2\2wx\7?\2\2x\30\3\2\2\2yz\7@\2\2z\32\3\2\2\2{|\7>\2\2|\34"+
		"\3\2\2\2}~\7@\2\2~\177\7?\2\2\177\36\3\2\2\2\u0080\u0081\7>\2\2\u0081"+
		"\u0082\7?\2\2\u0082 \3\2\2\2\u0083\u0084\7(\2\2\u0084\u0085\7(\2\2\u0085"+
		"\"\3\2\2\2\u0086\u0087\7~\2\2\u0087\u0088\7~\2\2\u0088$\3\2\2\2\u0089"+
		"\u008a\7O\2\2\u008a\u008b\7K\2\2\u008b\u008c\7P\2\2\u008c&\3\2\2\2\u008d"+
		"\u008e\7O\2\2\u008e\u008f\7C\2\2\u008f\u0090\7Z\2\2\u0090(\3\2\2\2\u0091"+
		"\u0092\7U\2\2\u0092\u0093\7W\2\2\u0093\u0094\7O\2\2\u0094*\3\2\2\2\u0095"+
		"\u0096\7C\2\2\u0096\u0097\7X\2\2\u0097\u0098\7I\2\2\u0098,\3\2\2\2\u0099"+
		"\u009a\7E\2\2\u009a\u009b\7Q\2\2\u009b\u009c\7W\2\2\u009c\u009d\7P\2\2"+
		"\u009d\u009e\7V\2\2\u009e.\3\2\2\2\u009f\u00a0\7U\2\2\u00a0\u00a1\7G\2"+
		"\2\u00a1\u00a2\7N\2\2\u00a2\u00a3\7G\2\2\u00a3\u00a4\7E\2\2\u00a4\u00a5"+
		"\7V\2\2\u00a5\60\3\2\2\2\u00a6\u00a7\7R\2\2\u00a7\u00a8\7T\2\2\u00a8\u00a9"+
		"\7Q\2\2\u00a9\u00aa\7L\2\2\u00aa\u00ab\7G\2\2\u00ab\u00ac\7E\2\2\u00ac"+
		"\u00ad\7V\2\2\u00ad\62\3\2\2\2\u00ae\u00af\7I\2\2\u00af\u00b0\7T\2\2\u00b0"+
		"\u00b1\7Q\2\2\u00b1\u00b2\7W\2\2\u00b2\u00b3\7R\2\2\u00b3\64\3\2\2\2\u00b4"+
		"\u00b5\7U\2\2\u00b5\u00b6\7Q\2\2\u00b6\u00b7\7T\2\2\u00b7\u00b8\7V\2\2"+
		"\u00b8\66\3\2\2\2\u00b9\u00ba\7N\2\2\u00ba\u00bb\7K\2\2\u00bb\u00bc\7"+
		"O\2\2\u00bc\u00bd\7K\2\2\u00bd\u00be\7V\2\2\u00be8\3\2\2\2\u00bf\u00c0"+
		"\7F\2\2\u00c0\u00c1\7K\2\2\u00c1\u00c2\7U\2\2\u00c2\u00c3\7V\2\2\u00c3"+
		"\u00c4\7K\2\2\u00c4\u00c5\7P\2\2\u00c5\u00c6\7E\2\2\u00c6\u00c7\7V\2\2"+
		"\u00c7:\3\2\2\2\u00c8\u00c9\7Q\2\2\u00c9\u00ca\7P\2\2\u00ca<\3\2\2\2\u00cb"+
		"\u00cc\7C\2\2\u00cc\u00cd\7U\2\2\u00cd>\3\2\2\2\u00ce\u00cf\7D\2\2\u00cf"+
		"\u00d0\7[\2\2\u00d0@\3\2\2\2\u00d1\u00d2\7Q\2\2\u00d2\u00d3\7W\2\2\u00d3"+
		"\u00d4\7V\2\2\u00d4\u00d5\7G\2\2\u00d5\u00d6\7T\2\2\u00d6B\3\2\2\2\u00d7"+
		"\u00d8\7N\2\2\u00d8\u00d9\7G\2\2\u00d9\u00da\7H\2\2\u00da\u00db\7V\2\2"+
		"\u00dbD\3\2\2\2\u00dc\u00dd\7T\2\2\u00dd\u00de\7K\2\2\u00de\u00df\7I\2"+
		"\2\u00df\u00e0\7J\2\2\u00e0\u00e1\7V\2\2\u00e1F\3\2\2\2\u00e2\u00e3\7"+
		"C\2\2\u00e3\u00e4\7U\2\2\u00e4\u00e5\7E\2\2\u00e5H\3\2\2\2\u00e6\u00e7"+
		"\7F\2\2\u00e7\u00e8\7G\2\2\u00e8\u00e9\7U\2\2\u00e9\u00ea\7E\2\2\u00ea"+
		"J\3\2\2\2\u00eb\u00ec\7V\2\2\u00ec\u00ed\7T\2\2\u00ed\u00ee\7W\2\2\u00ee"+
		"\u00ef\7G\2\2\u00efL\3\2\2\2\u00f0\u00f1\7H\2\2\u00f1\u00f2\7C\2\2\u00f2"+
		"\u00f3\7N\2\2\u00f3\u00f4\7U\2\2\u00f4\u00f5\7G\2\2\u00f5N\3\2\2\2\u00f6"+
		"\u00f7\7L\2\2\u00f7\u00f8\7Q\2\2\u00f8\u00f9\7K\2\2\u00f9\u00fa\7P\2\2"+
		"\u00faP\3\2\2\2\u00fb\u00fc\7E\2\2\u00fc\u00fd\7T\2\2\u00fd\u00fe\7Q\2"+
		"\2\u00fe\u00ff\7U\2\2\u00ff\u0100\7U\2\2\u0100R\3\2\2\2\u0101\u0102\7"+
		"W\2\2\u0102\u0103\7P\2\2\u0103\u0104\7K\2\2\u0104\u0105\7Q\2\2\u0105\u0106"+
		"\7P\2\2\u0106T\3\2\2\2\u0107\u0108\7F\2\2\u0108\u0109\7K\2\2\u0109\u010a"+
		"\7H\2\2\u010a\u010b\7H\2\2\u010bV\3\2\2\2\u010c\u010d\7K\2\2\u010d\u010e"+
		"\7P\2\2\u010e\u010f\7V\2\2\u010f\u0110\7G\2\2\u0110\u0111\7T\2\2\u0111"+
		"\u0112\7U\2\2\u0112\u0113\7G\2\2\u0113\u0114\7E\2\2\u0114\u0115\7V\2\2"+
		"\u0115X\3\2\2\2\u0116\u0118\t\2\2\2\u0117\u0116\3\2\2\2\u0118\u0119\3"+
		"\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011aZ\3\2\2\2\u011b\u011d"+
		"\7$\2\2\u011c\u011e\t\3\2\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0124\3\2\2\2\u0121\u0123\t\4"+
		"\2\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128\7$"+
		"\2\2\u0128\\\3\2\2\2\u0129\u012b\t\5\2\2\u012a\u0129\3\2\2\2\u012b\u012c"+
		"\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d^\3\2\2\2\u012e"+
		"\u0130\t\6\2\2\u012f\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\b\60\2\2\u0134"+
		"`\3\2\2\2\b\2\u0119\u011f\u0124\u012c\u0131\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}