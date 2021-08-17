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

public class NasmDefineImpl extends ASTWrapperPsiElement implements NasmDefine {

  public NasmDefineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NasmVisitor visitor) {
    visitor.visitDefine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NasmVisitor) accept((NasmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public NasmDefineParams getDefineParams() {
    return findChildByClass(NasmDefineParams.class);
  }

  @Override
  @NotNull
  public List<NasmExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NasmExpr.class);
  }

  @Override
  @NotNull
  public PsiElement getDefineTag() {
    return findNotNullChildByType(DEFINE_TAG);
  }

}
