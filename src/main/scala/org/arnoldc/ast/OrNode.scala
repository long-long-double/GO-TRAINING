package org.arnoldc.ast

import org.objectweb.asm.{Opcodes, MethodVisitor, Label}
import org.objectweb.asm.Opcodes._
import org.arnoldc.SymbolTable


case class OrNode(expression: Ast