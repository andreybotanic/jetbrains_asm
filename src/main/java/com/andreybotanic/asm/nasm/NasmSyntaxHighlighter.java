package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import gnu.trove.THashMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class NasmSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("NASM_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("NASM_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("NASM_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey OPERATION =
            createTextAttributesKey("NASM_OPERATION", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey REGISTER =
            createTextAttributesKey("NASM_REGISTER", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey LABEL =
            createTextAttributesKey("NASM_LABEL", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("NASM_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("NASM_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    
    private static final Map<IElementType, TextAttributesKey> AttributesKeys;
    static {
        AttributesKeys = new THashMap<>();
        
        AttributesKeys.put(NasmTypes.REGISTER, REGISTER);

        AttributesKeys.put(NasmTypes.GENERAL_OP, OPERATION);
        AttributesKeys.put(NasmTypes.DX, OPERATION);

        AttributesKeys.put(NasmTypes.STRING, STRING);
        AttributesKeys.put(NasmTypes.CHARACTER, STRING);

        AttributesKeys.put(NasmTypes.NUMERIC_LITERAL, NUMBER);
        AttributesKeys.put(NasmTypes.ZEROES, NUMBER);
        AttributesKeys.put(NasmTypes.BINARY, NUMBER);
        AttributesKeys.put(NasmTypes.DECIMAL, NUMBER);
        AttributesKeys.put(NasmTypes.HEXADECIMAL, NUMBER);
        AttributesKeys.put(NasmTypes.FLOAT_DECIMAL, NUMBER);

        AttributesKeys.put(NasmTypes.LBL, LABEL);
        AttributesKeys.put(NasmTypes.LBL_DEF, LABEL);
        AttributesKeys.put(NasmTypes.IDENTIFIER, LABEL);

        AttributesKeys.put(NasmTypes.COMMENT, COMMENT);
        AttributesKeys.put(NasmTypes.SEMICOLON, COMMENT);

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
