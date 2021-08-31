package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.ResourceLoader;
import com.andreybotanic.asm.icons.AsmIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.Pair;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class NasmColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Separator", NasmSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Comment", NasmSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Documentation comment", NasmSyntaxHighlighter.DOC_COMMENT),
            new AttributesDescriptor("Number", NasmSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("NASM mnemonic", NasmSyntaxHighlighter.OPERATION),
            new AttributesDescriptor("Label", NasmSyntaxHighlighter.LABEL),
            new AttributesDescriptor("Identifier", NasmSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("Register", NasmSyntaxHighlighter.REGISTER),
            new AttributesDescriptor("String", NasmSyntaxHighlighter.STRING),
            new AttributesDescriptor("Type size", NasmSyntaxHighlighter.SIZE),
            new AttributesDescriptor("Preprocessor tag", NasmSyntaxHighlighter.PREPROCESSOR_TAG),
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
        return ResourceLoader.loadResource("/code_stubs/highlighting.asm", getClass(), "");
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
