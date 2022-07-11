package org.arnoldc.ast

import org.objectweb.asm.Opcodes._
import org.objectweb.asm.{MethodVisitor, ClassWriter}
import org.arnoldc.{MethodInformation, SymbolTable}

case class RootNode(methods: List[AbstractMethodNode]) extends AstNode {

  def generateByteCode(filename: String): Array[Byte] = {
    val globalSymbols = storeMethodSignatures(filename)
    generateClass(filename, globalSymbols).toByteArray
  }

  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {
  }


  def storeMethodSignatures(filename: String) = {
    def storeTo(symbols: SymbolTable)(s: MethodSignature) = {
      symbols.putMethod(s.name, new MethodInformation(s.returnsValue, s.args.size))
    }
    val globalSymb