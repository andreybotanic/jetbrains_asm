// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface NasmIdentifier extends NasmNamedElement {

  @NotNull
  PsiElement getId();

  String getName();

  PsiElement setName(String newName);

  @NotNull PsiElement getNameIdentifier();

  @NotNull PsiReference[] getReferences();

}
