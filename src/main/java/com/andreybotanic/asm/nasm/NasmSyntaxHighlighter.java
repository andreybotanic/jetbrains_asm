package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

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
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("NASM_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] REGISTER_KEYS = new TextAttributesKey[]{REGISTER};
    private static final TextAttributesKey[] OPERATION_KEYS = new TextAttributesKey[]{OPERATION};
    private static final TextAttributesKey[] LABEL_KEYS = new TextAttributesKey[]{LABEL};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];


    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new NasmLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(NasmTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        } else if (tokenType.equals(NasmTypes.BINARY)
                || tokenType.equals(NasmTypes.DECIMAL)
                || tokenType.equals(NasmTypes.HEXADECIMAL)
                || tokenType.equals(NasmTypes.FLOAT_DECIMAL)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(NasmTypes.REGISTER)) {
            return REGISTER_KEYS;
        } else if (tokenType.equals(NasmTypes.OPERATION)) {
            return OPERATION_KEYS;
        } else if (tokenType.equals(NasmTypes.LBL_DEF) || tokenType.equals(NasmTypes.LBL)) {
            return LABEL_KEYS;
        } else if (tokenType.equals(NasmTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
