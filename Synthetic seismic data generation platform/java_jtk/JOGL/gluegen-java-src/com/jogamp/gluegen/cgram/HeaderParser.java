// $ANTLR 2.7.7 (2006-11-01): "expandedHeaderParser.g" -> "HeaderParser.java"$

        package com.jogamp.gluegen.cgram;

        import java.io.*;
        import java.util.*;

        import antlr.CommonAST;
        import com.jogamp.gluegen.ASTLocusTag;
        import com.jogamp.gluegen.ConstantDefinition;
        import com.jogamp.gluegen.ConstantDefinition.CNumber;
        import com.jogamp.gluegen.GlueGenException;
        import com.jogamp.gluegen.JavaConfiguration;
        import com.jogamp.gluegen.cgram.types.*;
        import com.jogamp.gluegen.cgram.types.EnumType;
        import com.jogamp.gluegen.cgram.types.EnumType.Enumerator;

import antlr.TreeParser;
import antlr.Token;
import antlr.collections.AST;
import antlr.RecognitionException;
import antlr.ANTLRException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;


public class HeaderParser extends antlr.TreeParser       implements HeaderParserTokenTypes
 {

    /** Name assigned to a anonymous EnumType (e.g., "enum { ... }"). */
    public static final String ANONYMOUS_ENUM_NAME = "<anonymous>";

    boolean debug = false;

    public boolean getDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /** Set the configuration for this
        HeaderParser. Must be done before parsing. */
    public void setJavaConfiguration(JavaConfiguration cfg) {
        this.cfg = cfg;
    }

    /** Set the dictionary mapping typedef names to types for this
        HeaderParser. Must be done before parsing. */
    public void setTypedefDictionary(TypeDictionary dict) {
        this.typedefDictionary = dict;
    }

    /** Returns the typedef dictionary this HeaderParser uses. */
    public TypeDictionary getTypedefDictionary() {
        return typedefDictionary;
    }    
    
    /** Set the dictionary mapping struct names (i.e., the "foo" in
        "struct foo { ... };") to types for this HeaderParser. Must be done
        before parsing. */
    public void setStructDictionary(TypeDictionary dict) {
        this.structDictionary = dict;
    }

    /** Returns the struct name dictionary this HeaderParser uses. */
    public TypeDictionary getStructDictionary() {
        return structDictionary;
    }    
    
    /** Get the canonicalization map, which is a regular HashMap
        mapping Type to Type and which is used for looking up the unique
        instances of e.g. pointer-to-structure types that have been typedefed
        and therefore have names. */
    public Map getCanonMap() {
        return canonMap;
    }

    /** Pre-define the list of EnumTypes for this HeaderParser. Must be
                done before parsing. */
    public void setEnums(List<EnumType> enumTypes) {
        // FIXME: Need to take the input set of EnumTypes, extract all
        // the enumerates from each EnumType, and fill in the enumHash
        // so that each enumerate maps to the enumType to which it
        // belongs.
        throw new RuntimeException("setEnums is Unimplemented!");
    }

    /** Returns the EnumTypes this HeaderParser processed. */
    public List<EnumType> getEnums() {
        return new ArrayList<EnumType>(enumHash.values());
    }    
    
    /** Clears the list of functions this HeaderParser has parsed.
        Useful when reusing the same HeaderParser for more than one
        header file. */
    public void clearParsedFunctions() {
        functions.clear();
    }

    /** Returns the list of FunctionSymbols this HeaderParser has parsed. */
    public List<FunctionSymbol> getParsedFunctions() {
        return functions;
    }

    private CompoundType lookupInStructDictionary(String structName,
                                                  CompoundTypeKind kind,
                                                  int cvAttrs, final ASTLocusTag locusTag) 
    {
        CompoundType t = (CompoundType) structDictionary.get(structName);
        if (t == null) {
            t = CompoundType.create(structName, null, kind, cvAttrs, locusTag);
            structDictionary.put(structName, t);
            debugPrintln("Adding compound mapping: [" + structName + "] -> "+getDebugTypeString(t)+" @ "+locusTag);
            debugPrintln(t.getStructString());
        }
        return t;
    }

    private Type lookupInTypedefDictionary(final AST _t, String typeName) {
        Type t = typedefDictionary.get(typeName);
        if (t == null) {
            throwGlueGenException(_t,
                 "Undefined reference to typedef name " + typeName);
        }
        return t;
    }

    static class ParameterDeclaration {
        private String id;
        private Type   type;

        ParameterDeclaration(String id, Type type) {
            this.id = id;
            this.type = type;
        }
        String id()              { return id; }
        Type   type()            { return type; }
        void setType(final Type t) { type = t; }
        public String toString() { return "ParamDecl["+id+": "+type.getDebugString()+"]"; }
    }

    // A box for a Type. Allows type to be passed down to be modified by recursive rules.
    static class TypeBox {
        private Type origType;
        private Type type;
        private boolean isTypedef;

        TypeBox(Type type) {
            this(type, false);
        }

        TypeBox(Type type, boolean isTypedef) {
            this.origType = type;
            this.isTypedef = isTypedef;
        }

        Type type() {
            if (type == null) {
                return origType;
            }
            return type;
        }
        void setType(Type type) {
            this.type = type;
        }
        void reset() {
            type = null;
        }

        boolean isTypedef()     { return isTypedef; }

            // for easier debugging
            public String toString() { 
               String tStr = "Type=NULL_REF";
               if (type == origType) {
                         tStr = "Type=ORIG_TYPE";
                     } else if (type != null) {
                     tStr = "Type: name=\"" + type.getCVAttributesString() + " " + 
                    type.getName() + "\"; signature=\"" + type + "\"; class " + 
                                        type.getClass().getName();
               }
               String oStr = "OrigType=NULL_REF";
               if (origType != null) {
                     oStr = "OrigType: name=\"" + origType.getCVAttributesString() + " " + 
             origType.getName() + "\"; signature=\"" + origType + "\"; class " + 
                        origType.getClass().getName();
               }
               return "<["+tStr + "] [" + oStr + "] " + " isTypedef=" + isTypedef+">"; 
            }
    }

    private String getDebugTypeString(Type t) {
      if(debug) {
        return getTypeString(t);
      } else {
        return null;
      }
    }
    private String getTypeString(Type t) {
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      if(null!=t) {
        sb.append(t.getDebugString());
        sb.append(", opaque ").append(isOpaque(t)).append("]");
      } else {
        sb.append("nil]");
      }
      return sb.toString();
    }
    private boolean isOpaque(final Type type) {
      return (cfg.typeInfo(type) != null);
    }

    private void debugPrintln(String msg) {
        if(debug) {
            System.err.println(msg);
        }
    }

    private void debugPrint(String msg) {
        if(debug) {
            System.err.print(msg);
        }
    }

    private JavaConfiguration cfg;
    private TypeDictionary typedefDictionary;
    private TypeDictionary structDictionary;
    private List<FunctionSymbol> functions = new ArrayList<FunctionSymbol>();
    // hash from name of an enumerated value to the EnumType to which it belongs
    private HashMap<String, EnumType> enumHash = new HashMap<String, EnumType>();
    private HashMap<String, EnumType> enumMap = new HashMap<String, EnumType>();

    // Storage class specifiers
    private static final int AUTO     = 1 << 0;
    private static final int REGISTER = 1 << 1;
    private static final int TYPEDEF  = 1 << 2;
    // Function storage class specifiers
    private static final int EXTERN   = 1 << 3;
    private static final int STATIC   = 1 << 4;
    private static final int INLINE   = 1 << 5;
    // Type qualifiers
    private static final int CONST    = 1 << 6;
    private static final int VOLATILE = 1 << 7;
    private static final int SIGNED   = 1 << 8;
    private static final int UNSIGNED = 1 << 9;

    private boolean isFuncDeclaration;   // Used to only process function typedefs
    private String  funcDeclName;
    private List<ParameterDeclaration> funcDeclParams;
    private ASTLocusTag funcLocusTag;

    private void resetFuncDeclaration() {
        isFuncDeclaration = false;
        funcDeclName = null;
        funcDeclParams = null;
        funcLocusTag = null;
    }
    private void setFuncDeclaration(final String name, final List<ParameterDeclaration> p, final ASTLocusTag locusTag) {
        isFuncDeclaration = true;
        funcDeclName = name;
        funcDeclParams = p;
        funcLocusTag = locusTag;
    }

    private void processDeclaration(Type returnType) {
        if (isFuncDeclaration) {
            final FunctionSymbol sym = new FunctionSymbol(funcDeclName, 
                                                          new FunctionType(null, null, returnType, 0, funcLocusTag),
                                                          funcLocusTag);
            debugPrintln("Function ... "+sym.toString()+" @ "+funcLocusTag);
            if (funcDeclParams != null) { // handle funcs w/ empty parameter lists (e.g., "foo()")
                for (Iterator<ParameterDeclaration> iter = funcDeclParams.iterator(); iter.hasNext(); ) {
                    ParameterDeclaration pd = iter.next();
                    pd.setType(pd.type());
                    debugPrintln(" add "+pd.toString());
                    sym.addArgument(pd.type(), pd.id());
                }
            }
            debugPrintln("Function Added "+sym.toString());
            functions.add(sym);
            resetFuncDeclaration();
        }
    }

    private int attrs2CVAttrs(int attrs) {
        int cvAttrs = 0;
        if ((attrs & CONST) != 0) {
            cvAttrs |= CVAttributes.CONST;
        }
        if ((attrs & VOLATILE) != 0) {
            cvAttrs |= CVAttributes.VOLATILE;
        }
        return cvAttrs;
    }

    /** Helper routine which handles creating a pointer or array type
        for [] expressions */
    private void handleArrayExpr(TypeBox tb, AST t, ASTLocusTag locusTag) {
        if (t != null) {
            try {
                final int len = parseIntConstExpr(t);
                tb.setType(canonicalize(new ArrayType(tb.type(), SizeThunk.mul(SizeThunk.constant(len), tb.type().getSize()), len, 0, locusTag)));
                return;
            } catch (RecognitionException e) {
                // Fall through
            }
        }
        tb.setType(canonicalize(new PointerType(SizeThunk.POINTER,
                                                tb.type(), 0, locusTag)));
    }

    private int parseIntConstExpr(AST t) throws RecognitionException {
        return intConstExpr(t);
    }

  /** Utility function: creates a new EnumType with the given name, or
          returns an existing one if it has already been created. */
    private EnumType getEnumType(String enumTypeName, ASTLocusTag locusTag) {
        EnumType enumType = null;
        Iterator<EnumType> it = enumHash.values().iterator(); 
        while (it.hasNext()) {
          EnumType potentialMatch = it.next();
          if (potentialMatch.getName().equals(enumTypeName)) {
              enumType = potentialMatch;
              break;        
          }
        }
        
        if (enumType == null) {
          // This isn't quite correct. In theory the enum should expand to
          // the size of the largest element, so if there were a long long
          // entry the enum should expand to e.g. int64. However, using
          // "long" here (which is what used to be the case) was 
          // definitely incorrect and caused problems.
          enumType = new EnumType(enumTypeName, SizeThunk.INT32, locusTag);
        }  
        
        return enumType;
    }        
  
  // Map used to canonicalize types. For example, we may typedef
  // struct foo { ... } *pfoo; subsequent references to struct foo* should
  // point to the same PointerType object that had its name set to "pfoo".
  // Opaque canonical types are excluded.
  private Map<Type, Type> canonMap = new HashMap<Type, Type>();
  private Type canonicalize(Type t) {
    Type res = (Type) canonMap.get(t);
    if (res != null) {
      return res;
    } else {
      canonMap.put(t, t);
      return t;
    }
  }

  private void throwGlueGenException(final AST t, final String message) throws GlueGenException {
    // dumpASTTree("XXX", t);
    throw new GlueGenException(message, findASTLocusTag(t));
  }
  private void throwGlueGenException(final ASTLocusTag locusTag, final String message) throws GlueGenException {
    // dumpASTTree("XXX", t);
    throw new GlueGenException(message, locusTag);
  }

  /**
   * Return ASTLocusTag in tree, or null if not found.
   */
  private ASTLocusTag findASTLocusTag(final AST astIn) {
    AST ast = astIn;
    while(null != ast) {
        if( ast instanceof TNode ) {
            final TNode tn = (TNode) ast;
            final ASTLocusTag tag = tn.getASTLocusTag();
            if( null != tag ) {
                return tag;
            }
        }
        ast = ast.getFirstChild();
    }
    return null;
  }
  private void dumpASTTree(final String pre, final AST t) {
    int i=0;
    AST it = t;
    while( null != it ) {
        it = dumpAST(pre+"."+i, it);
        i++;
    }
  }
  private AST dumpAST(final String pre, final AST ast) {
    if( null == ast ) {
        System.err.println(pre+".0: AST NULL");
        return null;
    } else {
        System.err.println(pre+".0: AST Type: "+ast.getClass().getName());
        System.err.println(pre+".1: line:col "+ast.getLine()+":"+ast.getColumn()+" -> "+ast.getText());
        if( ast instanceof TNode ) {
            final TNode tn = (TNode) ast;
            final ASTLocusTag tag = tn.getASTLocusTag();
            System.err.println(pre+".TN.1: "+tag);
            final Hashtable<String, Object> attributes = tn.getAttributesTable();
            System.err.println(pre+".TN.2: "+attributes);
        }
        return ast.getFirstChild();
    }
  }
public HeaderParser() {
	tokenNames = _tokenNames;
}

	public final String  declarator(AST _t,
		TypeBox tb
	) throws RecognitionException {
		String s;
		
		TNode declarator_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		TNode id = null;
		TNode e = null;
		
		resetFuncDeclaration();
		s = null;
		List<ParameterDeclaration> params = null;
		String funcPointerName = null;
		TypeBox dummyTypeBox = null;
		final ASTLocusTag locusTag = findASTLocusTag(declarator_AST_in);
		
		
		try {      // for error handling
			AST __t2 = _t;
			TNode tmp1_AST_in = (TNode)_t;
			match(_t,NDeclarator);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case NPointerGroup:
			{
				pointerGroup(_t,tb);
				_t = _retTree;
				break;
			}
			case ID:
			case LPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			{
				id = (TNode)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					s = id.getText();
				}
				break;
			}
			case LPAREN:
			{
				TNode tmp2_AST_in = (TNode)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				funcPointerName=declarator(_t,dummyTypeBox);
				_t = _retTree;
				TNode tmp3_AST_in = (TNode)_t;
				match(_t,RPAREN);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			_loop10:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case NParameterTypeList:
				{
					AST __t6 = _t;
					TNode tmp4_AST_in = (TNode)_t;
					match(_t,NParameterTypeList);
					_t = _t.getFirstChild();
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case NParameterDeclaration:
					{
						params=parameterTypeList(_t);
						_t = _retTree;
						break;
					}
					case ID:
					case RPAREN:
					{
						{
						if (_t==null) _t=ASTNULL;
						switch ( _t.getType()) {
						case ID:
						{
							idList(_t);
							_t = _retTree;
							break;
						}
						case RPAREN:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(_t);
						}
						}
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
					TNode tmp5_AST_in = (TNode)_t;
					match(_t,RPAREN);
					_t = _t.getNextSibling();
					_t = __t6;
					_t = _t.getNextSibling();
					if ( inputState.guessing==0 ) {
						
						if (id != null) {
						setFuncDeclaration(id.getText(), params, locusTag);
						} else if ( funcPointerName != null ) {
						/* TypeBox becomes function pointer in this case */
						final FunctionType ft = new FunctionType(null, null, tb.type(), 0, locusTag);
						if (params == null) {
						// If the function pointer has no declared parameters, it's a 
						// void function. I'm not sure if the parameter name is 
						// ever referenced anywhere when the type is VoidType, so
						// just in case I'll set it to a comment string so it will
						// still compile if written out to code anywhere.
						ft.addArgument(new VoidType(0, locusTag), "/*unnamed-void*/");
						} else {
						for (Iterator iter = params.iterator(); iter.hasNext(); ) {
						ParameterDeclaration pd = (ParameterDeclaration) iter.next();
						ft.addArgument(pd.type(), pd.id());
						}
						}
						tb.setType(canonicalize(new PointerType(SizeThunk.POINTER,
						ft, 0, locusTag)));
						s = funcPointerName;
						}
						
					}
					break;
				}
				case LBRACKET:
				{
					TNode tmp6_AST_in = (TNode)_t;
					match(_t,LBRACKET);
					_t = _t.getNextSibling();
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case ID:
					case ASSIGN:
					case STAR:
					case LPAREN:
					case DIV_ASSIGN:
					case PLUS_ASSIGN:
					case MINUS_ASSIGN:
					case STAR_ASSIGN:
					case MOD_ASSIGN:
					case RSHIFT_ASSIGN:
					case LSHIFT_ASSIGN:
					case BAND_ASSIGN:
					case BOR_ASSIGN:
					case BXOR_ASSIGN:
					case QUESTION:
					case LOR:
					case LAND:
					case BOR:
					case BXOR:
					case BAND:
					case EQUAL:
					case NOT_EQUAL:
					case LT:
					case LTE:
					case GT:
					case GTE:
					case LSHIFT:
					case RSHIFT:
					case PLUS:
					case MINUS:
					case DIV:
					case MOD:
					case INC:
					case DEC:
					case LITERAL_sizeof:
					case CharLiteral:
					case NCast:
					case NExpressionGroup:
					case NInitializer:
					case NEmptyExpression:
					case NCommaExpr:
					case NUnaryExpr:
					case NPostfixExpr:
					case NRangeExpr:
					case NStringSeq:
					case NLcurlyInitializer:
					case NGnuAsmExpr:
					case Number:
					case LITERAL___alignof:
					{
						e = _t==ASTNULL ? null : (TNode)_t;
						expr(_t);
						_t = _retTree;
						break;
					}
					case RBRACKET:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
					TNode tmp7_AST_in = (TNode)_t;
					match(_t,RBRACKET);
					_t = _t.getNextSibling();
					if ( inputState.guessing==0 ) {
						handleArrayExpr(tb, e, locusTag);
					}
					break;
				}
				default:
				{
					break _loop10;
				}
				}
			} while (true);
			}
			_t = __t2;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return s;
	}
	
	public final void pointerGroup(AST _t,
		TypeBox tb
	) throws RecognitionException {
		
		TNode pointerGroup_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		int x = 0; int y = 0;
		
		try {      // for error handling
			AST __t93 = _t;
			TNode tmp8_AST_in = (TNode)_t;
			match(_t,NPointerGroup);
			_t = _t.getFirstChild();
			{
			int _cnt97=0;
			_loop97:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==STAR)) {
					TNode tmp9_AST_in = (TNode)_t;
					match(_t,STAR);
					_t = _t.getNextSibling();
					if ( inputState.guessing==0 ) {
						x = 0; y = 0;
					}
					{
					_loop96:
					do {
						if (_t==null) _t=ASTNULL;
						if ((_tokenSet_0.member(_t.getType()))) {
							y=typeQualifier(_t);
							_t = _retTree;
							if ( inputState.guessing==0 ) {
								x |= y;
							}
						}
						else {
							break _loop96;
						}
						
					} while (true);
					}
					if ( inputState.guessing==0 ) {
						
						debugPrintln("IN PTR GROUP: TB=" + tb);
						if (tb != null) {
						tb.setType(canonicalize(new PointerType(SizeThunk.POINTER,
						tb.type(),
						attrs2CVAttrs(x), 
						findASTLocusTag(pointerGroup_AST_in))));
						}
						
					}
				}
				else {
					if ( _cnt97>=1 ) { break _loop97; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt97++;
			} while (true);
			}
			_t = __t93;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final List<ParameterDeclaration>  parameterTypeList(AST _t) throws RecognitionException {
		List<ParameterDeclaration> l;
		
		TNode parameterTypeList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		l = new ArrayList<ParameterDeclaration>(); ParameterDeclaration decl = null;
		
		try {      // for error handling
			{
			int _cnt21=0;
			_loop21:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==NParameterDeclaration)) {
					decl=parameterDeclaration(_t);
					_t = _retTree;
					if ( inputState.guessing==0 ) {
						if (decl != null) { l.add(decl); }
					}
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case COMMA:
					{
						TNode tmp10_AST_in = (TNode)_t;
						match(_t,COMMA);
						_t = _t.getNextSibling();
						break;
					}
					case SEMI:
					{
						TNode tmp11_AST_in = (TNode)_t;
						match(_t,SEMI);
						_t = _t.getNextSibling();
						break;
					}
					case RPAREN:
					case VARARGS:
					case NParameterDeclaration:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
				}
				else {
					if ( _cnt21>=1 ) { break _loop21; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt21++;
			} while (true);
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case VARARGS:
			{
				TNode tmp12_AST_in = (TNode)_t;
				match(_t,VARARGS);
				_t = _t.getNextSibling();
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return l;
	}
	
	public final void idList(AST _t) throws RecognitionException {
		
		TNode idList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			TNode tmp13_AST_in = (TNode)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			{
			_loop137:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==COMMA)) {
					TNode tmp14_AST_in = (TNode)_t;
					match(_t,COMMA);
					_t = _t.getNextSibling();
					TNode tmp15_AST_in = (TNode)_t;
					match(_t,ID);
					_t = _t.getNextSibling();
				}
				else {
					break _loop137;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void expr(AST _t) throws RecognitionException {
		
		TNode expr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ASSIGN:
			case DIV_ASSIGN:
			case PLUS_ASSIGN:
			case MINUS_ASSIGN:
			case STAR_ASSIGN:
			case MOD_ASSIGN:
			case RSHIFT_ASSIGN:
			case LSHIFT_ASSIGN:
			case BAND_ASSIGN:
			case BOR_ASSIGN:
			case BXOR_ASSIGN:
			{
				assignExpr(_t);
				_t = _retTree;
				break;
			}
			case QUESTION:
			{
				conditionalExpr(_t);
				_t = _retTree;
				break;
			}
			case LOR:
			{
				logicalOrExpr(_t);
				_t = _retTree;
				break;
			}
			case LAND:
			{
				logicalAndExpr(_t);
				_t = _retTree;
				break;
			}
			case BOR:
			{
				inclusiveOrExpr(_t);
				_t = _retTree;
				break;
			}
			case BXOR:
			{
				exclusiveOrExpr(_t);
				_t = _retTree;
				break;
			}
			case BAND:
			{
				bitAndExpr(_t);
				_t = _retTree;
				break;
			}
			case EQUAL:
			case NOT_EQUAL:
			{
				equalityExpr(_t);
				_t = _retTree;
				break;
			}
			case LT:
			case LTE:
			case GT:
			case GTE:
			{
				relationalExpr(_t);
				_t = _retTree;
				break;
			}
			case LSHIFT:
			case RSHIFT:
			{
				shiftExpr(_t);
				_t = _retTree;
				break;
			}
			case PLUS:
			case MINUS:
			{
				additiveExpr(_t);
				_t = _retTree;
				break;
			}
			case STAR:
			case DIV:
			case MOD:
			{
				multExpr(_t);
				_t = _retTree;
				break;
			}
			case NCast:
			{
				castExpr(_t);
				_t = _retTree;
				break;
			}
			case INC:
			case DEC:
			case LITERAL_sizeof:
			case NUnaryExpr:
			case LITERAL___alignof:
			{
				unaryExpr(_t);
				_t = _retTree;
				break;
			}
			case NPostfixExpr:
			{
				postfixExpr(_t);
				_t = _retTree;
				break;
			}
			case ID:
			case CharLiteral:
			case NExpressionGroup:
			case NStringSeq:
			case Number:
			{
				primaryExpr(_t);
				_t = _retTree;
				break;
			}
			case NCommaExpr:
			{
				commaExpr(_t);
				_t = _retTree;
				break;
			}
			case NEmptyExpression:
			{
				emptyExpr(_t);
				_t = _retTree;
				break;
			}
			case LPAREN:
			{
				compoundStatementExpr(_t);
				_t = _retTree;
				break;
			}
			case NInitializer:
			case NLcurlyInitializer:
			{
				initializer(_t);
				_t = _retTree;
				break;
			}
			case NRangeExpr:
			{
				rangeExpr(_t);
				_t = _retTree;
				break;
			}
			case NGnuAsmExpr:
			{
				gnuAsmExpr(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void typelessDeclaration(AST _t) throws RecognitionException {
		
		TNode typelessDeclaration_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		TypeBox tb = null;
		
		
		try {      // for error handling
			AST __t12 = _t;
			TNode tmp16_AST_in = (TNode)_t;
			match(_t,NTypeMissing);
			_t = _t.getFirstChild();
			initDeclList(_t,tb);
			_t = _retTree;
			TNode tmp17_AST_in = (TNode)_t;
			match(_t,SEMI);
			_t = _t.getNextSibling();
			_t = __t12;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void initDeclList(AST _t,
		TypeBox tb
	) throws RecognitionException {
		
		TNode initDeclList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			{
			int _cnt86=0;
			_loop86:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==NInitDecl)) {
					initDecl(_t,tb);
					_t = _retTree;
				}
				else {
					if ( _cnt86>=1 ) { break _loop86; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt86++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void declaration(AST _t) throws RecognitionException {
		
		TNode declaration_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		TypeBox tb = null;
		
		
		try {      // for error handling
			AST __t14 = _t;
			TNode tmp18_AST_in = (TNode)_t;
			match(_t,NDeclaration);
			_t = _t.getFirstChild();
			tb=declSpecifiers(_t);
			_t = _retTree;
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case NInitDecl:
			{
				initDeclList(_t,tb);
				_t = _retTree;
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			int _cnt17=0;
			_loop17:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==SEMI)) {
					TNode tmp19_AST_in = (TNode)_t;
					match(_t,SEMI);
					_t = _t.getNextSibling();
				}
				else {
					if ( _cnt17>=1 ) { break _loop17; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt17++;
			} while (true);
			}
			_t = __t14;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				processDeclaration(tb.type());
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final TypeBox  declSpecifiers(AST _t) throws RecognitionException {
		TypeBox tb;
		
		TNode declSpecifiers_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		tb = null;
		Type t = null;
		int x = 0;
		int y = 0; 
		
		
		try {      // for error handling
			{
			int _cnt33=0;
			_loop33:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case LITERAL_typedef:
				case LITERAL_auto:
				case LITERAL_register:
				case LITERAL_extern:
				case LITERAL_static:
				case LITERAL_inline:
				{
					y=storageClassSpecifier(_t);
					_t = _retTree;
					if ( inputState.guessing==0 ) {
						x |= y;
					}
					break;
				}
				case LITERAL_volatile:
				case LITERAL_const:
				case LITERAL_signed:
				case LITERAL_unsigned:
				{
					y=typeQualifier(_t);
					_t = _retTree;
					if ( inputState.guessing==0 ) {
						x |= y;
					}
					break;
				}
				case LITERAL_struct:
				case LITERAL_union:
				case LITERAL_enum:
				case LITERAL_void:
				case LITERAL_char:
				case LITERAL_short:
				case LITERAL_int:
				case LITERAL_long:
				case LITERAL_float:
				case LITERAL_double:
				case 27:
				case 28:
				case 29:
				case 30:
				case 31:
				case 32:
				case LITERAL_wchar_t:
				case 34:
				case 35:
				case 36:
				case 37:
				case LITERAL_ptrdiff_t:
				case LITERAL_intptr_t:
				case LITERAL_size_t:
				case LITERAL_uintptr_t:
				case NTypedefName:
				case LITERAL_typeof:
				case LITERAL___complex:
				{
					t=typeSpecifier(_t,x);
					_t = _retTree;
					break;
				}
				default:
				{
					if ( _cnt33>=1 ) { break _loop33; } else {throw new NoViableAltException(_t);}
				}
				}
				_cnt33++;
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				
				if (t == null &&
				(x & (SIGNED | UNSIGNED)) != 0) {
				t = new IntType("int", SizeThunk.INTxx, 
				((x & UNSIGNED) != 0), 
				attrs2CVAttrs(x),
				findASTLocusTag(declSpecifiers_AST_in));
				}
				tb = new TypeBox(t, ((x & TYPEDEF) != 0));
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return tb;
	}
	
	public final ParameterDeclaration  parameterDeclaration(AST _t) throws RecognitionException {
		ParameterDeclaration pd;
		
		TNode parameterDeclaration_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		Type t = null;
		String decl = null;
		pd = null;
		TypeBox tb = null;
		
		
		try {      // for error handling
			AST __t24 = _t;
			TNode tmp20_AST_in = (TNode)_t;
			match(_t,NParameterDeclaration);
			_t = _t.getFirstChild();
			tb=declSpecifiers(_t);
			_t = _retTree;
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case NDeclarator:
			{
				decl=declarator(_t,tb);
				_t = _retTree;
				break;
			}
			case NNonemptyAbstractDeclarator:
			{
				nonemptyAbstractDeclarator(_t,tb);
				_t = _retTree;
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t24;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				
				if( null == tb ) {
				throwGlueGenException(parameterDeclaration_AST_in,
				String.format("Undefined type for declaration '%s'", decl));
				}
				pd = new ParameterDeclaration(decl, tb.type()); 
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return pd;
	}
	
	public final void nonemptyAbstractDeclarator(AST _t,
		TypeBox tb
	) throws RecognitionException {
		
		TNode nonemptyAbstractDeclarator_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		TNode e1 = null;
		TNode e2 = null;
		
		final ASTLocusTag locusTag = findASTLocusTag(nonemptyAbstractDeclarator_AST_in);
		
		
		try {      // for error handling
			AST __t104 = _t;
			TNode tmp21_AST_in = (TNode)_t;
			match(_t,NNonemptyAbstractDeclarator);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case NPointerGroup:
			{
				pointerGroup(_t,tb);
				_t = _retTree;
				{
				_loop111:
				do {
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case LPAREN:
					{
						{
						TNode tmp22_AST_in = (TNode)_t;
						match(_t,LPAREN);
						_t = _t.getNextSibling();
						{
						if (_t==null) _t=ASTNULL;
						switch ( _t.getType()) {
						case NNonemptyAbstractDeclarator:
						{
							nonemptyAbstractDeclarator(_t,tb);
							_t = _retTree;
							break;
						}
						case NParameterDeclaration:
						{
							parameterTypeList(_t);
							_t = _retTree;
							break;
						}
						case RPAREN:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(_t);
						}
						}
						}
						TNode tmp23_AST_in = (TNode)_t;
						match(_t,RPAREN);
						_t = _t.getNextSibling();
						}
						break;
					}
					case LBRACKET:
					{
						{
						TNode tmp24_AST_in = (TNode)_t;
						match(_t,LBRACKET);
						_t = _t.getNextSibling();
						{
						if (_t==null) _t=ASTNULL;
						switch ( _t.getType()) {
						case ID:
						case ASSIGN:
						case STAR:
						case LPAREN:
						case DIV_ASSIGN:
						case PLUS_ASSIGN:
						case MINUS_ASSIGN:
						case STAR_ASSIGN:
						case MOD_ASSIGN:
						case RSHIFT_ASSIGN:
						case LSHIFT_ASSIGN:
						case BAND_ASSIGN:
						case BOR_ASSIGN:
						case BXOR_ASSIGN:
						case QUESTION:
						case LOR:
						case LAND:
						case BOR:
						case BXOR:
						case BAND:
						case EQUAL:
						case NOT_EQUAL:
						case LT:
						case LTE:
						case GT:
						case GTE:
						case LSHIFT:
						case RSHIFT:
						case PLUS:
						case MINUS:
						case DIV:
						case MOD:
						case INC:
						case DEC:
						case LITERAL_sizeof:
						case CharLiteral:
						case NCast:
						case NExpressionGroup:
						case NInitializer:
						case NEmptyExpression:
						case NCommaExpr:
						case NUnaryExpr:
						case NPostfixExpr:
						case NRangeExpr:
						case NStringSeq:
						case NLcurlyInitializer:
						case NGnuAsmExpr:
						case Number:
						case LITERAL___alignof:
						{
							e1 = _t==ASTNULL ? null : (TNode)_t;
							expr(_t);
							_t = _retTree;
							break;
						}
						case RBRACKET:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(_t);
						}
						}
						}
						TNode tmp25_AST_in = (TNode)_t;
						match(_t,RBRACKET);
						_t = _t.getNextSibling();
						}
						if ( inputState.guessing==0 ) {
							handleArrayExpr(tb, e1, locusTag);
						}
						break;
					}
					default:
					{
						break _loop111;
					}
					}
				} while (true);
				}
				break;
			}
			case LPAREN:
			case LBRACKET:
			{
				{
				int _cnt117=0;
				_loop117:
				do {
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case LPAREN:
					{
						{
						TNode tmp26_AST_in = (TNode)_t;
						match(_t,LPAREN);
						_t = _t.getNextSibling();
						{
						if (_t==null) _t=ASTNULL;
						switch ( _t.getType()) {
						case NNonemptyAbstractDeclarator:
						{
							nonemptyAbstractDeclarator(_t,tb);
							_t = _retTree;
							break;
						}
						case NParameterDeclaration:
						{
							parameterTypeList(_t);
							_t = _retTree;
							break;
						}
						case RPAREN:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(_t);
						}
						}
						}
						TNode tmp27_AST_in = (TNode)_t;
						match(_t,RPAREN);
						_t = _t.getNextSibling();
						}
						break;
					}
					case LBRACKET:
					{
						{
						TNode tmp28_AST_in = (TNode)_t;
						match(_t,LBRACKET);
						_t = _t.getNextSibling();
						{
						if (_t==null) _t=ASTNULL;
						switch ( _t.getType()) {
						case ID:
						case ASSIGN:
						case STAR:
						case LPAREN:
						case DIV_ASSIGN:
						case PLUS_ASSIGN:
						case MINUS_ASSIGN:
						case STAR_ASSIGN:
						case MOD_ASSIGN:
						case RSHIFT_ASSIGN:
						case LSHIFT_ASSIGN:
						case BAND_ASSIGN:
						case BOR_ASSIGN:
						case BXOR_ASSIGN:
						case QUESTION:
						case LOR:
						case LAND:
						case BOR:
						case BXOR:
						case BAND:
						case EQUAL:
						case NOT_EQUAL:
						case LT:
						case LTE:
						case GT:
						case GTE:
						case LSHIFT:
						case RSHIFT:
						case PLUS:
						case MINUS:
						case DIV:
						case MOD:
						case INC:
						case DEC:
						case LITERAL_sizeof:
						case CharLiteral:
						case NCast:
						case NExpressionGroup:
						case NInitializer:
						case NEmptyExpression:
						case NCommaExpr:
						case NUnaryExpr:
						case NPostfixExpr:
						case NRangeExpr:
						case NStringSeq:
						case NLcurlyInitializer:
						case NGnuAsmExpr:
						case Number:
						case LITERAL___alignof:
						{
							e2 = _t==ASTNULL ? null : (TNode)_t;
							expr(_t);
							_t = _retTree;
							break;
						}
						case RBRACKET:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(_t);
						}
						}
						}
						TNode tmp29_AST_in = (TNode)_t;
						match(_t,RBRACKET);
						_t = _t.getNextSibling();
						}
						if ( inputState.guessing==0 ) {
							handleArrayExpr(tb, e2, locusTag);
						}
						break;
					}
					default:
					{
						if ( _cnt117>=1 ) { break _loop117; } else {throw new NoViableAltException(_t);}
					}
					}
					_cnt117++;
				} while (true);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t104;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void functionDef(AST _t) throws RecognitionException {
		
		TNode functionDef_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		TypeBox tb = null;
		
		
		try {      // for error handling
			AST __t27 = _t;
			TNode tmp30_AST_in = (TNode)_t;
			match(_t,NFunctionDef);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_volatile:
			case LITERAL_struct:
			case LITERAL_union:
			case LITERAL_enum:
			case LITERAL_extern:
			case LITERAL_static:
			case LITERAL_const:
			case LITERAL_void:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_long:
			case LITERAL_float:
			case LITERAL_double:
			case LITERAL_signed:
			case LITERAL_unsigned:
			case 27:
			case 28:
			case 29:
			case 30:
			case 31:
			case 32:
			case LITERAL_wchar_t:
			case 34:
			case 35:
			case 36:
			case 37:
			case LITERAL_ptrdiff_t:
			case LITERAL_intptr_t:
			case LITERAL_size_t:
			case LITERAL_uintptr_t:
			case NTypedefName:
			case LITERAL_inline:
			case LITERAL_typeof:
			case LITERAL___complex:
			{
				functionDeclSpecifiers(_t);
				_t = _retTree;
				break;
			}
			case NDeclarator:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			declarator(_t,tb);
			_t = _retTree;
			{
			_loop30:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case NDeclaration:
				{
					declaration(_t);
					_t = _retTree;
					break;
				}
				case VARARGS:
				{
					TNode tmp31_AST_in = (TNode)_t;
					match(_t,VARARGS);
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					break _loop30;
				}
				}
			} while (true);
			}
			compoundStatement(_t);
			_t = _retTree;
			_t = __t27;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void functionDeclSpecifiers(AST _t) throws RecognitionException {
		
		TNode functionDeclSpecifiers_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			{
			int _cnt100=0;
			_loop100:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case LITERAL_extern:
				case LITERAL_static:
				case LITERAL_inline:
				{
					functionStorageClassSpecifier(_t);
					_t = _retTree;
					break;
				}
				case LITERAL_volatile:
				case LITERAL_const:
				case LITERAL_signed:
				case LITERAL_unsigned:
				{
					typeQualifier(_t);
					_t = _retTree;
					break;
				}
				case LITERAL_struct:
				case LITERAL_union:
				case LITERAL_enum:
				case LITERAL_void:
				case LITERAL_char:
				case LITERAL_short:
				case LITERAL_int:
				case LITERAL_long:
				case LITERAL_float:
				case LITERAL_double:
				case 27:
				case 28:
				case 29:
				case 30:
				case 31:
				case 32:
				case LITERAL_wchar_t:
				case 34:
				case 35:
				case 36:
				case 37:
				case LITERAL_ptrdiff_t:
				case LITERAL_intptr_t:
				case LITERAL_size_t:
				case LITERAL_uintptr_t:
				case NTypedefName:
				case LITERAL_typeof:
				case LITERAL___complex:
				{
					typeSpecifier(_t,0);
					_t = _retTree;
					break;
				}
				default:
				{
					if ( _cnt100>=1 ) { break _loop100; } else {throw new NoViableAltException(_t);}
				}
				}
				_cnt100++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void compoundStatement(AST _t) throws RecognitionException {
		
		TNode compoundStatement_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t159 = _t;
			TNode tmp32_AST_in = (TNode)_t;
			match(_t,NCompoundStatement);
			_t = _t.getFirstChild();
			{
			_loop161:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case NDeclaration:
				case LITERAL___label__:
				{
					declarationList(_t);
					_t = _retTree;
					break;
				}
				case NFunctionDef:
				{
					functionDef(_t);
					_t = _retTree;
					break;
				}
				default:
				{
					break _loop161;
				}
				}
			} while (true);
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case SEMI:
			case LITERAL_while:
			case LITERAL_do:
			case LITERAL_for:
			case LITERAL_goto:
			case LITERAL_continue:
			case LITERAL_break:
			case LITERAL_return:
			case LITERAL_case:
			case LITERAL_default:
			case LITERAL_if:
			case LITERAL_switch:
			case NStatementExpr:
			case NCompoundStatement:
			case NLabel:
			{
				statementList(_t);
				_t = _retTree;
				break;
			}
			case RCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			TNode tmp33_AST_in = (TNode)_t;
			match(_t,RCURLY);
			_t = _t.getNextSibling();
			_t = __t159;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final int  storageClassSpecifier(AST _t) throws RecognitionException {
		int x;
		
		TNode storageClassSpecifier_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		x = 0;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_auto:
			{
				TNode tmp34_AST_in = (TNode)_t;
				match(_t,LITERAL_auto);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					x |= AUTO;
				}
				break;
			}
			case LITERAL_register:
			{
				TNode tmp35_AST_in = (TNode)_t;
				match(_t,LITERAL_register);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					x |= REGISTER;
				}
				break;
			}
			case LITERAL_typedef:
			{
				TNode tmp36_AST_in = (TNode)_t;
				match(_t,LITERAL_typedef);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					x |= TYPEDEF;
				}
				break;
			}
			case LITERAL_extern:
			case LITERAL_static:
			case LITERAL_inline:
			{
				x=functionStorageClassSpecifier(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return x;
	}
	
	public final int  typeQualifier(AST _t) throws RecognitionException {
		int x;
		
		TNode typeQualifier_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		x = 0;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_const:
			{
				TNode tmp37_AST_in = (TNode)_t;
				match(_t,LITERAL_const);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					x |= CONST;
				}
				break;
			}
			case LITERAL_volatile:
			{
				TNode tmp38_AST_in = (TNode)_t;
				match(_t,LITERAL_volatile);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					x |= VOLATILE;
				}
				break;
			}
			case LITERAL_signed:
			{
				TNode tmp39_AST_in = (TNode)_t;
				match(_t,LITERAL_signed);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					x |= SIGNED;
				}
				break;
			}
			case LITERAL_unsigned:
			{
				TNode tmp40_AST_in = (TNode)_t;
				match(_t,LITERAL_unsigned);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					x |= UNSIGNED;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return x;
	}
	
	public final Type  typeSpecifier(AST _t,
		int attributes
	) throws RecognitionException {
		Type t;
		
		TNode typeSpecifier_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		t = null;
		int cvAttrs = attrs2CVAttrs(attributes);
		boolean unsig = ((attributes & UNSIGNED) != 0);
		final ASTLocusTag locusTag = findASTLocusTag(typeSpecifier_AST_in);
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_void:
			{
				TNode tmp41_AST_in = (TNode)_t;
				match(_t,LITERAL_void);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new VoidType(                                      cvAttrs,               locusTag);
				}
				break;
			}
			case LITERAL_char:
			{
				TNode tmp42_AST_in = (TNode)_t;
				match(_t,LITERAL_char);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("char" ,     SizeThunk.INT8,    unsig, cvAttrs, false, false, locusTag);
				}
				break;
			}
			case LITERAL_short:
			{
				TNode tmp43_AST_in = (TNode)_t;
				match(_t,LITERAL_short);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("short",     SizeThunk.INT16,   unsig, cvAttrs, false, false, locusTag);
				}
				break;
			}
			case LITERAL_int:
			{
				TNode tmp44_AST_in = (TNode)_t;
				match(_t,LITERAL_int);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("int"  ,     SizeThunk.INTxx,   unsig, cvAttrs, false, false, locusTag);
				}
				break;
			}
			case LITERAL_long:
			{
				TNode tmp45_AST_in = (TNode)_t;
				match(_t,LITERAL_long);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("long" ,     SizeThunk.LONG,    unsig, cvAttrs, false, false, locusTag);
				}
				break;
			}
			case LITERAL_float:
			{
				TNode tmp46_AST_in = (TNode)_t;
				match(_t,LITERAL_float);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new FloatType("float",   SizeThunk.FLOAT,          cvAttrs,               locusTag);
				}
				break;
			}
			case LITERAL_double:
			{
				TNode tmp47_AST_in = (TNode)_t;
				match(_t,LITERAL_double);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new DoubleType("double", SizeThunk.DOUBLE,         cvAttrs,               locusTag);
				}
				break;
			}
			case 31:
			{
				TNode tmp48_AST_in = (TNode)_t;
				match(_t,31);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("__int32",   SizeThunk.INT32,   unsig, cvAttrs, true,  false, locusTag);
				}
				break;
			}
			case 35:
			{
				TNode tmp49_AST_in = (TNode)_t;
				match(_t,35);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("__int64",   SizeThunk.INT64,   unsig, cvAttrs, true,  false, locusTag);
				}
				break;
			}
			case 27:
			{
				TNode tmp50_AST_in = (TNode)_t;
				match(_t,27);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("int8_t",    SizeThunk.INT8,    unsig, cvAttrs, true,  false, locusTag);
				}
				break;
			}
			case 28:
			{
				TNode tmp51_AST_in = (TNode)_t;
				match(_t,28);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("uint8_t",   SizeThunk.INT8,    unsig, cvAttrs, true,  true,  locusTag);
				}
				break;
			}
			case 29:
			{
				TNode tmp52_AST_in = (TNode)_t;
				match(_t,29);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("int16_t",   SizeThunk.INT16,   unsig, cvAttrs, true,  false, locusTag);
				}
				break;
			}
			case 30:
			{
				TNode tmp53_AST_in = (TNode)_t;
				match(_t,30);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("uint16_t",  SizeThunk.INT16,   unsig, cvAttrs, true,  true,  locusTag);
				}
				break;
			}
			case 32:
			{
				TNode tmp54_AST_in = (TNode)_t;
				match(_t,32);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("int32_t",   SizeThunk.INT32,   unsig, cvAttrs, true,  false, locusTag);
				}
				break;
			}
			case LITERAL_wchar_t:
			{
				TNode tmp55_AST_in = (TNode)_t;
				match(_t,LITERAL_wchar_t);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("wchar_t",   SizeThunk.INT32,   unsig, cvAttrs, true,  false, locusTag);
				}
				break;
			}
			case 34:
			{
				TNode tmp56_AST_in = (TNode)_t;
				match(_t,34);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("uint32_t",  SizeThunk.INT32,   unsig, cvAttrs, true,  true,  locusTag);
				}
				break;
			}
			case 36:
			{
				TNode tmp57_AST_in = (TNode)_t;
				match(_t,36);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("int64_t",   SizeThunk.INT64,   unsig, cvAttrs, true,  false, locusTag);
				}
				break;
			}
			case 37:
			{
				TNode tmp58_AST_in = (TNode)_t;
				match(_t,37);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("uint64_t",  SizeThunk.INT64,   unsig, cvAttrs, true,  true,  locusTag);
				}
				break;
			}
			case LITERAL_ptrdiff_t:
			{
				TNode tmp59_AST_in = (TNode)_t;
				match(_t,LITERAL_ptrdiff_t);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("ptrdiff_t", SizeThunk.POINTER, unsig, cvAttrs, true,  false, locusTag);
				}
				break;
			}
			case LITERAL_intptr_t:
			{
				TNode tmp60_AST_in = (TNode)_t;
				match(_t,LITERAL_intptr_t);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("intptr_t",  SizeThunk.POINTER, unsig, cvAttrs, true,  false, locusTag);
				}
				break;
			}
			case LITERAL_size_t:
			{
				TNode tmp61_AST_in = (TNode)_t;
				match(_t,LITERAL_size_t);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("size_t",    SizeThunk.POINTER, unsig, cvAttrs, true,  true,  locusTag);
				}
				break;
			}
			case LITERAL_uintptr_t:
			{
				TNode tmp62_AST_in = (TNode)_t;
				match(_t,LITERAL_uintptr_t);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t = new IntType("uintptr_t", SizeThunk.POINTER, unsig, cvAttrs, true,  true,  locusTag);
				}
				break;
			}
			case LITERAL_struct:
			{
				t=structSpecifier(_t,cvAttrs);
				_t = _retTree;
				{
				_loop39:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==NAsmAttribute||_t.getType()==LITERAL___attribute)) {
						attributeDecl(_t);
						_t = _retTree;
					}
					else {
						break _loop39;
					}
					
				} while (true);
				}
				break;
			}
			case LITERAL_union:
			{
				t=unionSpecifier(_t,cvAttrs);
				_t = _retTree;
				{
				_loop41:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==NAsmAttribute||_t.getType()==LITERAL___attribute)) {
						attributeDecl(_t);
						_t = _retTree;
					}
					else {
						break _loop41;
					}
					
				} while (true);
				}
				break;
			}
			case LITERAL_enum:
			{
				t=enumSpecifier(_t,cvAttrs);
				_t = _retTree;
				break;
			}
			case NTypedefName:
			{
				t=typedefName(_t,cvAttrs);
				_t = _retTree;
				break;
			}
			case LITERAL_typeof:
			{
				AST __t42 = _t;
				TNode tmp63_AST_in = (TNode)_t;
				match(_t,LITERAL_typeof);
				_t = _t.getFirstChild();
				TNode tmp64_AST_in = (TNode)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case LITERAL_volatile:
				case LITERAL_struct:
				case LITERAL_union:
				case LITERAL_enum:
				case LITERAL_const:
				case LITERAL_void:
				case LITERAL_char:
				case LITERAL_short:
				case LITERAL_int:
				case LITERAL_long:
				case LITERAL_float:
				case LITERAL_double:
				case LITERAL_signed:
				case LITERAL_unsigned:
				case 27:
				case 28:
				case 29:
				case 30:
				case 31:
				case 32:
				case LITERAL_wchar_t:
				case 34:
				case 35:
				case 36:
				case 37:
				case LITERAL_ptrdiff_t:
				case LITERAL_intptr_t:
				case LITERAL_size_t:
				case LITERAL_uintptr_t:
				case NTypedefName:
				case LITERAL_typeof:
				case LITERAL___complex:
				{
					typeName(_t);
					_t = _retTree;
					break;
				}
				case ID:
				case ASSIGN:
				case STAR:
				case LPAREN:
				case DIV_ASSIGN:
				case PLUS_ASSIGN:
				case MINUS_ASSIGN:
				case STAR_ASSIGN:
				case MOD_ASSIGN:
				case RSHIFT_ASSIGN:
				case LSHIFT_ASSIGN:
				case BAND_ASSIGN:
				case BOR_ASSIGN:
				case BXOR_ASSIGN:
				case QUESTION:
				case LOR:
				case LAND:
				case BOR:
				case BXOR:
				case BAND:
				case EQUAL:
				case NOT_EQUAL:
				case LT:
				case LTE:
				case GT:
				case GTE:
				case LSHIFT:
				case RSHIFT:
				case PLUS:
				case MINUS:
				case DIV:
				case MOD:
				case INC:
				case DEC:
				case LITERAL_sizeof:
				case CharLiteral:
				case NCast:
				case NExpressionGroup:
				case NInitializer:
				case NEmptyExpression:
				case NCommaExpr:
				case NUnaryExpr:
				case NPostfixExpr:
				case NRangeExpr:
				case NStringSeq:
				case NLcurlyInitializer:
				case NGnuAsmExpr:
				case Number:
				case LITERAL___alignof:
				{
					expr(_t);
					_t = _retTree;
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				TNode tmp65_AST_in = (TNode)_t;
				match(_t,RPAREN);
				_t = _t.getNextSibling();
				_t = __t42;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL___complex:
			{
				TNode tmp66_AST_in = (TNode)_t;
				match(_t,LITERAL___complex);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return t;
	}
	
	public final int  functionStorageClassSpecifier(AST _t) throws RecognitionException {
		int x;
		
		TNode functionStorageClassSpecifier_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		x = 0;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_extern:
			{
				TNode tmp67_AST_in = (TNode)_t;
				match(_t,LITERAL_extern);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					x |= EXTERN;
				}
				break;
			}
			case LITERAL_static:
			{
				TNode tmp68_AST_in = (TNode)_t;
				match(_t,LITERAL_static);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					x |= STATIC;
				}
				break;
			}
			case LITERAL_inline:
			{
				TNode tmp69_AST_in = (TNode)_t;
				match(_t,LITERAL_inline);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					x |= INLINE;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return x;
	}
	
	public final Type  structSpecifier(AST _t,
		int cvAttrs
	) throws RecognitionException {
		Type t;
		
		TNode structSpecifier_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		t = null;
		
		try {      // for error handling
			AST __t49 = _t;
			TNode tmp70_AST_in = (TNode)_t;
			match(_t,LITERAL_struct);
			_t = _t.getFirstChild();
			t=structOrUnionBody(_t,CompoundTypeKind.STRUCT, cvAttrs);
			_t = _retTree;
			_t = __t49;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return t;
	}
	
	public final void attributeDecl(AST _t) throws RecognitionException {
		
		TNode attributeDecl_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL___attribute:
			{
				AST __t131 = _t;
				TNode tmp71_AST_in = (TNode)_t;
				match(_t,LITERAL___attribute);
				_t = _t.getFirstChild();
				{
				_loop133:
				do {
					if (_t==null) _t=ASTNULL;
					if (((_t.getType() >= LITERAL_typedef && _t.getType() <= LITERAL___imag))) {
						TNode tmp72_AST_in = (TNode)_t;
						if ( _t==null ) throw new MismatchedTokenException();
						_t = _t.getNextSibling();
					}
					else {
						break _loop133;
					}
					
				} while (true);
				}
				_t = __t131;
				_t = _t.getNextSibling();
				break;
			}
			case NAsmAttribute:
			{
				AST __t134 = _t;
				TNode tmp73_AST_in = (TNode)_t;
				match(_t,NAsmAttribute);
				_t = _t.getFirstChild();
				TNode tmp74_AST_in = (TNode)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				expr(_t);
				_t = _retTree;
				TNode tmp75_AST_in = (TNode)_t;
				match(_t,RPAREN);
				_t = _t.getNextSibling();
				_t = __t134;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final Type  unionSpecifier(AST _t,
		int cvAttrs
	) throws RecognitionException {
		Type t;
		
		TNode unionSpecifier_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		t = null;
		
		try {      // for error handling
			AST __t51 = _t;
			TNode tmp76_AST_in = (TNode)_t;
			match(_t,LITERAL_union);
			_t = _t.getFirstChild();
			t=structOrUnionBody(_t,CompoundTypeKind.UNION, cvAttrs);
			_t = _retTree;
			_t = __t51;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return t;
	}
	
	public final Type  enumSpecifier(AST _t,
		int cvAttrs
	) throws RecognitionException {
		Type t;
		
		TNode enumSpecifier_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		TNode i = null;
		
		t = null; 
		EnumType e = null;
		ASTLocusTag locusTag = findASTLocusTag(enumSpecifier_AST_in);
		
		
		try {      // for error handling
			AST __t75 = _t;
			TNode tmp77_AST_in = (TNode)_t;
			match(_t,LITERAL_enum);
			_t = _t.getFirstChild();
			{
			boolean synPredMatched78 = false;
			if (_t==null) _t=ASTNULL;
			if (((_t.getType()==ID))) {
				AST __t78 = _t;
				synPredMatched78 = true;
				inputState.guessing++;
				try {
					{
					TNode tmp78_AST_in = (TNode)_t;
					match(_t,ID);
					_t = _t.getNextSibling();
					TNode tmp79_AST_in = (TNode)_t;
					match(_t,LCURLY);
					_t = _t.getNextSibling();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched78 = false;
				}
				_t = __t78;
inputState.guessing--;
			}
			if ( synPredMatched78 ) {
				i = (TNode)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				TNode tmp80_AST_in = (TNode)_t;
				match(_t,LCURLY);
				_t = _t.getNextSibling();
				enumList(_t,(EnumType)(e = getEnumType(i.getText(), locusTag)));
				_t = _retTree;
				TNode tmp81_AST_in = (TNode)_t;
				match(_t,RCURLY);
				_t = _t.getNextSibling();
			}
			else if ((_t.getType()==LCURLY)) {
				TNode tmp82_AST_in = (TNode)_t;
				match(_t,LCURLY);
				_t = _t.getNextSibling();
				enumList(_t,(EnumType)(e = getEnumType(ANONYMOUS_ENUM_NAME, locusTag)));
				_t = _retTree;
				TNode tmp83_AST_in = (TNode)_t;
				match(_t,RCURLY);
				_t = _t.getNextSibling();
			}
			else if ((_t.getType()==ID)) {
				TNode tmp84_AST_in = (TNode)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					e = getEnumType(i.getText(), locusTag);
				}
			}
			else {
				throw new NoViableAltException(_t);
			}
			
			}
			if ( inputState.guessing==0 ) {
				
				debugPrintln("Adding enum mapping: "+getDebugTypeString(e));
				if( null != e ) {
				final String eName = e.getName();
				if( null != eName && !eName.equals(ANONYMOUS_ENUM_NAME) ) { // validate only non-anonymous enum
				final EnumType dupE = enumMap.get(eName);
				if( null != dupE && !dupE.equalSemantics(e) ) {
				throwGlueGenException(enumSpecifier_AST_in,
				String.format("Duplicate enum w/ incompatible type:%n  this '%s',%n  have '%s',%n  %s: previous definition is here",
				getTypeString(e), getTypeString(dupE), dupE.getASTLocusTag().toString(new StringBuilder(), "note", true)));
				}
				enumMap.put(eName, (EnumType)e.clone(locusTag));
				}
				}
				t = e; // return val
				
			}
			_t = __t75;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return t;
	}
	
	public final Type  typedefName(AST _t,
		int cvAttrs
	) throws RecognitionException {
		Type t;
		
		TNode typedefName_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		TNode id = null;
		t = null;
		
		try {      // for error handling
			AST __t47 = _t;
			TNode tmp85_AST_in = (TNode)_t;
			match(_t,NTypedefName);
			_t = _t.getFirstChild();
			id = (TNode)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			_t = __t47;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				
				final Type t0 = lookupInTypedefDictionary(typedefName_AST_in, id.getText());
				debugPrint("Adding typedef lookup: [" + id.getText() + "] -> "+getDebugTypeString(t0));
				final Type t1 = t0.newCVVariant(cvAttrs);
				debugPrintln(" - cvvar -> "+getDebugTypeString(t1));
				t = canonicalize(t1);
				debugPrintln(" - canon -> "+getDebugTypeString(t));
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return t;
	}
	
	public final void typeName(AST _t) throws RecognitionException {
		
		TNode typeName_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		TypeBox tb = null;
		
		
		try {      // for error handling
			specifierQualifierList(_t);
			_t = _retTree;
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case NNonemptyAbstractDeclarator:
			{
				nonemptyAbstractDeclarator(_t,tb);
				_t = _retTree;
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final CompoundType  structOrUnionBody(AST _t,
		CompoundTypeKind kind, int cvAttrs
	) throws RecognitionException {
		CompoundType t;
		
		TNode structOrUnionBody_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		TNode id = null;
		TNode id2 = null;
		
		t = null;
		boolean addedAny = false;
		final ASTLocusTag locusTag = findASTLocusTag(structOrUnionBody_AST_in);
		
		
		try {      // for error handling
			{
			boolean synPredMatched55 = false;
			if (_t==null) _t=ASTNULL;
			if (((_t.getType()==ID))) {
				AST __t55 = _t;
				synPredMatched55 = true;
				inputState.guessing++;
				try {
					{
					TNode tmp86_AST_in = (TNode)_t;
					match(_t,ID);
					_t = _t.getNextSibling();
					TNode tmp87_AST_in = (TNode)_t;
					match(_t,LCURLY);
					_t = _t.getNextSibling();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched55 = false;
				}
				_t = __t55;
inputState.guessing--;
			}
			if ( synPredMatched55 ) {
				id = (TNode)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				TNode tmp88_AST_in = (TNode)_t;
				match(_t,LCURLY);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					// fully declared struct, i.e. not anonymous
					t = (CompoundType) canonicalize(lookupInStructDictionary(id.getText(), kind, cvAttrs, locusTag));
					
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case LITERAL_volatile:
				case LITERAL_struct:
				case LITERAL_union:
				case LITERAL_enum:
				case LITERAL_const:
				case LITERAL_void:
				case LITERAL_char:
				case LITERAL_short:
				case LITERAL_int:
				case LITERAL_long:
				case LITERAL_float:
				case LITERAL_double:
				case LITERAL_signed:
				case LITERAL_unsigned:
				case 27:
				case 28:
				case 29:
				case 30:
				case 31:
				case 32:
				case LITERAL_wchar_t:
				case 34:
				case 35:
				case 36:
				case 37:
				case LITERAL_ptrdiff_t:
				case LITERAL_intptr_t:
				case LITERAL_size_t:
				case LITERAL_uintptr_t:
				case NTypedefName:
				case LITERAL_typeof:
				case LITERAL___complex:
				{
					addedAny=structDeclarationList(_t,t);
					_t = _retTree;
					break;
				}
				case RCURLY:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				TNode tmp89_AST_in = (TNode)_t;
				match(_t,RCURLY);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t.setBodyParsed();
				}
			}
			else if ((_t.getType()==LCURLY)) {
				TNode tmp90_AST_in = (TNode)_t;
				match(_t,LCURLY);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					// anonymous declared struct
					t = CompoundType.create(null, null, kind, cvAttrs, locusTag); 
					
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case LITERAL_volatile:
				case LITERAL_struct:
				case LITERAL_union:
				case LITERAL_enum:
				case LITERAL_const:
				case LITERAL_void:
				case LITERAL_char:
				case LITERAL_short:
				case LITERAL_int:
				case LITERAL_long:
				case LITERAL_float:
				case LITERAL_double:
				case LITERAL_signed:
				case LITERAL_unsigned:
				case 27:
				case 28:
				case 29:
				case 30:
				case 31:
				case 32:
				case LITERAL_wchar_t:
				case 34:
				case 35:
				case 36:
				case 37:
				case LITERAL_ptrdiff_t:
				case LITERAL_intptr_t:
				case LITERAL_size_t:
				case LITERAL_uintptr_t:
				case NTypedefName:
				case LITERAL_typeof:
				case LITERAL___complex:
				{
					structDeclarationList(_t,t);
					_t = _retTree;
					break;
				}
				case RCURLY:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				TNode tmp91_AST_in = (TNode)_t;
				match(_t,RCURLY);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					t.setBodyParsed();
				}
			}
			else if ((_t.getType()==ID)) {
				id2 = (TNode)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					// anonymous struct
					t = (CompoundType) canonicalize(lookupInStructDictionary(id2.getText(), kind, cvAttrs, locusTag)); 
					
				}
			}
			else {
				throw new NoViableAltException(_t);
			}
			
			}
			if ( inputState.guessing==0 ) {
				
				debugPrintln("Adding compound body: [" + t.getName() + "] -> "+getDebugTypeString(t)+" @ "+locusTag);
				debugPrintln(t.getStructString());
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return t;
	}
	
	public final boolean  structDeclarationList(AST _t,
		CompoundType t
	) throws RecognitionException {
		boolean addedAny;
		
		TNode structDeclarationList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		addedAny = false;
		boolean addedOne = false;
		
		
		try {      // for error handling
			{
			int _cnt60=0;
			_loop60:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_1.member(_t.getType()))) {
					addedOne=structDeclaration(_t,t);
					_t = _retTree;
					if ( inputState.guessing==0 ) {
						addedAny |= addedOne;
					}
				}
				else {
					if ( _cnt60>=1 ) { break _loop60; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt60++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return addedAny;
	}
	
	public final boolean  structDeclaration(AST _t,
		CompoundType containingType
	) throws RecognitionException {
		boolean addedAny;
		
		TNode structDeclaration_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		addedAny = false;
		Type t = null;
		
		
		try {      // for error handling
			t=specifierQualifierList(_t);
			_t = _retTree;
			addedAny=structDeclaratorList(_t,containingType, t);
			_t = _retTree;
			if ( inputState.guessing==0 ) {
				
				if (!addedAny) {
				if (t != null) {
				CompoundType ct = t.asCompound();
				if( null == ct ) {
				throwGlueGenException(structDeclaration_AST_in,
				String.format("Anonymous compound, w/ NULL type:%n  containing '%s'",
				getTypeString(containingType)));
				}
				if ( ct.isUnion() ) {
				// Anonymous union
				containingType.addField(new Field(null, t, null));
				}
				}
				}
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return addedAny;
	}
	
	public final Type  specifierQualifierList(AST _t) throws RecognitionException {
		Type t;
		
		TNode specifierQualifierList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		t = null; int x = 0; int y = 0;
		
		
		try {      // for error handling
			{
			int _cnt64=0;
			_loop64:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case LITERAL_struct:
				case LITERAL_union:
				case LITERAL_enum:
				case LITERAL_void:
				case LITERAL_char:
				case LITERAL_short:
				case LITERAL_int:
				case LITERAL_long:
				case LITERAL_float:
				case LITERAL_double:
				case 27:
				case 28:
				case 29:
				case 30:
				case 31:
				case 32:
				case LITERAL_wchar_t:
				case 34:
				case 35:
				case 36:
				case 37:
				case LITERAL_ptrdiff_t:
				case LITERAL_intptr_t:
				case LITERAL_size_t:
				case LITERAL_uintptr_t:
				case NTypedefName:
				case LITERAL_typeof:
				case LITERAL___complex:
				{
					t=typeSpecifier(_t,x);
					_t = _retTree;
					break;
				}
				case LITERAL_volatile:
				case LITERAL_const:
				case LITERAL_signed:
				case LITERAL_unsigned:
				{
					y=typeQualifier(_t);
					_t = _retTree;
					if ( inputState.guessing==0 ) {
						x |= y;
					}
					break;
				}
				default:
				{
					if ( _cnt64>=1 ) { break _loop64; } else {throw new NoViableAltException(_t);}
				}
				}
				_cnt64++;
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				
				if (t == null &&
				(x & (SIGNED | UNSIGNED)) != 0) {
				t = new IntType("int", SizeThunk.INTxx, ((x & UNSIGNED) != 0), attrs2CVAttrs(x), 
				findASTLocusTag(specifierQualifierList_AST_in));
				}
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return t;
	}
	
	public final boolean  structDeclaratorList(AST _t,
		CompoundType containingType, Type t
	) throws RecognitionException {
		boolean addedAny;
		
		TNode structDeclaratorList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		addedAny = false;
		boolean y = false;
		
		
		try {      // for error handling
			{
			int _cnt67=0;
			_loop67:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==NStructDeclarator)) {
					y=structDeclarator(_t,containingType, t);
					_t = _retTree;
					if ( inputState.guessing==0 ) {
						addedAny = y;
					}
				}
				else {
					if ( _cnt67>=1 ) { break _loop67; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt67++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return addedAny;
	}
	
	public final boolean  structDeclarator(AST _t,
		CompoundType containingType, Type t
	) throws RecognitionException {
		boolean addedAny;
		
		TNode structDeclarator_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		addedAny = false;
		String s = null;
		TypeBox tb = new TypeBox(t);
		
		
		try {      // for error handling
			AST __t69 = _t;
			TNode tmp92_AST_in = (TNode)_t;
			match(_t,NStructDeclarator);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case NDeclarator:
			{
				s=declarator(_t,tb);
				_t = _retTree;
				if ( inputState.guessing==0 ) {
					containingType.addField(new Field(s, tb.type(), null)); addedAny = true;
				}
				break;
			}
			case 3:
			case COLON:
			case NAsmAttribute:
			case LITERAL___attribute:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COLON:
			{
				TNode tmp93_AST_in = (TNode)_t;
				match(_t,COLON);
				_t = _t.getNextSibling();
				expr(_t);
				_t = _retTree;
				if ( inputState.guessing==0 ) {
					/* FIXME: bit types not handled yet */
				}
				break;
			}
			case 3:
			case NAsmAttribute:
			case LITERAL___attribute:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			_loop73:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==NAsmAttribute||_t.getType()==LITERAL___attribute)) {
					attributeDecl(_t);
					_t = _retTree;
				}
				else {
					break _loop73;
				}
				
			} while (true);
			}
			_t = __t69;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return addedAny;
	}
	
	public final void enumList(AST _t,
		EnumType enumeration
	) throws RecognitionException {
		
		TNode enumList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		ConstantDefinition defEnumerant = new ConstantDefinition("def", "0", new CNumber(true, false, 0), findASTLocusTag(enumList_AST_in));
		
		
		try {      // for error handling
			{
			int _cnt81=0;
			_loop81:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ID)) {
					defEnumerant=enumerator(_t,enumeration, defEnumerant);
					_t = _retTree;
				}
				else {
					if ( _cnt81>=1 ) { break _loop81; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt81++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final ConstantDefinition  enumerator(AST _t,
		EnumType enumeration, ConstantDefinition defaultValue
	) throws RecognitionException {
		ConstantDefinition newDefaultValue;
		
		TNode enumerator_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		TNode eName = null;
		TNode eVal = null;
		
		newDefaultValue = defaultValue;
		
		
		try {      // for error handling
			eName = (TNode)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ASSIGN:
			{
				TNode tmp94_AST_in = (TNode)_t;
				match(_t,ASSIGN);
				_t = _t.getNextSibling();
				eVal = _t==ASTNULL ? null : (TNode)_t;
				expr(_t);
				_t = _retTree;
				break;
			}
			case RCURLY:
			case ID:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
				final String eTxt = eName.getText();
				final Enumerator newEnum;
				if (eVal != null) {
				String vTxt = eVal.getAllChildrenText(eTxt);
				if (enumHash.containsKey(vTxt)) {
				EnumType oldEnumType = enumHash.get(vTxt);
				Enumerator oldEnum = oldEnumType.getEnum(vTxt);
				newEnum = oldEnum;
				} else {
				newEnum = new Enumerator(eTxt, vTxt);
				}
				} else if( defaultValue.hasNumber() ) {
				newEnum = new Enumerator(eTxt, defaultValue.getNumber());
				} else {
				newEnum = new Enumerator(eTxt, defaultValue.getNativeExpr());
				}
				final ASTLocusTag locus = findASTLocusTag(enumerator_AST_in);
				final CNumber newEnumNum = newEnum.getNumber();
				if( null != newEnumNum && newEnumNum.isInteger ) {
				final long n = newEnumNum.i+1;
				newDefaultValue = new ConstantDefinition("def", String.valueOf(n), new CNumber(newEnumNum.isLong, newEnumNum.isUnsigned, n), locus);
				} else {
				newDefaultValue = new ConstantDefinition("def", "("+newEnum.getExpr()+")+1", null, locus);
				}
				if (enumHash.containsKey(eTxt)) {
				EnumType oldEnumType = enumHash.get(eTxt);
				final Enumerator oldEnum = oldEnumType.getEnum(eTxt);
				final String oldExpr = oldEnum.getExpr();
				if( !oldExpr.equals(newEnum.getExpr()) ) {
				throwGlueGenException(enumerator_AST_in,
				String.format("Duplicate enum value '%s.%s' w/ diff value:%n  this %s,%n  have %s",
				oldEnumType.getName(), eTxt, newEnum, oldEnum));
				}
				// remove old definition
				oldEnumType.removeEnumerate(eTxt);
				}
				// insert new definition
				enumeration.addEnum(eTxt, newEnum);
				enumHash.put(eTxt, enumeration);
				debugPrintln("ENUM [" + enumeration.getName() + "]: " + eTxt + " = " + newEnum +
				" (new default = " + newDefaultValue + ")");
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return newDefaultValue;
	}
	
	public final void initDecl(AST _t,
		TypeBox tb
	) throws RecognitionException {
		
		TNode initDecl_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		String declName = null;
		final ASTLocusTag locusTag = findASTLocusTag(initDecl_AST_in);
		
		
		try {      // for error handling
			AST __t88 = _t;
			TNode tmp95_AST_in = (TNode)_t;
			match(_t,NInitDecl);
			_t = _t.getFirstChild();
			declName=declarator(_t,tb);
			_t = _retTree;
			if ( inputState.guessing==0 ) {
				
				debugPrintln("GOT declName: " + declName + " TB=" + tb);
				
			}
			{
			_loop90:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==NAsmAttribute||_t.getType()==LITERAL___attribute)) {
					attributeDecl(_t);
					_t = _retTree;
				}
				else {
					break _loop90;
				}
				
			} while (true);
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ASSIGN:
			{
				TNode tmp96_AST_in = (TNode)_t;
				match(_t,ASSIGN);
				_t = _t.getNextSibling();
				initializer(_t);
				_t = _retTree;
				break;
			}
			case COLON:
			{
				TNode tmp97_AST_in = (TNode)_t;
				match(_t,COLON);
				_t = _t.getNextSibling();
				expr(_t);
				_t = _retTree;
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t88;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				
				if ((declName != null) && (tb != null) && tb.isTypedef()) {
				Type t = tb.type();
				debugPrintln("Adding typedef mapping: [" + declName + "] -> "+getDebugTypeString(t));
				final Type tg;
				if( t.isPointer() ) {
				tg = t.getTargetType();
				debugPrintln("  - has target: "+getDebugTypeString(tg));
				} else {
				tg = null;
				}
				// NOTE: Struct Name Resolution (JavaEmitter, HeaderParser)
				// Also see NOTE below.
				if (!t.isTypedef()) {
				if( t.isCompound() || t.isEnum() ) {
				// This aliases '_a' -> 'A' for 'typedef struct _a { } A;' in-place
				// This aliases '_a' -> 'A' for 'typedef enum _a { } A;' in-place
				t.setTypedefName(declName);
				debugPrintln(" - alias.11 -> "+getDebugTypeString(t));
				} else {
				// Use new typedef, using a copy to preserve canonicalized base type
				t = t.clone(locusTag);
				t.setTypedefName(declName);
				debugPrintln(" - newdefine.12 -> "+getDebugTypeString(t));
				}
				} else {
				// Adds typeInfo alias w/ t's typeInfo, if exists
				cfg.addTypeInfo(declName, t);
				final Type alias;
				if( t.isCompound() ) {
				// This aliases 'D' -> 'A' for 'typedef struct _a { } A, D;' in-place
				debugPrintln(" - alias.21 -> "+getDebugTypeString(t));
				} else {
				// copy to preserve canonicalized base type
				t = t.clone(locusTag);
				t.setTypedefName(declName);
				debugPrintln(" - copy.22 -> "+getDebugTypeString(t));
				}
				}
				final Type dupT = typedefDictionary.get(declName);
				if( null != dupT && !dupT.equalSemantics(t) ) {
				throwGlueGenException(locusTag,
				String.format("Duplicate typedef w/ incompatible type:%n  this '%s',%n  have '%s',%n  %s: previous definition is here",
				getTypeString(t), getTypeString(dupT), dupT.getASTLocusTag().toString(new StringBuilder(), "note", true)));
				}
				t = canonicalize(t);
				debugPrintln(" - canon -> "+getDebugTypeString(t));
				typedefDictionary.put(declName, t);
				// Clear out PointerGroup effects in case another typedef variant follows
				tb.reset();
				}
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void initializer(AST _t) throws RecognitionException {
		
		TNode initializer_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case NInitializer:
			{
				AST __t139 = _t;
				TNode tmp98_AST_in = (TNode)_t;
				match(_t,NInitializer);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case NInitializerElementLabel:
				{
					initializerElementLabel(_t);
					_t = _retTree;
					break;
				}
				case ID:
				case ASSIGN:
				case STAR:
				case LPAREN:
				case DIV_ASSIGN:
				case PLUS_ASSIGN:
				case MINUS_ASSIGN:
				case STAR_ASSIGN:
				case MOD_ASSIGN:
				case RSHIFT_ASSIGN:
				case LSHIFT_ASSIGN:
				case BAND_ASSIGN:
				case BOR_ASSIGN:
				case BXOR_ASSIGN:
				case QUESTION:
				case LOR:
				case LAND:
				case BOR:
				case BXOR:
				case BAND:
				case EQUAL:
				case NOT_EQUAL:
				case LT:
				case LTE:
				case GT:
				case GTE:
				case LSHIFT:
				case RSHIFT:
				case PLUS:
				case MINUS:
				case DIV:
				case MOD:
				case INC:
				case DEC:
				case LITERAL_sizeof:
				case CharLiteral:
				case NCast:
				case NExpressionGroup:
				case NInitializer:
				case NEmptyExpression:
				case NCommaExpr:
				case NUnaryExpr:
				case NPostfixExpr:
				case NRangeExpr:
				case NStringSeq:
				case NLcurlyInitializer:
				case NGnuAsmExpr:
				case Number:
				case LITERAL___alignof:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				expr(_t);
				_t = _retTree;
				_t = __t139;
				_t = _t.getNextSibling();
				break;
			}
			case NLcurlyInitializer:
			{
				lcurlyInitializer(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final int  intConstExpr(AST _t) throws RecognitionException {
		int i;
		
		TNode intConstExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		TNode n = null;
		TNode e = null;
		i = -1;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case Number:
			{
				n = (TNode)_t;
				match(_t,Number);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					return Integer.parseInt(n.getText());
				}
				break;
			}
			case ID:
			{
				e = (TNode)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					final String enumName = e.getText();
					final EnumType enumType = enumHash.get(enumName);
					if( null == enumType ) {
					throwGlueGenException(intConstExpr_AST_in,
					"Error: intConstExpr ID "+enumName+" recognized, but no containing enum-type found");
					}
					final Enumerator enumerator = enumType.getEnum(enumName);
					final CNumber number = enumerator.getNumber();
					if( null != number && number.isInteger && !number.isLong ) {
					debugPrintln("INFO: intConstExpr: enum[Type "+enumType.getName()+", "+enumerator+"]");
					} else {
					throwGlueGenException(intConstExpr_AST_in,
					"Error: intConstExpr ID "+enumName+" enum "+enumerator+" not an int32_t");
					}
					return (int)number.i;
					
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return i;
	}
	
	public final void translationUnit(AST _t) throws RecognitionException {
		
		TNode translationUnit_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		{
		if (_t==null) _t=ASTNULL;
		switch ( _t.getType()) {
		case LITERAL_asm:
		case SEMI:
		case NDeclaration:
		case NFunctionDef:
		case NTypeMissing:
		{
			externalList(_t);
			_t = _retTree;
			break;
		}
		case 3:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(_t);
		}
		}
		}
		_retTree = _t;
	}
	
	public final void externalList(AST _t) throws RecognitionException {
		
		TNode externalList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			{
			int _cnt123=0;
			_loop123:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_2.member(_t.getType()))) {
					externalDef(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt123>=1 ) { break _loop123; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt123++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void externalDef(AST _t) throws RecognitionException {
		
		TNode externalDef_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case NDeclaration:
			{
				declaration(_t);
				_t = _retTree;
				break;
			}
			case NFunctionDef:
			{
				functionDef(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_asm:
			{
				asm_expr(_t);
				_t = _retTree;
				break;
			}
			case SEMI:
			{
				TNode tmp99_AST_in = (TNode)_t;
				match(_t,SEMI);
				_t = _t.getNextSibling();
				break;
			}
			case NTypeMissing:
			{
				typelessDeclaration(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void asm_expr(AST _t) throws RecognitionException {
		
		TNode asm_expr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t126 = _t;
			TNode tmp100_AST_in = (TNode)_t;
			match(_t,LITERAL_asm);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_volatile:
			{
				TNode tmp101_AST_in = (TNode)_t;
				match(_t,LITERAL_volatile);
				_t = _t.getNextSibling();
				break;
			}
			case LCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			TNode tmp102_AST_in = (TNode)_t;
			match(_t,LCURLY);
			_t = _t.getNextSibling();
			expr(_t);
			_t = _retTree;
			TNode tmp103_AST_in = (TNode)_t;
			match(_t,RCURLY);
			_t = _t.getNextSibling();
			{
			int _cnt129=0;
			_loop129:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==SEMI)) {
					TNode tmp104_AST_in = (TNode)_t;
					match(_t,SEMI);
					_t = _t.getNextSibling();
				}
				else {
					if ( _cnt129>=1 ) { break _loop129; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt129++;
			} while (true);
			}
			_t = __t126;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void initializerElementLabel(AST _t) throws RecognitionException {
		
		TNode initializerElementLabel_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t142 = _t;
			TNode tmp105_AST_in = (TNode)_t;
			match(_t,NInitializerElementLabel);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LBRACKET:
			{
				{
				TNode tmp106_AST_in = (TNode)_t;
				match(_t,LBRACKET);
				_t = _t.getNextSibling();
				expr(_t);
				_t = _retTree;
				TNode tmp107_AST_in = (TNode)_t;
				match(_t,RBRACKET);
				_t = _t.getNextSibling();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ASSIGN:
				{
					TNode tmp108_AST_in = (TNode)_t;
					match(_t,ASSIGN);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				}
				break;
			}
			case ID:
			{
				TNode tmp109_AST_in = (TNode)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				TNode tmp110_AST_in = (TNode)_t;
				match(_t,COLON);
				_t = _t.getNextSibling();
				break;
			}
			case DOT:
			{
				TNode tmp111_AST_in = (TNode)_t;
				match(_t,DOT);
				_t = _t.getNextSibling();
				TNode tmp112_AST_in = (TNode)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				TNode tmp113_AST_in = (TNode)_t;
				match(_t,ASSIGN);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t142;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void lcurlyInitializer(AST _t) throws RecognitionException {
		
		TNode lcurlyInitializer_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t147 = _t;
			TNode tmp114_AST_in = (TNode)_t;
			match(_t,NLcurlyInitializer);
			_t = _t.getFirstChild();
			initializerList(_t);
			_t = _retTree;
			TNode tmp115_AST_in = (TNode)_t;
			match(_t,RCURLY);
			_t = _t.getNextSibling();
			_t = __t147;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void initializerList(AST _t) throws RecognitionException {
		
		TNode initializerList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			{
			_loop150:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==NInitializer||_t.getType()==NLcurlyInitializer)) {
					initializer(_t);
					_t = _retTree;
				}
				else {
					break _loop150;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void declarationList(AST _t) throws RecognitionException {
		
		TNode declarationList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			{
			int _cnt153=0;
			_loop153:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==LITERAL___label__)) {
					localLabelDecl(_t);
					_t = _retTree;
				}
				else if ((_t.getType()==NDeclaration)) {
					declaration(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt153>=1 ) { break _loop153; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt153++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void localLabelDecl(AST _t) throws RecognitionException {
		
		TNode localLabelDecl_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t155 = _t;
			TNode tmp116_AST_in = (TNode)_t;
			match(_t,LITERAL___label__);
			_t = _t.getFirstChild();
			{
			int _cnt157=0;
			_loop157:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ID)) {
					TNode tmp117_AST_in = (TNode)_t;
					match(_t,ID);
					_t = _t.getNextSibling();
				}
				else {
					if ( _cnt157>=1 ) { break _loop157; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt157++;
			} while (true);
			}
			_t = __t155;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void statementList(AST _t) throws RecognitionException {
		
		TNode statementList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			{
			int _cnt165=0;
			_loop165:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_3.member(_t.getType()))) {
					statement(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt165>=1 ) { break _loop165; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt165++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void statement(AST _t) throws RecognitionException {
		
		TNode statement_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			statementBody(_t);
			_t = _retTree;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void statementBody(AST _t) throws RecognitionException {
		
		TNode statementBody_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case SEMI:
			{
				TNode tmp118_AST_in = (TNode)_t;
				match(_t,SEMI);
				_t = _t.getNextSibling();
				break;
			}
			case NCompoundStatement:
			{
				compoundStatement(_t);
				_t = _retTree;
				break;
			}
			case NStatementExpr:
			{
				AST __t168 = _t;
				TNode tmp119_AST_in = (TNode)_t;
				match(_t,NStatementExpr);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t168;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_while:
			{
				AST __t169 = _t;
				TNode tmp120_AST_in = (TNode)_t;
				match(_t,LITERAL_while);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				statement(_t);
				_t = _retTree;
				_t = __t169;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_do:
			{
				AST __t170 = _t;
				TNode tmp121_AST_in = (TNode)_t;
				match(_t,LITERAL_do);
				_t = _t.getFirstChild();
				statement(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t170;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_for:
			{
				AST __t171 = _t;
				TNode tmp122_AST_in = (TNode)_t;
				match(_t,LITERAL_for);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				statement(_t);
				_t = _retTree;
				_t = __t171;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_goto:
			{
				AST __t172 = _t;
				TNode tmp123_AST_in = (TNode)_t;
				match(_t,LITERAL_goto);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t172;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_continue:
			{
				TNode tmp124_AST_in = (TNode)_t;
				match(_t,LITERAL_continue);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_break:
			{
				TNode tmp125_AST_in = (TNode)_t;
				match(_t,LITERAL_break);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_return:
			{
				AST __t173 = _t;
				TNode tmp126_AST_in = (TNode)_t;
				match(_t,LITERAL_return);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ID:
				case ASSIGN:
				case STAR:
				case LPAREN:
				case DIV_ASSIGN:
				case PLUS_ASSIGN:
				case MINUS_ASSIGN:
				case STAR_ASSIGN:
				case MOD_ASSIGN:
				case RSHIFT_ASSIGN:
				case LSHIFT_ASSIGN:
				case BAND_ASSIGN:
				case BOR_ASSIGN:
				case BXOR_ASSIGN:
				case QUESTION:
				case LOR:
				case LAND:
				case BOR:
				case BXOR:
				case BAND:
				case EQUAL:
				case NOT_EQUAL:
				case LT:
				case LTE:
				case GT:
				case GTE:
				case LSHIFT:
				case RSHIFT:
				case PLUS:
				case MINUS:
				case DIV:
				case MOD:
				case INC:
				case DEC:
				case LITERAL_sizeof:
				case CharLiteral:
				case NCast:
				case NExpressionGroup:
				case NInitializer:
				case NEmptyExpression:
				case NCommaExpr:
				case NUnaryExpr:
				case NPostfixExpr:
				case NRangeExpr:
				case NStringSeq:
				case NLcurlyInitializer:
				case NGnuAsmExpr:
				case Number:
				case LITERAL___alignof:
				{
					expr(_t);
					_t = _retTree;
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t173;
				_t = _t.getNextSibling();
				break;
			}
			case NLabel:
			{
				AST __t175 = _t;
				TNode tmp127_AST_in = (TNode)_t;
				match(_t,NLabel);
				_t = _t.getFirstChild();
				TNode tmp128_AST_in = (TNode)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case SEMI:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_for:
				case LITERAL_goto:
				case LITERAL_continue:
				case LITERAL_break:
				case LITERAL_return:
				case LITERAL_case:
				case LITERAL_default:
				case LITERAL_if:
				case LITERAL_switch:
				case NStatementExpr:
				case NCompoundStatement:
				case NLabel:
				{
					statement(_t);
					_t = _retTree;
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t175;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_case:
			{
				AST __t177 = _t;
				TNode tmp129_AST_in = (TNode)_t;
				match(_t,LITERAL_case);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case SEMI:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_for:
				case LITERAL_goto:
				case LITERAL_continue:
				case LITERAL_break:
				case LITERAL_return:
				case LITERAL_case:
				case LITERAL_default:
				case LITERAL_if:
				case LITERAL_switch:
				case NStatementExpr:
				case NCompoundStatement:
				case NLabel:
				{
					statement(_t);
					_t = _retTree;
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t177;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_default:
			{
				AST __t179 = _t;
				TNode tmp130_AST_in = (TNode)_t;
				match(_t,LITERAL_default);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case SEMI:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_for:
				case LITERAL_goto:
				case LITERAL_continue:
				case LITERAL_break:
				case LITERAL_return:
				case LITERAL_case:
				case LITERAL_default:
				case LITERAL_if:
				case LITERAL_switch:
				case NStatementExpr:
				case NCompoundStatement:
				case NLabel:
				{
					statement(_t);
					_t = _retTree;
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t179;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_if:
			{
				AST __t181 = _t;
				TNode tmp131_AST_in = (TNode)_t;
				match(_t,LITERAL_if);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				statement(_t);
				_t = _retTree;
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case LITERAL_else:
				{
					TNode tmp132_AST_in = (TNode)_t;
					match(_t,LITERAL_else);
					_t = _t.getNextSibling();
					statement(_t);
					_t = _retTree;
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t181;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_switch:
			{
				AST __t183 = _t;
				TNode tmp133_AST_in = (TNode)_t;
				match(_t,LITERAL_switch);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				statement(_t);
				_t = _retTree;
				_t = __t183;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void assignExpr(AST _t) throws RecognitionException {
		
		TNode assignExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ASSIGN:
			{
				AST __t209 = _t;
				TNode tmp134_AST_in = (TNode)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t209;
				_t = _t.getNextSibling();
				break;
			}
			case DIV_ASSIGN:
			{
				AST __t210 = _t;
				TNode tmp135_AST_in = (TNode)_t;
				match(_t,DIV_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t210;
				_t = _t.getNextSibling();
				break;
			}
			case PLUS_ASSIGN:
			{
				AST __t211 = _t;
				TNode tmp136_AST_in = (TNode)_t;
				match(_t,PLUS_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t211;
				_t = _t.getNextSibling();
				break;
			}
			case MINUS_ASSIGN:
			{
				AST __t212 = _t;
				TNode tmp137_AST_in = (TNode)_t;
				match(_t,MINUS_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t212;
				_t = _t.getNextSibling();
				break;
			}
			case STAR_ASSIGN:
			{
				AST __t213 = _t;
				TNode tmp138_AST_in = (TNode)_t;
				match(_t,STAR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t213;
				_t = _t.getNextSibling();
				break;
			}
			case MOD_ASSIGN:
			{
				AST __t214 = _t;
				TNode tmp139_AST_in = (TNode)_t;
				match(_t,MOD_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t214;
				_t = _t.getNextSibling();
				break;
			}
			case RSHIFT_ASSIGN:
			{
				AST __t215 = _t;
				TNode tmp140_AST_in = (TNode)_t;
				match(_t,RSHIFT_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t215;
				_t = _t.getNextSibling();
				break;
			}
			case LSHIFT_ASSIGN:
			{
				AST __t216 = _t;
				TNode tmp141_AST_in = (TNode)_t;
				match(_t,LSHIFT_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t216;
				_t = _t.getNextSibling();
				break;
			}
			case BAND_ASSIGN:
			{
				AST __t217 = _t;
				TNode tmp142_AST_in = (TNode)_t;
				match(_t,BAND_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t217;
				_t = _t.getNextSibling();
				break;
			}
			case BOR_ASSIGN:
			{
				AST __t218 = _t;
				TNode tmp143_AST_in = (TNode)_t;
				match(_t,BOR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t218;
				_t = _t.getNextSibling();
				break;
			}
			case BXOR_ASSIGN:
			{
				AST __t219 = _t;
				TNode tmp144_AST_in = (TNode)_t;
				match(_t,BXOR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t219;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void conditionalExpr(AST _t) throws RecognitionException {
		
		TNode conditionalExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t221 = _t;
			TNode tmp145_AST_in = (TNode)_t;
			match(_t,QUESTION);
			_t = _t.getFirstChild();
			expr(_t);
			_t = _retTree;
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			case ASSIGN:
			case STAR:
			case LPAREN:
			case DIV_ASSIGN:
			case PLUS_ASSIGN:
			case MINUS_ASSIGN:
			case STAR_ASSIGN:
			case MOD_ASSIGN:
			case RSHIFT_ASSIGN:
			case LSHIFT_ASSIGN:
			case BAND_ASSIGN:
			case BOR_ASSIGN:
			case BXOR_ASSIGN:
			case QUESTION:
			case LOR:
			case LAND:
			case BOR:
			case BXOR:
			case BAND:
			case EQUAL:
			case NOT_EQUAL:
			case LT:
			case LTE:
			case GT:
			case GTE:
			case LSHIFT:
			case RSHIFT:
			case PLUS:
			case MINUS:
			case DIV:
			case MOD:
			case INC:
			case DEC:
			case LITERAL_sizeof:
			case CharLiteral:
			case NCast:
			case NExpressionGroup:
			case NInitializer:
			case NEmptyExpression:
			case NCommaExpr:
			case NUnaryExpr:
			case NPostfixExpr:
			case NRangeExpr:
			case NStringSeq:
			case NLcurlyInitializer:
			case NGnuAsmExpr:
			case Number:
			case LITERAL___alignof:
			{
				expr(_t);
				_t = _retTree;
				break;
			}
			case COLON:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			TNode tmp146_AST_in = (TNode)_t;
			match(_t,COLON);
			_t = _t.getNextSibling();
			expr(_t);
			_t = _retTree;
			_t = __t221;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void logicalOrExpr(AST _t) throws RecognitionException {
		
		TNode logicalOrExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t224 = _t;
			TNode tmp147_AST_in = (TNode)_t;
			match(_t,LOR);
			_t = _t.getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t224;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void logicalAndExpr(AST _t) throws RecognitionException {
		
		TNode logicalAndExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t226 = _t;
			TNode tmp148_AST_in = (TNode)_t;
			match(_t,LAND);
			_t = _t.getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t226;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void inclusiveOrExpr(AST _t) throws RecognitionException {
		
		TNode inclusiveOrExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t228 = _t;
			TNode tmp149_AST_in = (TNode)_t;
			match(_t,BOR);
			_t = _t.getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t228;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void exclusiveOrExpr(AST _t) throws RecognitionException {
		
		TNode exclusiveOrExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t230 = _t;
			TNode tmp150_AST_in = (TNode)_t;
			match(_t,BXOR);
			_t = _t.getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t230;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void bitAndExpr(AST _t) throws RecognitionException {
		
		TNode bitAndExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t232 = _t;
			TNode tmp151_AST_in = (TNode)_t;
			match(_t,BAND);
			_t = _t.getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t232;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void equalityExpr(AST _t) throws RecognitionException {
		
		TNode equalityExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case EQUAL:
			{
				AST __t234 = _t;
				TNode tmp152_AST_in = (TNode)_t;
				match(_t,EQUAL);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t234;
				_t = _t.getNextSibling();
				break;
			}
			case NOT_EQUAL:
			{
				AST __t235 = _t;
				TNode tmp153_AST_in = (TNode)_t;
				match(_t,NOT_EQUAL);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t235;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void relationalExpr(AST _t) throws RecognitionException {
		
		TNode relationalExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LT:
			{
				AST __t237 = _t;
				TNode tmp154_AST_in = (TNode)_t;
				match(_t,LT);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t237;
				_t = _t.getNextSibling();
				break;
			}
			case LTE:
			{
				AST __t238 = _t;
				TNode tmp155_AST_in = (TNode)_t;
				match(_t,LTE);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t238;
				_t = _t.getNextSibling();
				break;
			}
			case GT:
			{
				AST __t239 = _t;
				TNode tmp156_AST_in = (TNode)_t;
				match(_t,GT);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t239;
				_t = _t.getNextSibling();
				break;
			}
			case GTE:
			{
				AST __t240 = _t;
				TNode tmp157_AST_in = (TNode)_t;
				match(_t,GTE);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t240;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void shiftExpr(AST _t) throws RecognitionException {
		
		TNode shiftExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LSHIFT:
			{
				AST __t242 = _t;
				TNode tmp158_AST_in = (TNode)_t;
				match(_t,LSHIFT);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t242;
				_t = _t.getNextSibling();
				break;
			}
			case RSHIFT:
			{
				AST __t243 = _t;
				TNode tmp159_AST_in = (TNode)_t;
				match(_t,RSHIFT);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t243;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void additiveExpr(AST _t) throws RecognitionException {
		
		TNode additiveExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case PLUS:
			{
				AST __t245 = _t;
				TNode tmp160_AST_in = (TNode)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t245;
				_t = _t.getNextSibling();
				break;
			}
			case MINUS:
			{
				AST __t246 = _t;
				TNode tmp161_AST_in = (TNode)_t;
				match(_t,MINUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t246;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void multExpr(AST _t) throws RecognitionException {
		
		TNode multExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case STAR:
			{
				AST __t248 = _t;
				TNode tmp162_AST_in = (TNode)_t;
				match(_t,STAR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t248;
				_t = _t.getNextSibling();
				break;
			}
			case DIV:
			{
				AST __t249 = _t;
				TNode tmp163_AST_in = (TNode)_t;
				match(_t,DIV);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t249;
				_t = _t.getNextSibling();
				break;
			}
			case MOD:
			{
				AST __t250 = _t;
				TNode tmp164_AST_in = (TNode)_t;
				match(_t,MOD);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t250;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void castExpr(AST _t) throws RecognitionException {
		
		TNode castExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t252 = _t;
			TNode tmp165_AST_in = (TNode)_t;
			match(_t,NCast);
			_t = _t.getFirstChild();
			typeName(_t);
			_t = _retTree;
			TNode tmp166_AST_in = (TNode)_t;
			match(_t,RPAREN);
			_t = _t.getNextSibling();
			expr(_t);
			_t = _retTree;
			_t = __t252;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void unaryExpr(AST _t) throws RecognitionException {
		
		TNode unaryExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case INC:
			{
				AST __t254 = _t;
				TNode tmp167_AST_in = (TNode)_t;
				match(_t,INC);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t254;
				_t = _t.getNextSibling();
				break;
			}
			case DEC:
			{
				AST __t255 = _t;
				TNode tmp168_AST_in = (TNode)_t;
				match(_t,DEC);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t255;
				_t = _t.getNextSibling();
				break;
			}
			case NUnaryExpr:
			{
				AST __t256 = _t;
				TNode tmp169_AST_in = (TNode)_t;
				match(_t,NUnaryExpr);
				_t = _t.getFirstChild();
				unaryOperator(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t256;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sizeof:
			{
				AST __t257 = _t;
				TNode tmp170_AST_in = (TNode)_t;
				match(_t,LITERAL_sizeof);
				_t = _t.getFirstChild();
				{
				boolean synPredMatched260 = false;
				if (_t==null) _t=ASTNULL;
				if (((_t.getType()==LPAREN))) {
					AST __t260 = _t;
					synPredMatched260 = true;
					inputState.guessing++;
					try {
						{
						TNode tmp171_AST_in = (TNode)_t;
						match(_t,LPAREN);
						_t = _t.getNextSibling();
						typeName(_t);
						_t = _retTree;
						}
					}
					catch (RecognitionException pe) {
						synPredMatched260 = false;
					}
					_t = __t260;
inputState.guessing--;
				}
				if ( synPredMatched260 ) {
					TNode tmp172_AST_in = (TNode)_t;
					match(_t,LPAREN);
					_t = _t.getNextSibling();
					typeName(_t);
					_t = _retTree;
					TNode tmp173_AST_in = (TNode)_t;
					match(_t,RPAREN);
					_t = _t.getNextSibling();
				}
				else if ((_tokenSet_4.member(_t.getType()))) {
					expr(_t);
					_t = _retTree;
				}
				else {
					throw new NoViableAltException(_t);
				}
				
				}
				_t = __t257;
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL___alignof:
			{
				AST __t261 = _t;
				TNode tmp174_AST_in = (TNode)_t;
				match(_t,LITERAL___alignof);
				_t = _t.getFirstChild();
				{
				boolean synPredMatched264 = false;
				if (_t==null) _t=ASTNULL;
				if (((_t.getType()==LPAREN))) {
					AST __t264 = _t;
					synPredMatched264 = true;
					inputState.guessing++;
					try {
						{
						TNode tmp175_AST_in = (TNode)_t;
						match(_t,LPAREN);
						_t = _t.getNextSibling();
						typeName(_t);
						_t = _retTree;
						}
					}
					catch (RecognitionException pe) {
						synPredMatched264 = false;
					}
					_t = __t264;
inputState.guessing--;
				}
				if ( synPredMatched264 ) {
					TNode tmp176_AST_in = (TNode)_t;
					match(_t,LPAREN);
					_t = _t.getNextSibling();
					typeName(_t);
					_t = _retTree;
					TNode tmp177_AST_in = (TNode)_t;
					match(_t,RPAREN);
					_t = _t.getNextSibling();
				}
				else if ((_tokenSet_4.member(_t.getType()))) {
					expr(_t);
					_t = _retTree;
				}
				else {
					throw new NoViableAltException(_t);
				}
				
				}
				_t = __t261;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void postfixExpr(AST _t) throws RecognitionException {
		
		TNode postfixExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t267 = _t;
			TNode tmp178_AST_in = (TNode)_t;
			match(_t,NPostfixExpr);
			_t = _t.getFirstChild();
			primaryExpr(_t);
			_t = _retTree;
			{
			int _cnt271=0;
			_loop271:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case PTR:
				{
					TNode tmp179_AST_in = (TNode)_t;
					match(_t,PTR);
					_t = _t.getNextSibling();
					TNode tmp180_AST_in = (TNode)_t;
					match(_t,ID);
					_t = _t.getNextSibling();
					break;
				}
				case DOT:
				{
					TNode tmp181_AST_in = (TNode)_t;
					match(_t,DOT);
					_t = _t.getNextSibling();
					TNode tmp182_AST_in = (TNode)_t;
					match(_t,ID);
					_t = _t.getNextSibling();
					break;
				}
				case NFunctionCallArgs:
				{
					AST __t269 = _t;
					TNode tmp183_AST_in = (TNode)_t;
					match(_t,NFunctionCallArgs);
					_t = _t.getFirstChild();
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case ID:
					case ASSIGN:
					case STAR:
					case LPAREN:
					case DIV_ASSIGN:
					case PLUS_ASSIGN:
					case MINUS_ASSIGN:
					case STAR_ASSIGN:
					case MOD_ASSIGN:
					case RSHIFT_ASSIGN:
					case LSHIFT_ASSIGN:
					case BAND_ASSIGN:
					case BOR_ASSIGN:
					case BXOR_ASSIGN:
					case QUESTION:
					case LOR:
					case LAND:
					case BOR:
					case BXOR:
					case BAND:
					case EQUAL:
					case NOT_EQUAL:
					case LT:
					case LTE:
					case GT:
					case GTE:
					case LSHIFT:
					case RSHIFT:
					case PLUS:
					case MINUS:
					case DIV:
					case MOD:
					case INC:
					case DEC:
					case LITERAL_sizeof:
					case CharLiteral:
					case NCast:
					case NExpressionGroup:
					case NInitializer:
					case NEmptyExpression:
					case NCommaExpr:
					case NUnaryExpr:
					case NPostfixExpr:
					case NRangeExpr:
					case NStringSeq:
					case NLcurlyInitializer:
					case NGnuAsmExpr:
					case Number:
					case LITERAL___alignof:
					{
						argExprList(_t);
						_t = _retTree;
						break;
					}
					case RPAREN:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
					TNode tmp184_AST_in = (TNode)_t;
					match(_t,RPAREN);
					_t = _t.getNextSibling();
					_t = __t269;
					_t = _t.getNextSibling();
					break;
				}
				case LBRACKET:
				{
					TNode tmp185_AST_in = (TNode)_t;
					match(_t,LBRACKET);
					_t = _t.getNextSibling();
					expr(_t);
					_t = _retTree;
					TNode tmp186_AST_in = (TNode)_t;
					match(_t,RBRACKET);
					_t = _t.getNextSibling();
					break;
				}
				case INC:
				{
					TNode tmp187_AST_in = (TNode)_t;
					match(_t,INC);
					_t = _t.getNextSibling();
					break;
				}
				case DEC:
				{
					TNode tmp188_AST_in = (TNode)_t;
					match(_t,DEC);
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					if ( _cnt271>=1 ) { break _loop271; } else {throw new NoViableAltException(_t);}
				}
				}
				_cnt271++;
			} while (true);
			}
			_t = __t267;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void primaryExpr(AST _t) throws RecognitionException {
		
		TNode primaryExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			{
				TNode tmp189_AST_in = (TNode)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				break;
			}
			case Number:
			{
				TNode tmp190_AST_in = (TNode)_t;
				match(_t,Number);
				_t = _t.getNextSibling();
				break;
			}
			case CharLiteral:
			{
				charConst(_t);
				_t = _retTree;
				break;
			}
			case NStringSeq:
			{
				stringConst(_t);
				_t = _retTree;
				break;
			}
			case NExpressionGroup:
			{
				AST __t273 = _t;
				TNode tmp191_AST_in = (TNode)_t;
				match(_t,NExpressionGroup);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t273;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void commaExpr(AST _t) throws RecognitionException {
		
		TNode commaExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t186 = _t;
			TNode tmp192_AST_in = (TNode)_t;
			match(_t,NCommaExpr);
			_t = _t.getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t186;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void emptyExpr(AST _t) throws RecognitionException {
		
		TNode emptyExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			TNode tmp193_AST_in = (TNode)_t;
			match(_t,NEmptyExpression);
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void compoundStatementExpr(AST _t) throws RecognitionException {
		
		TNode compoundStatementExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t189 = _t;
			TNode tmp194_AST_in = (TNode)_t;
			match(_t,LPAREN);
			_t = _t.getFirstChild();
			compoundStatement(_t);
			_t = _retTree;
			TNode tmp195_AST_in = (TNode)_t;
			match(_t,RPAREN);
			_t = _t.getNextSibling();
			_t = __t189;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rangeExpr(AST _t) throws RecognitionException {
		
		TNode rangeExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t191 = _t;
			TNode tmp196_AST_in = (TNode)_t;
			match(_t,NRangeExpr);
			_t = _t.getFirstChild();
			expr(_t);
			_t = _retTree;
			TNode tmp197_AST_in = (TNode)_t;
			match(_t,VARARGS);
			_t = _t.getNextSibling();
			expr(_t);
			_t = _retTree;
			_t = __t191;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void gnuAsmExpr(AST _t) throws RecognitionException {
		
		TNode gnuAsmExpr_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t193 = _t;
			TNode tmp198_AST_in = (TNode)_t;
			match(_t,NGnuAsmExpr);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_volatile:
			{
				TNode tmp199_AST_in = (TNode)_t;
				match(_t,LITERAL_volatile);
				_t = _t.getNextSibling();
				break;
			}
			case LPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			TNode tmp200_AST_in = (TNode)_t;
			match(_t,LPAREN);
			_t = _t.getNextSibling();
			stringConst(_t);
			_t = _retTree;
			{
			if (_t==null) _t=ASTNULL;
			if ((_t.getType()==COLON)) {
				TNode tmp201_AST_in = (TNode)_t;
				match(_t,COLON);
				_t = _t.getNextSibling();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case NStringSeq:
				{
					strOptExprPair(_t);
					_t = _retTree;
					{
					_loop198:
					do {
						if (_t==null) _t=ASTNULL;
						if ((_t.getType()==COMMA)) {
							TNode tmp202_AST_in = (TNode)_t;
							match(_t,COMMA);
							_t = _t.getNextSibling();
							strOptExprPair(_t);
							_t = _retTree;
						}
						else {
							break _loop198;
						}
						
					} while (true);
					}
					break;
				}
				case COLON:
				case RPAREN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==COLON)) {
					TNode tmp203_AST_in = (TNode)_t;
					match(_t,COLON);
					_t = _t.getNextSibling();
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case NStringSeq:
					{
						strOptExprPair(_t);
						_t = _retTree;
						{
						_loop202:
						do {
							if (_t==null) _t=ASTNULL;
							if ((_t.getType()==COMMA)) {
								TNode tmp204_AST_in = (TNode)_t;
								match(_t,COMMA);
								_t = _t.getNextSibling();
								strOptExprPair(_t);
								_t = _retTree;
							}
							else {
								break _loop202;
							}
							
						} while (true);
						}
						break;
					}
					case COLON:
					case RPAREN:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
				}
				else if ((_t.getType()==COLON||_t.getType()==RPAREN)) {
				}
				else {
					throw new NoViableAltException(_t);
				}
				
				}
			}
			else if ((_t.getType()==COLON||_t.getType()==RPAREN)) {
			}
			else {
				throw new NoViableAltException(_t);
			}
			
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COLON:
			{
				TNode tmp205_AST_in = (TNode)_t;
				match(_t,COLON);
				_t = _t.getNextSibling();
				stringConst(_t);
				_t = _retTree;
				{
				_loop205:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==COMMA)) {
						TNode tmp206_AST_in = (TNode)_t;
						match(_t,COMMA);
						_t = _t.getNextSibling();
						stringConst(_t);
						_t = _retTree;
					}
					else {
						break _loop205;
					}
					
				} while (true);
				}
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			TNode tmp207_AST_in = (TNode)_t;
			match(_t,RPAREN);
			_t = _t.getNextSibling();
			_t = __t193;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	protected final void stringConst(AST _t) throws RecognitionException {
		
		TNode stringConst_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			AST __t279 = _t;
			TNode tmp208_AST_in = (TNode)_t;
			match(_t,NStringSeq);
			_t = _t.getFirstChild();
			{
			int _cnt281=0;
			_loop281:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==StringLiteral)) {
					TNode tmp209_AST_in = (TNode)_t;
					match(_t,StringLiteral);
					_t = _t.getNextSibling();
				}
				else {
					if ( _cnt281>=1 ) { break _loop281; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt281++;
			} while (true);
			}
			_t = __t279;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void strOptExprPair(AST _t) throws RecognitionException {
		
		TNode strOptExprPair_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			stringConst(_t);
			_t = _retTree;
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LPAREN:
			{
				TNode tmp210_AST_in = (TNode)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				expr(_t);
				_t = _retTree;
				TNode tmp211_AST_in = (TNode)_t;
				match(_t,RPAREN);
				_t = _t.getNextSibling();
				break;
			}
			case COMMA:
			case COLON:
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void unaryOperator(AST _t) throws RecognitionException {
		
		TNode unaryOperator_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case BAND:
			{
				TNode tmp212_AST_in = (TNode)_t;
				match(_t,BAND);
				_t = _t.getNextSibling();
				break;
			}
			case STAR:
			{
				TNode tmp213_AST_in = (TNode)_t;
				match(_t,STAR);
				_t = _t.getNextSibling();
				break;
			}
			case PLUS:
			{
				TNode tmp214_AST_in = (TNode)_t;
				match(_t,PLUS);
				_t = _t.getNextSibling();
				break;
			}
			case MINUS:
			{
				TNode tmp215_AST_in = (TNode)_t;
				match(_t,MINUS);
				_t = _t.getNextSibling();
				break;
			}
			case BNOT:
			{
				TNode tmp216_AST_in = (TNode)_t;
				match(_t,BNOT);
				_t = _t.getNextSibling();
				break;
			}
			case LNOT:
			{
				TNode tmp217_AST_in = (TNode)_t;
				match(_t,LNOT);
				_t = _t.getNextSibling();
				break;
			}
			case LAND:
			{
				TNode tmp218_AST_in = (TNode)_t;
				match(_t,LAND);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL___real:
			{
				TNode tmp219_AST_in = (TNode)_t;
				match(_t,LITERAL___real);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL___imag:
			{
				TNode tmp220_AST_in = (TNode)_t;
				match(_t,LITERAL___imag);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void argExprList(AST _t) throws RecognitionException {
		
		TNode argExprList_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			{
			int _cnt276=0;
			_loop276:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_4.member(_t.getType()))) {
					expr(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt276>=1 ) { break _loop276; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt276++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	protected final void charConst(AST _t) throws RecognitionException {
		
		TNode charConst_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			TNode tmp221_AST_in = (TNode)_t;
			match(_t,CharLiteral);
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	protected final void intConst(AST _t) throws RecognitionException {
		
		TNode intConst_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case IntOctalConst:
			{
				TNode tmp222_AST_in = (TNode)_t;
				match(_t,IntOctalConst);
				_t = _t.getNextSibling();
				break;
			}
			case LongOctalConst:
			{
				TNode tmp223_AST_in = (TNode)_t;
				match(_t,LongOctalConst);
				_t = _t.getNextSibling();
				break;
			}
			case UnsignedOctalConst:
			{
				TNode tmp224_AST_in = (TNode)_t;
				match(_t,UnsignedOctalConst);
				_t = _t.getNextSibling();
				break;
			}
			case IntIntConst:
			{
				TNode tmp225_AST_in = (TNode)_t;
				match(_t,IntIntConst);
				_t = _t.getNextSibling();
				break;
			}
			case LongIntConst:
			{
				TNode tmp226_AST_in = (TNode)_t;
				match(_t,LongIntConst);
				_t = _t.getNextSibling();
				break;
			}
			case UnsignedIntConst:
			{
				TNode tmp227_AST_in = (TNode)_t;
				match(_t,UnsignedIntConst);
				_t = _t.getNextSibling();
				break;
			}
			case IntHexConst:
			{
				TNode tmp228_AST_in = (TNode)_t;
				match(_t,IntHexConst);
				_t = _t.getNextSibling();
				break;
			}
			case LongHexConst:
			{
				TNode tmp229_AST_in = (TNode)_t;
				match(_t,LongHexConst);
				_t = _t.getNextSibling();
				break;
			}
			case UnsignedHexConst:
			{
				TNode tmp230_AST_in = (TNode)_t;
				match(_t,UnsignedHexConst);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	protected final void floatConst(AST _t) throws RecognitionException {
		
		TNode floatConst_AST_in = (_t == ASTNULL) ? null : (TNode)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case FloatDoubleConst:
			{
				TNode tmp231_AST_in = (TNode)_t;
				match(_t,FloatDoubleConst);
				_t = _t.getNextSibling();
				break;
			}
			case DoubleDoubleConst:
			{
				TNode tmp232_AST_in = (TNode)_t;
				match(_t,DoubleDoubleConst);
				_t = _t.getNextSibling();
				break;
			}
			case LongDoubleConst:
			{
				TNode tmp233_AST_in = (TNode)_t;
				match(_t,LongDoubleConst);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"typedef\"",
		"\"asm\"",
		"\"volatile\"",
		"LCURLY",
		"RCURLY",
		"SEMI",
		"\"struct\"",
		"\"union\"",
		"\"enum\"",
		"\"auto\"",
		"\"register\"",
		"\"extern\"",
		"\"static\"",
		"\"const\"",
		"\"void\"",
		"\"char\"",
		"\"short\"",
		"\"int\"",
		"\"long\"",
		"\"float\"",
		"\"double\"",
		"\"signed\"",
		"\"unsigned\"",
		"\"int8_t\"",
		"\"uint8_t\"",
		"\"int16_t\"",
		"\"uint16_t\"",
		"\"__int32\"",
		"\"int32_t\"",
		"\"wchar_t\"",
		"\"uint32_t\"",
		"\"__int64\"",
		"\"int64_t\"",
		"\"uint64_t\"",
		"\"ptrdiff_t\"",
		"\"intptr_t\"",
		"\"size_t\"",
		"\"uintptr_t\"",
		"ID",
		"COMMA",
		"COLON",
		"ASSIGN",
		"STAR",
		"LPAREN",
		"RPAREN",
		"LBRACKET",
		"RBRACKET",
		"VARARGS",
		"\"while\"",
		"\"do\"",
		"\"for\"",
		"\"goto\"",
		"\"continue\"",
		"\"break\"",
		"\"return\"",
		"\"case\"",
		"\"default\"",
		"\"if\"",
		"\"else\"",
		"\"switch\"",
		"DIV_ASSIGN",
		"PLUS_ASSIGN",
		"MINUS_ASSIGN",
		"STAR_ASSIGN",
		"MOD_ASSIGN",
		"RSHIFT_ASSIGN",
		"LSHIFT_ASSIGN",
		"BAND_ASSIGN",
		"BOR_ASSIGN",
		"BXOR_ASSIGN",
		"QUESTION",
		"LOR",
		"LAND",
		"BOR",
		"BXOR",
		"BAND",
		"EQUAL",
		"NOT_EQUAL",
		"LT",
		"LTE",
		"GT",
		"GTE",
		"LSHIFT",
		"RSHIFT",
		"PLUS",
		"MINUS",
		"DIV",
		"MOD",
		"INC",
		"DEC",
		"\"sizeof\"",
		"BNOT",
		"LNOT",
		"PTR",
		"DOT",
		"CharLiteral",
		"StringLiteral",
		"IntOctalConst",
		"LongOctalConst",
		"UnsignedOctalConst",
		"IntIntConst",
		"LongIntConst",
		"UnsignedIntConst",
		"IntHexConst",
		"LongHexConst",
		"UnsignedHexConst",
		"FloatDoubleConst",
		"DoubleDoubleConst",
		"LongDoubleConst",
		"NTypedefName",
		"NInitDecl",
		"NDeclarator",
		"NStructDeclarator",
		"NDeclaration",
		"NCast",
		"NPointerGroup",
		"NExpressionGroup",
		"NFunctionCallArgs",
		"NNonemptyAbstractDeclarator",
		"NInitializer",
		"NStatementExpr",
		"NEmptyExpression",
		"NParameterTypeList",
		"NFunctionDef",
		"NCompoundStatement",
		"NParameterDeclaration",
		"NCommaExpr",
		"NUnaryExpr",
		"NLabel",
		"NPostfixExpr",
		"NRangeExpr",
		"NStringSeq",
		"NInitializerElementLabel",
		"NLcurlyInitializer",
		"NAsmAttribute",
		"NGnuAsmExpr",
		"NTypeMissing",
		"Vocabulary",
		"Whitespace",
		"Comment",
		"CPPComment",
		"NonWhitespace",
		"a line directive",
		"DefineExpr",
		"DefineExpr2",
		"Space",
		"LineDirective",
		"BadStringLiteral",
		"Escape",
		"Digit",
		"LongSuffix",
		"UnsignedSuffix",
		"FloatSuffix",
		"Exponent",
		"Number",
		"\"__label__\"",
		"\"inline\"",
		"\"typeof\"",
		"\"__complex\"",
		"\"__attribute\"",
		"\"__alignof\"",
		"\"__real\"",
		"\"__imag\""
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 100794432L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 4398046387264L, 562949953421312L, 25769803776L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 544L, -9214364837600034816L, 4096L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { -4616189618054757888L, 1152921504606846976L, 17L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 250688651132928L, 2972375790571749375L, 69793221356L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	}
	
