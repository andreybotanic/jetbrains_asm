package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.NasmIdentifier;
import com.andreybotanic.asm.nasm.psi.NasmTokenType;
import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy;
import com.intellij.spellchecker.tokenizer.Tokenizer;
import org.jetbrains.annotations.NotNull;

public class NasmSpellcheckingStrategy extends SpellcheckingStrategy {
    @Override
    public @NotNull Tokenizer getTokenizer(PsiElement element) {
        IElementType elementType = element.getNode().getElementType();
        if (elementType.equals(NasmTypes.COMMENT)) {
            return TEXT_TOKENIZER;
        }
        if (elementType.equals(NasmTypes.ID)) {
            return TEXT_TOKENIZER;
        }
        if (elementType.equals(NasmTypes.LBL)) {
            return TEXT_TOKENIZER;
        }
        if (elementType.equals(NasmTypes.LBL_DEF)) {
            return TEXT_TOKENIZER;
        }
        return EMPTY_TOKENIZER;
    }
}
