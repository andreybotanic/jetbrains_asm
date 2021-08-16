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

public class NasmSectionImpl extends ASTWrapperPsiElement implements NasmSection {

  public NasmSectionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NasmVisitor visitor) {
    visitor.visitSection(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NasmVisitor) accept((NasmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getSectionDef() {
    return findNotNullChildByType(SECTION_DEF);
  }

  @Override
  @NotNull
  public PsiElement getSectionName() {
    return findNotNullChildByType(SECTION_NAME);
  }

}
