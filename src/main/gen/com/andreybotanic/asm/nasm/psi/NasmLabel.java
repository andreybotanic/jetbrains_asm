// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NasmLabel extends NasmNamedElement {

  @NotNull
  PsiElement getLblDef();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}
