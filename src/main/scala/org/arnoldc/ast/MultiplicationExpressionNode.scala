package org.arnoldc.ast

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes._
import org.arnoldc.SymbolTable

case class MultiplicationExpressionNode(expression: AstNode ,operand: AstNode ) extends AstNode{
  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {
    express