// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NasmOperand extends PsiElement {

  @Nullable
  NasmIdentifier getIdentifier();

  @Nullable
  NasmLabelIdentifier getLabelIdentifier();

  @Nullable
  PsiElement getBinary();

  @Nullable
  PsiElement getCharacter();

  @Nullable
  PsiElement getDecimal();

  @Nullable
  PsiElement getFloatDecimal();

  @Nullable
  PsiElement getHexadecimal();

  @Nullable
  PsiElement getRegister();

  @Nullable
  PsiElement getString();

}
