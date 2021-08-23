package com.andreybotanic.asm.nasm.completion;

import com.andreybotanic.asm.nasm.NasmFile;
import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.ElementPattern;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;

public class NasmCompletionContributor extends CompletionContributor {
    public NasmCompletionContributor() {
        extend(CompletionType.BASIC, mnemonic(), new MnemonicProvider());
    }

    private static ElementPattern<PsiElement> mnemonic() {
        return PlatformPatterns.psiElement(NasmTypes.ID)
                .withSuperParent(4, NasmFile.class);
    }
}
