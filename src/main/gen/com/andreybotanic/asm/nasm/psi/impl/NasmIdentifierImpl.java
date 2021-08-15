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
import com.intellij.psi.PsiReference;

public class NasmIdentifierImpl extends NasmNamedElementImpl implements NasmIdentifier {

  public NasmIdentifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NasmVisitor visitor) {
    visitor.visitIdentifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NasmVisitor) accept((NasmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
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
  public @NotNull PsiElement getNameIdentifier() {
    return NasmPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public @NotNull PsiReference[] getReferences() {
    return NasmPsiImplUtil.getReferences(this);
  }

}
