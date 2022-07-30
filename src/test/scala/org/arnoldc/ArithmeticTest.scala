
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