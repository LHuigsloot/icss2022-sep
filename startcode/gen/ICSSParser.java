// Generated from C:/Users/Lhuig/Documents/GitHub/icss2022-sep/startcode/src/main/antlr4/nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ICSSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, BOX_BRACKET_OPEN=3, BOX_BRACKET_CLOSE=4, TRUE=5, FALSE=6, 
		PIXELSIZE=7, PERCENTAGE=8, SCALAR=9, COLOR=10, ID_IDENT=11, CLASS_IDENT=12, 
		LOWER_IDENT=13, CAPITAL_IDENT=14, WS=15, OPEN_BRACE=16, CLOSE_BRACE=17, 
		SEMICOLON=18, COLON=19, PLUS=20, MIN=21, MUL=22, ASSIGNMENT_OPERATOR=23;
	public static final int
		RULE_stylesheet = 0, RULE_colorLiteral = 1, RULE_percentageLiteral = 2, 
		RULE_pixelLiteral = 3, RULE_boolLiteral = 4, RULE_scalarLiteral = 5, RULE_literal = 6, 
		RULE_variableAssignment = 7, RULE_variableReference = 8, RULE_operation = 9, 
		RULE_multiplyOperation = 10, RULE_addOperation = 11, RULE_substractOperation = 12, 
		RULE_styleRule = 13, RULE_selector = 14, RULE_tagSelector = 15, RULE_idSelector = 16, 
		RULE_classSelector = 17, RULE_declaration = 18, RULE_propertyName = 19, 
		RULE_ifClause = 20, RULE_elseClause = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"stylesheet", "colorLiteral", "percentageLiteral", "pixelLiteral", "boolLiteral", 
			"scalarLiteral", "literal", "variableAssignment", "variableReference", 
			"operation", "multiplyOperation", "addOperation", "substractOperation", 
			"styleRule", "selector", "tagSelector", "idSelector", "classSelector", 
			"declaration", "propertyName", "ifClause", "elseClause"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'['", "']'", "'TRUE'", "'FALSE'", null, null, 
			null, null, null, null, null, null, null, "'{'", "'}'", "';'", "':'", 
			"'+'", "'-'", "'*'", "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "BOX_BRACKET_OPEN", "BOX_BRACKET_CLOSE", "TRUE", 
			"FALSE", "PIXELSIZE", "PERCENTAGE", "SCALAR", "COLOR", "ID_IDENT", "CLASS_IDENT", 
			"LOWER_IDENT", "CAPITAL_IDENT", "WS", "OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", 
			"COLON", "PLUS", "MIN", "MUL", "ASSIGNMENT_OPERATOR"
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
	public String getGrammarFileName() { return "ICSS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ICSSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StylesheetContext extends ParserRuleContext {
		public List<VariableAssignmentContext> variableAssignment() {
			return getRuleContexts(VariableAssignmentContext.class);
		}
		public VariableAssignmentContext variableAssignment(int i) {
			return getRuleContext(VariableAssignmentContext.class,i);
		}
		public List<StyleRuleContext> styleRule() {
			return getRuleContexts(StyleRuleContext.class);
		}
		public StyleRuleContext styleRule(int i) {
			return getRuleContext(StyleRuleContext.class,i);
		}
		public TerminalNode EOF() { return getToken(ICSSParser.EOF, 0); }
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStylesheet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID_IDENT:
			case CLASS_IDENT:
			case LOWER_IDENT:
			case CAPITAL_IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(46);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CAPITAL_IDENT:
						{
						setState(44);
						variableAssignment();
						}
						break;
					case ID_IDENT:
					case CLASS_IDENT:
					case LOWER_IDENT:
						{
						setState(45);
						styleRule();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(48); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 30720L) != 0) );
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ColorLiteralContext extends ParserRuleContext {
		public TerminalNode COLOR() { return getToken(ICSSParser.COLOR, 0); }
		public ColorLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colorLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterColorLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitColorLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitColorLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorLiteralContext colorLiteral() throws RecognitionException {
		ColorLiteralContext _localctx = new ColorLiteralContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_colorLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(COLOR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PercentageLiteralContext extends ParserRuleContext {
		public TerminalNode PERCENTAGE() { return getToken(ICSSParser.PERCENTAGE, 0); }
		public PercentageLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_percentageLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPercentageLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPercentageLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitPercentageLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PercentageLiteralContext percentageLiteral() throws RecognitionException {
		PercentageLiteralContext _localctx = new PercentageLiteralContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_percentageLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(PERCENTAGE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PixelLiteralContext extends ParserRuleContext {
		public TerminalNode PIXELSIZE() { return getToken(ICSSParser.PIXELSIZE, 0); }
		public PixelLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pixelLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPixelLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPixelLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitPixelLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PixelLiteralContext pixelLiteral() throws RecognitionException {
		PixelLiteralContext _localctx = new PixelLiteralContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pixelLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(PIXELSIZE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BoolLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ICSSParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ICSSParser.FALSE, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitBoolLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_boolLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ScalarLiteralContext extends ParserRuleContext {
		public TerminalNode SCALAR() { return getToken(ICSSParser.SCALAR, 0); }
		public ScalarLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterScalarLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitScalarLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitScalarLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarLiteralContext scalarLiteral() throws RecognitionException {
		ScalarLiteralContext _localctx = new ScalarLiteralContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_scalarLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(SCALAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public ColorLiteralContext colorLiteral() {
			return getRuleContext(ColorLiteralContext.class,0);
		}
		public PercentageLiteralContext percentageLiteral() {
			return getRuleContext(PercentageLiteralContext.class,0);
		}
		public PixelLiteralContext pixelLiteral() {
			return getRuleContext(PixelLiteralContext.class,0);
		}
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public ScalarLiteralContext scalarLiteral() {
			return getRuleContext(ScalarLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_literal);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				colorLiteral();
				}
				break;
			case PERCENTAGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				percentageLiteral();
				}
				break;
			case PIXELSIZE:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				pixelLiteral();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				boolLiteral();
				}
				break;
			case SCALAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				scalarLiteral();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableAssignmentContext extends ParserRuleContext {
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(ICSSParser.ASSIGNMENT_OPERATOR, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ICSSParser.SEMICOLON, 0); }
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			variableReference();
			setState(71);
			match(ASSIGNMENT_OPERATOR);
			setState(72);
			literal();
			setState(73);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableReferenceContext extends ParserRuleContext {
		public TerminalNode CAPITAL_IDENT() { return getToken(ICSSParser.CAPITAL_IDENT, 0); }
		public VariableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVariableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVariableReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableReferenceContext variableReference() throws RecognitionException {
		VariableReferenceContext _localctx = new VariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(CAPITAL_IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OperationContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public MultiplyOperationContext multiplyOperation() {
			return getRuleContext(MultiplyOperationContext.class,0);
		}
		public AddOperationContext addOperation() {
			return getRuleContext(AddOperationContext.class,0);
		}
		public SubstractOperationContext substractOperation() {
			return getRuleContext(SubstractOperationContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		return operation(0);
	}

	private OperationContext operation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OperationContext _localctx = new OperationContext(_ctx, _parentState);
		OperationContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_operation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case PIXELSIZE:
			case PERCENTAGE:
			case SCALAR:
			case COLOR:
				{
				setState(78);
				literal();
				}
				break;
			case CAPITAL_IDENT:
				{
				setState(79);
				variableReference();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(93);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new OperationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(82);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(83);
						multiplyOperation();
						setState(84);
						operation(4);
						}
						break;
					case 2:
						{
						_localctx = new OperationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(86);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(89);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PLUS:
							{
							setState(87);
							addOperation();
							}
							break;
						case MIN:
							{
							setState(88);
							substractOperation();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(91);
						operation(3);
						}
						break;
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplyOperationContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(ICSSParser.MUL, 0); }
		public MultiplyOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterMultiplyOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitMultiplyOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitMultiplyOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyOperationContext multiplyOperation() throws RecognitionException {
		MultiplyOperationContext _localctx = new MultiplyOperationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multiplyOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(MUL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AddOperationContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ICSSParser.PLUS, 0); }
		public AddOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterAddOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitAddOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitAddOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOperationContext addOperation() throws RecognitionException {
		AddOperationContext _localctx = new AddOperationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_addOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(PLUS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SubstractOperationContext extends ParserRuleContext {
		public TerminalNode MIN() { return getToken(ICSSParser.MIN, 0); }
		public SubstractOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_substractOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSubstractOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSubstractOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitSubstractOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubstractOperationContext substractOperation() throws RecognitionException {
		SubstractOperationContext _localctx = new SubstractOperationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_substractOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(MIN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StyleRuleContext extends ParserRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public TerminalNode OPEN_BRACE() { return getToken(ICSSParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(ICSSParser.CLOSE_BRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<IfClauseContext> ifClause() {
			return getRuleContexts(IfClauseContext.class);
		}
		public IfClauseContext ifClause(int i) {
			return getRuleContext(IfClauseContext.class,i);
		}
		public StyleRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStyleRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStyleRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitStyleRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleRuleContext styleRule() throws RecognitionException {
		StyleRuleContext _localctx = new StyleRuleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_styleRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			selector();
			setState(105);
			match(OPEN_BRACE);
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(108);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LOWER_IDENT:
					{
					setState(106);
					declaration();
					}
					break;
				case IF:
					{
					setState(107);
					ifClause();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IF || _la==LOWER_IDENT );
			setState(112);
			match(CLOSE_BRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorContext extends ParserRuleContext {
		public TagSelectorContext tagSelector() {
			return getRuleContext(TagSelectorContext.class,0);
		}
		public IdSelectorContext idSelector() {
			return getRuleContext(IdSelectorContext.class,0);
		}
		public ClassSelectorContext classSelector() {
			return getRuleContext(ClassSelectorContext.class,0);
		}
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_selector);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOWER_IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				tagSelector();
				}
				break;
			case ID_IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				idSelector();
				}
				break;
			case CLASS_IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				classSelector();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TagSelectorContext extends ParserRuleContext {
		public TerminalNode LOWER_IDENT() { return getToken(ICSSParser.LOWER_IDENT, 0); }
		public TagSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterTagSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitTagSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitTagSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagSelectorContext tagSelector() throws RecognitionException {
		TagSelectorContext _localctx = new TagSelectorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tagSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(LOWER_IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdSelectorContext extends ParserRuleContext {
		public TerminalNode ID_IDENT() { return getToken(ICSSParser.ID_IDENT, 0); }
		public IdSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterIdSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitIdSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitIdSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdSelectorContext idSelector() throws RecognitionException {
		IdSelectorContext _localctx = new IdSelectorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_idSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(ID_IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassSelectorContext extends ParserRuleContext {
		public TerminalNode CLASS_IDENT() { return getToken(ICSSParser.CLASS_IDENT, 0); }
		public ClassSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterClassSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitClassSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitClassSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassSelectorContext classSelector() throws RecognitionException {
		ClassSelectorContext _localctx = new ClassSelectorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_classSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(CLASS_IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ICSSParser.COLON, 0); }
		public TerminalNode SEMICOLON() { return getToken(ICSSParser.SEMICOLON, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			propertyName();
			setState(126);
			match(COLON);
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(127);
				literal();
				}
				break;
			case 2:
				{
				setState(128);
				variableReference();
				}
				break;
			case 3:
				{
				setState(129);
				operation(0);
				}
				break;
			}
			setState(132);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyNameContext extends ParserRuleContext {
		public TerminalNode LOWER_IDENT() { return getToken(ICSSParser.LOWER_IDENT, 0); }
		public PropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPropertyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPropertyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitPropertyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyNameContext propertyName() throws RecognitionException {
		PropertyNameContext _localctx = new PropertyNameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_propertyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(LOWER_IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfClauseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ICSSParser.IF, 0); }
		public TerminalNode BOX_BRACKET_OPEN() { return getToken(ICSSParser.BOX_BRACKET_OPEN, 0); }
		public TerminalNode BOX_BRACKET_CLOSE() { return getToken(ICSSParser.BOX_BRACKET_CLOSE, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(ICSSParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(ICSSParser.CLOSE_BRACE, 0); }
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<IfClauseContext> ifClause() {
			return getRuleContexts(IfClauseContext.class);
		}
		public IfClauseContext ifClause(int i) {
			return getRuleContext(IfClauseContext.class,i);
		}
		public ElseClauseContext elseClause() {
			return getRuleContext(ElseClauseContext.class,0);
		}
		public IfClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterIfClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitIfClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitIfClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfClauseContext ifClause() throws RecognitionException {
		IfClauseContext _localctx = new IfClauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ifClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(IF);
			setState(137);
			match(BOX_BRACKET_OPEN);
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				{
				setState(138);
				boolLiteral();
				}
				break;
			case CAPITAL_IDENT:
				{
				setState(139);
				variableReference();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(142);
			match(BOX_BRACKET_CLOSE);
			setState(143);
			match(OPEN_BRACE);
			setState(146); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(146);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LOWER_IDENT:
					{
					setState(144);
					declaration();
					}
					break;
				case IF:
					{
					setState(145);
					ifClause();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IF || _la==LOWER_IDENT );
			setState(150);
			match(CLOSE_BRACE);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(151);
				elseClause();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElseClauseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(ICSSParser.ELSE, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(ICSSParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(ICSSParser.CLOSE_BRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<IfClauseContext> ifClause() {
			return getRuleContexts(IfClauseContext.class);
		}
		public IfClauseContext ifClause(int i) {
			return getRuleContext(IfClauseContext.class,i);
		}
		public ElseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterElseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitElseClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitElseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseClauseContext elseClause() throws RecognitionException {
		ElseClauseContext _localctx = new ElseClauseContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_elseClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ELSE);
			setState(155);
			match(OPEN_BRACE);
			setState(158); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(158);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LOWER_IDENT:
					{
					setState(156);
					declaration();
					}
					break;
				case IF:
					{
					setState(157);
					ifClause();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IF || _la==LOWER_IDENT );
			setState(162);
			match(CLOSE_BRACE);
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
		case 9:
			return operation_sempred((OperationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean operation_sempred(OperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017\u00a5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0001\u0000\u0001\u0000\u0004\u0000/\b\u0000\u000b\u0000\f\u0000"+
		"0\u0001\u0000\u0003\u00004\b\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006E\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\tQ\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tZ\b\t\u0001"+
		"\t\u0001\t\u0005\t^\b\t\n\t\f\ta\t\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0004\rm\b\r\u000b"+
		"\r\f\rn\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"v\b\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u0083\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u008d\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u0093\b\u0014"+
		"\u000b\u0014\f\u0014\u0094\u0001\u0014\u0001\u0014\u0003\u0014\u0099\b"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0004\u0015\u009f"+
		"\b\u0015\u000b\u0015\f\u0015\u00a0\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0000\u0001\u0012\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000\u0001\u0001\u0000\u0005"+
		"\u0006\u00a5\u00003\u0001\u0000\u0000\u0000\u00025\u0001\u0000\u0000\u0000"+
		"\u00047\u0001\u0000\u0000\u0000\u00069\u0001\u0000\u0000\u0000\b;\u0001"+
		"\u0000\u0000\u0000\n=\u0001\u0000\u0000\u0000\fD\u0001\u0000\u0000\u0000"+
		"\u000eF\u0001\u0000\u0000\u0000\u0010K\u0001\u0000\u0000\u0000\u0012M"+
		"\u0001\u0000\u0000\u0000\u0014b\u0001\u0000\u0000\u0000\u0016d\u0001\u0000"+
		"\u0000\u0000\u0018f\u0001\u0000\u0000\u0000\u001ah\u0001\u0000\u0000\u0000"+
		"\u001cu\u0001\u0000\u0000\u0000\u001ew\u0001\u0000\u0000\u0000 y\u0001"+
		"\u0000\u0000\u0000\"{\u0001\u0000\u0000\u0000$}\u0001\u0000\u0000\u0000"+
		"&\u0086\u0001\u0000\u0000\u0000(\u0088\u0001\u0000\u0000\u0000*\u009a"+
		"\u0001\u0000\u0000\u0000,/\u0003\u000e\u0007\u0000-/\u0003\u001a\r\u0000"+
		".,\u0001\u0000\u0000\u0000.-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000"+
		"\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000014\u0001\u0000"+
		"\u0000\u000024\u0005\u0000\u0000\u00013.\u0001\u0000\u0000\u000032\u0001"+
		"\u0000\u0000\u00004\u0001\u0001\u0000\u0000\u000056\u0005\n\u0000\u0000"+
		"6\u0003\u0001\u0000\u0000\u000078\u0005\b\u0000\u00008\u0005\u0001\u0000"+
		"\u0000\u00009:\u0005\u0007\u0000\u0000:\u0007\u0001\u0000\u0000\u0000"+
		";<\u0007\u0000\u0000\u0000<\t\u0001\u0000\u0000\u0000=>\u0005\t\u0000"+
		"\u0000>\u000b\u0001\u0000\u0000\u0000?E\u0003\u0002\u0001\u0000@E\u0003"+
		"\u0004\u0002\u0000AE\u0003\u0006\u0003\u0000BE\u0003\b\u0004\u0000CE\u0003"+
		"\n\u0005\u0000D?\u0001\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000DA\u0001"+
		"\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000"+
		"E\r\u0001\u0000\u0000\u0000FG\u0003\u0010\b\u0000GH\u0005\u0017\u0000"+
		"\u0000HI\u0003\f\u0006\u0000IJ\u0005\u0012\u0000\u0000J\u000f\u0001\u0000"+
		"\u0000\u0000KL\u0005\u000e\u0000\u0000L\u0011\u0001\u0000\u0000\u0000"+
		"MP\u0006\t\uffff\uffff\u0000NQ\u0003\f\u0006\u0000OQ\u0003\u0010\b\u0000"+
		"PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000Q_\u0001\u0000\u0000"+
		"\u0000RS\n\u0003\u0000\u0000ST\u0003\u0014\n\u0000TU\u0003\u0012\t\u0004"+
		"U^\u0001\u0000\u0000\u0000VY\n\u0002\u0000\u0000WZ\u0003\u0016\u000b\u0000"+
		"XZ\u0003\u0018\f\u0000YW\u0001\u0000\u0000\u0000YX\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[\\\u0003\u0012\t\u0003\\^\u0001\u0000\u0000"+
		"\u0000]R\u0001\u0000\u0000\u0000]V\u0001\u0000\u0000\u0000^a\u0001\u0000"+
		"\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\u0013"+
		"\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\u0016\u0000"+
		"\u0000c\u0015\u0001\u0000\u0000\u0000de\u0005\u0014\u0000\u0000e\u0017"+
		"\u0001\u0000\u0000\u0000fg\u0005\u0015\u0000\u0000g\u0019\u0001\u0000"+
		"\u0000\u0000hi\u0003\u001c\u000e\u0000il\u0005\u0010\u0000\u0000jm\u0003"+
		"$\u0012\u0000km\u0003(\u0014\u0000lj\u0001\u0000\u0000\u0000lk\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0005\u0011\u0000\u0000"+
		"q\u001b\u0001\u0000\u0000\u0000rv\u0003\u001e\u000f\u0000sv\u0003 \u0010"+
		"\u0000tv\u0003\"\u0011\u0000ur\u0001\u0000\u0000\u0000us\u0001\u0000\u0000"+
		"\u0000ut\u0001\u0000\u0000\u0000v\u001d\u0001\u0000\u0000\u0000wx\u0005"+
		"\r\u0000\u0000x\u001f\u0001\u0000\u0000\u0000yz\u0005\u000b\u0000\u0000"+
		"z!\u0001\u0000\u0000\u0000{|\u0005\f\u0000\u0000|#\u0001\u0000\u0000\u0000"+
		"}~\u0003&\u0013\u0000~\u0082\u0005\u0013\u0000\u0000\u007f\u0083\u0003"+
		"\f\u0006\u0000\u0080\u0083\u0003\u0010\b\u0000\u0081\u0083\u0003\u0012"+
		"\t\u0000\u0082\u007f\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000"+
		"\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005\u0012\u0000\u0000\u0085%\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0005\r\u0000\u0000\u0087\'\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0005\u0001\u0000\u0000\u0089\u008c\u0005\u0003\u0000\u0000\u008a"+
		"\u008d\u0003\b\u0004\u0000\u008b\u008d\u0003\u0010\b\u0000\u008c\u008a"+
		"\u0001\u0000\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u0004\u0000\u0000\u008f\u0092"+
		"\u0005\u0010\u0000\u0000\u0090\u0093\u0003$\u0012\u0000\u0091\u0093\u0003"+
		"(\u0014\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0091\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000"+
		"\u0000\u0000\u0096\u0098\u0005\u0011\u0000\u0000\u0097\u0099\u0003*\u0015"+
		"\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099)\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0002\u0000\u0000"+
		"\u009b\u009e\u0005\u0010\u0000\u0000\u009c\u009f\u0003$\u0012\u0000\u009d"+
		"\u009f\u0003(\u0014\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009d"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u009e"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u0011\u0000\u0000\u00a3+\u0001"+
		"\u0000\u0000\u0000\u0012.03DPY]_lnu\u0082\u008c\u0092\u0094\u0098\u009e"+
		"\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}