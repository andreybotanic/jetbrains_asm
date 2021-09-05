package com.andreybotanic.asm.nasm.annotations;

import com.andreybotanic.asm.nasm.psi.NasmInstruction;
import com.andreybotanic.asm.nasm.psi.NasmRegister;
import com.andreybotanic.asm.nasm.quickfix.NasmAddSubFix;
import com.andreybotanic.asm.nasm.quickfix.NasmMoveZeroFix;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class NasmCodeInspectionAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof NasmInstruction) {
            annotateInstruction((NasmInstruction) element, holder);
        }
    }

    private void annotateInstruction(@NotNull NasmInstruction instruction, @NotNull AnnotationHolder holder) {
        // Check for all possible fixes
        if (instruction.getOperation().getText().equals("mov")
                && instruction.getOperandList().get(0).getFirstChild() instanceof NasmRegister
                && instruction.getOperandList().get(1).getText().equals("0")) {
            addWarningAnnotation(holder, instruction, new NasmMoveZeroFix());
        } else if ((instruction.getOperation().getText().equals("add")
                || instruction.getOperation().getText().equals("sub"))
                && instruction.getOperandList().get(0).getFirstChild() instanceof NasmRegister
                && instruction.getOperandList().get(1).getText().equals("1")) {
            addWarningAnnotation(holder, instruction, new NasmAddSubFix());
        }
    }

    private void addWarningAnnotation(@NotNull AnnotationHolder holder,
                                      @NotNull NasmInstruction instruction,
                                      IntentionAction action) {
        holder.newAnnotation(HighlightSeverity.WARNING, "Not optimized code")
                .highlightType(ProblemHighlightType.WEAK_WARNING)
                .range(instruction.getTextRange())
                .withFix(action)
                .create();
    }
}
