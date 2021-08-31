package com.andreybotanic.asm.nasm.quickfix;

import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInsight.intention.PsiElementBaseIntentionAction;
import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

public abstract class NasmOptimizeQuickFix extends PsiElementBaseIntentionAction implements IntentionAction {
    @Override
    public @NotNull @IntentionFamilyName String getFamilyName() {
        return "Optimize code";
    }
}
