// This is a generated file. Not intended for manual editing.
package com.andreybotanic.asm.nasm.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.andreybotanic.asm.nasm.psi.NasmTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NasmParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return NasmFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(EXPR, NUMERIC_LITERAL, PARENTHESIS_EXPR, STR),
  };

  /* ********************************************************** */
  // LBL_DEF? DataStmt NL*
  public static boolean DataElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataElement")) return false;
    if (!nextTokenIs(b, "<data element>", DX, LBL_DEF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_ELEMENT, "<data element>");
    r = DataElement_0(b, l + 1);
    r = r && DataStmt(b, l + 1);
    r = r && DataElement_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBL_DEF?
  private static boolean DataElement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataElement_0")) return false;
    consumeToken(b, LBL_DEF);
    return true;
  }

  // NL*
  private static boolean DataElement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataElement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NL)) break;
      if (!empty_element_parsed_guard_(b, "DataElement_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // DX DataValue (SEPARATOR DataValue)*
  public static boolean DataStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataStmt")) return false;
    if (!nextTokenIs(b, DX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DX);
    r = r && DataValue(b, l + 1);
    r = r && DataStmt_2(b, l + 1);
    exit_section_(b, m, DATA_STMT, r);
    return r;
  }

  // (SEPARATOR DataValue)*
  private static boolean DataStmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataStmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DataStmt_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DataStmt_2", c)) break;
    }
    return true;
  }

  // SEPARATOR DataValue
  private static boolean DataStmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataStmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEPARATOR);
    r = r && DataValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expr | STRING | FLOAT_DECIMAL | QUESTION
  public static boolean DataValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_VALUE, "<data value>");
    r = Expr(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, FLOAT_DECIMAL);
    if (!r) r = consumeToken(b, QUESTION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ParenthesisExpr
  //        | NumericLiteral
  //        | Str
  public static boolean Expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPR, "<expr>");
    r = ParenthesisExpr(b, l + 1);
    if (!r) r = NumericLiteral(b, l + 1);
    if (!r) r = Str(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean Identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // Operation Operands? COMMENT? (<<eof>> | EOL+)?
  public static boolean Instruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction")) return false;
    if (!nextTokenIs(b, GENERAL_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Operation(b, l + 1);
    r = r && Instruction_1(b, l + 1);
    r = r && Instruction_2(b, l + 1);
    r = r && Instruction_3(b, l + 1);
    exit_section_(b, m, INSTRUCTION, r);
    return r;
  }

  // Operands?
  private static boolean Instruction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_1")) return false;
    Operands(b, l + 1);
    return true;
  }

  // COMMENT?
  private static boolean Instruction_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_2")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  // (<<eof>> | EOL+)?
  private static boolean Instruction_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_3")) return false;
    Instruction_3_0(b, l + 1);
    return true;
  }

  // <<eof>> | EOL+
  private static boolean Instruction_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eof(b, l + 1);
    if (!r) r = Instruction_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EOL+
  private static boolean Instruction_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_3_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBL_DEF EOL*
  public static boolean Label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Label")) return false;
    if (!nextTokenIs(b, LBL_DEF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBL_DEF);
    r = r && Label_1(b, l + 1);
    exit_section_(b, m, LABEL, r);
    return r;
  }

  // EOL*
  private static boolean Label_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Label_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "Label_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LBL | ID
  public static boolean LabelIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LabelIdentifier")) return false;
    if (!nextTokenIs(b, "<label identifier>", ID, LBL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABEL_IDENTIFIER, "<label identifier>");
    r = consumeToken(b, LBL);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean NasmFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NasmFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "NasmFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SIZE_TYPE? (BITWISE_NOT|MINUS|PLUS)? (BINARY|ZEROES|HEXADECIMAL|DECIMAL|FLOAT_DECIMAL|CHARACTER)
  public static boolean NumericLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMERIC_LITERAL, "<numeric literal>");
    r = NumericLiteral_0(b, l + 1);
    r = r && NumericLiteral_1(b, l + 1);
    r = r && NumericLiteral_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SIZE_TYPE?
  private static boolean NumericLiteral_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteral_0")) return false;
    consumeToken(b, SIZE_TYPE);
    return true;
  }

  // (BITWISE_NOT|MINUS|PLUS)?
  private static boolean NumericLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteral_1")) return false;
    NumericLiteral_1_0(b, l + 1);
    return true;
  }

  // BITWISE_NOT|MINUS|PLUS
  private static boolean NumericLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteral_1_0")) return false;
    boolean r;
    r = consumeToken(b, BITWISE_NOT);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, PLUS);
    return r;
  }

  // BINARY|ZEROES|HEXADECIMAL|DECIMAL|FLOAT_DECIMAL|CHARACTER
  private static boolean NumericLiteral_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteral_2")) return false;
    boolean r;
    r = consumeToken(b, BINARY);
    if (!r) r = consumeToken(b, ZEROES);
    if (!r) r = consumeToken(b, HEXADECIMAL);
    if (!r) r = consumeToken(b, DECIMAL);
    if (!r) r = consumeToken(b, FLOAT_DECIMAL);
    if (!r) r = consumeToken(b, CHARACTER);
    return r;
  }

  /* ********************************************************** */
  // REGISTER
  //             | (BINARY | DECIMAL | HEXADECIMAL | FLOAT_DECIMAL)
  //             | STRING
  //             | CHARACTER
  //             | Identifier
  //             | LabelIdentifier
  public static boolean Operand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operand")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERAND, "<operand>");
    r = consumeToken(b, REGISTER);
    if (!r) r = Operand_1(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, CHARACTER);
    if (!r) r = Identifier(b, l + 1);
    if (!r) r = LabelIdentifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BINARY | DECIMAL | HEXADECIMAL | FLOAT_DECIMAL
  private static boolean Operand_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operand_1")) return false;
    boolean r;
    r = consumeToken(b, BINARY);
    if (!r) r = consumeToken(b, DECIMAL);
    if (!r) r = consumeToken(b, HEXADECIMAL);
    if (!r) r = consumeToken(b, FLOAT_DECIMAL);
    return r;
  }

  /* ********************************************************** */
  // Operand (SEPARATOR Operand)*
  public static boolean Operands(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operands")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERANDS, "<operands>");
    r = Operand(b, l + 1);
    r = r && Operands_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (SEPARATOR Operand)*
  private static boolean Operands_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operands_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Operands_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Operands_1", c)) break;
    }
    return true;
  }

  // SEPARATOR Operand
  private static boolean Operands_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operands_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEPARATOR);
    r = r && Operand(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // GENERAL_OP
  public static boolean Operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation")) return false;
    if (!nextTokenIs(b, GENERAL_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GENERAL_OP);
    exit_section_(b, m, OPERATION, r);
    return r;
  }

  /* ********************************************************** */
  // ROUND_L Expr ROUND_R
  public static boolean ParenthesisExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesisExpr")) return false;
    if (!nextTokenIs(b, ROUND_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARENTHESIS_EXPR, null);
    r = consumeToken(b, ROUND_L);
    p = r; // pin = 1
    r = r && report_error_(b, Expr(b, l + 1));
    r = p && consumeToken(b, ROUND_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // STRING
  public static boolean Str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Str")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, STR, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT
  //                 | Label
  //                 | Instruction
  //                 | DataElement
  //                 | EOL
  //                 | ID
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = Label(b, l + 1);
    if (!r) r = Instruction(b, l + 1);
    if (!r) r = DataElement(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, ID);
    return r;
  }

}
