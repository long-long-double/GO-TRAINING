package org.arnoldc.ast

abstract class AbstractMethodNode extends AstNode {
  val statements: List[StatementNode]
  val arguments: List[VariableNode]
  val methodName: String
  val returnsValue: Boolean

  def