// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.andreybotanic.asm.nasm.psi.impl.*;

public interface NasmTypes {

  IElementType INSTRUCTION = new NasmElementType("INSTRUCTION");
  IElementType LABEL = new NasmElementType("LABEL");
  IElementType NUMBER = new NasmElementType("NUMBER");
  IElementType OPERAND = new NasmElementType("OPERAND");
  IElementType OPERANDS = new NasmElementType("OPERANDS");
  IElementType OPERATION = new NasmElementType("OPERATION");

  IElementType BINARY = new NasmTokenType("BINARY");
  IElementType COLON = new NasmTokenType(":");
  IElementType COMMENT = new NasmTokenType("COMMENT");
  IElementType DECIMAL = new NasmTokenType("DECIMAL");
  IElementType EOL = new NasmTokenType("EOL");
  IElementType GENERAL_OP = new NasmTokenType("GENERAL_OP");
  IElementType HEXADECIMAL = new NasmTokenType("HEXADECIMAL");
  IElementType IDENTIFIER = new NasmTokenType("IDENTIFIER");
  IElementType REGISTER = new NasmTokenType("REGISTER");
  IElementType SEPARATOR = new NasmTokenType(",");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == INSTRUCTION) {
        return new NasmInstructionImpl(node);
      }
      else if (type == LABEL) {
        return new NasmLabelImpl(node);
      }
      else if (type == NUMBER) {
        return new NasmNumberImpl(node);
      }
      else if (type == OPERAND) {
        return new NasmOperandImpl(node);
      }
      else if (type == OPERANDS) {
        return new NasmOperandsImpl(node);
      }
      else if (type == OPERATION) {
        return new NasmOperationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
