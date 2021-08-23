package org.arnoldc

import org.arnoldc.ast.RootNode


class ArnoldGenerator extends ClassLoader {

  def generate(arnoldCode: String, filename: String): (Array[Byte], RootNode) = {
    val