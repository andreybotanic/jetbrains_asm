package com.andreybotanic.asm.nasm.psi;

import com.andreybotanic.asm.nasm.NasmLanguage;
import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NasmTokenType extends IElementType {
    public NasmTokenType(@NonNls @NotNull String debugName) {
        super(debugName, NasmLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "NasmTokenType." + super.toString();
    }
}
