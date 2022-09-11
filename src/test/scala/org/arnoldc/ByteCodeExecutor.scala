package org.arnoldc

import java.io.{PrintStream, ByteArrayOutputStream}

class ByteCodeExecutor extends ClassLoader {
  val originalOutputStream = System.out

  def getOutput(bytecode: Array[Byte], className: String): String = {

    val outputRedirectionStream = new ByteArrayOutputStream()

   