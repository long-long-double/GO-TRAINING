package org.arnoldc

import java.io.FileOutputStream
import org.arnoldc.ast.RootNode

object ArnoldC {
  def main(args: Array[String]) {
    if (args.length < 1) {
      println("Usage: ArnoldC [-run|-declaim] [FileToSourceCode]")
      return
    }
    val filename = getFilNameFromArgs(args)
    val sourceCode = scala.io.Source.fromFile(filename).mkString
    val a = new ArnoldGenerator()
    val classFile