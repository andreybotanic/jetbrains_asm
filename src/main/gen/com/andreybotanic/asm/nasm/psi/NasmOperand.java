// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NasmOperand extends PsiElement {

  @Nullable
  NasmExpr getExpr();

  @Nullable
  NasmImmediate getImmediate();

  @Nullable
  NasmMemory getMemory();

}
