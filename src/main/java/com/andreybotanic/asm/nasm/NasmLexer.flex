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
BINARY=[1][01]*b
DECIMAL=0|[1-9][0-9]*
HEXADECIMAL=(0x[0-9A-Fa-f]+)|([0-9A-Fa-f]+h)
COMMENT=;[^\r\n]*
REGISTER=[re]?[abcd]x|[abcd][hl]
GENERAL_OP=mov|xor|add|inc|dec|jmp
IDENTIFIER=([a-zA-Z$._?#@]+[a-zA-Z0-9$._~]*)

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  ","                { return SEPARATOR; }
  ":"                { return COLON; }

  {WHITE_SPACE}      { return WHITE_SPACE; }
  {EOL}              { return EOL; }
  {BINARY}           { return BINARY; }
  {DECIMAL}          { return DECIMAL; }
  {HEXADECIMAL}      { return HEXADECIMAL; }
  {COMMENT}          { return COMMENT; }
  {REGISTER}         { return REGISTER; }
  {GENERAL_OP}       { return GENERAL_OP; }
  {IDENTIFIER}       { return IDENTIFIER; }

}

[^] { return BAD_CHARACTER; }
