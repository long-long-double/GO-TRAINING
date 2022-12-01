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
        "LISTEN TO ME VERY CAREFULLY mymethod\n" +
        "HASTA LA VISTA, BABY"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute a plain method call" in {
    val code =
      "IT'S SHOWTIME\n" +
        "DO IT NOW printHello\n" +
        "YOU HAVE BEEN TERMINATED\n" +
        "LISTEN TO ME VERY CAREFULLY printHello\n" +
        "TALK TO THE HAND \"Hello\"\n" +
        "HASTA LA VISTA, BABY"
    getOutput(code) should equal("Hello\n")
  }

  it should "evalute a method call that takes an argument" in {
    val code =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE argument\n" +
        "YOU SET US UP 123\n" +
        "DO IT NOW printInteger argument\n" +
        "YOU HAVE BEEN TERMINATED\n" +
        "LISTEN TO ME VERY CAREFULLY printInteger\n" +
        "I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE value\n" +
        "TALK TO THE HAND value\n" +
        "HASTA LA VISTA, BABY"
    getOutput(code) should equal("123\n")
  }

  it should "evalute multiple method calls" in {
    val code =
      "IT'S SHOWTIME\n" +
        "DO IT NOW printHello\n" +
        "DO IT NOW printCheers\n" +
        "YOU HAVE BEEN TERMINATED\n" +
        "LISTEN TO ME VERY CAREFULLY printHello\n" +
        "TALK TO THE HAND \"Hello\"\n" +
        "HASTA LA VISTA, BABY\n" +
        "LISTEN TO ME VERY CAREFULLY printCheers\n" +
        "TALK TO THE HAND \"Cheers\"\n" +
        "HASTA LA VISTA, BABY"
    getOutput(code) should equal("Hello\nCheers\n")
  }

  it should "evalute method calls inside method calls" in {
    val code =
      "IT'S SHOWTIME\n" +
        "DO IT NOW printHello\n" +
        "YOU HAVE BEEN TERMINATED\n" +
        "LISTEN TO ME VERY CAREFULLY printHello\n" +
        "TALK TO THE HAND \"Hello\"\n" +
        "DO IT NOW printCheers\n" +
        "DO IT NOW printHejsan\n" +
        "HASTA LA VISTA, BABY\n" +
        "LISTEN TO ME VERY CAREFULLY printCheers\n" +
        "TALK TO THE HAND \"Cheers\"\n" +
        "HASTA LA VISTA, BABY\n" +
        "LISTEN TO ME VERY CAREFULLY printHejsan\n" +
        "TALK TO THE HAND \"Hejsan\"\n" +
        "HASTA LA VISTA, BABY"
    getOutput(code) should equal("Hello\nCheers\nHejsan\n")
  }

  it should "evalute a return statement in void calls" in {
    val code =
      "IT'S SHOWTIME\n" +
        "DO IT NOW method\n" +
        "YOU HAVE BEEN TERMINATED\n" +
        "LISTEN TO ME VERY CAREFULLY method\n" +
        "I'LL BE BACK\n" +
        "HASTA LA VISTA, BABY\n"

    getOutput(code) should equal("")
  }

  it should "evalute multiple return statemenents in void calls" in {
    val code = "IT'S SHOWTIME\n" +
      "DO IT NOW printboolean @NO PROBLEMO\n" +
      "DO IT NOW printboolean @I LIED\n" +
      "YOU HAVE BEEN TERMINATED\n" +
      "LISTEN TO ME VERY CAREFULLY printboolean\n" +
      "I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE value\n" +
      "BECAUSE I'M GOING TO SAY PLEASE value\n" +
      "TALK TO THE HAND \"true\"\n" +
      "I'LL BE BACK\n" +
      "BULLSHIT\n" +
      "TALK TO THE HAND \"false\"\n" +
      "I'LL BE BACK\n" +
      "YOU HAVE NO RESPECT FOR LOGIC\n" +
      "HASTA LA VISTA, BABY\n"

    getOutput(code) should equal("true\nfalse\n")
  }

  it should "evalute multiple return statemenents in void calls permutation2" in {
    val code = "IT'S SHOWTIME\n" +
      "DO IT NOW printboolean @NO PROBLEMO\n" +
      "DO IT NOW printboolean @I LIED\n" +
      "YOU HAVE BEEN TERMINATED\n" +
      "LISTEN TO ME VERY CAREFULLY printboolean\n" +
      "I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE value\n" +
      "BECAUSE I'M GOING TO SAY PLEASE value\n" +
      "TALK TO THE HAND \"true\"\n" +
      "BULLSHIT\n" +
      "TALK TO THE HAND \"false\"\n" +
      "YOU HAVE NO RESPECT FOR LOGIC\n" +
      "HASTA LA VISTA, BABY\n"
    getOutput(code) should equal("true\nfalse\n")
  }

  it should "evalute multiple return statemenents in void calls permutation3" in {
    val code = "IT'S SHOWTIME\n" +
      "DO IT NOW printboolean @NO PROBLEMO\n" +
      "DO IT NOW printboolean @I LIED\n" +
      "YOU HAVE BEEN TERMINATED\n" +
      "LISTEN TO ME VERY CAREFULLY printboolean\n" +
      "I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE value\n