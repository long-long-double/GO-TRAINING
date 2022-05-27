package org.arnoldc.ast

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes._
import org.arnoldc.SymbolTable
import org.parboiled.errors.ParsingException


case class ReturnNode(operand: Option[OperandNode]) extends StatementNode {
  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {
    if (operand.isEmpty) {
      if (symbolTable.getCurrentMethod().returnsValue) {
        throw new ParsingException("NON VOID METHOD: " 