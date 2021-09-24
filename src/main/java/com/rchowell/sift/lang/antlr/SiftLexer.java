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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PIPE=8, MAPS=9, 
		LP=10, RP=11, COMMA=12, SQUOTE=13, SELECT=14, PROJECT=15, GROUP=16, SORT=17, 
		LIMIT=18, DISTINCT=19, ON=20, AS=21, BY=22, OUTER=23, LEFT=24, RIGHT=25, 
		ASC=26, DESC=27, TRUE=28, FALSE=29, AND=30, OR=31, JOIN=32, CROSS=33, 
		UNION=34, DIFF=35, INTERSECT=36, ID=37, WORD=38, INT=39, WS=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "PIPE", "MAPS", 
			"LP", "RP", "COMMA", "SQUOTE", "SELECT", "PROJECT", "GROUP", "SORT", 
			"LIMIT", "DISTINCT", "ON", "AS", "BY", "OUTER", "LEFT", "RIGHT", "ASC", 
			"DESC", "TRUE", "FALSE", "AND", "OR", "JOIN", "CROSS", "UNION", "DIFF", 
			"INTERSECT", "ID", "WORD", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'X'", "'U'", "'-'", "'&'", "'*'", "'/'", "'+'", "'|>'", "'->'", 
			"'('", "')'", "','", "'''", "'SELECT'", "'PROJECT'", "'GROUP'", "'SORT'", 
			"'LIMIT'", "'DISTINCT'", "'ON'", "'AS'", "'BY'", "'OUTER'", "'LEFT'", 
			"'RIGHT'", "'ASC'", "'DESC'", "'TRUE'", "'FALSE'", "'AND'", "'OR'", "'JOIN'", 
			"'CROSS'", "'UNION'", "'DIFF'", "'INTERSECT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "PIPE", "MAPS", "LP", 
			"RP", "COMMA", "SQUOTE", "SELECT", "PROJECT", "GROUP", "SORT", "LIMIT", 
			"DISTINCT", "ON", "AS", "BY", "OUTER", "LEFT", "RIGHT", "ASC", "DESC", 
			"TRUE", "FALSE", "AND", "OR", "JOIN", "CROSS", "UNION", "DIFF", "INTERSECT", 
			"ID", "WORD", "INT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0108\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\6&\u00ef\n&\r&\16&\u00f0\3\'"+
		"\6\'\u00f4\n\'\r\'\16\'\u00f5\3\'\6\'\u00f9\n\'\r\'\16\'\u00fa\3(\6(\u00fe"+
		"\n(\r(\16(\u00ff\3)\6)\u0103\n)\r)\16)\u0104\3)\3)\2\2*\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*\3\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2"+
		"\u010c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3"+
		"\2\2\2\5U\3\2\2\2\7W\3\2\2\2\tY\3\2\2\2\13[\3\2\2\2\r]\3\2\2\2\17_\3\2"+
		"\2\2\21a\3\2\2\2\23d\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33m\3"+
		"\2\2\2\35o\3\2\2\2\37v\3\2\2\2!~\3\2\2\2#\u0084\3\2\2\2%\u0089\3\2\2\2"+
		"\'\u008f\3\2\2\2)\u0098\3\2\2\2+\u009b\3\2\2\2-\u009e\3\2\2\2/\u00a1\3"+
		"\2\2\2\61\u00a7\3\2\2\2\63\u00ac\3\2\2\2\65\u00b2\3\2\2\2\67\u00b6\3\2"+
		"\2\29\u00bb\3\2\2\2;\u00c0\3\2\2\2=\u00c6\3\2\2\2?\u00ca\3\2\2\2A\u00cd"+
		"\3\2\2\2C\u00d2\3\2\2\2E\u00d8\3\2\2\2G\u00de\3\2\2\2I\u00e3\3\2\2\2K"+
		"\u00ee\3\2\2\2M\u00f3\3\2\2\2O\u00fd\3\2\2\2Q\u0102\3\2\2\2ST\7Z\2\2T"+
		"\4\3\2\2\2UV\7W\2\2V\6\3\2\2\2WX\7/\2\2X\b\3\2\2\2YZ\7(\2\2Z\n\3\2\2\2"+
		"[\\\7,\2\2\\\f\3\2\2\2]^\7\61\2\2^\16\3\2\2\2_`\7-\2\2`\20\3\2\2\2ab\7"+
		"~\2\2bc\7@\2\2c\22\3\2\2\2de\7/\2\2ef\7@\2\2f\24\3\2\2\2gh\7*\2\2h\26"+
		"\3\2\2\2ij\7+\2\2j\30\3\2\2\2kl\7.\2\2l\32\3\2\2\2mn\7)\2\2n\34\3\2\2"+
		"\2op\7U\2\2pq\7G\2\2qr\7N\2\2rs\7G\2\2st\7E\2\2tu\7V\2\2u\36\3\2\2\2v"+
		"w\7R\2\2wx\7T\2\2xy\7Q\2\2yz\7L\2\2z{\7G\2\2{|\7E\2\2|}\7V\2\2} \3\2\2"+
		"\2~\177\7I\2\2\177\u0080\7T\2\2\u0080\u0081\7Q\2\2\u0081\u0082\7W\2\2"+
		"\u0082\u0083\7R\2\2\u0083\"\3\2\2\2\u0084\u0085\7U\2\2\u0085\u0086\7Q"+
		"\2\2\u0086\u0087\7T\2\2\u0087\u0088\7V\2\2\u0088$\3\2\2\2\u0089\u008a"+
		"\7N\2\2\u008a\u008b\7K\2\2\u008b\u008c\7O\2\2\u008c\u008d\7K\2\2\u008d"+
		"\u008e\7V\2\2\u008e&\3\2\2\2\u008f\u0090\7F\2\2\u0090\u0091\7K\2\2\u0091"+
		"\u0092\7U\2\2\u0092\u0093\7V\2\2\u0093\u0094\7K\2\2\u0094\u0095\7P\2\2"+
		"\u0095\u0096\7E\2\2\u0096\u0097\7V\2\2\u0097(\3\2\2\2\u0098\u0099\7Q\2"+
		"\2\u0099\u009a\7P\2\2\u009a*\3\2\2\2\u009b\u009c\7C\2\2\u009c\u009d\7"+
		"U\2\2\u009d,\3\2\2\2\u009e\u009f\7D\2\2\u009f\u00a0\7[\2\2\u00a0.\3\2"+
		"\2\2\u00a1\u00a2\7Q\2\2\u00a2\u00a3\7W\2\2\u00a3\u00a4\7V\2\2\u00a4\u00a5"+
		"\7G\2\2\u00a5\u00a6\7T\2\2\u00a6\60\3\2\2\2\u00a7\u00a8\7N\2\2\u00a8\u00a9"+
		"\7G\2\2\u00a9\u00aa\7H\2\2\u00aa\u00ab\7V\2\2\u00ab\62\3\2\2\2\u00ac\u00ad"+
		"\7T\2\2\u00ad\u00ae\7K\2\2\u00ae\u00af\7I\2\2\u00af\u00b0\7J\2\2\u00b0"+
		"\u00b1\7V\2\2\u00b1\64\3\2\2\2\u00b2\u00b3\7C\2\2\u00b3\u00b4\7U\2\2\u00b4"+
		"\u00b5\7E\2\2\u00b5\66\3\2\2\2\u00b6\u00b7\7F\2\2\u00b7\u00b8\7G\2\2\u00b8"+
		"\u00b9\7U\2\2\u00b9\u00ba\7E\2\2\u00ba8\3\2\2\2\u00bb\u00bc\7V\2\2\u00bc"+
		"\u00bd\7T\2\2\u00bd\u00be\7W\2\2\u00be\u00bf\7G\2\2\u00bf:\3\2\2\2\u00c0"+
		"\u00c1\7H\2\2\u00c1\u00c2\7C\2\2\u00c2\u00c3\7N\2\2\u00c3\u00c4\7U\2\2"+
		"\u00c4\u00c5\7G\2\2\u00c5<\3\2\2\2\u00c6\u00c7\7C\2\2\u00c7\u00c8\7P\2"+
		"\2\u00c8\u00c9\7F\2\2\u00c9>\3\2\2\2\u00ca\u00cb\7Q\2\2\u00cb\u00cc\7"+
		"T\2\2\u00cc@\3\2\2\2\u00cd\u00ce\7L\2\2\u00ce\u00cf\7Q\2\2\u00cf\u00d0"+
		"\7K\2\2\u00d0\u00d1\7P\2\2\u00d1B\3\2\2\2\u00d2\u00d3\7E\2\2\u00d3\u00d4"+
		"\7T\2\2\u00d4\u00d5\7Q\2\2\u00d5\u00d6\7U\2\2\u00d6\u00d7\7U\2\2\u00d7"+
		"D\3\2\2\2\u00d8\u00d9\7W\2\2\u00d9\u00da\7P\2\2\u00da\u00db\7K\2\2\u00db"+
		"\u00dc\7Q\2\2\u00dc\u00dd\7P\2\2\u00ddF\3\2\2\2\u00de\u00df\7F\2\2\u00df"+
		"\u00e0\7K\2\2\u00e0\u00e1\7H\2\2\u00e1\u00e2\7H\2\2\u00e2H\3\2\2\2\u00e3"+
		"\u00e4\7K\2\2\u00e4\u00e5\7P\2\2\u00e5\u00e6\7V\2\2\u00e6\u00e7\7G\2\2"+
		"\u00e7\u00e8\7T\2\2\u00e8\u00e9\7U\2\2\u00e9\u00ea\7G\2\2\u00ea\u00eb"+
		"\7E\2\2\u00eb\u00ec\7V\2\2\u00ecJ\3\2\2\2\u00ed\u00ef\t\2\2\2\u00ee\u00ed"+
		"\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"L\3\2\2\2\u00f2\u00f4\t\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2"+
		"\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f9"+
		"\t\3\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fbN\3\2\2\2\u00fc\u00fe\t\4\2\2\u00fd\u00fc\3\2\2\2"+
		"\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100P\3"+
		"\2\2\2\u0101\u0103\t\5\2\2\u0102\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\b)"+
		"\2\2\u0107R\3\2\2\2\b\2\u00f0\u00f5\u00fa\u00ff\u0104\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}