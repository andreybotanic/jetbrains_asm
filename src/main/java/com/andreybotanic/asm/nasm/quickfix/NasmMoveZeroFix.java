package com.andreybotanic.asm.nasm.quickfix;

import com.andreybotanic.asm.nasm.psi.NasmElementFactory;
import com.andreybotanic.asm.nasm.psi.NasmInstruction;
import com.intellij.codeInspection.util.IntentionName;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class NasmMoveZeroFix extends NasmOptimizeQuickFix {
    @SuppressWarnings("ConstantConditions")
    @Override
    public void invoke(@NotNull Project project, Editor editor, @NotNull PsiElement element) throws IncorrectOperationException {
        NasmInstruction instruction;
        if (element instanceof NasmInstruction) {
            instruction = (NasmInstruction) element;
        } else {
            instruction = PsiTreeUtil.getParentOfType(element, NasmInstruction.class);
        }
        String register = instruction.getOperandList().get(0).getText();
        String[] operands = new String[]{register, register};
        NasmInstruction newInstruction = NasmElementFactory.createInstruction(project, "xor", operands);
        instruction.replace(newInstruction);
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, @NotNull PsiElement element) {
        NasmInstruction instruction = PsiTreeUtil.getParentOfType(element, NasmInstruction.class);
        if (instruction == null) {
            return false;
        }
        if (!instruction.getOperation().getText().equals("mov")) {
            return false;
        }
        return instruction.getOperandList().get(1).getText().equals("0");
    }

    @Override
    public @IntentionName @NotNull String getText() {
        return "Replace with XOR";
    }

    public boolean startInWriteAction() {
        return true;
    }
}
