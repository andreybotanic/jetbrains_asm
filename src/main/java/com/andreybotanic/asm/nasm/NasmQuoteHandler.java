package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;

public class NasmQuoteHandler extends SimpleTokenSetQuoteHandler {
    public NasmQuoteHandler() {
        super(NasmTypes.STRING, NasmTypes.CHARACTER);
    }
}
