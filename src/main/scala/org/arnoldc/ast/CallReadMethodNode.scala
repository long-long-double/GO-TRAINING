package org.arnoldc.ast

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes._
import org.arnoldc.SymbolTable

case class CallReadMethodNode(returnVar: String) extends StatementNode{
  def generate(mv: MethodVisitor, symbolTable: SymbolTable) = {
    mv.visitTypeInsn(NEW, "java/util/Scanne