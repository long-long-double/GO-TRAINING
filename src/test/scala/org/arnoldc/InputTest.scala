package org.arnoldc
import org.scalatest.{Matchers, FlatSpec}
import java.io._

class InputTest extends ArnoldGeneratorTest{

  it should "read integer from input" in {
    writeToFile(path, "123")
    val code =
      "IT'S SHOWTIME\n" +
      "TALK TO THE HAND \"Input a number:\"\n" +
      "HEY CHRISTMAS TREE result\n" +
      "YOU SET US UP 0\n" +
      "GET YOUR ASS TO MARS result\n" +
      "DO IT NOW\n" +
      "I WANT TO ASK YOU A