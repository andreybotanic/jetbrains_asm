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
DX=[dD][bBwWdDqQtToOyYzZ]
COMMENT=;[^\r\n]*
REGISTER=[re]?[abcd]x|[abcd][hl]
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
  {WHITE_SPACE}        { return WHITE_SPACE; }

  ":"                  { return COLON; }
  ";"                  { return SEMICOLON; }
  "["                  { return SQUARE_L; }
  "]"                  { return SQUARE_R; }
  "("                  { return ROUND_L; }
  ")"                  { return ROUND_R; }
  ","                  { return SEPARATOR; }
  "."                  { return DOT; }
  "?"                  { return QUESTION; }
  "="                  { return EQUAL; }
  "=="                 { return EQUALEQUAL; }
  "!="                 { return NOTEQUAL; }
  ">"                  { return GREATERTHAN; }
  "<"                  { return LESSTHAN; }
  ">="                 { return GREATERTHANOREQUAL; }
  "<="                 { return LESSTHANOREQUAL; }
  "+"                  { return PLUS; }
  "-"                  { return MINUS; }
  "*"                  { return TIMES; }
  "/"                  { return DIVIDE; }
  "<<"                 { return BITSHIFT_L; }
  ">>"                 { return BITSHIFT_R; }
  "&"                  { return BITWISE_AND; }
  "|"                  { return BITWISE_OR; }
  "^"                  { return BITWISE_XOR; }
  "~"                  { return BITWISE_NOT; }
  "&&"                 { return LOGICAL_AND; }
  "||"                 { return LOGICAL_OR; }
  "^^"                 { return LOGICAL_XOR; }
  "$"                  { return DOLLARSIGN; }
  "$$"                 { return DOLLARSIGN2; }
  "%"                  { return PERCENT; }
  "%%"                 { return PERCENT2; }
  "%+"                 { return TOKEN_CONCAT; }
  "SIZE_TYPE"          { return SIZE_TYPE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {EOL}                { return EOL; }
  {DX}                 { return DX; }
  {COMMENT}            { return COMMENT; }
  {REGISTER}           { return REGISTER; }
  {GENERAL_OP}         { return GENERAL_OP; }
  {ID}                 { return ID; }
  {LBL_DEF}            { return LBL_DEF; }
  {LBL}                { return LBL; }
  {BINARY}             { return BINARY; }
  {HEXADECIMAL}        { return HEXADECIMAL; }
  {ZEROES}             { return ZEROES; }
  {DECIMAL}            { return DECIMAL; }
  {FLOAT_DECIMAL}      { return FLOAT_DECIMAL; }
  {CHARACTER}          { return CHARACTER; }
  {STRING}             { return STRING; }

}

[^] { return BAD_CHARACTER; }
