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

public class NasmPreprocessorImpl extends ASTWrapperPsiElement implements NasmPreprocessor {

  public NasmPreprocessorImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NasmVisitor visitor) {
    visitor.visitPreprocessor(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NasmVisitor) accept((NasmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public NasmAssign getAssign() {
    return findChildByClass(NasmAssign.class);
  }

  @Override
  @Nullable
  public NasmDefine getDefine() {
    return findChildByClass(NasmDefine.class);
  }

  @Override
  @Nullable
  public NasmInclude getInclude() {
    return findChildByClass(NasmInclude.class);
  }

}
