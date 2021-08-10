package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.parser.NasmParser;
import com.andreybotanic.asm.nasm.psi.NasmOperation;
import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class NasmParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(NasmTypes.COMMENT);

    public static final IFileElementType FILE = new IFileElementType(NasmLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new NasmLexerAdapter();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new NasmParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return NasmTypes.Factory.createElement(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new NasmFile(viewProvider);
    }

    @Override
    public @NotNull SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        if (left instanceof NasmOperation) {
            return SpaceRequirements.MUST;
        }
        return SpaceRequirements.MAY;
    }
}
