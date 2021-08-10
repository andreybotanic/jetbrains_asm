package com.andreybotanic.asm.nasm;

import com.intellij.lang.Language;

public class NasmLanguage extends Language {
    public static final NasmLanguage INSTANCE = new NasmLanguage();

    private NasmLanguage() {
        super("Nasm");
    }
}
