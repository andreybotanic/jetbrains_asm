package com.andreybotanic.asm.nasm;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class NasmFile extends PsiFileBase {
    protected NasmFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, NasmLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return NasmFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "NASM File";
    }
}
