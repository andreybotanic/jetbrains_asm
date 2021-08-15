package com.andreybotanic.asm.nasm.psi;

import com.andreybotanic.asm.nasm.NasmFile;
import com.andreybotanic.asm.nasm.NasmFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;

public class NasmElementFactory {
    public static NasmLabel createLabel(Project project, String name) {
        final NasmFile file = createFile(project, name + ":");
        return (NasmLabel) file.getFirstChild();
    }

    public static PsiElement createIdentifier(Project project, String name) {
        final NasmFile file = createFile(project, name);
        return file.getFirstChild();
    }

    public static NasmLabelIdentifier createLabelIdentifierId(Project project, String name) {
        final NasmFile file = createFile(project, "db short "+name);
        return PsiTreeUtil.getChildOfType(file.getFirstChild(), NasmLabelIdentifier.class);
    }

    public static NasmLabelIdentifier createLabelIdentifierLbl(Project project, String name) {
        if (name.charAt(0) == '.') {
            name = name.substring(1);
        }
        final NasmFile file = createFile(project, "db ."+name);
        return PsiTreeUtil.getChildOfType(file.getFirstChild(), NasmLabelIdentifier.class);
    }

    private static NasmFile createFile(Project project, String text) {
        return (NasmFile) PsiFileFactory.getInstance(project).createFileFromText("dummy.create.asm", NasmFileType.INSTANCE, text);
    }
}
