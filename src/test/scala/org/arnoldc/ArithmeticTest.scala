
package org.arnoldc

import org.parboiled.errors.ParsingException

class ArithmeticTest extends ArnoldGeneratorTest {

  it should "function when a variable is declared" in {
    val code: String =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE var\n" +
        "YOU SET US UP 123\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("")
  }

  it should "function when an integer is printed" in {
    val code: String =
      "IT'S SHOWTIME\n" +
        "TALK TO THE HAND 123\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("123\n")
  }

  it should "evaluate when a negative integer is printed" in {
    val code: String =
      "IT'S SHOWTIME\n" +
        "TALK TO THE HAND -111\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("-111\n")
  }

  it should "evaluate when a 'boolean' is printed" in {
    val code: String =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE varfalse\n" +
        "YOU SET US UP @I LIED\n" +
        "TALK TO THE HAND varfalse\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("0\n")
  }

  it should "evaluate when a string is printed" in {
    val code: String =
      "IT'S SHOWTIME\n" +
        "TALK TO THE HAND \"this should be printed\"\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("this should be printed\n")
  }

  it should "evaluate when a more exotic string is printed" in {
    val code: String =
      "IT'S SHOWTIME\n" +
        "TALK TO THE HAND \"!!! ??? äöäöäöä@#0123=+-,.\"\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("!!! ??? äöäöäöä@#0123=+-,.\n")
  }

  it should "evaluate when an integer is declared and printed" in {
    val code: String =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE A\n" +
        "YOU SET US UP 999\n" +
        "HEY CHRISTMAS TREE B\n" +
        "YOU SET US UP 555\n" +
        "TALK TO THE HAND A\n" +
        "TALK TO THE HAND B\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("999\n555\n")
  }
  it should "evaluate when a negative integer is declared and printed" in {
    val code: String =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE a\n" +
        "YOU SET US UP -999\n" +
        "HEY CHRISTMAS TREE b\n" +
        "YOU SET US UP -555\n" +
        "TALK TO THE HAND a\n" +
        "TALK TO THE HAND b\n" +
        "YOU HAVE BEEN TERMINATED\n"