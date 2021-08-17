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

public class NasmIncludeImpl extends ASTWrapperPsiElement implements NasmInclude {

  public NasmIncludeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NasmVisitor visitor) {
    visitor.visitInclude(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NasmVisitor) accept((NasmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIncludeTag() {
    return findNotNullChildByType(INCLUDE_TAG);
  }

  @Override
  @NotNull
  public PsiElement getString() {
    return findNotNullChildByType(STRING);
  }

}
