// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.andreybotanic.asm.nasm.psi.NasmTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.andreybotanic.asm.nasm.psi.*;

public class NasmOperandImpl extends ASTWrapperPsiElement implements NasmOperand {

  public NasmOperandImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NasmVisitor visitor) {
    visitor.visitOperand(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NasmVisitor) accept((NasmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public NasmIdentifier getIdentifier() {
    return findChildByClass(NasmIdentifier.class);
  }

  @Override
  @Nullable
  public NasmLabelIdentifier getLabelIdentifier() {
    return findChildByClass(NasmLabelIdentifier.class);
  }

  @Override
  @Nullable
  public PsiElement getBinary() {
    return findChildByType(BINARY);
  }

  @Override
  @Nullable
  public PsiElement getDecimal() {
    return findChildByType(DECIMAL);
  }

  @Override
  @Nullable
  public PsiElement getFloatDecimal() {
    return findChildByType(FLOAT_DECIMAL);
  }

  @Override
  @Nullable
  public PsiElement getHexadecimal() {
    return findChildByType(HEXADECIMAL);
  }

  @Override
  @Nullable
  public PsiElement getRegister() {
    return findChildByType(REGISTER);
  }

}
