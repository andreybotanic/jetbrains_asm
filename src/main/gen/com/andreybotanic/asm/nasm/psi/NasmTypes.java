// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.andreybotanic.asm.nasm.psi.impl.*;

public interface NasmTypes {

  IElementType ADDRESS = new NasmElementType("ADDRESS");
  IElementType ASSIGN = new NasmElementType("ASSIGN");
  IElementType BITWISE_AND_EXPR = new NasmElementType("BITWISE_AND_EXPR");
  IElementType BITWISE_NOT_EXPR = new NasmElementType("BITWISE_NOT_EXPR");
  IElementType BITWISE_OR_EXPR = new NasmElementType("BITWISE_OR_EXPR");
  IElementType BITWISE_XOR_EXPR = new NasmElementType("BITWISE_XOR_EXPR");
  IElementType BIT_SHIFT_L_EXPR = new NasmElementType("BIT_SHIFT_L_EXPR");
  IElementType BIT_SHIFT_R_EXPR = new NasmElementType("BIT_SHIFT_R_EXPR");
  IElementType DATA_DEF_STMT = new NasmElementType("DATA_DEF_STMT");
  IElementType DATA_ELEMENT = new NasmElementType("DATA_ELEMENT");
  IElementType DATA_RES_STMT = new NasmElementType("DATA_RES_STMT");
  IElementType DEFINE = new NasmElementType("DEFINE");
  IElementType DEFINE_PARAMS = new NasmElementType("DEFINE_PARAMS");
  IElementType DIRECTIVE = new NasmElementType("DIRECTIVE");
  IElementType DIV_EXPR = new NasmElementType("DIV_EXPR");
  IElementType EXPR = new NasmElementType("EXPR");
  IElementType IDENTIFIER = new NasmElementType("IDENTIFIER");
  IElementType IMMEDIATE = new NasmElementType("IMMEDIATE");
  IElementType INCLUDE = new NasmElementType("INCLUDE");
  IElementType INSTRUCTION = new NasmElementType("INSTRUCTION");
  IElementType LABEL = new NasmElementType("LABEL");
  IElementType LABEL_IDENTIFIER = new NasmElementType("LABEL_IDENTIFIER");
  IElementType LOGICAL_AND_EXPR = new NasmElementType("LOGICAL_AND_EXPR");
  IElementType LOGICAL_OR_EXPR = new NasmElementType("LOGICAL_OR_EXPR");
  IElementType LOGICAL_XOR_EXPR = new NasmElementType("LOGICAL_XOR_EXPR");
  IElementType MEMORY = new NasmElementType("MEMORY");
  IElementType MINUS_EXPR = new NasmElementType("MINUS_EXPR");
  IElementType MODULUS_EXPR = new NasmElementType("MODULUS_EXPR");
  IElementType MUL_EXPR = new NasmElementType("MUL_EXPR");
  IElementType NUMERIC_LITERAL = new NasmElementType("NUMERIC_LITERAL");
  IElementType OPERAND = new NasmElementType("OPERAND");
  IElementType OPERATION = new NasmElementType("OPERATION");
  IElementType PARENTHESIS_EXPR = new NasmElementType("PARENTHESIS_EXPR");
  IElementType PLUS_EXPR = new NasmElementType("PLUS_EXPR");
  IElementType PREPROCESSOR = new NasmElementType("PREPROCESSOR");
  IElementType REGISTER = new NasmElementType("REGISTER");
  IElementType SECTION = new NasmElementType("SECTION");
  IElementType STR = new NasmElementType("STR");

  IElementType ASSIGN_TAG = new NasmTokenType("ASSIGN_TAG");
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
  IElementType DATA_DEF = new NasmTokenType("DATA_DEF");
  IElementType DATA_RES = new NasmTokenType("DATA_RES");
  IElementType DECIMAL = new NasmTokenType("DECIMAL");
  IElementType DEFINE_TAG = new NasmTokenType("DEFINE_TAG");
  IElementType DIRECTIVE_OP = new NasmTokenType("DIRECTIVE_OP");
  IElementType DIVIDE = new NasmTokenType("/");
  IElementType DOLLARSIGN = new NasmTokenType("$");
  IElementType DOLLARSIGN2 = new NasmTokenType("$$");
  IElementType DOT = new NasmTokenType(".");
  IElementType END_DIRECTIVE_OP = new NasmTokenType("END_DIRECTIVE_OP");
  IElementType EOL = new NasmTokenType("EOL");
  IElementType EQUAL = new NasmTokenType("=");
  IElementType EQUALEQUAL = new NasmTokenType("==");
  IElementType FLOAT_DECIMAL = new NasmTokenType("FLOAT_DECIMAL");
  IElementType GENERAL_OP = new NasmTokenType("GENERAL_OP");
  IElementType GREATERTHAN = new NasmTokenType(">");
  IElementType GREATERTHANOREQUAL = new NasmTokenType(">=");
  IElementType HEXADECIMAL = new NasmTokenType("HEXADECIMAL");
  IElementType ID = new NasmTokenType("ID");
  IElementType INCLUDE_TAG = new NasmTokenType("INCLUDE_TAG");
  IElementType LBL = new NasmTokenType("LBL");
  IElementType LBL_DEF = new NasmTokenType("LBL_DEF");
  IElementType LESSTHAN = new NasmTokenType("<");
  IElementType LESSTHANOREQUAL = new NasmTokenType("<=");
  IElementType LOGICAL_AND = new NasmTokenType("&&");
  IElementType LOGICAL_OR = new NasmTokenType("||");
  IElementType LOGICAL_XOR = new NasmTokenType("^^");
  IElementType MINUS = new NasmTokenType("-");
  IElementType NOTEQUAL = new NasmTokenType("!=");
  IElementType OP_PREFIX = new NasmTokenType("OP_PREFIX");
  IElementType PERCENT = new NasmTokenType("%");
  IElementType PERCENT2 = new NasmTokenType("%%");
  IElementType PLUS = new NasmTokenType("+");
  IElementType QUESTION = new NasmTokenType("?");
  IElementType REG_16 = new NasmTokenType("REG_16");
  IElementType REG_32 = new NasmTokenType("REG_32");
  IElementType REG_64 = new NasmTokenType("REG_64");
  IElementType REG_8 = new NasmTokenType("REG_8");
  IElementType ROUND_L = new NasmTokenType("(");
  IElementType ROUND_R = new NasmTokenType(")");
  IElementType SECTION_DEF = new NasmTokenType("SECTION_DEF");
  IElementType SECTION_NAME = new NasmTokenType("SECTION_NAME");
  IElementType SEMICOLON = new NasmTokenType(";");
  IElementType SEPARATOR = new NasmTokenType(",");
  IElementType SIZE_PREFIX = new NasmTokenType("SIZE_PREFIX");
  IElementType SQUARE_L = new NasmTokenType("[");
  IElementType SQUARE_R = new NasmTokenType("]");
  IElementType STRING = new NasmTokenType("STRING");
  IElementType TIMES = new NasmTokenType("*");
  IElementType TOKEN_CONCAT = new NasmTokenType("%+");
  IElementType ZEROES = new NasmTokenType("ZEROES");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADDRESS) {
        return new NasmAddressImpl(node);
      }
      else if (type == ASSIGN) {
        return new NasmAssignImpl(node);
      }
      else if (type == BITWISE_AND_EXPR) {
        return new NasmBitwiseANDExprImpl(node);
      }
      else if (type == BITWISE_NOT_EXPR) {
        return new NasmBitwiseNOTExprImpl(node);
      }
      else if (type == BITWISE_OR_EXPR) {
        return new NasmBitwiseORExprImpl(node);
      }
      else if (type == BITWISE_XOR_EXPR) {
        return new NasmBitwiseXORExprImpl(node);
      }
      else if (type == BIT_SHIFT_L_EXPR) {
        return new NasmBitShiftLExprImpl(node);
      }
      else if (type == BIT_SHIFT_R_EXPR) {
        return new NasmBitShiftRExprImpl(node);
      }
      else if (type == DATA_DEF_STMT) {
        return new NasmDataDefStmtImpl(node);
      }
      else if (type == DATA_ELEMENT) {
        return new NasmDataElementImpl(node);
      }
      else if (type == DATA_RES_STMT) {
        return new NasmDataResStmtImpl(node);
      }
      else if (type == DEFINE) {
        return new NasmDefineImpl(node);
      }
      else if (type == DEFINE_PARAMS) {
        return new NasmDefineParamsImpl(node);
      }
      else if (type == DIRECTIVE) {
        return new NasmDirectiveImpl(node);
      }
      else if (type == DIV_EXPR) {
        return new NasmDivExprImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new NasmIdentifierImpl(node);
      }
      else if (type == IMMEDIATE) {
        return new NasmImmediateImpl(node);
      }
      else if (type == INCLUDE) {
        return new NasmIncludeImpl(node);
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
      else if (type == LOGICAL_AND_EXPR) {
        return new NasmLogicalANDExprImpl(node);
      }
      else if (type == LOGICAL_OR_EXPR) {
        return new NasmLogicalORExprImpl(node);
      }
      else if (type == LOGICAL_XOR_EXPR) {
        return new NasmLogicalXORExprImpl(node);
      }
      else if (type == MEMORY) {
        return new NasmMemoryImpl(node);
      }
      else if (type == MINUS_EXPR) {
        return new NasmMinusExprImpl(node);
      }
      else if (type == MODULUS_EXPR) {
        return new NasmModulusExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new NasmMulExprImpl(node);
      }
      else if (type == NUMERIC_LITERAL) {
        return new NasmNumericLiteralImpl(node);
      }
      else if (type == OPERAND) {
        return new NasmOperandImpl(node);
      }
      else if (type == OPERATION) {
        return new NasmOperationImpl(node);
      }
      else if (type == PARENTHESIS_EXPR) {
        return new NasmParenthesisExprImpl(node);
      }
      else if (type == PLUS_EXPR) {
        return new NasmPlusExprImpl(node);
      }
      else if (type == PREPROCESSOR) {
        return new NasmPreprocessorImpl(node);
      }
      else if (type == REGISTER) {
        return new NasmRegisterImpl(node);
      }
      else if (type == SECTION) {
        return new NasmSectionImpl(node);
      }
      else if (type == STR) {
        return new NasmStrImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
