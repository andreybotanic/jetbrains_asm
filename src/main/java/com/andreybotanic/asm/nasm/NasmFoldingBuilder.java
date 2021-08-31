package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.NasmBlockComment;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class NasmFoldingBuilder extends FoldingBuilderEx implements DumbAware {
    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        FoldingDescriptor[] descriptors = PsiTreeUtil.findChildrenOfType(root, NasmBlockComment.class).stream()
                .map(blockComment -> new FoldingDescriptor(blockComment.getNode(), blockComment.getTextRange()))
                .toArray(FoldingDescriptor[]::new);
        return descriptors;
    }

    @Override
    public @Nullable String getPlaceholderText(@NotNull ASTNode node) {
        return ";...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
