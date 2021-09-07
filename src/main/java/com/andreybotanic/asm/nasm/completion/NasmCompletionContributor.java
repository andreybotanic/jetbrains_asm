package com.andreybotanic.asm.nasm.completion;

import com.andreybotanic.asm.nasm.psi.NasmInstruction;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.ElementPattern;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;

public class NasmCompletionContributor extends CompletionContributor {
    private static final ElementPattern<PsiElement> MNEMONIC_START = PlatformPatterns
            .psiElement()
            .afterLeaf("\n");

    private static final ElementPattern<PsiElement> AFTER_MNEMONIC = PlatformPatterns
            .psiElement()
            .inside(NasmInstruction.class); // TODO: check for more strict pattern

    public NasmCompletionContributor() {
        extend(CompletionType.BASIC, MNEMONIC_START, new MnemonicProvider());
        extend(CompletionType.BASIC, AFTER_MNEMONIC, new RegisterProvider());
    }
}
