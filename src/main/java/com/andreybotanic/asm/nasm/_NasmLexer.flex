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
DATA_DEF=d[bwdqtoyz]
DATA_RES=res[bwdqtoyz]
COMMENT=;[^\r\n]*
SECTION_DEF=section|segment
SECTION_NAME=\.(text|data|bss)
DIRECTIVE_OP=(bits |use|code)(16|32)|absolute|external|global|org|align|struc|endstruc|common|cpu|group|uppercase|import|library|module
END_DIRECTIVE_OP=end
REG_8=[abcd][hl]
REG_16=[abcd]x
REG_32=e[abcd]x
REG_64=r[abcd]x
OP_PREFIX=((rep(n?[ez])|rep)|lock|bnd|xacquire|xrelease)
SIZE_PREFIX=byte|word|dword|qword
GENERAL_OP=mov|xor|add|inc|dec|jmp
ID=([a-zA-Z_?]+[a-zA-Z0-9_$.#@~?]*)
LBL_DEF=([a-zA-Z$._?#@]+[a-zA-Z0-9$._~]*):
LBL=([a-zA-Z$._?#@]+[a-zA-Z0-9$._~]*)
BINARY=[1][01]*b
HEXADECIMAL=(0x[0-9A-Fa-f]+)|([0-9A-Fa-f]+h)
ZEROES=[0]+
DECIMAL=((0[dD])?[0-9]+)
FLOAT_DECIMAL=(([0-9]*\.[^A-Za-z][0-9]*)([Ee][+-]?[0-9]+)?)
CHARACTER=(`([^`\\]|\\.)`|'([^'\\]|\\.)')
STRING=(`([^`\\]|\\.)*`|'([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

%%
<YYINITIAL> {
  {WHITE_SPACE}           { return WHITE_SPACE; }

  ":"                     { return COLON; }
  ";"                     { return SEMICOLON; }
  "["                     { return SQUARE_L; }
  "]"                     { return SQUARE_R; }
  "("                     { return ROUND_L; }
  ")"                     { return ROUND_R; }
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
