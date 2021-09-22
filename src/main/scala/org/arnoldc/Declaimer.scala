
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