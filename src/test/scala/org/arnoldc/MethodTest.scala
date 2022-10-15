package org.arnoldc

import org.parboiled.errors.ParsingException

class MethodTest extends ArnoldGeneratorTest {

  it should "evalute method other than main" in {
    val code =
      "LISTEN TO ME VERY CAREFULLY mymethod\n" +
        "HASTA LA VISTA, BABY\n" +
        "IT'S SHOWTIME\n" +
        "TALK TO THE HAND \"Hello\"\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute method other than main2" in {
    val code =
      "LISTEN TO ME VERY CAREFULLY mymethod\n" +
        "HASTA LA VISTA, BABY\n" +
        "IT'S SHOWTIME\n" +
        "TALK TO THE HAND \"Hello\"\n" +
        "YOU HAVE BEEN TERMINATED"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute method other than main3" in {
    val code =
      "IT'S SHOWTIME\n" +
        "TALK TO THE HAND \"Hello\"\n" +
        "YOU HAVE BEEN TERMINATED\n" +
        "LISTEN TO ME VERY CAREFULLY mymethod\n" +
        "HASTA LA VISTA, BABY\n"
    getOutput(code) should equal("Hello\n")
  }
  it should "evalute method other than main4" in {
    val code =
      "IT'S SHOWTIME\n" +
        "TALK TO THE HAND \"Hello\"\n" +
        "YOU HAVE BEEN TERMINATED\n" +
        "LISTEN TO ME VERY CAREFULLY mymethod\