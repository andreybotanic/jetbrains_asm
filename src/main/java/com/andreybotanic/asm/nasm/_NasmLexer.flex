package com.andreybotanic.asm.nasm;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.andreybotanic.asm.nasm.psi.NasmTypes.*;

%%

%{
  public _NasmLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _NasmLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

WHITE_SPACE=[ \t\x0B\f]+
EOL=\R
INCLUDE_TAG=(%([ \t\n\x0B\f\r]+)?)([iI][nN][cC][lL][uU][dD][eE])
DEFINE_TAG=(%([ \t\n\x0B\f\r]+)?)(([xX]|[iI])?[dD][eE][fF][iI][nN][eE])
ASSIGN_TAG=(%([ \t\n\x0B\f\r]+)?)([iI]?[aA][sS][sS][iI][gG][nN])
DATA_DEF=[dD][bBwWdDqQtToOyYzZ]
DATA_RES=[rR][eE][sS][bBwWdDqQtToOyYzZ]
COMMENT=;[^\r\n]*
SECTION_DEF=section|segment
SECTION_NAME=\.(text|data|bss)
DIRECTIVE_OP=(bits |use|code)(16|32)|absolute|external|global|org|align|struc|endstruc|common|cpu|group|uppercase|import|library|module
END_DIRECTIVE_OP=end
REG_8=[aAbBcCdD][hHlL]
REG_16=[aAbBcCdD][xX]
REG_32=[eE][aAbBcCdD][xX]
REG_64=[rR][aAbBcCdD][xX]
OP_PREFIX=[rR][eE][pP]([nN]?[eEzZ])?|[lL][oO][cC][kK]|[bB][nN][dD]|[xX][aA][cC][qQ][uU][iI][rR][eE]|[xX][rR][eE][lL][eE][aA][sS][eE]
SIZE_PREFIX=[bB][yY][tT][eE]|[dDqQ]?[wW][oO][rR][dD]
ARITHMETIC_OP=[iI][nN][cC]|[dD][eE][cC]|[aA][dD][dD]|[sS][uU][bB]|[iI][mM][uU][lL]|[iI][dD][iI][vV]|[nN][eE][gG]
LOGIC_OP=[xX]?[oO][rR]|[aA][nN][dD]|[nN][oO][tT]|[bB][tT][cCsSrR]?|[tT][eE][sS][tT]
BIT_SHIFT_OP=[sS][aAhH][lL][rR]|[rR][cCoO][lL][rR]
STACK_OP=([pP][uU][sS][hH]|[pP][oO][pP])([aAfF][dD]?)?
MOV_OP=[mM][oO][vV]
STR_MOV_OP=[mM][oO][vV]([sS][bBwWdD]|[zZ]?[xX])
STR_LOAD_OP=[lL][oO][dD][sS][bBwWdD]?
STR_STORE_OP=[sS][tT][oO][sS][bBwWdD]?
STR_OP={STR_MOV_OP}|{STR_LOAD_OP}|{STR_STORE_OP}
JUMP_OP=[jJ][mM][pP]|[jJ][nN]?[aAbBcCeEgGlLoOpPsSzZ]|[jJ][nN]?[aAbBgGlL][eE]|[jJ][pP][eEoO]|[jJ][eErR]?[cC][xX][zZ]
LOOP_OP=[lL][oO][oO][pP][dD]?([nN]?[eEzZ])?
GENERAL_OP={ARITHMETIC_OP}|{LOGIC_OP}|{BIT_SHIFT_OP}|{STACK_OP}|{MOV_OP}|{STR_OP}|{JUMP_OP}|{LOOP_OP}
ID=([a-zA-Z_?]+[a-zA-Z0-9_$.#@~?]*)
LBL_DEF=([a-zA-Z$._?#@]+[a-zA-Z0-9$._~]*):
LBL=([a-zA-Z$._?#@]+[a-zA-Z0-9$._~]*)
BINARY=(0[Bb][01]+)|([1][01]*[Bb])
HEXADECIMAL=(0x[0-9A-Fa-f]+)|([0-9A-Fa-f]+h)
ZEROES=[0]+
DECIMAL=((0[dD])?[0-9]+)
FLOAT_DECIMAL=(([0-9]*\.[^A-Za-z][0-9]*)([Ee][+-]?[0-9]+)?)
CHARACTER=(`([^`\\]|\\.)`?|'([^'\\]|\\.)'?)
STRING=(`([^`\\]|\\.)*`?|'([^'\\]|\\.)*'?|\"([^\"\\]|\\.)*\"?)

%%
<YYINITIAL> {
  {WHITE_SPACE}           { return WHITE_SPACE; }

  ":"                     { return COLON; }
  ";"                     { return COMMENT; }
  "["                     { return SQUARE_L; }
  "]"                     { return SQUARE_R; }
  "("                     { return ROUND_L; }
  ")"                     { return ROUND_R; }
  "{"                     { return CURLY_L; }
  "}"                     { return CURLY_R; }
  ","                     { return SEPARATOR; }
  "."                     { return DOT; }
  "?"                     { return QUESTION; }
  "="                     { return EQUAL; }
  "=="                    { return EQUALEQUAL; }
  "!="                    { return NOTEQUAL; }
  ">"                     { return GREATERTHAN; }
  "<"                     { return LESSTHAN; }
  ">="                    { return GREATERTHANOREQUAL; }
  "<="                    { return LESSTHANOREQUAL; }
  "+"                     { return PLUS; }
  "-"                     { return MINUS; }
  "*"                     { return TIMES; }
  "/"                     { return DIVIDE; }
  "<<"                    { return BITSHIFT_L; }
  ">>"                    { return BITSHIFT_R; }
  "&"                     { return BITWISE_AND; }
  "|"                     { return BITWISE_OR; }
  "^"                     { return BITWISE_XOR; }
  "~"                     { return BITWISE_NOT; }
  "&&"                    { return LOGICAL_AND; }
  "||"                    { return LOGICAL_OR; }
  "^^"                    { return LOGICAL_XOR; }
  "$"                     { return DOLLARSIGN; }
  "$$"                    { return DOLLARSIGN2; }
  "%"                     { return PERCENT; }
  "%%"                    { return PERCENT2; }
  "%+"                    { return TOKEN_CONCAT; }

  {WHITE_SPACE}           { return WHITE_SPACE; }
  {EOL}                   { return EOL; }
  {INCLUDE_TAG}           { return INCLUDE_TAG; }
  {DEFINE_TAG}            { return DEFINE_TAG; }
  {ASSIGN_TAG}            { return ASSIGN_TAG; }
  {DATA_DEF}              { return DATA_DEF; }
  {DATA_RES}              { return DATA_RES; }
  {COMMENT}               { return COMMENT; }
  {SECTION_DEF}           { return SECTION_DEF; }
  {SECTION_NAME}          { return SECTION_NAME; }
  {DIRECTIVE_OP}          { return DIRECTIVE_OP; }
  {END_DIRECTIVE_OP}      { return END_DIRECTIVE_OP; }
  {REG_8}                 { return REG_8; }
  {REG_16}                { return REG_16; }
  {REG_32}                { return REG_32; }
  {REG_64}                { return REG_64; }
  {OP_PREFIX}             { return OP_PREFIX; }
  {SIZE_PREFIX}           { return SIZE_PREFIX; }
  {GENERAL_OP}            { return GENERAL_OP; }
  {ID}                    { return ID; }
  {LBL_DEF}               { return LBL_DEF; }
  {LBL}                   { return LBL; }
  {BINARY}                { return BINARY; }
  {HEXADECIMAL}           { return HEXADECIMAL; }
  {ZEROES}                { return ZEROES; }
  {DECIMAL}               { return DECIMAL; }
  {FLOAT_DECIMAL}         { return FLOAT_DECIMAL; }
  {CHARACTER}             { return CHARACTER; }
  {STRING}                { return STRING; }

}

[^] { return BAD_CHARACTER; }
