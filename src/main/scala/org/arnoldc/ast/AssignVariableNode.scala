package org.arnoldc.ast

import org.objectweb.asm.MethodVisitor
import org.arnoldc.SymbolTable
import org.objectweb.asm.Opcodes._

case class AssignVariableNode(variable: String, expression: AstNode) exten