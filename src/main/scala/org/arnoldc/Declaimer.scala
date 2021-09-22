
package org.arnoldc

import java.util.Locale
import javax.speech.Central
import javax.speech.synthesis.Synthesizer
import javax.speech.synthesis.SynthesizerModeDesc
import javax.speech.synthesis.Voice
import com.sun.speech.freetts.audio.AudioPlayer
import com.sun.speech.freetts.audio.SingleFileAudioPlayer
import javax.sound.sampled.AudioFileFormat.Type
import org.arnoldc.ast._

object Declaimer {

  val p = new ArnoldParser

  def declaim(root: RootNode, outputFile: String): Unit = {
    SpeechUtils.init("kevin16", outputFile)
    declaim(root)
    SpeechUtils.terminate()
  }

  def say(text: String) = SpeechUtils.doSpeak(text + "!\n")

  def declaim(node: AstNode): Unit = node match {
    case RootNode(methods) => methods.map(m => declaim(m))
    case MainMethodNode(stmts) =>
      say(p.BeginMain)
      stmts foreach declaim
      say(p.EndMain)
    case MethodNode(name, args, ret, stmts) =>
      say(s"${p.DeclareMethod} $name")
      args.foreach(a => say(s"${p.MethodArguments} ${a.variableName}"))
      if (ret) say(p.NonVoidMethod);
      stmts.map(s => declaim(s))
      say(p.EndMethodDeclaration)

    case AssignVariableNode(name, expr) =>
      say(s"${p.AssignVariable} $name")
      say(p.SetValue)
      declaim(expr)
      say(p.EndAssignVariable)
    case PrintNode(what) =>
      say(p.Print)
      declaim(what)
    case DeclareIntNode(name, value) =>
      say(s"${p.DeclareInt} $name")
      say(s"${p.SetInitialValue} $value")
    case ConditionNode(condition, ifStmts, elseStmts) =>
      say(p.If)
      declaim(condition)
      ifStmts foreach declaim
      if (elseStmts.nonEmpty) {
        say(p.Else)
        elseStmts foreach declaim
      }
      say(p.EndIf)
    case WhileNode(condition, stmts) =>
      say(p.While)
      declaim(condition)
      stmts foreach declaim
      say(p.EndWhile)
    case CallMethodNode(variable, name, args) =>
      if (variable.nonEmpty) {
        say(s"${p.AssignVariableFromMethodCall} $variable")
      }
      say(s"${p.CallMethod} $name")
      args foreach declaim
    case CallReadMethodNode(variable) =>
      say(s"${p.Read} $variable")
    case ReturnNode(expr) =>
      say(p.Return)
      expr.map { x => declaim(x) }

    case AndNode(expr1, expr2) =>
      declaim(expr1)
      say(p.And)
      declaim(expr2)
    case OrNode(expr1, expr2) =>
      declaim(expr1)
      say(p.Or)
      declaim(expr2)