package com.andreybotanic.asm.nasm;

import com.intellij.lexer.FlexAdapter;

public class NasmLexerAdapter extends FlexAdapter {
    public NasmLexerAdapter() {
        super(new _NasmLexer(null));
    }
}
