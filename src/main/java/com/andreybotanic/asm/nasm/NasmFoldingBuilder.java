package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.NasmBlockComment;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.CustomFoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.stream.Collectors;


public class NasmFoldingBuilder extends CustomFoldingBuilder {
    /**
     * Implement this method to build language folding regions besides custom folding regions.
     *
     * @param descriptors The list of folding descriptors to store results to.
     * @param root        The root node for which the folding is requested.
     * @param document    The document for which folding is built.
     * @param quick       whether the result should be provided as soon as possible without reference resolving
     */
    @Override
    protected void buildLanguageFoldRegions(@NotNull List<FoldingDescriptor> descriptors,
                                            @NotNull PsiElement root,
                                            @NotNull Document document,
                                            boolean quick) {
        descriptors.addAll(PsiTreeUtil.findChildrenOfType(root, NasmBlockComment.class).stream()
                .map(blockComment -> new FoldingDescriptor(blockComment.getNode(), blockComment.getTextRange()))
                .collect(Collectors.toList())
        );
    }

    @Override
    protected String getLanguagePlaceholderText(@NotNull ASTNode node, @NotNull TextRange range) {
        return ";...";
    }

    /**
     * Returns the default collapsed state for the folding region related to the specified node.
     *
     * @param node the node for which the collapsed state is requested.
     * @return true if the region is collapsed by default, false otherwise.
     */
    @Override
    protected boolean isRegionCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
