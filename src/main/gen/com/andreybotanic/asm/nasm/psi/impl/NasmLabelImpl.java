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

public class NasmLabelImpl extends NasmNamedElementImpl implements NasmLabel {

  public NasmLabelImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NasmVisitor visitor) {
    visitor.visitLabel(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NasmVisitor) accept((NasmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getLblDef() {
    return findNotNullChildByType(LBL_DEF);
  }

  @Override
  public String getName() {
    return NasmPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return NasmPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return NasmPsiImplUtil.getNameIdentifier(this);
  }

}
