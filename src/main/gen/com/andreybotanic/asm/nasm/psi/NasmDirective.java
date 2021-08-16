// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NasmDirective extends PsiElement {

  @NotNull
  List<NasmExpr> getExprList();

  @NotNull
  PsiElement getDirectiveOp();

}
