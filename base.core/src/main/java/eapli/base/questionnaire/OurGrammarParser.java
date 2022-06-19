// Generated from D:/eapli/lei21_22_s4_2dj_4/base.core/src/main/java/eapli/base/questionnaire\OurGrammar.g4 by ANTLR 4.10.1
package eapli.base.questionnaire;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OurGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, SECTION=5, TYPES=6, NEWLINE=7, INT=8, 
		SPACE=9, STRING=10, QMARK=11, LPARENTH=12, RPARENTH=13, LSQRPARENTH=14, 
		RSQRPARENTH=15, OPTIONAL=16, OBLIGATORY=17;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_beginning = 2, RULE_title = 3, RULE_welcome_message = 4, 
		RULE_questionnaire = 5, RULE_questionnaire_section = 6, RULE_content = 7, 
		RULE_description = 8, RULE_final_message = 9, RULE_questions = 10, RULE_type = 11, 
		RULE_possible_answers = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "beginning", "title", "welcome_message", "questionnaire", 
			"questionnaire_section", "content", "description", "final_message", "questions", 
			"type", "possible_answers"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'[Multiple Choice]'", "'[Numeric]'", "'[Free Text]'", "'|'", null, 
			null, null, null, "' '", null, null, "'('", "')'", "'['", "']'", "'(optional)'", 
			"'(obligatory)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "SECTION", "TYPES", "NEWLINE", "INT", "SPACE", 
			"STRING", "QMARK", "LPARENTH", "RPARENTH", "LSQRPARENTH", "RSQRPARENTH", 
			"OPTIONAL", "OBLIGATORY"
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
	public String getGrammarFileName() { return "OurGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OurGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			stat();
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

	public static class StatContext extends ParserRuleContext {
		public BeginningContext beginning() {
			return getRuleContext(BeginningContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(OurGrammarParser.NEWLINE, 0); }
		public QuestionnaireContext questionnaire() {
			return getRuleContext(QuestionnaireContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			beginning();
			setState(29);
			match(NEWLINE);
			setState(30);
			questionnaire();
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

	public static class BeginningContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(OurGrammarParser.NEWLINE, 0); }
		public Welcome_messageContext welcome_message() {
			return getRuleContext(Welcome_messageContext.class,0);
		}
		public BeginningContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beginning; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterBeginning(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitBeginning(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitBeginning(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeginningContext beginning() throws RecognitionException {
		BeginningContext _localctx = new BeginningContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_beginning);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			title();
			setState(33);
			match(NEWLINE);
			setState(34);
			welcome_message();
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

	public static class TitleContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(OurGrammarParser.STRING, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(STRING);
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

	public static class Welcome_messageContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(OurGrammarParser.STRING, 0); }
		public Welcome_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_welcome_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterWelcome_message(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitWelcome_message(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitWelcome_message(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Welcome_messageContext welcome_message() throws RecognitionException {
		Welcome_messageContext _localctx = new Welcome_messageContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_welcome_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(STRING);
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

	public static class QuestionnaireContext extends ParserRuleContext {
		public Final_messageContext final_message() {
			return getRuleContext(Final_messageContext.class,0);
		}
		public List<Questionnaire_sectionContext> questionnaire_section() {
			return getRuleContexts(Questionnaire_sectionContext.class);
		}
		public Questionnaire_sectionContext questionnaire_section(int i) {
			return getRuleContext(Questionnaire_sectionContext.class,i);
		}
		public QuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitQuestionnaire(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitQuestionnaire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionnaireContext questionnaire() throws RecognitionException {
		QuestionnaireContext _localctx = new QuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_questionnaire);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				questionnaire_section();
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SECTION );
			setState(45);
			final_message();
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

	public static class Questionnaire_sectionContext extends ParserRuleContext {
		public TerminalNode SECTION() { return getToken(OurGrammarParser.SECTION, 0); }
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(OurGrammarParser.NEWLINE, 0); }
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public Questionnaire_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterQuestionnaire_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitQuestionnaire_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitQuestionnaire_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Questionnaire_sectionContext questionnaire_section() throws RecognitionException {
		Questionnaire_sectionContext _localctx = new Questionnaire_sectionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_questionnaire_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(SECTION);
			setState(48);
			title();
			setState(49);
			description();
			setState(50);
			match(NEWLINE);
			setState(51);
			content();
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

	public static class ContentContext extends ParserRuleContext {
		public List<QuestionsContext> questions() {
			return getRuleContexts(QuestionsContext.class);
		}
		public QuestionsContext questions(int i) {
			return getRuleContext(QuestionsContext.class,i);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_content);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(53);
					questions();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(56); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode LPARENTH() { return getToken(OurGrammarParser.LPARENTH, 0); }
		public TerminalNode STRING() { return getToken(OurGrammarParser.STRING, 0); }
		public TerminalNode RPARENTH() { return getToken(OurGrammarParser.RPARENTH, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(LPARENTH);
			setState(59);
			match(STRING);
			setState(60);
			match(RPARENTH);
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

	public static class Final_messageContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(OurGrammarParser.STRING, 0); }
		public Final_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_final_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterFinal_message(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitFinal_message(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitFinal_message(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Final_messageContext final_message() throws RecognitionException {
		Final_messageContext _localctx = new Final_messageContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_final_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(STRING);
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

	public static class QuestionsContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(OurGrammarParser.STRING, 0); }
		public TerminalNode QMARK() { return getToken(OurGrammarParser.QMARK, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public QuestionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterQuestions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitQuestions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitQuestions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionsContext questions() throws RecognitionException {
		QuestionsContext _localctx = new QuestionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_questions);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(STRING);
				setState(65);
				match(QMARK);
				setState(66);
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(STRING);
				setState(68);
				match(QMARK);
				setState(69);
				type();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode OPTIONAL() { return getToken(OurGrammarParser.OPTIONAL, 0); }
		public Possible_answersContext possible_answers() {
			return getRuleContext(Possible_answersContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(OurGrammarParser.NEWLINE, 0); }
		public TerminalNode OBLIGATORY() { return getToken(OurGrammarParser.OBLIGATORY, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(OPTIONAL);
				setState(73);
				match(T__0);
				setState(74);
				possible_answers();
				setState(75);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(OPTIONAL);
				setState(78);
				match(T__1);
				setState(79);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(OPTIONAL);
				setState(81);
				match(T__2);
				setState(82);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				match(OBLIGATORY);
				setState(84);
				match(T__0);
				setState(85);
				possible_answers();
				setState(86);
				match(NEWLINE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				match(OBLIGATORY);
				setState(89);
				match(T__1);
				setState(90);
				match(NEWLINE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				match(OBLIGATORY);
				setState(92);
				match(T__2);
				setState(93);
				match(NEWLINE);
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

	public static class Possible_answersContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(OurGrammarParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(OurGrammarParser.STRING, i);
		}
		public Possible_answersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possible_answers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).enterPossible_answers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurGrammarListener ) ((OurGrammarListener)listener).exitPossible_answers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurGrammarVisitor ) return ((OurGrammarVisitor<? extends T>)visitor).visitPossible_answers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Possible_answersContext possible_answers() throws RecognitionException {
		Possible_answersContext _localctx = new Possible_answersContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_possible_answers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(96);
				match(STRING);
				setState(97);
				match(T__3);
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
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

	public static final String _serializedATN =
		"\u0004\u0001\u0011g\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005*\b\u0005"+
		"\u000b\u0005\f\u0005+\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007"+
		"7\b\u0007\u000b\u0007\f\u00078\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nG\b\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b_\b\u000b"+
		"\u0001\f\u0001\f\u0004\fc\b\f\u000b\f\f\fd\u0001\f\u0000\u0000\r\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0000"+
		"b\u0000\u001a\u0001\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000"+
		"\u0004 \u0001\u0000\u0000\u0000\u0006$\u0001\u0000\u0000\u0000\b&\u0001"+
		"\u0000\u0000\u0000\n)\u0001\u0000\u0000\u0000\f/\u0001\u0000\u0000\u0000"+
		"\u000e6\u0001\u0000\u0000\u0000\u0010:\u0001\u0000\u0000\u0000\u0012>"+
		"\u0001\u0000\u0000\u0000\u0014F\u0001\u0000\u0000\u0000\u0016^\u0001\u0000"+
		"\u0000\u0000\u0018b\u0001\u0000\u0000\u0000\u001a\u001b\u0003\u0002\u0001"+
		"\u0000\u001b\u0001\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0004\u0002"+
		"\u0000\u001d\u001e\u0005\u0007\u0000\u0000\u001e\u001f\u0003\n\u0005\u0000"+
		"\u001f\u0003\u0001\u0000\u0000\u0000 !\u0003\u0006\u0003\u0000!\"\u0005"+
		"\u0007\u0000\u0000\"#\u0003\b\u0004\u0000#\u0005\u0001\u0000\u0000\u0000"+
		"$%\u0005\n\u0000\u0000%\u0007\u0001\u0000\u0000\u0000&\'\u0005\n\u0000"+
		"\u0000\'\t\u0001\u0000\u0000\u0000(*\u0003\f\u0006\u0000)(\u0001\u0000"+
		"\u0000\u0000*+\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001"+
		"\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0003\u0012\t\u0000.\u000b"+
		"\u0001\u0000\u0000\u0000/0\u0005\u0005\u0000\u000001\u0003\u0006\u0003"+
		"\u000012\u0003\u0010\b\u000023\u0005\u0007\u0000\u000034\u0003\u000e\u0007"+
		"\u00004\r\u0001\u0000\u0000\u000057\u0003\u0014\n\u000065\u0001\u0000"+
		"\u0000\u000078\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u00009\u000f\u0001\u0000\u0000\u0000:;\u0005\f\u0000\u0000"+
		";<\u0005\n\u0000\u0000<=\u0005\r\u0000\u0000=\u0011\u0001\u0000\u0000"+
		"\u0000>?\u0005\n\u0000\u0000?\u0013\u0001\u0000\u0000\u0000@A\u0005\n"+
		"\u0000\u0000AB\u0005\u000b\u0000\u0000BG\u0003\u0016\u000b\u0000CD\u0005"+
		"\n\u0000\u0000DE\u0005\u000b\u0000\u0000EG\u0003\u0016\u000b\u0000F@\u0001"+
		"\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000G\u0015\u0001\u0000\u0000"+
		"\u0000HI\u0005\u0010\u0000\u0000IJ\u0005\u0001\u0000\u0000JK\u0003\u0018"+
		"\f\u0000KL\u0005\u0007\u0000\u0000L_\u0001\u0000\u0000\u0000MN\u0005\u0010"+
		"\u0000\u0000NO\u0005\u0002\u0000\u0000O_\u0005\u0007\u0000\u0000PQ\u0005"+
		"\u0010\u0000\u0000QR\u0005\u0003\u0000\u0000R_\u0005\u0007\u0000\u0000"+
		"ST\u0005\u0011\u0000\u0000TU\u0005\u0001\u0000\u0000UV\u0003\u0018\f\u0000"+
		"VW\u0005\u0007\u0000\u0000W_\u0001\u0000\u0000\u0000XY\u0005\u0011\u0000"+
		"\u0000YZ\u0005\u0002\u0000\u0000Z_\u0005\u0007\u0000\u0000[\\\u0005\u0011"+
		"\u0000\u0000\\]\u0005\u0003\u0000\u0000]_\u0005\u0007\u0000\u0000^H\u0001"+
		"\u0000\u0000\u0000^M\u0001\u0000\u0000\u0000^P\u0001\u0000\u0000\u0000"+
		"^S\u0001\u0000\u0000\u0000^X\u0001\u0000\u0000\u0000^[\u0001\u0000\u0000"+
		"\u0000_\u0017\u0001\u0000\u0000\u0000`a\u0005\n\u0000\u0000ac\u0005\u0004"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u0019\u0001\u0000\u0000"+
		"\u0000\u0005+8F^d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}