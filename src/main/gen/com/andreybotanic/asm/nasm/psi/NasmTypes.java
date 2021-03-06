// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.andreybotanic.asm.nasm.psi.impl.*;

public interface NasmTypes {

  IElementType DATA_ELEMENT = new NasmElementType("DATA_ELEMENT");
  IElementType DATA_STMT = new NasmElementType("DATA_STMT");
  IElementType DATA_VALUE = new NasmElementType("DATA_VALUE");
  IElementType EXPR = new NasmElementType("EXPR");
  IElementType IDENTIFIER = new NasmElementType("IDENTIFIER");
  IElementType INSTRUCTION = new NasmElementType("INSTRUCTION");
  IElementType LABEL = new NasmElementType("LABEL");
  IElementType LABEL_IDENTIFIER = new NasmElementType("LABEL_IDENTIFIER");
  IElementType NUMERIC_LITERAL = new NasmElementType("NUMERIC_LITERAL");
  IElementType OPERAND = new NasmElementType("OPERAND");
  IElementType OPERANDS = new NasmElementType("OPERANDS");
  IElementType OPERATION = new NasmElementType("OPERATION");
  IElementType PARENTHESIS_EXPR = new NasmElementType("PARENTHESIS_EXPR");
  IElementType STR = new NasmElementType("STR");

  IElementType BINARY = new NasmTokenType("BINARY");
  IElementType BITSHIFT_L = new NasmTokenType("<<");
  IElementType BITSHIFT_R = new NasmTokenType(">>");
  IElementType BITWISE_AND = new NasmTokenType("&");
  IElementType BITWISE_NOT = new NasmTokenType("~");
  IElementType BITWISE_OR = new NasmTokenType("|");
  IElementType BITWISE_XOR = new NasmTokenType("^");
  IElementType CHARACTER = new NasmTokenType("CHARACTER");
  IElementType COLON = new NasmTokenType(":");
  IElementType COMMENT = new NasmTokenType("COMMENT");
  IElementType DECIMAL = new NasmTokenType("DECIMAL");
  IElementType DIVIDE = new NasmTokenType("/");
  IElementType DOLLARSIGN = new NasmTokenType("$");
  IElementType DOLLARSIGN2 = new NasmTokenType("$$");
  IElementType DOT = new NasmTokenType(".");
  IElementType DX = new NasmTokenType("DX");
  IElementType EOL = new NasmTokenType("EOL");
  IElementType EQUAL = new NasmTokenType("=");
  IElementType EQUALEQUAL = new NasmTokenType("==");
  IElementType FLOAT_DECIMAL = new NasmTokenType("FLOAT_DECIMAL");
  IElementType GENERAL_OP = new NasmTokenType("GENERAL_OP");
  IElementType GREATERTHAN = new NasmTokenType(">");
  IElementType GREATERTHANOREQUAL = new NasmTokenType(">=");
  IElementType HEXADECIMAL = new NasmTokenType("HEXADECIMAL");
  IElementType ID = new NasmTokenType("ID");
  IElementType LBL = new NasmTokenType("LBL");
  IElementType LBL_DEF = new NasmTokenType("LBL_DEF");
  IElementType LESSTHAN = new NasmTokenType("<");
  IElementType LESSTHANOREQUAL = new NasmTokenType("<=");
  IElementType LOGICAL_AND = new NasmTokenType("&&");
  IElementType LOGICAL_OR = new NasmTokenType("||");
  IElementType LOGICAL_XOR = new NasmTokenType("^^");
  IElementType MINUS = new NasmTokenType("-");
  IElementType NL = new NasmTokenType("NL");
  IElementType NOTEQUAL = new NasmTokenType("!=");
  IElementType PERCENT = new NasmTokenType("%");
  IElementType PERCENT2 = new NasmTokenType("%%");
  IElementType PLUS = new NasmTokenType("+");
  IElementType QUESTION = new NasmTokenType("?");
  IElementType REGISTER = new NasmTokenType("REGISTER");
  IElementType ROUND_L = new NasmTokenType("(");
  IElementType ROUND_R = new NasmTokenType(")");
  IElementType SEMICOLON = new NasmTokenType(";");
  IElementType SEPARATOR = new NasmTokenType(",");
  IElementType SIZE_TYPE = new NasmTokenType("SIZE_TYPE");
  IElementType SQUARE_L = new NasmTokenType("[");
  IElementType SQUARE_R = new NasmTokenType("]");
  IElementType STRING = new NasmTokenType("STRING");
  IElementType TIMES = new NasmTokenType("*");
  IElementType TOKEN_CONCAT = new NasmTokenType("%+");
  IElementType ZEROES = new NasmTokenType("ZEROES");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DATA_ELEMENT) {
        return new NasmDataElementImpl(node);
      }
      else if (type == DATA_STMT) {
        return new NasmDataStmtImpl(node);
      }
      else if (type == DATA_VALUE) {
        return new NasmDataValueImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new NasmIdentifierImpl(node);
      }
      else if (type == INSTRUCTION) {
        return new NasmInstructionImpl(node);
      }
      else if (type == LABEL) {
        return new NasmLabelImpl(node);
      }
      else if (type == LABEL_IDENTIFIER) {
        return new NasmLabelIdentifierImpl(node);
      }
      else if (type == NUMERIC_LITERAL) {
        return new NasmNumericLiteralImpl(node);
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
      else if (type == PARENTHESIS_EXPR) {
        return new NasmParenthesisExprImpl(node);
      }
      else if (type == STR) {
        return new NasmStrImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
