package org.arnoldc

import java.io.{PrintStream, ByteArrayOutputStream}

class ByteCodeExecutor extends ClassLoader {
  val originalOutputStream = S