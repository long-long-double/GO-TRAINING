package org.arnoldc

import org.parboiled.errors.ParsingException

class MethodTest extends ArnoldGeneratorTest {

  it should "evalute method other than main" in {
    val code =
      "LISTEN TO ME VERY CAREFULLY mymethod\n" +
        "HASTA LA VISTA, BABY\n" +
        "IT'S SHOWTIME\n" +
        