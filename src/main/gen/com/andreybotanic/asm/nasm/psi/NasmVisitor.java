// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class NasmVisitor extends PsiElementVisitor {

  public void visitAddress(@NotNull NasmAddress o) {
    visitExpr(o);
  }

  public void visitAssign(@NotNull NasmAssign o) {
    visitPsiElement(o);
  }

  public void visitBitShiftLExpr(@NotNull NasmBitShiftLExpr o) {
    visitExpr(o);
  }

  public void visitBitShiftRExpr(@NotNull NasmBitShiftRExpr o) {
    visitExpr(o);
  }

  public void visitBitwiseANDExpr(@NotNull NasmBitwiseANDExpr o) {
    visitExpr(o);
  }

  public void visitBitwiseNOTExpr(@NotNull NasmBitwiseNOTExpr o) {
    visitExpr(o);
  }

  public void visitBitwiseORExpr(@NotNull NasmBitwiseORExpr o) {
    visitExpr(o);
  }

  public void visitBitwiseXORExpr(@NotNull NasmBitwiseXORExpr o) {
    visitExpr(o);
  }

  public void visitDataDefStmt(@NotNull NasmDataDefStmt o) {
    visitPsiElement(o);
  }

  public void visitDataElement(@NotNull NasmDataElement o) {
    visitPsiElement(o);
  }

  public void visitDataResStmt(@NotNull NasmDataResStmt o) {
    visitPsiElement(o);
  }

  public void visitDefine(@NotNull NasmDefine o) {
    visitPsiElement(o);
  }

  public void visitDefineParams(@NotNull NasmDefineParams o) {
    visitPsiElement(o);
  }

  public void visitDirective(@NotNull NasmDirective o) {
    visitPsiElement(o);
  }

  public void visitDivExpr(@NotNull NasmDivExpr o) {
    visitExpr(o);
  }

  public void visitExpr(@NotNull NasmExpr o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull NasmIdentifier o) {
    visitExpr(o);
    // visitNamedElement(o);
  }

  public void visitImmediate(@NotNull NasmImmediate o) {
    visitPsiElement(o);
  }

  public void visitInclude(@NotNull NasmInclude o) {
    visitPsiElement(o);
  }

  public void visitInstruction(@NotNull NasmInstruction o) {
    visitPsiElement(o);
  }

  public void visitLabel(@NotNull NasmLabel o) {
    visitNamedElement(o);
  }

  public void visitLabelIdentifier(@NotNull NasmLabelIdentifier o) {
    visitExpr(o);
    // visitNamedElement(o);
  }

  public void visitLogicalANDExpr(@NotNull NasmLogicalANDExpr o) {
    visitExpr(o);
  }

  public void visitLogicalORExpr(@NotNull NasmLogicalORExpr o) {
    visitExpr(o);
  }

  public void visitLogicalXORExpr(@NotNull NasmLogicalXORExpr o) {
    visitExpr(o);
  }

  public void visitMemory(@NotNull NasmMemory o) {
    visitPsiElement(o);
  }

  public void visitMinusExpr(@NotNull NasmMinusExpr o) {
    visitExpr(o);
  }

  public void visitModulusExpr(@NotNull NasmModulusExpr o) {
    visitExpr(o);
  }

  public void visitMulExpr(@NotNull NasmMulExpr o) {
    visitExpr(o);
  }

  public void visitNumericLiteral(@NotNull NasmNumericLiteral o) {
    visitExpr(o);
  }

  public void visitOperand(@NotNull NasmOperand o) {
    visitPsiElement(o);
  }

  public void visitOperation(@NotNull NasmOperation o) {
    visitExpr(o);
  }

  public void visitParenthesisExpr(@NotNull NasmParenthesisExpr o) {
    visitExpr(o);
  }

  public void visitPlusExpr(@NotNull NasmPlusExpr o) {
    visitExpr(o);
  }

  public void visitPreprocessor(@NotNull NasmPreprocessor o) {
    visitPsiElement(o);
  }

  public void visitRegister(@NotNull NasmRegister o) {
    visitExpr(o);
  }

  public void visitSection(@NotNull NasmSection o) {
    visitPsiElement(o);
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
