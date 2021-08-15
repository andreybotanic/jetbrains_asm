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
    b = adapt_builder_(t, b, this, null);
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

  /* ********************************************************** */
  // Operation Operands? (<<eof>> | EOL+)?
  public static boolean Instruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction")) return false;
    if (!nextTokenIs(b, GENERAL_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Operation(b, l + 1);
    r = r && Instruction_1(b, l + 1);
    r = r && Instruction_2(b, l + 1);
    exit_section_(b, m, INSTRUCTION, r);
    return r;
  }

  // Operands?
  private static boolean Instruction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_1")) return false;
    Operands(b, l + 1);
    return true;
  }

  // (<<eof>> | EOL+)?
  private static boolean Instruction_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_2")) return false;
    Instruction_2_0(b, l + 1);
    return true;
  }

  // <<eof>> | EOL+
  private static boolean Instruction_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eof(b, l + 1);
    if (!r) r = Instruction_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EOL+
  private static boolean Instruction_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_2_0_1", c)) break;
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
  // REGISTER
  //             | (BINARY | DECIMAL | HEXADECIMAL | FLOAT_DECIMAL)
  //             | ID
  //             | LBL
  public static boolean Operand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operand")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERAND, "<operand>");
    r = consumeToken(b, REGISTER);
    if (!r) r = Operand_1(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, LBL);
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
  // COMMENT
  //                 | Label
  //                 | Instruction
  //                 | EOL
  //                 | ID
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = Label(b, l + 1);
    if (!r) r = Instruction(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, ID);
    return r;
  }

}
