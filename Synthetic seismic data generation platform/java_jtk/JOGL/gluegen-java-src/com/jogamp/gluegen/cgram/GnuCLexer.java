// $ANTLR 2.7.7 (2006-11-01): "expandedGnuCParser.g" -> "GnuCLexer.java"$

        package com.jogamp.gluegen.cgram;

        import java.io.*;

        import antlr.CommonAST;
        import antlr.DumpASTVisitor;
        import com.jogamp.gluegen.ASTLocusTag;

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

        import java.io.*;
        import java.util.*;
        import antlr.*;

public class GnuCLexer extends antlr.CharScanner implements GnuCLexerTokenTypes, TokenStream
 {

  public void initialize(String src)
  {
    setOriginalSource(src);
    initialize();
  }

  public void initialize() 
  {
    literals.put(new ANTLRHashString("__alignof__", this), new Integer(LITERAL___alignof));
    literals.put(new ANTLRHashString("__asm", this), new Integer(LITERAL_asm));
    literals.put(new ANTLRHashString("__asm__", this), new Integer(LITERAL_asm));
    literals.put(new ANTLRHashString("__attribute__", this), new Integer(LITERAL___attribute));
    literals.put(new ANTLRHashString("__complex__", this), new Integer(LITERAL___complex));
    literals.put(new ANTLRHashString("__const", this), new Integer(LITERAL_const));
    literals.put(new ANTLRHashString("__const__", this), new Integer(LITERAL_const));
    literals.put(new ANTLRHashString("__imag__", this), new Integer(LITERAL___imag));
    literals.put(new ANTLRHashString("__inline", this), new Integer(LITERAL_inline));
    literals.put(new ANTLRHashString("__inline__", this), new Integer(LITERAL_inline));
    literals.put(new ANTLRHashString("__real__", this), new Integer(LITERAL___real));
    literals.put(new ANTLRHashString("__signed", this), new Integer(LITERAL_signed));
    literals.put(new ANTLRHashString("__signed__", this), new Integer(LITERAL_signed));
    literals.put(new ANTLRHashString("__typeof", this), new Integer(LITERAL_typeof));
    literals.put(new ANTLRHashString("__typeof__", this), new Integer(LITERAL_typeof));
    literals.put(new ANTLRHashString("__volatile", this), new Integer(LITERAL_volatile));
    literals.put(new ANTLRHashString("__volatile__", this), new Integer(LITERAL_volatile));
  }


  LineObject lineObject = new LineObject();
  String originalSource = "";
  PreprocessorInfoChannel preprocessorInfoChannel = new PreprocessorInfoChannel();
  int tokenNumber = 0;
  boolean countingTokens = true;
  int deferredLineCount = 0;
  List defines = new ArrayList();

  public void setCountingTokens(boolean ct) 
  {
    countingTokens = ct;
    if ( countingTokens ) {
      tokenNumber = 0;
    }
    else {
      tokenNumber = 1;
    }
  }

  public void setOriginalSource(String src) 
  {
    originalSource = src;
    lineObject.setSource(src);
  }
  public void setSource(String src) 
  {
    lineObject.setSource(src);
  }
  
  public PreprocessorInfoChannel getPreprocessorInfoChannel() 
  {
    return preprocessorInfoChannel;
  }

  public void setPreprocessingDirective(String pre)
  {
    preprocessorInfoChannel.addLineForTokenNumber( pre, new Integer(tokenNumber) );
  }
  
  public void addDefine(String name, String value)
  {
    defines.add(new Define(name, value, new ASTLocusTag(lineObject.getSource(), lineObject.getLine()+deferredLineCount, -1, name)));
  }

  /** Returns a list of Define objects corresponding to the
      preprocessor definitions seen during parsing. */
  public List getDefines() {
    return defines;
  }

  protected Token makeToken(int t)
  {
    if ( t != Token.SKIP && countingTokens) {
        tokenNumber++;
    }
    CToken tok = (CToken) super.makeToken(t);
    tok.setLine(lineObject.line);
    tok.setSource(lineObject.source);
    tok.setTokenNumber(tokenNumber);

    lineObject.line += deferredLineCount;
    deferredLineCount = 0;
    return tok;
  }

    public void deferredNewline() { 
        deferredLineCount++;
    }

    public void newline() { 
        lineObject.newline();
    }






public GnuCLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public GnuCLexer(Reader in) {
	this(new CharBuffer(in));
}
public GnuCLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public GnuCLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(true);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("intptr_t", this), new Integer(39));
	literals.put(new ANTLRHashString("extern", this), new Integer(15));
	literals.put(new ANTLRHashString("__real", this), new Integer(165));
	literals.put(new ANTLRHashString("case", this), new Integer(59));
	literals.put(new ANTLRHashString("short", this), new Integer(20));
	literals.put(new ANTLRHashString("break", this), new Integer(57));
	literals.put(new ANTLRHashString("while", this), new Integer(52));
	literals.put(new ANTLRHashString("uint32_t", this), new Integer(34));
	literals.put(new ANTLRHashString("int16_t", this), new Integer(29));
	literals.put(new ANTLRHashString("ptrdiff_t", this), new Integer(38));
	literals.put(new ANTLRHashString("typeof", this), new Integer(161));
	literals.put(new ANTLRHashString("inline", this), new Integer(160));
	literals.put(new ANTLRHashString("unsigned", this), new Integer(26));
	literals.put(new ANTLRHashString("const", this), new Integer(17));
	literals.put(new ANTLRHashString("float", this), new Integer(23));
	literals.put(new ANTLRHashString("return", this), new Integer(58));
	literals.put(new ANTLRHashString("int64_t", this), new Integer(36));
	literals.put(new ANTLRHashString("sizeof", this), new Integer(94));
	literals.put(new ANTLRHashString("size_t", this), new Integer(40));
	literals.put(new ANTLRHashString("do", this), new Integer(53));
	literals.put(new ANTLRHashString("__label__", this), new Integer(159));
	literals.put(new ANTLRHashString("typedef", this), new Integer(4));
	literals.put(new ANTLRHashString("uint16_t", this), new Integer(30));
	literals.put(new ANTLRHashString("if", this), new Integer(61));
	literals.put(new ANTLRHashString("__int32", this), new Integer(31));
	literals.put(new ANTLRHashString("double", this), new Integer(24));
	literals.put(new ANTLRHashString("volatile", this), new Integer(6));
	literals.put(new ANTLRHashString("__attribute", this), new Integer(163));
	literals.put(new ANTLRHashString("union", this), new Integer(11));
	literals.put(new ANTLRHashString("register", this), new Integer(14));
	literals.put(new ANTLRHashString("auto", this), new Integer(13));
	literals.put(new ANTLRHashString("goto", this), new Integer(55));
	literals.put(new ANTLRHashString("enum", this), new Integer(12));
	literals.put(new ANTLRHashString("int", this), new Integer(21));
	literals.put(new ANTLRHashString("for", this), new Integer(54));
	literals.put(new ANTLRHashString("int32_t", this), new Integer(32));
	literals.put(new ANTLRHashString("uint64_t", this), new Integer(37));
	literals.put(new ANTLRHashString("char", this), new Integer(19));
	literals.put(new ANTLRHashString("default", this), new Integer(60));
	literals.put(new ANTLRHashString("__imag", this), new Integer(166));
	literals.put(new ANTLRHashString("__alignof", this), new Integer(164));
	literals.put(new ANTLRHashString("static", this), new Integer(16));
	literals.put(new ANTLRHashString("int8_t", this), new Integer(27));
	literals.put(new ANTLRHashString("uint8_t", this), new Integer(28));
	literals.put(new ANTLRHashString("continue", this), new Integer(56));
	literals.put(new ANTLRHashString("struct", this), new Integer(10));
	literals.put(new ANTLRHashString("__int64", this), new Integer(35));
	literals.put(new ANTLRHashString("signed", this), new Integer(25));
	literals.put(new ANTLRHashString("else", this), new Integer(62));
	literals.put(new ANTLRHashString("uintptr_t", this), new Integer(41));
	literals.put(new ANTLRHashString("void", this), new Integer(18));
	literals.put(new ANTLRHashString("wchar_t", this), new Integer(33));
	literals.put(new ANTLRHashString("switch", this), new Integer(63));
	literals.put(new ANTLRHashString("long", this), new Integer(22));
	literals.put(new ANTLRHashString("__extension__", this), new Integer(167));
	literals.put(new ANTLRHashString("asm", this), new Integer(5));
	literals.put(new ANTLRHashString("__complex", this), new Integer(162));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case '\t':  case '\n':  case '\u000c':  case '\r':
				case ' ':
				{
					mWhitespace(true);
					theRetToken=_returnToken;
					break;
				}
				case '\'':
				{
					mCharLiteral(true);
					theRetToken=_returnToken;
					break;
				}
				case '"':
				{
					mStringLiteral(true);
					theRetToken=_returnToken;
					break;
				}
				case ':':
				{
					mCOLON(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mCOMMA(true);
					theRetToken=_returnToken;
					break;
				}
				case '?':
				{
					mQUESTION(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mSEMI(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mRPAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case '[':
				{
					mLBRACKET(true);
					theRetToken=_returnToken;
					break;
				}
				case ']':
				{
					mRBRACKET(true);
					theRetToken=_returnToken;
					break;
				}
				case '{':
				{
					mLCURLY(true);
					theRetToken=_returnToken;
					break;
				}
				case '}':
				{
					mRCURLY(true);
					theRetToken=_returnToken;
					break;
				}
				case '~':
				{
					mBNOT(true);
					theRetToken=_returnToken;
					break;
				}
				case '#':
				{
					mPREPROC_DIRECTIVE(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='>') && (LA(2)=='>') && (LA(3)=='=')) {
						mRSHIFT_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='<') && (LA(3)=='=')) {
						mLSHIFT_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='L') && (LA(2)=='\'')) {
						mWideCharLiteral(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='L') && (LA(2)=='"')) {
						mWideStringLiteral(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && (LA(2)=='>') && (true)) {
						mPTR(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='=') && (LA(2)=='=')) {
						mEQUAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='!') && (LA(2)=='=')) {
						mNOT_EQUAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='=')) {
						mLTE(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (LA(2)=='=')) {
						mGTE(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (LA(2)=='=')) {
						mDIV_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='+') && (LA(2)=='=')) {
						mPLUS_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='+') && (LA(2)=='+')) {
						mINC(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && (LA(2)=='=')) {
						mMINUS_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && (LA(2)=='-') && (true)) {
						mDEC(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='*') && (LA(2)=='=')) {
						mSTAR_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='%') && (LA(2)=='=')) {
						mMOD_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (LA(2)=='>') && (true)) {
						mRSHIFT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='<') && (true)) {
						mLSHIFT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='&') && (LA(2)=='&')) {
						mLAND(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='|') && (LA(2)=='|')) {
						mLOR(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='&') && (LA(2)=='=')) {
						mBAND_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='|') && (LA(2)=='=')) {
						mBOR_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='^') && (LA(2)=='=')) {
						mBXOR_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (LA(2)=='*')) {
						mComment(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (LA(2)=='/')) {
						mCPPComment(true);
						theRetToken=_returnToken;
					}
					else if ((_tokenSet_0.member(LA(1))) && (true) && (true)) {
						mNumber(true);
						theRetToken=_returnToken;
					}
					else if ((_tokenSet_1.member(LA(1))) && (true)) {
						mIDMEAT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='=') && (true)) {
						mASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='(') && (true) && (true)) {
						mLPAREN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (true)) {
						mLT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (true)) {
						mGT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (true)) {
						mDIV(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='+') && (true)) {
						mPLUS(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && (true) && (true)) {
						mMINUS(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='*') && (true)) {
						mSTAR(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='%') && (true)) {
						mMOD(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='!') && (true)) {
						mLNOT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='&') && (true)) {
						mBAND(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='|') && (true)) {
						mBOR(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='^') && (true)) {
						mBXOR(true);
						theRetToken=_returnToken;
					}
					else if ((_tokenSet_2.member(LA(1))) && (true) && (true)) {
						mDefineExpr(true);
						theRetToken=_returnToken;
					}
					else if ((_tokenSet_0.member(LA(1))) && (true) && (true)) {
						mDefineExpr2(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mWhitespace(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Whitespace;
		int _saveIndex;
		
		{
		if ((LA(1)=='\r') && (LA(2)=='\n')) {
			match("\r\n");
			if ( inputState.guessing==0 ) {
				newline();
			}
		}
		else if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ')) {
			{
			switch ( LA(1)) {
			case ' ':
			{
				match(' ');
				break;
			}
			case '\t':
			{
				match('\t');
				break;
			}
			case '\u000c':
			{
				match('\014');
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
		}
		else if ((LA(1)=='\n'||LA(1)=='\r') && (true)) {
			{
			switch ( LA(1)) {
			case '\n':
			{
				match('\n');
				break;
			}
			case '\r':
			{
				match('\r');
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				newline();
			}
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mEscape(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Escape;
		int _saveIndex;
		
		match('\\');
		{
		switch ( LA(1)) {
		case '0':  case '1':  case '2':  case '3':
		{
			{
			matchRange('0','3');
			}
			{
			_loop327:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
					mDigit(false);
				}
				else {
					break _loop327;
				}
				
			} while (true);
			}
			break;
		}
		case '4':  case '5':  case '6':  case '7':
		{
			{
			matchRange('4','7');
			}
			{
			_loop330:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
					mDigit(false);
				}
				else {
					break _loop330;
				}
				
			} while (true);
			}
			break;
		}
		case 'x':
		{
			match('x');
			{
			int _cnt332=0;
			_loop332:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
					mDigit(false);
				}
				else if (((LA(1) >= 'a' && LA(1) <= 'f')) && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
					matchRange('a','f');
				}
				else if (((LA(1) >= 'A' && LA(1) <= 'F')) && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
					matchRange('A','F');
				}
				else {
					if ( _cnt332>=1 ) { break _loop332; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				
				_cnt332++;
			} while (true);
			}
			break;
		}
		default:
			if ((_tokenSet_3.member(LA(1)))) {
				{
				match(_tokenSet_3);
				}
			}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDigit(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Digit;
		int _saveIndex;
		
		matchRange('0','9');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIntSuffix(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IntSuffix;
		int _saveIndex;
		
		switch ( LA(1)) {
		case 'L':
		{
			match('L');
			break;
		}
		case 'l':
		{
			match('l');
			break;
		}
		case 'U':
		{
			match('U');
			break;
		}
		case 'u':
		{
			match('u');
			break;
		}
		case 'I':
		{
			match('I');
			break;
		}
		case 'i':
		{
			match('i');
			break;
		}
		case 'J':
		{
			match('J');
			break;
		}
		case 'j':
		{
			match('j');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNumberSuffix(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NumberSuffix;
		int _saveIndex;
		
		switch ( LA(1)) {
		case 'I':  case 'J':  case 'L':  case 'U':
		case 'i':  case 'j':  case 'l':  case 'u':
		{
			mIntSuffix(false);
			break;
		}
		case 'F':
		{
			match('F');
			break;
		}
		case 'f':
		{
			match('f');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNumber(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Number;
		int _saveIndex;
		
		boolean synPredMatched352 = false;
		if (((LA(1)=='.') && (LA(2)=='.') && (LA(3)=='.'))) {
			int _m352 = mark();
			synPredMatched352 = true;
			inputState.guessing++;
			try {
				{
				match("...");
				}
			}
			catch (RecognitionException pe) {
				synPredMatched352 = false;
			}
			rewind(_m352);
inputState.guessing--;
		}
		if ( synPredMatched352 ) {
			match("...");
			if ( inputState.guessing==0 ) {
				_ttype = VARARGS;
			}
		}
		else if ((LA(1)=='0') && (LA(2)=='X'||LA(2)=='x') && (_tokenSet_4.member(LA(3)))) {
			match('0');
			{
			switch ( LA(1)) {
			case 'x':
			{
				match('x');
				break;
			}
			case 'X':
			{
				match('X');
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			{
			int _cnt370=0;
			_loop370:
			do {
				if (((LA(1) >= 'a' && LA(1) <= 'f')) && (true) && (true)) {
					matchRange('a','f');
				}
				else if (((LA(1) >= 'A' && LA(1) <= 'F')) && (true) && (true)) {
					matchRange('A','F');
				}
				else if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true)) {
					mDigit(false);
				}
				else {
					if ( _cnt370>=1 ) { break _loop370; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				
				_cnt370++;
			} while (true);
			}
			{
			_loop372:
			do {
				if ((_tokenSet_5.member(LA(1))) && (true) && (true)) {
					mIntSuffix(false);
				}
				else {
					break _loop372;
				}
				
			} while (true);
			}
		}
		else {
			boolean synPredMatched341 = false;
			if (((_tokenSet_6.member(LA(1))) && (_tokenSet_7.member(LA(2))) && (true))) {
				int _m341 = mark();
				synPredMatched341 = true;
				inputState.guessing++;
				try {
					{
					{
					switch ( LA(1)) {
					case '-':
					{
						match('-');
						break;
					}
					case '0':  case '1':  case '2':  case '3':
					case '4':  case '5':  case '6':  case '7':
					case '8':  case '9':
					{
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					}
					}
					{
					int _cnt339=0;
					_loop339:
					do {
						if (((LA(1) >= '0' && LA(1) <= '9'))) {
							mDigit(false);
						}
						else {
							if ( _cnt339>=1 ) { break _loop339; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
						}
						
						_cnt339++;
					} while (true);
					}
					{
					switch ( LA(1)) {
					case '.':
					{
						match('.');
						break;
					}
					case 'e':
					{
						match('e');
						break;
					}
					case 'E':
					{
						match('E');
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					}
					}
					}
				}
				catch (RecognitionException pe) {
					synPredMatched341 = false;
				}
				rewind(_m341);
inputState.guessing--;
			}
			if ( synPredMatched341 ) {
				{
				switch ( LA(1)) {
				case '-':
				{
					match('-');
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				{
				int _cnt344=0;
				_loop344:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						mDigit(false);
					}
					else {
						if ( _cnt344>=1 ) { break _loop344; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
					}
					
					_cnt344++;
				} while (true);
				}
				{
				switch ( LA(1)) {
				case '.':
				{
					match('.');
					{
					_loop347:
					do {
						if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true)) {
							mDigit(false);
						}
						else {
							break _loop347;
						}
						
					} while (true);
					}
					{
					if ((LA(1)=='E'||LA(1)=='e') && (_tokenSet_8.member(LA(2))) && (true)) {
						mExponent(false);
					}
					else {
					}
					
					}
					break;
				}
				case 'E':  case 'e':
				{
					mExponent(false);
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				{
				_loop350:
				do {
					if ((_tokenSet_9.member(LA(1))) && (true) && (true)) {
						mNumberSuffix(false);
					}
					else {
						break _loop350;
					}
					
				} while (true);
				}
			}
			else if ((LA(1)=='.') && (true) && (true)) {
				match('.');
				if ( inputState.guessing==0 ) {
					_ttype = DOT;
				}
				{
				if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true)) {
					{
					int _cnt355=0;
					_loop355:
					do {
						if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true)) {
							mDigit(false);
						}
						else {
							if ( _cnt355>=1 ) { break _loop355; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
						}
						
						_cnt355++;
					} while (true);
					}
					{
					if ((LA(1)=='E'||LA(1)=='e') && (_tokenSet_8.member(LA(2))) && (true)) {
						mExponent(false);
					}
					else {
					}
					
					}
					if ( inputState.guessing==0 ) {
						_ttype = Number;
					}
					{
					_loop358:
					do {
						if ((_tokenSet_9.member(LA(1))) && (true) && (true)) {
							mNumberSuffix(false);
						}
						else {
							break _loop358;
						}
						
					} while (true);
					}
				}
				else {
				}
				
				}
			}
			else if ((LA(1)=='0') && (true) && (true)) {
				match('0');
				{
				_loop360:
				do {
					if (((LA(1) >= '0' && LA(1) <= '7')) && (true) && (true)) {
						matchRange('0','7');
					}
					else {
						break _loop360;
					}
					
				} while (true);
				}
				{
				_loop362:
				do {
					if ((_tokenSet_9.member(LA(1))) && (true) && (true)) {
						mNumberSuffix(false);
					}
					else {
						break _loop362;
					}
					
				} while (true);
				}
			}
			else if ((_tokenSet_10.member(LA(1))) && (true) && (true)) {
				{
				switch ( LA(1)) {
				case '-':
				{
					match('-');
					break;
				}
				case '1':  case '2':  case '3':  case '4':
				case '5':  case '6':  case '7':  case '8':
				case '9':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				matchRange('1','9');
				{
				_loop365:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true)) {
						mDigit(false);
					}
					else {
						break _loop365;
					}
					
				} while (true);
				}
				{
				_loop367:
				do {
					if ((_tokenSet_9.member(LA(1))) && (true) && (true)) {
						mNumberSuffix(false);
					}
					else {
						break _loop367;
					}
					
				} while (true);
				}
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		}
		
	protected final void mExponent(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Exponent;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'e':
		{
			match('e');
			break;
		}
		case 'E':
		{
			match('E');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case '+':
		{
			match('+');
			break;
		}
		case '-':
		{
			match('-');
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		int _cnt522=0;
		_loop522:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true)) {
				mDigit(false);
			}
			else {
				if ( _cnt522>=1 ) { break _loop522; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt522++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mIDMEAT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDMEAT;
		int _saveIndex;
		Token i=null;
		
		mID(true);
		i=_returnToken;
		if ( inputState.guessing==0 ) {
			
			
			if ( i.getType() == LITERAL___extension__ ) {
			_ttype = Token.SKIP;
			}
			else {
			_ttype = i.getType();
			}
			
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mID(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			matchRange('a','z');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':
		{
			matchRange('A','Z');
			break;
		}
		case '_':
		{
			match('_');
			break;
		}
		case '$':
		{
			match('$');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		_loop377:
		do {
			if (((LA(1) >= 'a' && LA(1) <= 'z')) && (true) && (true)) {
				matchRange('a','z');
			}
			else if (((LA(1) >= 'A' && LA(1) <= 'Z')) && (true) && (true)) {
				matchRange('A','Z');
			}
			else if ((LA(1)=='_') && (true) && (true)) {
				match('_');
			}
			else if ((LA(1)=='$') && (true) && (true)) {
				match('$');
			}
			else if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true)) {
				matchRange('0','9');
			}
			else {
				break _loop377;
			}
			
		} while (true);
		}
		_ttype = testLiteralsTable(new String(text.getBuffer(),_begin,text.length()-_begin),_ttype);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mWideCharLiteral(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WideCharLiteral;
		int _saveIndex;
		
		match('L');
		mCharLiteral(false);
		if ( inputState.guessing==0 ) {
			_ttype = CharLiteral;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCharLiteral(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CharLiteral;
		int _saveIndex;
		
		match('\'');
		{
		if ((LA(1)=='\\') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (_tokenSet_11.member(LA(3)))) {
			mEscape(false);
		}
		else if ((_tokenSet_12.member(LA(1))) && (LA(2)=='\'') && (true)) {
			{
			match(_tokenSet_12);
			}
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		match('\'');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mWideStringLiteral(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WideStringLiteral;
		int _saveIndex;
		
		match('L');
		mStringLiteral(false);
		if ( inputState.guessing==0 ) {
			_ttype = StringLiteral;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mStringLiteral(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = StringLiteral;
		int _saveIndex;
		
		match('"');
		{
		_loop387:
		do {
			boolean synPredMatched384 = false;
			if (((LA(1)=='\\') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && ((LA(3) >= '\u0000' && LA(3) <= '\u00ff')))) {
				int _m384 = mark();
				synPredMatched384 = true;
				inputState.guessing++;
				try {
					{
					match('\\');
					{
					match(_tokenSet_13);
					}
					}
				}
				catch (RecognitionException pe) {
					synPredMatched384 = false;
				}
				rewind(_m384);
inputState.guessing--;
			}
			if ( synPredMatched384 ) {
				mEscape(false);
			}
			else if ((LA(1)=='\n'||LA(1)=='\r'||LA(1)=='\\') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
				{
				switch ( LA(1)) {
				case '\r':
				{
					match('\r');
					if ( inputState.guessing==0 ) {
						newline();
					}
					break;
				}
				case '\n':
				{
					match('\n');
					if ( inputState.guessing==0 ) {
						
						newline();
						
					}
					break;
				}
				case '\\':
				{
					match('\\');
					match('\n');
					if ( inputState.guessing==0 ) {
						
						newline();
						
					}
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
			}
			else if ((_tokenSet_14.member(LA(1)))) {
				{
				match(_tokenSet_14);
				}
			}
			else {
				break _loop387;
			}
			
		} while (true);
		}
		match('"');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mVocabulary(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Vocabulary;
		int _saveIndex;
		
		matchRange('\3','\377');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ASSIGN;
		int _saveIndex;
		
		match('=');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOLON(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COLON;
		int _saveIndex;
		
		match(':');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		int _saveIndex;
		
		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mQUESTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = QUESTION;
		int _saveIndex;
		
		match('?');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSEMI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMI;
		int _saveIndex;
		
		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPTR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PTR;
		int _saveIndex;
		
		match("->");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOT;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mVARARGS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = VARARGS;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LPAREN;
		int _saveIndex;
		
		match('(');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RPAREN;
		int _saveIndex;
		
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLBRACKET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LBRACKET;
		int _saveIndex;
		
		match('[');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRBRACKET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RBRACKET;
		int _saveIndex;
		
		match(']');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLCURLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LCURLY;
		int _saveIndex;
		
		match('{');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRCURLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RCURLY;
		int _saveIndex;
		
		match('}');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQUAL;
		int _saveIndex;
		
		match("==");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNOT_EQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOT_EQUAL;
		int _saveIndex;
		
		match("!=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLTE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LTE;
		int _saveIndex;
		
		match("<=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LT;
		int _saveIndex;
		
		match("<");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGTE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GTE;
		int _saveIndex;
		
		match(">=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GT;
		int _saveIndex;
		
		match(">");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDIV(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIV;
		int _saveIndex;
		
		match('/');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDIV_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIV_ASSIGN;
		int _saveIndex;
		
		match("/=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPLUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS;
		int _saveIndex;
		
		match('+');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPLUS_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS_ASSIGN;
		int _saveIndex;
		
		match("+=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mINC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INC;
		int _saveIndex;
		
		match("++");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMINUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MINUS;
		int _saveIndex;
		
		match('-');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMINUS_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MINUS_ASSIGN;
		int _saveIndex;
		
		match("-=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDEC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DEC;
		int _saveIndex;
		
		match("--");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSTAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STAR;
		int _saveIndex;
		
		match('*');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSTAR_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STAR_ASSIGN;
		int _saveIndex;
		
		match("*=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMOD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MOD;
		int _saveIndex;
		
		match('%');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMOD_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MOD_ASSIGN;
		int _saveIndex;
		
		match("%=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRSHIFT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RSHIFT;
		int _saveIndex;
		
		match(">>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRSHIFT_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RSHIFT_ASSIGN;
		int _saveIndex;
		
		match(">>=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLSHIFT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LSHIFT;
		int _saveIndex;
		
		match("<<");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLSHIFT_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LSHIFT_ASSIGN;
		int _saveIndex;
		
		match("<<=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLAND(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LAND;
		int _saveIndex;
		
		match("&&");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLNOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LNOT;
		int _saveIndex;
		
		match('!');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LOR;
		int _saveIndex;
		
		match("||");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBAND(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BAND;
		int _saveIndex;
		
		match('&');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBAND_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BAND_ASSIGN;
		int _saveIndex;
		
		match("&=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBNOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BNOT;
		int _saveIndex;
		
		match('~');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BOR;
		int _saveIndex;
		
		match('|');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBOR_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BOR_ASSIGN;
		int _saveIndex;
		
		match("|=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBXOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BXOR;
		int _saveIndex;
		
		match('^');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBXOR_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BXOR_ASSIGN;
		int _saveIndex;
		
		match("^=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mComment(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Comment;
		int _saveIndex;
		
		match("/*");
		{
		_loop439:
		do {
			if (((LA(1)=='*') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && ((LA(3) >= '\u0000' && LA(3) <= '\u00ff')))&&( LA(2) != '/' )) {
				match('*');
			}
			else if ((LA(1)=='\r') && (LA(2)=='\n') && ((LA(3) >= '\u0000' && LA(3) <= '\u00ff'))) {
				match("\r\n");
				if ( inputState.guessing==0 ) {
					deferredNewline();
				}
			}
			else if ((LA(1)=='\n'||LA(1)=='\r') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && ((LA(3) >= '\u0000' && LA(3) <= '\u00ff'))) {
				{
				switch ( LA(1)) {
				case '\r':
				{
					match('\r');
					break;
				}
				case '\n':
				{
					match('\n');
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					deferredNewline();
				}
			}
			else if ((_tokenSet_15.member(LA(1)))) {
				{
				match(_tokenSet_15);
				}
			}
			else {
				break _loop439;
			}
			
		} while (true);
		}
		match("*/");
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;  
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCPPComment(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CPPComment;
		int _saveIndex;
		
		match("//");
		{
		_loop443:
		do {
			if ((_tokenSet_13.member(LA(1)))) {
				{
				match(_tokenSet_13);
				}
			}
			else {
				break _loop443;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			
			_ttype = Token.SKIP;
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNonWhitespace(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NonWhitespace;
		int _saveIndex;
		
		{
		_loop447:
		do {
			if ((_tokenSet_16.member(LA(1)))) {
				{
				match(_tokenSet_16);
				}
			}
			else {
				break _loop447;
			}
			
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPREPROC_DIRECTIVE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PREPROC_DIRECTIVE;
		int _saveIndex;
		Token i=null;
		Token n=null;
		Token nw=null;
		
		match('#');
		{
		boolean synPredMatched454 = false;
		if (((_tokenSet_17.member(LA(1))) && (_tokenSet_18.member(LA(2))) && (_tokenSet_19.member(LA(3))))) {
			int _m454 = mark();
			synPredMatched454 = true;
			inputState.guessing++;
			try {
				{
				switch ( LA(1)) {
				case 'l':
				{
					match("line");
					break;
				}
				case '\t':  case '\u000c':  case ' ':
				{
					{
					{
					int _cnt453=0;
					_loop453:
					do {
						switch ( LA(1)) {
						case ' ':
						{
							match(' ');
							break;
						}
						case '\t':
						{
							match('\t');
							break;
						}
						case '\u000c':
						{
							match('\014');
							break;
						}
						default:
						{
							if ( _cnt453>=1 ) { break _loop453; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
						}
						}
						_cnt453++;
					} while (true);
					}
					matchRange('0','9');
					}
					break;
				}
				default:
					{
					}
				}
				}
			}
			catch (RecognitionException pe) {
				synPredMatched454 = false;
			}
			rewind(_m454);
inputState.guessing--;
		}
		if ( synPredMatched454 ) {
			mLineDirective(false);
		}
		else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_21.member(LA(2))) && (_tokenSet_22.member(LA(3)))) {
			{
			{
			_loop457:
			do {
				if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ')) {
					mSpace(false);
				}
				else {
					break _loop457;
				}
				
			} while (true);
			}
			match("define");
			{
			_loop459:
			do {
				if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ')) {
					mSpace(false);
				}
				else {
					break _loop459;
				}
				
			} while (true);
			}
			mID(true);
			i=_returnToken;
			{
			_loop461:
			do {
				if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
					mSpace(false);
				}
				else {
					break _loop461;
				}
				
			} while (true);
			}
			{
			if ((_tokenSet_2.member(LA(1))) && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
				mDefineExpr(true);
				n=_returnToken;
			}
			else if (((LA(1) >= '\u0000' && LA(1) <= '\u00ff')) && (true) && (true)) {
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
			}
			mNonWhitespace(true);
			nw=_returnToken;
			{
			if ((LA(1)=='\r') && (LA(2)=='\n')) {
				match("\r\n");
			}
			else if ((LA(1)=='\r') && (true)) {
				match("\r");
			}
			else if ((LA(1)=='\n')) {
				match("\n");
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
			}
			}
			if ( inputState.guessing==0 ) {
				
				if (n != null) {
				// System.out.println("addDefine: #define " + i.getText() + " " +  n.getText()+" @ "+lineObject.getSource()+":"+(lineObject.line+deferredLineCount));
				addDefine(i.getText(), n.getText());
				} else {
				setPreprocessingDirective("#define " + i.getText() + " " + nw.getText());
				}
				deferredNewline();
				
			}
		}
		else {
			{
			_loop465:
			do {
				if ((_tokenSet_13.member(LA(1)))) {
					matchNot('\n');
				}
				else {
					break _loop465;
				}
				
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				setPreprocessingDirective(getText());
			}
		}
		
		}
		if ( inputState.guessing==0 ) {
			
			_ttype = Token.SKIP;
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLineDirective(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LineDirective;
		int _saveIndex;
		Token n=null;
		Token fn=null;
		Token fi=null;
		
		boolean oldCountingTokens = countingTokens;
		countingTokens = false;
		
		
		if ( inputState.guessing==0 ) {
			
			lineObject = new LineObject();
			deferredLineCount = 0;
			
		}
		{
		switch ( LA(1)) {
		case 'l':
		{
			match("line");
			break;
		}
		case '\t':  case '\u000c':  case ' ':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		int _cnt490=0;
		_loop490:
		do {
			if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ')) {
				mSpace(false);
			}
			else {
				if ( _cnt490>=1 ) { break _loop490; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt490++;
		} while (true);
		}
		mNumber(true);
		n=_returnToken;
		if ( inputState.guessing==0 ) {
			
			lineObject.setLine(Integer.parseInt(n.getText()));
			
		}
		{
		int _cnt492=0;
		_loop492:
		do {
			if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
				mSpace(false);
			}
			else {
				if ( _cnt492>=1 ) { break _loop492; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt492++;
		} while (true);
		}
		{
		if ((LA(1)=='"') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && ((LA(3) >= '\u0000' && LA(3) <= '\u00ff'))) {
			mStringLiteral(true);
			fn=_returnToken;
			if ( inputState.guessing==0 ) {
				try { 
				final String newSource = fn.getText().substring(1,fn.getText().length()-1);
				// System.out.println("line: "+lineObject.getSource()+" -> "+newSource+", line "+(lineObject.line+deferredLineCount));
				lineObject.setSource(newSource);
				} 
				catch (StringIndexOutOfBoundsException e) { /*not possible*/ } 
				
			}
		}
		else if ((_tokenSet_1.member(LA(1))) && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
			mID(true);
			fi=_returnToken;
			if ( inputState.guessing==0 ) {
				lineObject.setSource(fi.getText());
			}
		}
		else if (((LA(1) >= '\u0000' && LA(1) <= '\u00ff')) && (true) && (true)) {
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		{
		_loop495:
		do {
			if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
				mSpace(false);
			}
			else {
				break _loop495;
			}
			
		} while (true);
		}
		{
		if ((LA(1)=='1') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
			match("1");
			if ( inputState.guessing==0 ) {
				lineObject.setEnteringFile(true);
			}
		}
		else if (((LA(1) >= '\u0000' && LA(1) <= '\u00ff')) && (true) && (true)) {
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		{
		_loop498:
		do {
			if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
				mSpace(false);
			}
			else {
				break _loop498;
			}
			
		} while (true);
		}
		{
		if ((LA(1)=='2') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
			match("2");
			if ( inputState.guessing==0 ) {
				lineObject.setReturningToFile(true);
			}
		}
		else if (((LA(1) >= '\u0000' && LA(1) <= '\u00ff')) && (true) && (true)) {
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		{
		_loop501:
		do {
			if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
				mSpace(false);
			}
			else {
				break _loop501;
			}
			
		} while (true);
		}
		{
		if ((LA(1)=='3') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
			match("3");
			if ( inputState.guessing==0 ) {
				lineObject.setSystemHeader(true);
			}
		}
		else if (((LA(1) >= '\u0000' && LA(1) <= '\u00ff')) && (true) && (true)) {
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		{
		_loop504:
		do {
			if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
				mSpace(false);
			}
			else {
				break _loop504;
			}
			
		} while (true);
		}
		{
		if ((LA(1)=='4') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && (true)) {
			match("4");
			if ( inputState.guessing==0 ) {
				lineObject.setTreatAsC(true);
			}
		}
		else if (((LA(1) >= '\u0000' && LA(1) <= '\u00ff')) && (true) && (true)) {
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		{
		_loop508:
		do {
			if ((_tokenSet_16.member(LA(1)))) {
				{
				match(_tokenSet_16);
				}
			}
			else {
				break _loop508;
			}
			
		} while (true);
		}
		{
		if ((LA(1)=='\r') && (LA(2)=='\n')) {
			match("\r\n");
		}
		else if ((LA(1)=='\r') && (true)) {
			match("\r");
		}
		else if ((LA(1)=='\n')) {
			match("\n");
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		if ( inputState.guessing==0 ) {
			
			preprocessorInfoChannel.addLineForTokenNumber(new LineObject(lineObject), new Integer(tokenNumber));
			countingTokens = oldCountingTokens;
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSpace(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Space;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case ' ':
		{
			match(' ');
			break;
		}
		case '\t':
		{
			match('\t');
			break;
		}
		case '\u000c':
		{
			match('\014');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDefineExpr(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DefineExpr;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '(':
		{
			{
			{
			mLPAREN(false);
			}
			{
			_loop470:
			do {
				if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ')) {
					mSpace(false);
				}
				else {
					break _loop470;
				}
				
			} while (true);
			}
			{
			mDefineExpr2(false);
			}
			{
			_loop473:
			do {
				if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ')) {
					mSpace(false);
				}
				else {
					break _loop473;
				}
				
			} while (true);
			}
			{
			mRPAREN(false);
			}
			}
			break;
		}
		case '-':  case '.':  case '0':  case '1':
		case '2':  case '3':  case '4':  case '5':
		case '6':  case '7':  case '8':  case '9':
		{
			{
			mDefineExpr2(false);
			}
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDefineExpr2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DefineExpr2;
		int _saveIndex;
		
		{
		mNumber(false);
		}
		{
		if ((_tokenSet_23.member(LA(1))) && (_tokenSet_24.member(LA(2))) && (true)) {
			{
			_loop480:
			do {
				if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ')) {
					mSpace(false);
				}
				else {
					break _loop480;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case '<':
			{
				mLSHIFT(false);
				break;
			}
			case '>':
			{
				mRSHIFT(false);
				break;
			}
			case '+':
			{
				mPLUS(false);
				break;
			}
			case '-':
			{
				mMINUS(false);
				break;
			}
			case '*':
			{
				mSTAR(false);
				break;
			}
			case '/':
			{
				mDIV(false);
				break;
			}
			case '%':
			{
				mMOD(false);
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			{
			_loop483:
			do {
				if ((LA(1)=='\t'||LA(1)=='\u000c'||LA(1)==' ')) {
					mSpace(false);
				}
				else {
					break _loop483;
				}
				
			} while (true);
			}
			{
			mDefineExpr(false);
			}
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBadStringLiteral(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BadStringLiteral;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLongSuffix(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LongSuffix;
		int _saveIndex;
		
		switch ( LA(1)) {
		case 'l':
		{
			match('l');
			break;
		}
		case 'L':
		{
			match('L');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mUnsignedSuffix(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UnsignedSuffix;
		int _saveIndex;
		
		switch ( LA(1)) {
		case 'u':
		{
			match('u');
			break;
		}
		case 'U':
		{
			match('U');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mFloatSuffix(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = FloatSuffix;
		int _saveIndex;
		
		switch ( LA(1)) {
		case 'f':
		{
			match('f');
			break;
		}
		case 'F':
		{
			match('F');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDoubleDoubleConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DoubleDoubleConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mFloatDoubleConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = FloatDoubleConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLongDoubleConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LongDoubleConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIntOctalConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IntOctalConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLongOctalConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LongOctalConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mUnsignedOctalConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UnsignedOctalConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIntIntConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IntIntConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLongIntConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LongIntConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mUnsignedIntConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UnsignedIntConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIntHexConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IntHexConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLongHexConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LongHexConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mUnsignedHexConst(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UnsignedHexConst;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 288054454291267584L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 68719476736L, 576460745995190270L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 288055553802895360L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0]=-71776119061217281L;
		data[1]=-72057594037927937L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 287948901175001088L, 541165879422L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 0L, 9031388512654848L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 287984085547089920L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 288019269919178752L, 137438953504L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 287992881640112128L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 0L, 9031663390561856L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 287702610570379264L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 287949450930814976L, 541165879422L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = new long[8];
		data[0]=-549755813889L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = new long[8];
		data[0]=-1025L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = new long[8];
		data[0]=-17179878401L;
		data[1]=-268435457L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = new long[8];
		data[0]=-4398046520321L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = new long[8];
		data[0]=-9217L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { 4294971904L, 17592186044416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 288054458586239488L, 2199023255552L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 288054458586239488L, 81159763628398176L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 4294971904L, 68719476736L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 4294971904L, 206158430208L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = { 4294971904L, 481036337152L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = { 5764796780768137728L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = { 6052817150198944256L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	
	}
