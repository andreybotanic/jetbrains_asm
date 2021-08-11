package com.andreybotanic.asm.nasm.psi;

import com.andreybotanic.asm.nasm.NasmLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class NasmElementType extends IElementType {
    public NasmElementType(@NonNls @NotNull String debugName) {
        super(debugName, NasmLanguage.INSTANCE);
    }
}
