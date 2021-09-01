package com.andreybotanic.asm.nasm.quickfix;

import com.andreybotanic.asm.nasm.psi.NasmInstruction;
import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInsight.intention.PsiElementBaseIntentionAction;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class NasmOptimizeQuickFix extends PsiElementBaseIntentionAction implements IntentionAction {
    @Override
    public @NotNull @IntentionFamilyName String getFamilyName() {
        return "Optimize code";
    }

    @Nullable
    protected NasmInstruction findInstruction(@NotNull PsiElement element) {
        if (element instanceof NasmInstruction) {
            return (NasmInstruction) element;
        } else if (((LeafPsiElement) element).getElementType() == NasmTypes.EOL) {
            return (NasmInstruction) element.getPrevSibling().getFirstChild();
        } else {
            return PsiTreeUtil.getParentOfType(element, NasmInstruction.class);
        }
    }
}
