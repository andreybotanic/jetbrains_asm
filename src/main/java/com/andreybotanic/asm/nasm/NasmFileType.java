package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.icons.AsmIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class NasmFileType extends LanguageFileType {
    public static final NasmFileType INSTANCE = new NasmFileType();

    private NasmFileType() {
        super(NasmLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "NASM File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Netwide Assembly language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "asm";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return AsmIcons.NasmFileType;
    }

}
