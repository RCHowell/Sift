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
		PIPE=1, MAPS=2, LP=3, RP=4, COMMA=5, SQUOTE=6, EQ=7, GT=8, LT=9, GTE=10, 
		LTE=11, AND=12, OR=13, MIN=14, MAX=15, SUM=16, AVG=17, COUNT=18, SELECT=19, 
		PROJECT=20, GROUP=21, SORT=22, LIMIT=23, DISTINCT=24, ON=25, AS=26, BY=27, 
		OUTER=28, LEFT=29, RIGHT=30, ASC=31, DESC=32, TRUE=33, FALSE=34, JOIN=35, 
		CROSS=36, UNION=37, DIFF=38, INTERSECT=39, ID=40, STRING=41, INT=42, WS=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PIPE", "MAPS", "LP", "RP", "COMMA", "SQUOTE", "EQ", "GT", "LT", "GTE", 
			"LTE", "AND", "OR", "MIN", "MAX", "SUM", "AVG", "COUNT", "SELECT", "PROJECT", 
			"GROUP", "SORT", "LIMIT", "DISTINCT", "ON", "AS", "BY", "OUTER", "LEFT", 
			"RIGHT", "ASC", "DESC", "TRUE", "FALSE", "JOIN", "CROSS", "UNION", "DIFF", 
			"INTERSECT", "ID", "STRING", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|>'", "'->'", "'('", "')'", "','", "'''", "'='", "'>'", "'<'", 
			"'>='", "'<='", "'&&'", "'||'", "'MIN'", "'MAX'", "'SUM'", "'AVG'", "'COUNT'", 
			"'SELECT'", "'PROJECT'", "'GROUP'", "'SORT'", "'LIMIT'", "'DISTINCT'", 
			"'ON'", "'AS'", "'BY'", "'OUTER'", "'LEFT'", "'RIGHT'", "'ASC'", "'DESC'", 
			"'TRUE'", "'FALSE'", "'JOIN'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PIPE", "MAPS", "LP", "RP", "COMMA", "SQUOTE", "EQ", "GT", "LT", 
			"GTE", "LTE", "AND", "OR", "MIN", "MAX", "SUM", "AVG", "COUNT", "SELECT", 
			"PROJECT", "GROUP", "SORT", "LIMIT", "DISTINCT", "ON", "AS", "BY", "OUTER", 
			"LEFT", "RIGHT", "ASC", "DESC", "TRUE", "FALSE", "JOIN", "CROSS", "UNION", 
			"DIFF", "INTERSECT", "ID", "STRING", "INT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u012d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\5%\u00f2\n%\3&\3&"+
		"\3&\3&\3&\3&\5&\u00fa\n&\3\'\3\'\3\'\3\'\3\'\5\'\u0101\n\'\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\5(\u010d\n(\3)\6)\u0110\n)\r)\16)\u0111\3*\3*\6*\u0116"+
		"\n*\r*\16*\u0117\3*\7*\u011b\n*\f*\16*\u011e\13*\3*\3*\3+\6+\u0123\n+"+
		"\r+\16+\u0124\3,\6,\u0128\n,\r,\16,\u0129\3,\3,\2\2-\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-\3\2\7\6\2//C\\aac|\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f"+
		"\17\17\"\"\2\u0135\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5\\\3\2\2\2\7_\3\2\2"+
		"\2\ta\3\2\2\2\13c\3\2\2\2\re\3\2\2\2\17g\3\2\2\2\21i\3\2\2\2\23k\3\2\2"+
		"\2\25m\3\2\2\2\27p\3\2\2\2\31s\3\2\2\2\33v\3\2\2\2\35y\3\2\2\2\37}\3\2"+
		"\2\2!\u0081\3\2\2\2#\u0085\3\2\2\2%\u0089\3\2\2\2\'\u008f\3\2\2\2)\u0096"+
		"\3\2\2\2+\u009e\3\2\2\2-\u00a4\3\2\2\2/\u00a9\3\2\2\2\61\u00af\3\2\2\2"+
		"\63\u00b8\3\2\2\2\65\u00bb\3\2\2\2\67\u00be\3\2\2\29\u00c1\3\2\2\2;\u00c7"+
		"\3\2\2\2=\u00cc\3\2\2\2?\u00d2\3\2\2\2A\u00d6\3\2\2\2C\u00db\3\2\2\2E"+
		"\u00e0\3\2\2\2G\u00e6\3\2\2\2I\u00f1\3\2\2\2K\u00f9\3\2\2\2M\u0100\3\2"+
		"\2\2O\u010c\3\2\2\2Q\u010f\3\2\2\2S\u0113\3\2\2\2U\u0122\3\2\2\2W\u0127"+
		"\3\2\2\2YZ\7~\2\2Z[\7@\2\2[\4\3\2\2\2\\]\7/\2\2]^\7@\2\2^\6\3\2\2\2_`"+
		"\7*\2\2`\b\3\2\2\2ab\7+\2\2b\n\3\2\2\2cd\7.\2\2d\f\3\2\2\2ef\7)\2\2f\16"+
		"\3\2\2\2gh\7?\2\2h\20\3\2\2\2ij\7@\2\2j\22\3\2\2\2kl\7>\2\2l\24\3\2\2"+
		"\2mn\7@\2\2no\7?\2\2o\26\3\2\2\2pq\7>\2\2qr\7?\2\2r\30\3\2\2\2st\7(\2"+
		"\2tu\7(\2\2u\32\3\2\2\2vw\7~\2\2wx\7~\2\2x\34\3\2\2\2yz\7O\2\2z{\7K\2"+
		"\2{|\7P\2\2|\36\3\2\2\2}~\7O\2\2~\177\7C\2\2\177\u0080\7Z\2\2\u0080 \3"+
		"\2\2\2\u0081\u0082\7U\2\2\u0082\u0083\7W\2\2\u0083\u0084\7O\2\2\u0084"+
		"\"\3\2\2\2\u0085\u0086\7C\2\2\u0086\u0087\7X\2\2\u0087\u0088\7I\2\2\u0088"+
		"$\3\2\2\2\u0089\u008a\7E\2\2\u008a\u008b\7Q\2\2\u008b\u008c\7W\2\2\u008c"+
		"\u008d\7P\2\2\u008d\u008e\7V\2\2\u008e&\3\2\2\2\u008f\u0090\7U\2\2\u0090"+
		"\u0091\7G\2\2\u0091\u0092\7N\2\2\u0092\u0093\7G\2\2\u0093\u0094\7E\2\2"+
		"\u0094\u0095\7V\2\2\u0095(\3\2\2\2\u0096\u0097\7R\2\2\u0097\u0098\7T\2"+
		"\2\u0098\u0099\7Q\2\2\u0099\u009a\7L\2\2\u009a\u009b\7G\2\2\u009b\u009c"+
		"\7E\2\2\u009c\u009d\7V\2\2\u009d*\3\2\2\2\u009e\u009f\7I\2\2\u009f\u00a0"+
		"\7T\2\2\u00a0\u00a1\7Q\2\2\u00a1\u00a2\7W\2\2\u00a2\u00a3\7R\2\2\u00a3"+
		",\3\2\2\2\u00a4\u00a5\7U\2\2\u00a5\u00a6\7Q\2\2\u00a6\u00a7\7T\2\2\u00a7"+
		"\u00a8\7V\2\2\u00a8.\3\2\2\2\u00a9\u00aa\7N\2\2\u00aa\u00ab\7K\2\2\u00ab"+
		"\u00ac\7O\2\2\u00ac\u00ad\7K\2\2\u00ad\u00ae\7V\2\2\u00ae\60\3\2\2\2\u00af"+
		"\u00b0\7F\2\2\u00b0\u00b1\7K\2\2\u00b1\u00b2\7U\2\2\u00b2\u00b3\7V\2\2"+
		"\u00b3\u00b4\7K\2\2\u00b4\u00b5\7P\2\2\u00b5\u00b6\7E\2\2\u00b6\u00b7"+
		"\7V\2\2\u00b7\62\3\2\2\2\u00b8\u00b9\7Q\2\2\u00b9\u00ba\7P\2\2\u00ba\64"+
		"\3\2\2\2\u00bb\u00bc\7C\2\2\u00bc\u00bd\7U\2\2\u00bd\66\3\2\2\2\u00be"+
		"\u00bf\7D\2\2\u00bf\u00c0\7[\2\2\u00c08\3\2\2\2\u00c1\u00c2\7Q\2\2\u00c2"+
		"\u00c3\7W\2\2\u00c3\u00c4\7V\2\2\u00c4\u00c5\7G\2\2\u00c5\u00c6\7T\2\2"+
		"\u00c6:\3\2\2\2\u00c7\u00c8\7N\2\2\u00c8\u00c9\7G\2\2\u00c9\u00ca\7H\2"+
		"\2\u00ca\u00cb\7V\2\2\u00cb<\3\2\2\2\u00cc\u00cd\7T\2\2\u00cd\u00ce\7"+
		"K\2\2\u00ce\u00cf\7I\2\2\u00cf\u00d0\7J\2\2\u00d0\u00d1\7V\2\2\u00d1>"+
		"\3\2\2\2\u00d2\u00d3\7C\2\2\u00d3\u00d4\7U\2\2\u00d4\u00d5\7E\2\2\u00d5"+
		"@\3\2\2\2\u00d6\u00d7\7F\2\2\u00d7\u00d8\7G\2\2\u00d8\u00d9\7U\2\2\u00d9"+
		"\u00da\7E\2\2\u00daB\3\2\2\2\u00db\u00dc\7V\2\2\u00dc\u00dd\7T\2\2\u00dd"+
		"\u00de\7W\2\2\u00de\u00df\7G\2\2\u00dfD\3\2\2\2\u00e0\u00e1\7H\2\2\u00e1"+
		"\u00e2\7C\2\2\u00e2\u00e3\7N\2\2\u00e3\u00e4\7U\2\2\u00e4\u00e5\7G\2\2"+
		"\u00e5F\3\2\2\2\u00e6\u00e7\7L\2\2\u00e7\u00e8\7Q\2\2\u00e8\u00e9\7K\2"+
		"\2\u00e9\u00ea\7P\2\2\u00eaH\3\2\2\2\u00eb\u00f2\7Z\2\2\u00ec\u00ed\7"+
		"E\2\2\u00ed\u00ee\7T\2\2\u00ee\u00ef\7Q\2\2\u00ef\u00f0\7U\2\2\u00f0\u00f2"+
		"\7U\2\2\u00f1\u00eb\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f2J\3\2\2\2\u00f3\u00fa"+
		"\7W\2\2\u00f4\u00f5\7W\2\2\u00f5\u00f6\7P\2\2\u00f6\u00f7\7K\2\2\u00f7"+
		"\u00f8\7Q\2\2\u00f8\u00fa\7P\2\2\u00f9\u00f3\3\2\2\2\u00f9\u00f4\3\2\2"+
		"\2\u00faL\3\2\2\2\u00fb\u0101\7/\2\2\u00fc\u00fd\7F\2\2\u00fd\u00fe\7"+
		"K\2\2\u00fe\u00ff\7H\2\2\u00ff\u0101\7H\2\2\u0100\u00fb\3\2\2\2\u0100"+
		"\u00fc\3\2\2\2\u0101N\3\2\2\2\u0102\u010d\7(\2\2\u0103\u0104\7K\2\2\u0104"+
		"\u0105\7P\2\2\u0105\u0106\7V\2\2\u0106\u0107\7G\2\2\u0107\u0108\7T\2\2"+
		"\u0108\u0109\7U\2\2\u0109\u010a\7G\2\2\u010a\u010b\7E\2\2\u010b\u010d"+
		"\7V\2\2\u010c\u0102\3\2\2\2\u010c\u0103\3\2\2\2\u010dP\3\2\2\2\u010e\u0110"+
		"\t\2\2\2\u010f\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112R\3\2\2\2\u0113\u0115\7$\2\2\u0114\u0116\t\3\2\2\u0115"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u011c\3\2\2\2\u0119\u011b\t\4\2\2\u011a\u0119\3\2\2\2\u011b"+
		"\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011f\3\2"+
		"\2\2\u011e\u011c\3\2\2\2\u011f\u0120\7$\2\2\u0120T\3\2\2\2\u0121\u0123"+
		"\t\5\2\2\u0122\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125V\3\2\2\2\u0126\u0128\t\6\2\2\u0127\u0126\3\2\2\2"+
		"\u0128\u0129\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b"+
		"\3\2\2\2\u012b\u012c\b,\2\2\u012cX\3\2\2\2\f\2\u00f1\u00f9\u0100\u010c"+
		"\u0111\u0117\u011c\u0124\u0129\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}