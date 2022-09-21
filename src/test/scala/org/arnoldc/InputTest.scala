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
      "