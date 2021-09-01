package com.andreybotanic.asm.nasm.quickfix;

import com.andreybotanic.asm.nasm.psi.NasmElementFactory;
import com.andreybotanic.asm.nasm.psi.NasmInstruction;
import com.intellij.codeInspection.util.IntentionName;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

public class NasmAddSubFix extends NasmOptimizeQuickFix {
    @Override
    public void invoke(@NotNull Project project, Editor editor, @NotNull PsiElement element) throws IncorrectOperationException {
        NasmInstruction instruction = findInstruction(element);
        if (instruction == null) {
            return;
        }
        String register = instruction.getOperandList().get(0).getText();
        if (instruction.getOperation().getText().equals("add")) {
            NasmInstruction newInstruction = NasmElementFactory.createInstruction(project, "inc", new String[]{register});
            instruction.replace(newInstruction);
        } else if (instruction.getOperation().getText().equals("sub")) {
            NasmInstruction newInstruction = NasmElementFactory.createInstruction(project, "dec", new String[]{register});
            instruction.replace(newInstruction);
        }
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, @NotNull PsiElement element) {
        return true;
    }

    @Override
    public @IntentionName @NotNull String getText() {
        return "Replace with INC / DEC";
    }
}
