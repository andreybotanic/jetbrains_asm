/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.andreybotanic.asm.nasm;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.andreybotanic.asm.nasm.psi.NasmTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>_NasmLexer.flex</tt>
 */
public class _NasmLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\1\1\4\2\3\1\5\22\0\1\1\1\62\1\53\1\32\1\34\1\73\1\70\1\52\1\56\1\57"+
    "\1\66\1\65\1\60\1\47\1\44\1\67\1\37\1\36\10\41\1\35\1\10\1\64\1\61\1\63\1"+
    "\30\1\32\1\42\1\40\1\42\1\6\1\46\1\42\2\45\1\77\2\45\1\75\1\45\1\74\1\7\1"+
    "\103\1\7\1\45\1\76\1\101\2\45\1\7\1\45\1\102\1\100\1\54\1\51\1\55\1\72\1\33"+
    "\1\50\1\23\1\14\1\12\1\13\1\11\1\42\1\45\1\43\1\24\1\26\1\45\1\16\1\17\1\25"+
    "\1\20\1\27\1\7\1\22\1\45\1\7\1\45\1\21\1\7\1\15\2\7\1\0\1\71\1\0\1\31\6\0"+
    "\1\2\242\0\2\2\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\2\4\1\5\10\4\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\13\1\15"+
    "\1\16\3\1\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\1\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\2\4\1\36\1\4\1\37\1\40\1\4"+
    "\1\41\5\4\1\10\1\42\1\0\1\43\1\44\3\0"+
    "\1\14\1\45\2\10\1\37\1\0\1\46\5\0\1\47"+
    "\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57"+
    "\1\60\1\61\1\62\2\4\1\63\1\13\1\44\1\0"+
    "\2\10\1\0\1\64\3\0\1\4\1\45\1\0\5\4"+
    "\1\65";

  private static int [] zzUnpackAction() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\104\0\210\0\104\0\314\0\u0110\0\u0154\0\u0198"+
    "\0\u01dc\0\u0220\0\u0264\0\u02a8\0\u02ec\0\u0330\0\u0374\0\u03b8"+
    "\0\u0154\0\104\0\u03fc\0\u0440\0\104\0\u0484\0\u04c8\0\u050c"+
    "\0\u0550\0\104\0\u0594\0\u05d8\0\u061c\0\104\0\104\0\104"+
    "\0\104\0\104\0\u0660\0\u06a4\0\u06e8\0\u072c\0\104\0\104"+
    "\0\104\0\u0770\0\u07b4\0\u07f8\0\u083c\0\u0880\0\u08c4\0\u0154"+
    "\0\u0908\0\104\0\u0198\0\u094c\0\u0154\0\u0990\0\u09d4\0\u0a18"+
    "\0\u0a5c\0\u0aa0\0\u0ae4\0\u03fc\0\u0b28\0\u0b28\0\104\0\u0b6c"+
    "\0\u0bb0\0\u0bf4\0\u0c38\0\u0c7c\0\u0cc0\0\u0d04\0\u0c7c\0\u0d48"+
    "\0\104\0\u0d8c\0\u0dd0\0\u0e14\0\u061c\0\u0e58\0\104\0\104"+
    "\0\104\0\104\0\104\0\104\0\104\0\104\0\104\0\104"+
    "\0\104\0\u0154\0\u0e9c\0\u0ee0\0\u0154\0\u0bb0\0\u0bf4\0\u0f24"+
    "\0\u0f68\0\u0fac\0\u0ff0\0\104\0\u1034\0\u1078\0\u10bc\0\u1100"+
    "\0\u1144\0\u1144\0\u1188\0\u11cc\0\u1210\0\u1254\0\u1298\0\u0154";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\12\1\14\1\7\1\15"+
    "\2\7\1\11\1\16\1\17\1\7\1\20\1\7\1\21"+
    "\1\22\1\23\1\7\1\24\1\25\1\26\1\27\1\7"+
    "\1\30\2\7\1\31\2\7\1\32\1\33\1\2\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54"+
    "\1\55\1\56\1\7\1\57\5\7\105\0\1\3\1\0"+
    "\1\3\104\0\1\4\105\0\2\60\1\0\2\7\2\60"+
    "\3\7\1\60\10\7\1\61\3\7\1\62\2\61\1\60"+
    "\1\61\5\7\25\0\4\7\3\60\1\7\6\0\2\7"+
    "\1\0\20\7\1\61\3\7\1\62\2\61\1\7\1\61"+
    "\5\7\25\0\10\7\4\63\2\0\76\63\6\0\2\7"+
    "\1\0\1\7\3\64\6\7\1\64\5\7\1\61\3\7"+
    "\1\62\2\61\1\7\1\61\5\7\25\0\10\7\6\0"+
    "\2\7\1\0\4\7\2\65\12\7\1\61\3\7\1\62"+
    "\2\61\1\7\1\61\1\7\1\65\3\7\25\0\10\7"+
    "\6\0\2\60\1\0\1\66\1\7\2\60\2\65\1\7"+
    "\1\60\10\7\1\61\3\7\1\62\2\61\1\60\1\61"+
    "\1\7\1\65\3\7\25\0\4\7\3\60\1\7\6\0"+
    "\2\7\1\0\7\7\1\67\10\7\1\61\3\7\1\62"+
    "\2\61\1\7\1\61\5\7\25\0\10\7\6\0\2\7"+
    "\1\0\7\7\1\70\10\7\1\61\3\7\1\62\2\61"+
    "\1\7\1\61\5\7\25\0\10\7\6\0\2\7\1\0"+
    "\2\7\1\71\1\7\2\65\12\7\1\61\3\7\1\62"+
    "\2\61\1\7\1\61\1\7\1\65\3\7\25\0\10\7"+
    "\6\0\2\7\1\0\14\7\1\66\3\7\1\61\3\7"+
    "\1\62\2\61\1\7\1\61\5\7\25\0\10\7\6\0"+
    "\2\7\1\0\6\7\1\72\11\7\1\61\3\7\1\62"+
    "\2\61\1\7\1\61\5\7\25\0\10\7\6\0\2\23"+
    "\1\0\20\23\1\73\3\23\1\62\2\73\1\23\1\73"+
    "\5\23\25\0\10\23\6\0\2\23\1\0\20\23\1\73"+
    "\2\23\1\74\1\62\2\73\1\23\1\73\5\23\25\0"+
    "\10\23\6\0\1\75\2\0\3\75\1\76\6\0\1\75"+
    "\12\0\2\26\1\75\1\30\1\75\1\77\1\100\1\0"+
    "\1\75\43\0\1\101\2\0\2\75\1\101\1\75\1\102"+
    "\5\0\1\75\12\0\1\30\1\103\1\75\1\30\1\75"+
    "\1\77\1\100\1\0\1\75\43\0\1\75\2\0\4\75"+
    "\6\0\1\75\12\0\2\30\1\75\1\30\1\75\1\77"+
    "\1\100\1\0\1\75\35\0\6\104\2\23\1\104\17\23"+
    "\1\105\1\106\3\105\1\107\2\106\1\23\1\106\2\23"+
    "\1\105\2\23\25\104\10\23\50\110\1\111\1\112\32\110"+
    "\51\113\1\114\1\111\31\113\51\115\1\116\1\115\1\111"+
    "\30\115\61\0\1\117\103\0\1\120\103\0\1\121\1\0"+
    "\1\122\101\0\1\123\2\0\1\124\107\0\1\125\104\0"+
    "\1\126\104\0\1\127\76\0\1\130\5\0\1\131\16\0"+
    "\2\7\1\0\20\7\1\61\3\7\1\62\2\61\1\7"+
    "\1\61\5\7\25\0\1\7\1\132\6\7\6\0\2\7"+
    "\1\0\20\7\1\61\3\7\1\62\2\61\1\7\1\61"+
    "\5\7\25\0\3\7\1\133\4\7\6\0\2\61\1\0"+
    "\17\61\1\134\1\61\1\134\2\61\1\62\11\61\25\0"+
    "\10\61\6\0\2\7\1\0\4\7\1\65\13\7\1\61"+
    "\3\7\1\62\2\61\1\7\1\61\5\7\25\0\10\7"+
    "\6\0\2\7\1\0\1\7\1\135\16\7\1\61\3\7"+
    "\1\62\2\61\1\7\1\61\5\7\25\0\10\7\6\0"+
    "\2\7\1\0\11\7\1\135\6\7\1\61\3\7\1\62"+
    "\2\61\1\7\1\61\5\7\25\0\10\7\6\0\2\7"+
    "\1\0\10\7\1\135\7\7\1\61\3\7\1\62\2\61"+
    "\1\7\1\61\5\7\25\0\10\7\6\0\2\7\1\0"+
    "\2\7\1\135\15\7\1\61\3\7\1\62\2\61\1\7"+
    "\1\61\5\7\25\0\10\7\6\0\2\7\1\0\16\7"+
    "\1\135\1\7\1\61\3\7\1\62\2\61\1\7\1\61"+
    "\5\7\25\0\10\7\6\0\2\73\1\0\17\73\1\0"+
    "\1\73\1\0\2\73\1\62\11\73\25\0\10\73\6\0"+
    "\1\75\2\0\4\75\6\0\1\75\12\0\5\75\1\77"+
    "\2\0\1\75\35\0\6\104\2\0\1\104\17\0\10\104"+
    "\1\0\1\104\2\0\1\104\2\0\25\104\16\0\1\75"+
    "\2\0\4\75\6\0\1\75\12\0\2\136\1\75\1\136"+
    "\1\75\1\77\2\0\1\75\43\0\1\137\2\0\4\137"+
    "\6\0\1\137\12\0\5\137\3\0\1\137\43\0\1\75"+
    "\2\0\4\75\6\0\1\75\12\0\1\30\1\103\1\75"+
    "\1\30\1\75\1\77\1\100\1\0\1\75\46\0\1\140"+
    "\24\0\2\104\1\0\1\104\4\0\1\140\43\0\2\23"+
    "\1\0\1\141\17\23\1\73\3\23\1\62\2\106\1\23"+
    "\1\106\4\23\1\141\25\0\10\23\6\0\2\73\1\0"+
    "\1\142\16\73\1\0\1\73\1\0\2\73\1\62\2\106"+
    "\1\73\1\106\4\73\1\142\25\0\10\73\50\143\1\144"+
    "\1\145\32\143\2\110\4\0\76\110\51\146\1\147\1\144"+
    "\31\146\2\113\4\0\76\113\2\115\4\0\76\115\6\0"+
    "\2\7\1\0\20\7\1\61\3\7\1\62\2\61\1\7"+
    "\1\61\5\7\25\0\4\7\1\150\3\7\6\0\2\134"+
    "\1\0\24\134\1\0\11\134\25\0\10\134\36\0\2\151"+
    "\1\0\1\151\5\0\1\152\15\0\1\152\24\0\2\23"+
    "\1\0\20\23\1\73\3\23\1\62\2\73\1\23\1\73"+
    "\5\23\1\152\15\0\1\152\6\0\10\23\6\0\2\73"+
    "\1\0\17\73\1\0\1\73\1\0\2\73\1\62\11\73"+
    "\1\152\15\0\1\152\6\0\10\73\50\143\1\111\1\145"+
    "\34\143\4\0\76\143\51\146\1\147\1\111\33\146\4\0"+
    "\76\146\6\0\2\7\1\0\20\7\1\61\3\7\1\62"+
    "\2\61\1\7\1\61\4\7\1\153\25\0\10\7\36\0"+
    "\2\151\1\0\1\151\50\0\2\7\1\0\20\7\1\61"+
    "\1\7\1\154\1\7\1\62\2\61\1\7\1\61\5\7"+
    "\25\0\10\7\6\0\2\7\1\0\20\7\1\61\3\7"+
    "\1\62\2\61\1\7\1\61\5\7\25\0\5\7\1\155"+
    "\2\7\6\0\2\7\1\0\20\7\1\61\3\7\1\62"+
    "\2\61\1\7\1\61\5\7\25\0\6\7\1\156\1\7"+
    "\6\0\2\7\1\0\20\7\1\61\3\7\1\62\2\61"+
    "\1\7\1\61\5\7\25\0\7\7\1\157\6\0\2\7"+
    "\1\0\20\7\1\61\3\7\1\62\2\61\1\7\1\61"+
    "\4\7\1\160\25\0\10\7";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4828];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\15\1\1\11\2\1\1\11"+
    "\4\1\1\11\3\1\5\11\4\1\3\11\10\1\1\11"+
    "\12\1\1\0\1\1\1\11\3\0\5\1\1\0\1\11"+
    "\5\0\13\11\6\1\1\0\2\1\1\0\1\11\3\0"+
    "\2\1\1\0\6\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _NasmLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _NasmLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 54: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 55: break;
          case 3: 
            { return EOL;
            } 
            // fall through
          case 56: break;
          case 4: 
            { return ID;
            } 
            // fall through
          case 57: break;
          case 5: 
            { return SEMICOLON;
            } 
            // fall through
          case 58: break;
          case 6: 
            { return QUESTION;
            } 
            // fall through
          case 59: break;
          case 7: 
            { return BITWISE_NOT;
            } 
            // fall through
          case 60: break;
          case 8: 
            { return LBL;
            } 
            // fall through
          case 61: break;
          case 9: 
            { return DOLLARSIGN;
            } 
            // fall through
          case 62: break;
          case 10: 
            { return COLON;
            } 
            // fall through
          case 63: break;
          case 11: 
            { return DECIMAL;
            } 
            // fall through
          case 64: break;
          case 12: 
            { return ZEROES;
            } 
            // fall through
          case 65: break;
          case 13: 
            { return DOT;
            } 
            // fall through
          case 66: break;
          case 14: 
            { return MINUS;
            } 
            // fall through
          case 67: break;
          case 15: 
            { return SQUARE_L;
            } 
            // fall through
          case 68: break;
          case 16: 
            { return SQUARE_R;
            } 
            // fall through
          case 69: break;
          case 17: 
            { return ROUND_L;
            } 
            // fall through
          case 70: break;
          case 18: 
            { return ROUND_R;
            } 
            // fall through
          case 71: break;
          case 19: 
            { return SEPARATOR;
            } 
            // fall through
          case 72: break;
          case 20: 
            { return EQUAL;
            } 
            // fall through
          case 73: break;
          case 21: 
            { return GREATERTHAN;
            } 
            // fall through
          case 74: break;
          case 22: 
            { return LESSTHAN;
            } 
            // fall through
          case 75: break;
          case 23: 
            { return PLUS;
            } 
            // fall through
          case 76: break;
          case 24: 
            { return TIMES;
            } 
            // fall through
          case 77: break;
          case 25: 
            { return DIVIDE;
            } 
            // fall through
          case 78: break;
          case 26: 
            { return BITWISE_AND;
            } 
            // fall through
          case 79: break;
          case 27: 
            { return BITWISE_OR;
            } 
            // fall through
          case 80: break;
          case 28: 
            { return BITWISE_XOR;
            } 
            // fall through
          case 81: break;
          case 29: 
            { return PERCENT;
            } 
            // fall through
          case 82: break;
          case 30: 
            { return DX;
            } 
            // fall through
          case 83: break;
          case 31: 
            { return LBL_DEF;
            } 
            // fall through
          case 84: break;
          case 32: 
            { return COMMENT;
            } 
            // fall through
          case 85: break;
          case 33: 
            { return REGISTER;
            } 
            // fall through
          case 86: break;
          case 34: 
            { return DOLLARSIGN2;
            } 
            // fall through
          case 87: break;
          case 35: 
            { return BINARY;
            } 
            // fall through
          case 88: break;
          case 36: 
            { return HEXADECIMAL;
            } 
            // fall through
          case 89: break;
          case 37: 
            { return FLOAT_DECIMAL;
            } 
            // fall through
          case 90: break;
          case 38: 
            { return STRING;
            } 
            // fall through
          case 91: break;
          case 39: 
            { return EQUALEQUAL;
            } 
            // fall through
          case 92: break;
          case 40: 
            { return NOTEQUAL;
            } 
            // fall through
          case 93: break;
          case 41: 
            { return GREATERTHANOREQUAL;
            } 
            // fall through
          case 94: break;
          case 42: 
            { return BITSHIFT_R;
            } 
            // fall through
          case 95: break;
          case 43: 
            { return LESSTHANOREQUAL;
            } 
            // fall through
          case 96: break;
          case 44: 
            { return BITSHIFT_L;
            } 
            // fall through
          case 97: break;
          case 45: 
            { return LOGICAL_AND;
            } 
            // fall through
          case 98: break;
          case 46: 
            { return LOGICAL_OR;
            } 
            // fall through
          case 99: break;
          case 47: 
            { return LOGICAL_XOR;
            } 
            // fall through
          case 100: break;
          case 48: 
            { return TOKEN_CONCAT;
            } 
            // fall through
          case 101: break;
          case 49: 
            { return PERCENT2;
            } 
            // fall through
          case 102: break;
          case 50: 
            { return NL;
            } 
            // fall through
          case 103: break;
          case 51: 
            { return GENERAL_OP;
            } 
            // fall through
          case 104: break;
          case 52: 
            { return CHARACTER;
            } 
            // fall through
          case 105: break;
          case 53: 
            { return SIZE_TYPE;
            } 
            // fall through
          case 106: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}