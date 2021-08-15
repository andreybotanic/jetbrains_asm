package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.icons.AsmIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class NasmColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Separator", NasmSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Comment", NasmSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Number", NasmSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("NASM mnemonic", NasmSyntaxHighlighter.OPERATION),
            new AttributesDescriptor("Label", NasmSyntaxHighlighter.LABEL),
            new AttributesDescriptor("Register", NasmSyntaxHighlighter.REGISTER)
    };

    @Override
    public @Nullable Icon getIcon() {
        return AsmIcons.NasmFileType;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new NasmSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return "mov eax, 0x01\n" +
                "xor ax, ax\n" +
                ".label:\n" +
                "add cx, 10h ; comment\n" +
                "\n" +
                "    ; comment too\n" +
                "inc al\n" +
                "dec bl\n" +
                "jmp .label";
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull String getDisplayName() {
        return "NASM";
    }
}
