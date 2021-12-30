package org.arnoldc.ast

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes._
import org.objectweb.asm.Label
import org.arnoldc.SymbolTable

case class EqualToNode(operand1: AstNode, operand2: AstNode) extends ExpressionNode {
  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {

    val notEqual = new Label()
    val conclude = new Label()
    operand1.generate(mv, symbolTable)
    operand2.generate(mv, symbolTable)
    mv.v