package org.arnoldc.ast

import org.objectweb.asm.{Opcodes, MethodVisitor, Label}
import org.objectweb.asm.Opcodes._
import org.arnoldc.SymbolTable


case class OrNode(expression: AstNode, operand: AstNode) extends ExpressionNode {
  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {

    val eitherTrue = new Label()
    val conclude = new Label()
    expression.generate(mv, symbolTable)
    mv.visitJumpInsn(IFNE, eitherTrue)
    operand.generate(mv, symbolTable)
    mv.visitJumpInsn(IFNE, eithe