package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.NasmTokenType;
import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.mac.foundation.ID;
import gnu.trove.THashMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class NasmSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("NASM_SEPARATOR", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("NASM_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey DOC_COMMENT =
            createTextAttributesKey("NASM_DOC_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT);
    public static final TextAttributesKey PREPROCESSOR_TAG =
            createTextAttributesKey("NASM_PREPROCESSOR_TAG", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("NASM_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey OPERATION =
            createTextAttributesKey("NASM_OPERATION", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey REGISTER =
            createTextAttributesKey("NASM_REGISTER", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey SIZE =
            createTextAttributesKey("NASM_SIZE", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey LABEL =
            createTextAttributesKey("NASM_LABEL", DefaultLanguageHighlighterColors.LABEL);
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("NASM_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("NASM_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("NASM_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    
    private static final Map<IElementType, TextAttributesKey> AttributesKeys;
    static {
        AttributesKeys = new THashMap<>();
        
        AttributesKeys.put(NasmTypes.REG_8, REGISTER);
        AttributesKeys.put(NasmTypes.REG_16, REGISTER);
        AttributesKeys.put(NasmTypes.REG_32, REGISTER);
        AttributesKeys.put(NasmTypes.REG_64, REGISTER);

        AttributesKeys.put(NasmTypes.INCLUDE_TAG, PREPROCESSOR_TAG);
        AttributesKeys.put(NasmTypes.ASSIGN_TAG, PREPROCESSOR_TAG);
        AttributesKeys.put(NasmTypes.DEFINE_TAG, PREPROCESSOR_TAG);
        AttributesKeys.put(NasmTypes.TOKEN_CONCAT, PREPROCESSOR_TAG);

        AttributesKeys.put(NasmTypes.GENERAL_OP, OPERATION);
        AttributesKeys.put(NasmTypes.DATA_DEF, OPERATION);
        AttributesKeys.put(NasmTypes.DATA_RES, OPERATION);
        AttributesKeys.put(NasmTypes.SECTION_DEF, OPERATION);
        AttributesKeys.put(NasmTypes.SECTION_NAME, OPERATION);
        AttributesKeys.put(NasmTypes.DIRECTIVE_OP, OPERATION);

        AttributesKeys.put(NasmTypes.STRING, STRING);
        AttributesKeys.put(NasmTypes.CHARACTER, STRING);

        AttributesKeys.put(NasmTypes.ZEROES, NUMBER);
        AttributesKeys.put(NasmTypes.BINARY, NUMBER);
        AttributesKeys.put(NasmTypes.DECIMAL, NUMBER);
        AttributesKeys.put(NasmTypes.HEXADECIMAL, NUMBER);
        AttributesKeys.put(NasmTypes.FLOAT_DECIMAL, NUMBER);

        AttributesKeys.put(NasmTypes.SIZE_PREFIX, SIZE);

        AttributesKeys.put(NasmTypes.COMMENT, COMMENT);
        AttributesKeys.put(NasmTypes.SEMICOLON, COMMENT);

        AttributesKeys.put(NasmTypes.LBL_DEF, LABEL);
        AttributesKeys.put(NasmTypes.LBL, LABEL);

        AttributesKeys.put(NasmTypes.ID, IDENTIFIER);

        AttributesKeys.put(NasmTypes.SEPARATOR, SEPARATOR);

        AttributesKeys.put(TokenType.BAD_CHARACTER, BAD_CHARACTER);
    }

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new NasmLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return SyntaxHighlighterBase.pack(AttributesKeys.get(tokenType));
    }
}
