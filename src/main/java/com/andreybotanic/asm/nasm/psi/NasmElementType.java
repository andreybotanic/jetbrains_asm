package com.andreybotanic.asm.nasm.psi;

import com.andreybotanic.asm.nasm.NasmLanguage;
import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NasmElementType extends IElementType {
    public NasmElementType(@NonNls @NotNull String debugName) {
        super(debugName, NasmLanguage.INSTANCE);
    }
}
