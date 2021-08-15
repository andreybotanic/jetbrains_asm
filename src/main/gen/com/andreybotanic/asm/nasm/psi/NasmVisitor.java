// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class NasmVisitor extends PsiElementVisitor {

  public void visitDataElement(@NotNull NasmDataElement o) {
    visitPsiElement(o);
  }

  public void visitDataStmt(@NotNull NasmDataStmt o) {
    visitPsiElement(o);
  }

  public void visitDataValue(@NotNull NasmDataValue o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull NasmExpr o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull NasmIdentifier o) {
    visitNamedElement(o);
  }

  public void visitInstruction(@NotNull NasmInstruction o) {
    visitPsiElement(o);
  }

  public void visitLabel(@NotNull NasmLabel o) {
    visitNamedElement(o);
  }

  public void visitLabelIdentifier(@NotNull NasmLabelIdentifier o) {
    visitNamedElement(o);
  }

  public void visitNumericLiteral(@NotNull NasmNumericLiteral o) {
    visitExpr(o);
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

  public void visitParenthesisExpr(@NotNull NasmParenthesisExpr o) {
    visitExpr(o);
  }

  public void visitStr(@NotNull NasmStr o) {
    visitExpr(o);
  }

  public void visitNamedElement(@NotNull NasmNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
