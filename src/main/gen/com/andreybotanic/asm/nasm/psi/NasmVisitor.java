// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class NasmVisitor extends PsiElementVisitor {

  public void visitInstruction(@NotNull NasmInstruction o) {
    visitPsiElement(o);
  }

  public void visitLabel(@NotNull NasmLabel o) {
    visitPsiElement(o);
  }

  public void visitNumber(@NotNull NasmNumber o) {
    visitPsiElement(o);
  }

  public void visitOperand(@NotNull NasmOperand o) {
    visitPsiElement(o);
  }

  public void visitOperands(@NotNull NasmOperands o) {
    visitPsiElement(o);
  }

  public void visitOperation(@NotNull NasmOperation o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
