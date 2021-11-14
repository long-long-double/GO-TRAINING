package org.arnoldc.ast

import org.objectweb.asm.MethodVisitor
import org.arnoldc.{SymbolTable}
import org.objectweb.asm.Opcodes._
import org.parboiled.errors.ParsingException


case class Declar