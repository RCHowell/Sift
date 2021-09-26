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
		EQ=11, GT=12, LT=13, GTE=14, LTE=15, SELECT=16, PROJECT=17, GROUP=18, 
		SORT=19, LIMIT=20, DISTINCT=21, ON=22, AS=23, BY=24, OUTER=25, LEFT=26, 
		RIGHT=27, ASC=28, DESC=29, TRUE=30, FALSE=31, AND=32, OR=33, JOIN=34, 
		CROSS=35, UNION=36, DIFF=37, INTERSECT=38, ID=39, STRING=40, INT=41, WS=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "PIPE", "MAPS", "LP", "RP", "COMMA", 
			"SQUOTE", "EQ", "GT", "LT", "GTE", "LTE", "SELECT", "PROJECT", "GROUP", 
			"SORT", "LIMIT", "DISTINCT", "ON", "AS", "BY", "OUTER", "LEFT", "RIGHT", 
			"ASC", "DESC", "TRUE", "FALSE", "AND", "OR", "JOIN", "CROSS", "UNION", 
			"DIFF", "INTERSECT", "ID", "STRING", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'X'", "'U'", "'-'", "'&'", "'|>'", "'->'", "'('", "')'", "','", 
			"'''", "'='", "'>'", "'<'", "'>='", "'<='", "'SELECT'", "'PROJECT'", 
			"'GROUP'", "'SORT'", "'LIMIT'", "'DISTINCT'", "'ON'", "'AS'", "'BY'", 
			"'OUTER'", "'LEFT'", "'RIGHT'", "'ASC'", "'DESC'", "'TRUE'", "'FALSE'", 
			"'AND'", "'OR'", "'JOIN'", "'CROSS'", "'UNION'", "'DIFF'", "'INTERSECT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "PIPE", "MAPS", "LP", "RP", "COMMA", "SQUOTE", 
			"EQ", "GT", "LT", "GTE", "LTE", "SELECT", "PROJECT", "GROUP", "SORT", 
			"LIMIT", "DISTINCT", "ON", "AS", "BY", "OUTER", "LEFT", "RIGHT", "ASC", 
			"DESC", "TRUE", "FALSE", "AND", "OR", "JOIN", "CROSS", "UNION", "DIFF", 
			"INTERSECT", "ID", "STRING", "INT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0116\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%"+
		"\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3(\6(\u00f9\n(\r(\16(\u00fa\3)\3)\6)\u00ff\n)\r)\16)\u0100\3)\7)\u0104"+
		"\n)\f)\16)\u0107\13)\3)\3)\3*\6*\u010c\n*\r*\16*\u010d\3+\6+\u0111\n+"+
		"\r+\16+\u0112\3+\3+\2\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,\3\2\6\4\2C\\c|\5\2"+
		"\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u011a\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5Y\3"+
		"\2\2\2\7[\3\2\2\2\t]\3\2\2\2\13_\3\2\2\2\rb\3\2\2\2\17e\3\2\2\2\21g\3"+
		"\2\2\2\23i\3\2\2\2\25k\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2\35"+
		"s\3\2\2\2\37v\3\2\2\2!y\3\2\2\2#\u0080\3\2\2\2%\u0088\3\2\2\2\'\u008e"+
		"\3\2\2\2)\u0093\3\2\2\2+\u0099\3\2\2\2-\u00a2\3\2\2\2/\u00a5\3\2\2\2\61"+
		"\u00a8\3\2\2\2\63\u00ab\3\2\2\2\65\u00b1\3\2\2\2\67\u00b6\3\2\2\29\u00bc"+
		"\3\2\2\2;\u00c0\3\2\2\2=\u00c5\3\2\2\2?\u00ca\3\2\2\2A\u00d0\3\2\2\2C"+
		"\u00d4\3\2\2\2E\u00d7\3\2\2\2G\u00dc\3\2\2\2I\u00e2\3\2\2\2K\u00e8\3\2"+
		"\2\2M\u00ed\3\2\2\2O\u00f8\3\2\2\2Q\u00fc\3\2\2\2S\u010b\3\2\2\2U\u0110"+
		"\3\2\2\2WX\7Z\2\2X\4\3\2\2\2YZ\7W\2\2Z\6\3\2\2\2[\\\7/\2\2\\\b\3\2\2\2"+
		"]^\7(\2\2^\n\3\2\2\2_`\7~\2\2`a\7@\2\2a\f\3\2\2\2bc\7/\2\2cd\7@\2\2d\16"+
		"\3\2\2\2ef\7*\2\2f\20\3\2\2\2gh\7+\2\2h\22\3\2\2\2ij\7.\2\2j\24\3\2\2"+
		"\2kl\7)\2\2l\26\3\2\2\2mn\7?\2\2n\30\3\2\2\2op\7@\2\2p\32\3\2\2\2qr\7"+
		">\2\2r\34\3\2\2\2st\7@\2\2tu\7?\2\2u\36\3\2\2\2vw\7>\2\2wx\7?\2\2x \3"+
		"\2\2\2yz\7U\2\2z{\7G\2\2{|\7N\2\2|}\7G\2\2}~\7E\2\2~\177\7V\2\2\177\""+
		"\3\2\2\2\u0080\u0081\7R\2\2\u0081\u0082\7T\2\2\u0082\u0083\7Q\2\2\u0083"+
		"\u0084\7L\2\2\u0084\u0085\7G\2\2\u0085\u0086\7E\2\2\u0086\u0087\7V\2\2"+
		"\u0087$\3\2\2\2\u0088\u0089\7I\2\2\u0089\u008a\7T\2\2\u008a\u008b\7Q\2"+
		"\2\u008b\u008c\7W\2\2\u008c\u008d\7R\2\2\u008d&\3\2\2\2\u008e\u008f\7"+
		"U\2\2\u008f\u0090\7Q\2\2\u0090\u0091\7T\2\2\u0091\u0092\7V\2\2\u0092("+
		"\3\2\2\2\u0093\u0094\7N\2\2\u0094\u0095\7K\2\2\u0095\u0096\7O\2\2\u0096"+
		"\u0097\7K\2\2\u0097\u0098\7V\2\2\u0098*\3\2\2\2\u0099\u009a\7F\2\2\u009a"+
		"\u009b\7K\2\2\u009b\u009c\7U\2\2\u009c\u009d\7V\2\2\u009d\u009e\7K\2\2"+
		"\u009e\u009f\7P\2\2\u009f\u00a0\7E\2\2\u00a0\u00a1\7V\2\2\u00a1,\3\2\2"+
		"\2\u00a2\u00a3\7Q\2\2\u00a3\u00a4\7P\2\2\u00a4.\3\2\2\2\u00a5\u00a6\7"+
		"C\2\2\u00a6\u00a7\7U\2\2\u00a7\60\3\2\2\2\u00a8\u00a9\7D\2\2\u00a9\u00aa"+
		"\7[\2\2\u00aa\62\3\2\2\2\u00ab\u00ac\7Q\2\2\u00ac\u00ad\7W\2\2\u00ad\u00ae"+
		"\7V\2\2\u00ae\u00af\7G\2\2\u00af\u00b0\7T\2\2\u00b0\64\3\2\2\2\u00b1\u00b2"+
		"\7N\2\2\u00b2\u00b3\7G\2\2\u00b3\u00b4\7H\2\2\u00b4\u00b5\7V\2\2\u00b5"+
		"\66\3\2\2\2\u00b6\u00b7\7T\2\2\u00b7\u00b8\7K\2\2\u00b8\u00b9\7I\2\2\u00b9"+
		"\u00ba\7J\2\2\u00ba\u00bb\7V\2\2\u00bb8\3\2\2\2\u00bc\u00bd\7C\2\2\u00bd"+
		"\u00be\7U\2\2\u00be\u00bf\7E\2\2\u00bf:\3\2\2\2\u00c0\u00c1\7F\2\2\u00c1"+
		"\u00c2\7G\2\2\u00c2\u00c3\7U\2\2\u00c3\u00c4\7E\2\2\u00c4<\3\2\2\2\u00c5"+
		"\u00c6\7V\2\2\u00c6\u00c7\7T\2\2\u00c7\u00c8\7W\2\2\u00c8\u00c9\7G\2\2"+
		"\u00c9>\3\2\2\2\u00ca\u00cb\7H\2\2\u00cb\u00cc\7C\2\2\u00cc\u00cd\7N\2"+
		"\2\u00cd\u00ce\7U\2\2\u00ce\u00cf\7G\2\2\u00cf@\3\2\2\2\u00d0\u00d1\7"+
		"C\2\2\u00d1\u00d2\7P\2\2\u00d2\u00d3\7F\2\2\u00d3B\3\2\2\2\u00d4\u00d5"+
		"\7Q\2\2\u00d5\u00d6\7T\2\2\u00d6D\3\2\2\2\u00d7\u00d8\7L\2\2\u00d8\u00d9"+
		"\7Q\2\2\u00d9\u00da\7K\2\2\u00da\u00db\7P\2\2\u00dbF\3\2\2\2\u00dc\u00dd"+
		"\7E\2\2\u00dd\u00de\7T\2\2\u00de\u00df\7Q\2\2\u00df\u00e0\7U\2\2\u00e0"+
		"\u00e1\7U\2\2\u00e1H\3\2\2\2\u00e2\u00e3\7W\2\2\u00e3\u00e4\7P\2\2\u00e4"+
		"\u00e5\7K\2\2\u00e5\u00e6\7Q\2\2\u00e6\u00e7\7P\2\2\u00e7J\3\2\2\2\u00e8"+
		"\u00e9\7F\2\2\u00e9\u00ea\7K\2\2\u00ea\u00eb\7H\2\2\u00eb\u00ec\7H\2\2"+
		"\u00ecL\3\2\2\2\u00ed\u00ee\7K\2\2\u00ee\u00ef\7P\2\2\u00ef\u00f0\7V\2"+
		"\2\u00f0\u00f1\7G\2\2\u00f1\u00f2\7T\2\2\u00f2\u00f3\7U\2\2\u00f3\u00f4"+
		"\7G\2\2\u00f4\u00f5\7E\2\2\u00f5\u00f6\7V\2\2\u00f6N\3\2\2\2\u00f7\u00f9"+
		"\t\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fbP\3\2\2\2\u00fc\u00fe\7$\2\2\u00fd\u00ff\t\2\2\2\u00fe"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\u0105\3\2\2\2\u0102\u0104\t\3\2\2\u0103\u0102\3\2\2\2\u0104"+
		"\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2"+
		"\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7$\2\2\u0109R\3\2\2\2\u010a\u010c"+
		"\t\4\2\2\u010b\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010eT\3\2\2\2\u010f\u0111\t\5\2\2\u0110\u010f\3\2\2\2"+
		"\u0111\u0112\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114"+
		"\3\2\2\2\u0114\u0115\b+\2\2\u0115V\3\2\2\2\b\2\u00fa\u0100\u0105\u010d"+
		"\u0112\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}