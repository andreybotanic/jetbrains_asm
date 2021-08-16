// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.andreybotanic.asm.nasm.psi.NasmTypes.*;
import com.andreybotanic.asm.nasm.psi.*;

public class NasmRegisterImpl extends NasmExprImpl implements NasmRegister {

  public NasmRegisterImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull NasmVisitor visitor) {
    visitor.visitRegister(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NasmVisitor) accept((NasmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getReg16() {
    return findChildByType(REG_16);
  }

  @Override
  @Nullable
  public PsiElement getReg32() {
    return findChildByType(REG_32);
  }

  @Override
  @Nullable
  public PsiElement getReg64() {
    return findChildByType(REG_64);
  }

  @Override
  @Nullable
  public PsiElement getReg8() {
    return findChildByType(REG_8);
  }

}
