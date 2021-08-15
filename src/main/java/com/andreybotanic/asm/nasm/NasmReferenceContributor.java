package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.NasmNamedElement;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;
import org.jetbrains.annotations.NotNull;

public class NasmReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(NasmNamedElement.class),
                new NasmReferenceProvider());
    }
}
