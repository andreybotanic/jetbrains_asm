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
    create_token_set_(ADDRESS, BITWISE_AND_EXPR, BITWISE_NOT_EXPR, BITWISE_OR_EXPR,
      BITWISE_XOR_EXPR, BIT_SHIFT_L_EXPR, BIT_SHIFT_R_EXPR, DIV_EXPR,
      EXPR, IDENTIFIER, LABEL_IDENTIFIER, LOGICAL_AND_EXPR,
      LOGICAL_OR_EXPR, LOGICAL_XOR_EXPR, MINUS_EXPR, MODULUS_EXPR,
      MUL_EXPR, NUMERIC_LITERAL, OPERATION, PARENTHESIS_EXPR,
      PLUS_EXPR, REGISTER, STR),
  };

  /* ********************************************************** */
  // SQUARE_L MINUS? Expr SQUARE_R
  static boolean AddressInternal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AddressInternal")) return false;
    if (!nextTokenIs(b, SQUARE_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, SQUARE_L);
    p = r; // pin = 1
    r = r && report_error_(b, AddressInternal_1(b, l + 1));
    r = p && report_error_(b, Expr(b, l + 1, -1)) && r;
    r = p && consumeToken(b, SQUARE_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // MINUS?
  private static boolean AddressInternal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AddressInternal_1")) return false;
    consumeToken(b, MINUS);
    return true;
  }

  /* ********************************************************** */
  // DATA_DEF Expr (SEPARATOR Expr)*
  public static boolean DataDefStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataDefStmt")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DATA_DEF_STMT, "<data def stmt>");
    r = consumeToken(b, DATA_DEF);
    p = r; // pin = 1
    r = r && report_error_(b, Expr(b, l + 1, -1));
    r = p && DataDefStmt_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, NasmParser::DataValueRecover);
    return r || p;
  }

  // (SEPARATOR Expr)*
  private static boolean DataDefStmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataDefStmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DataDefStmt_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DataDefStmt_2", c)) break;
    }
    return true;
  }

  // SEPARATOR Expr
  private static boolean DataDefStmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataDefStmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEPARATOR);
    r = r && Expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBL_DEF? DataStmt EOL*
  public static boolean DataElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataElement")) return false;
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

  // EOL*
  private static boolean DataElement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataElement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "DataElement_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // DATA_RES Expr
  public static boolean DataResStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataResStmt")) return false;
    if (!nextTokenIs(b, DATA_RES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATA_RES);
    r = r && Expr(b, l + 1, -1);
    exit_section_(b, m, DATA_RES_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // DataResStmt | DataDefStmt
  public static boolean DataStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataStmt")) return false;
    if (!nextTokenIs(b, "<data stmt>", DATA_DEF, DATA_RES)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_STMT, "<data stmt>");
    r = DataResStmt(b, l + 1);
    if (!r) r = DataDefStmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(COMMENT | EOL)
  static boolean DataValueRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataValueRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !DataValueRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT | EOL
  private static boolean DataValueRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataValueRecover_0")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // (DirectiveDecl|DirectiveDeclBrackets) EOL*
  public static boolean Directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Directive")) return false;
    if (!nextTokenIs(b, "<directive>", DIRECTIVE_OP, SQUARE_L)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIRECTIVE, "<directive>");
    r = Directive_0(b, l + 1);
    r = r && Directive_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DirectiveDecl|DirectiveDeclBrackets
  private static boolean Directive_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Directive_0")) return false;
    boolean r;
    r = DirectiveDecl(b, l + 1);
    if (!r) r = DirectiveDeclBrackets(b, l + 1);
    return r;
  }

  // EOL*
  private static boolean Directive_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Directive_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "Directive_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // DIRECTIVE_OP (Expr SEPARATOR?)*
  static boolean DirectiveDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DirectiveDecl")) return false;
    if (!nextTokenIs(b, DIRECTIVE_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DIRECTIVE_OP);
    r = r && DirectiveDecl_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Expr SEPARATOR?)*
  private static boolean DirectiveDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DirectiveDecl_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DirectiveDecl_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DirectiveDecl_1", c)) break;
    }
    return true;
  }

  // Expr SEPARATOR?
  private static boolean DirectiveDecl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DirectiveDecl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expr(b, l + 1, -1);
    r = r && DirectiveDecl_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEPARATOR?
  private static boolean DirectiveDecl_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DirectiveDecl_1_0_1")) return false;
    consumeToken(b, SEPARATOR);
    return true;
  }

  /* ********************************************************** */
  // SQUARE_L DIRECTIVE_OP Expr* SQUARE_R
  static boolean DirectiveDeclBrackets(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DirectiveDeclBrackets")) return false;
    if (!nextTokenIs(b, SQUARE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SQUARE_L, DIRECTIVE_OP);
    r = r && DirectiveDeclBrackets_2(b, l + 1);
    r = r && consumeToken(b, SQUARE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expr*
  private static boolean DirectiveDeclBrackets_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DirectiveDeclBrackets_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expr(b, l + 1, -1)) break;
      if (!empty_element_parsed_guard_(b, "DirectiveDeclBrackets_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // Expr | Str
  public static boolean Immediate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Immediate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMMEDIATE, "<immediate>");
    r = Expr(b, l + 1, -1);
    if (!r) r = Str(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // Identifier | Address
  public static boolean Memory(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Memory")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MEMORY, "<memory>");
    r = Identifier(b, l + 1);
    if (!r) r = Address(b, l + 1);
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
  // Register
  //           | Immediate
  //           | Memory
  //           | Identifier
  //           | LabelIdentifier
  public static boolean Operand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operand")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERAND, "<operand>");
    r = Register(b, l + 1);
    if (!r) r = Immediate(b, l + 1);
    if (!r) r = Memory(b, l + 1);
    if (!r) r = Identifier(b, l + 1);
    if (!r) r = LabelIdentifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(COMMENT | EOL)
  static boolean OperandRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperandRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !OperandRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT | EOL
  private static boolean OperandRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperandRecover_0")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // Operand (SEPARATOR Operand)*
  static boolean Operands(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operands")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = Operand(b, l + 1);
    p = r; // pin = 1
    r = r && Operands_1(b, l + 1);
    exit_section_(b, l, m, r, p, NasmParser::OperandRecover);
    return r || p;
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
  // SECTION_DEF SECTION_NAME
  public static boolean Section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Section")) return false;
    if (!nextTokenIs(b, SECTION_DEF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SECTION_DEF, SECTION_NAME);
    exit_section_(b, m, SECTION, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT
  //                 | Section
  //                 | Label
  //                 | Directive
  //                 | Instruction
  //                 | DataElement
  //                 | EOL
  //                 | ID
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = Section(b, l + 1);
    if (!r) r = Label(b, l + 1);
    if (!r) r = Directive(b, l + 1);
    if (!r) r = Instruction(b, l + 1);
    if (!r) r = DataElement(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, ID);
    return r;
  }

  /* ********************************************************** */
  // Expression root: Expr
  // Operator priority table:
  // 0: ATOM(ParenthesisExpr)
  // 1: BINARY(MulExpr) BINARY(DivExpr)
  // 2: BINARY(PlusExpr) BINARY(MinusExpr)
  // 3: BINARY(ModulusExpr)
  // 4: BINARY(BitShiftLExpr) BINARY(BitShiftRExpr)
  // 5: BINARY(BitwiseANDExpr)
  // 6: BINARY(BitwiseORExpr)
  // 7: BINARY(BitwiseXORExpr)
  // 8: PREFIX(BitwiseNOTExpr)
  // 9: BINARY(LogicalANDExpr)
  // 10: BINARY(LogicalORExpr)
  // 11: BINARY(LogicalXORExpr)
  // 12: ATOM(NumericLiteral)
  // 13: ATOM(Str)
  // 14: ATOM(Address)
  // 15: ATOM(Register)
  // 16: ATOM(Operation)
  // 17: ATOM(Identifier)
  // 18: ATOM(LabelIdentifier)
  public static boolean Expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = ParenthesisExpr(b, l + 1);
    if (!r) r = BitwiseNOTExpr(b, l + 1);
    if (!r) r = NumericLiteral(b, l + 1);
    if (!r) r = Str(b, l + 1);
    if (!r) r = Address(b, l + 1);
    if (!r) r = Register(b, l + 1);
    if (!r) r = Operation(b, l + 1);
    if (!r) r = Identifier(b, l + 1);
    if (!r) r = LabelIdentifier(b, l + 1);
    p = r;
    r = r && Expr_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean Expr_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expr_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 1 && consumeTokenSmart(b, TIMES)) {
        r = Expr(b, l, 1);
        exit_section_(b, l, m, MUL_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, DIVIDE)) {
        r = Expr(b, l, 1);
        exit_section_(b, l, m, DIV_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, PLUS)) {
        r = Expr(b, l, 2);
        exit_section_(b, l, m, PLUS_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, MINUS)) {
        r = Expr(b, l, 2);
        exit_section_(b, l, m, MINUS_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, PERCENT)) {
        r = Expr(b, l, 3);
        exit_section_(b, l, m, MODULUS_EXPR, r, true, null);
      }
      else if (g < 4 && consumeTokenSmart(b, BITSHIFT_L)) {
        r = Expr(b, l, 4);
        exit_section_(b, l, m, BIT_SHIFT_L_EXPR, r, true, null);
      }
      else if (g < 4 && consumeTokenSmart(b, BITSHIFT_R)) {
        r = Expr(b, l, 4);
        exit_section_(b, l, m, BIT_SHIFT_R_EXPR, r, true, null);
      }
      else if (g < 5 && consumeTokenSmart(b, BITWISE_AND)) {
        r = Expr(b, l, 5);
        exit_section_(b, l, m, BITWISE_AND_EXPR, r, true, null);
      }
      else if (g < 6 && consumeTokenSmart(b, BITWISE_OR)) {
        r = Expr(b, l, 6);
        exit_section_(b, l, m, BITWISE_OR_EXPR, r, true, null);
      }
      else if (g < 7 && consumeTokenSmart(b, BITWISE_XOR)) {
        r = Expr(b, l, 7);
        exit_section_(b, l, m, BITWISE_XOR_EXPR, r, true, null);
      }
      else if (g < 9 && consumeTokenSmart(b, LOGICAL_AND)) {
        r = Expr(b, l, 9);
        exit_section_(b, l, m, LOGICAL_AND_EXPR, r, true, null);
      }
      else if (g < 10 && consumeTokenSmart(b, LOGICAL_OR)) {
        r = Expr(b, l, 10);
        exit_section_(b, l, m, LOGICAL_OR_EXPR, r, true, null);
      }
      else if (g < 11 && consumeTokenSmart(b, LOGICAL_XOR)) {
        r = Expr(b, l, 11);
        exit_section_(b, l, m, LOGICAL_XOR_EXPR, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // ROUND_L Expr ROUND_R
  public static boolean ParenthesisExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesisExpr")) return false;
    if (!nextTokenIsSmart(b, ROUND_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARENTHESIS_EXPR, null);
    r = consumeTokenSmart(b, ROUND_L);
    p = r; // pin = 1
    r = r && report_error_(b, Expr(b, l + 1, -1));
    r = p && consumeToken(b, ROUND_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  public static boolean BitwiseNOTExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitwiseNOTExpr")) return false;
    if (!nextTokenIsSmart(b, BITWISE_NOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, BITWISE_NOT);
    p = r;
    r = p && Expr(b, l, 8);
    exit_section_(b, l, m, BITWISE_NOT_EXPR, r, p, null);
    return r || p;
  }

  // SIZE_PREFIX? (BITWISE_NOT|MINUS|PLUS)? (BINARY|ZEROES|HEXADECIMAL|DECIMAL|FLOAT_DECIMAL|CHARACTER)
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

  // SIZE_PREFIX?
  private static boolean NumericLiteral_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteral_0")) return false;
    consumeTokenSmart(b, SIZE_PREFIX);
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
    r = consumeTokenSmart(b, BITWISE_NOT);
    if (!r) r = consumeTokenSmart(b, MINUS);
    if (!r) r = consumeTokenSmart(b, PLUS);
    return r;
  }

  // BINARY|ZEROES|HEXADECIMAL|DECIMAL|FLOAT_DECIMAL|CHARACTER
  private static boolean NumericLiteral_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteral_2")) return false;
    boolean r;
    r = consumeTokenSmart(b, BINARY);
    if (!r) r = consumeTokenSmart(b, ZEROES);
    if (!r) r = consumeTokenSmart(b, HEXADECIMAL);
    if (!r) r = consumeTokenSmart(b, DECIMAL);
    if (!r) r = consumeTokenSmart(b, FLOAT_DECIMAL);
    if (!r) r = consumeTokenSmart(b, CHARACTER);
    return r;
  }

  // STRING
  public static boolean Str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Str")) return false;
    if (!nextTokenIsSmart(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, STRING);
    exit_section_(b, m, STR, r);
    return r;
  }

  // SIZE_PREFIX? AddressInternal
  public static boolean Address(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Address")) return false;
    if (!nextTokenIsSmart(b, SIZE_PREFIX, SQUARE_L)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDRESS, "<address>");
    r = Address_0(b, l + 1);
    r = r && AddressInternal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SIZE_PREFIX?
  private static boolean Address_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Address_0")) return false;
    consumeTokenSmart(b, SIZE_PREFIX);
    return true;
  }

  // REG_8 | REG_16 | REG_32 | REG_64
  public static boolean Register(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Register")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REGISTER, "<register>");
    r = consumeTokenSmart(b, REG_8);
    if (!r) r = consumeTokenSmart(b, REG_16);
    if (!r) r = consumeTokenSmart(b, REG_32);
    if (!r) r = consumeTokenSmart(b, REG_64);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // GENERAL_OP
  public static boolean Operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation")) return false;
    if (!nextTokenIsSmart(b, GENERAL_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, GENERAL_OP);
    exit_section_(b, m, OPERATION, r);
    return r;
  }

  // ID
  public static boolean Identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier")) return false;
    if (!nextTokenIsSmart(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, ID);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  // LBL | ID
  public static boolean LabelIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LabelIdentifier")) return false;
    if (!nextTokenIsSmart(b, ID, LBL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABEL_IDENTIFIER, "<label identifier>");
    r = consumeTokenSmart(b, LBL);
    if (!r) r = consumeTokenSmart(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
