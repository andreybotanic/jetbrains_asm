package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NasmBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] BRACE_PAIRS = new BracePair[] {
            new BracePair(NasmTypes.SQUARE_L, NasmTypes.SQUARE_R, true),
            new BracePair(NasmTypes.ROUND_L, NasmTypes.ROUND_R, false),
    };

    /**
     * Returns the array of definitions for brace pairs that need to be matched when
     * editing code in the language.
     *
     * @return the array of brace pair definitions.
     */
    @Override
    public BracePair @NotNull [] getPairs() {
        return BRACE_PAIRS;
    }

    /**
     * Returns {@code true} if paired rbrace should be inserted after lbrace of given type when lbrace is encountered before contextType token.
     * It is safe to always return {@code true}, then paired brace will be inserted anyway.
     *
     * @param lbraceType  lbrace for which information is queried
     * @param contextType token type that follows lbrace
     * @return true / false as described
     */
    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    /**
     * Returns the start offset of the code construct which owns the opening structural brace at the specified offset. For example,
     * if the opening brace belongs to an 'if' statement, returns the start offset of the 'if' statement.
     *
     * @param file               the file in which brace matching is performed.
     * @param openingBraceOffset the offset of an opening structural brace.
     * @return the offset of corresponding code construct, or the same offset if not defined.
     */
    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
