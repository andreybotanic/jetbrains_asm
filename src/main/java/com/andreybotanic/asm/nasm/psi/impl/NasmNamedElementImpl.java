package com.andreybotanic.asm.nasm.psi.impl;

import com.andreybotanic.asm.nasm.psi.NasmNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class NasmNamedElementImpl extends ASTWrapperPsiElement implements NasmNamedElement {
    public NasmNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
