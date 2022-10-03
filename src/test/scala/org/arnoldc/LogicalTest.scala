
package org.arnoldc

import org.parboiled.errors.ParsingException

class LogicalTest extends ArnoldGeneratorTest {
  it should "False Or True Evaluate True" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE var\n" +
      "YOU SET US UP 0\n" +
      "GET TO THE CHOPPER var\n" +
      "HERE IS MY INVITATION 0\n" +
      "CONSIDER THAT A DIVORCE 1\n" +
      "ENOUGH TALK\n" +
      "TALK TO THE HAND var\n" +
      "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("1\n")
  }


  it should "True Or False Evaluate True" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE var\n" +
      "YOU SET US UP @I LIED\n" +
      "GET TO THE CHOPPER var\n" +
      "HERE IS MY INVITATION @NO PROBLEMO\n" +
      "CONSIDER THAT A DIVORCE @I LIED\n" +
      "ENOUGH TALK\n" +
      "TALK TO THE HAND var\n" +
      "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("1\n")
  }

  it should "True Or True Evaluate True" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE var\n" +
      "YOU SET US UP @I LIED\n" +
      "GET TO THE CHOPPER var\n" +
      "HERE IS MY INVITATION @NO PROBLEMO\n" +
      "CONSIDER THAT A DIVORCE @NO PROBLEMO\n" +
      "ENOUGH TALK\n" +
      "TALK TO THE HAND var\n" +
      "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("1\n")
  }

  it should "False Or False Evaluate False" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE var\n" +
      "YOU SET US UP @I LIED\n" +
      "GET TO THE CHOPPER var\n" +
      "HERE IS MY INVITATION @I LIED\n" +
      "CONSIDER THAT A DIVORCE @I LIED\n" +
      "ENOUGH TALK\n" +
      "TALK TO THE HAND var\n" +
      "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("0\n")
  }

  it should "False And True Evaluate False" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE var\n" +
      "YOU SET US UP @I LIED\n" +
      "GET TO THE CHOPPER var\n" +
      "HERE IS MY INVITATION @I LIED\n" +
      "KNOCK KNOCK @NO PROBLEMO\n" +
      "ENOUGH TALK\n" +
      "TALK TO THE HAND var\n" +
      "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("0\n")
  }

  it should "True And False Evaluate False" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE var\n" +
      "YOU SET US UP @I LIED\n" +
      "GET TO THE CHOPPER var\n" +
      "HERE IS MY INVITATION @NO PROBLEMO\n" +
      "KNOCK KNOCK @I LIED\n" +
      "ENOUGH TALK\n" +
      "TALK TO THE HAND var\n" +
      "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("0\n")
  }

  it should "True And True Evaluate True" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE var\n" +
      "YOU SET US UP @I LIED\n" +
      "GET TO THE CHOPPER var\n" +
      "HERE IS MY INVITATION @NO PROBLEMO\n" +
      "KNOCK KNOCK @NO PROBLEMO\n" +
      "ENOUGH TALK\n" +
      "TALK TO THE HAND var\n" +
      "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("1\n")
  }

  it should "True and True and False evaluates False" in {
    val code =
    "IT'S SHOWTIME\n" +
    "HEY CHRISTMAS TREE var\n" +
    "YOU SET US UP @I LIED\n" +
    "GET TO THE CHOPPER var\n" +
    "HERE IS MY INVITATION 1\n" +
    "KNOCK KNOCK 1\n" +
    "KNOCK KNOCK 0\n" +
    "ENOUGH TALK\n" +
    "TALK TO THE HAND var\n" +
    "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("0\n")
  }

  it should "True and True and True evaluates True" in {
    val code =
    "IT'S SHOWTIME\n" +
    "HEY CHRISTMAS TREE var\n" +
    "YOU SET US UP @I LIED\n" +
    "GET TO THE CHOPPER var\n" +
    "HERE IS MY INVITATION 1\n" +
    "KNOCK KNOCK 1\n" +
    "KNOCK KNOCK 1\n" +
    "ENOUGH TALK\n" +
    "TALK TO THE HAND var\n" +
    "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("1\n")
  }

    it should "True and True and True and True and False evaluates False" in {
    val code =
    "IT'S SHOWTIME\n" +
    "HEY CHRISTMAS TREE var\n" +
    "YOU SET US UP @I LIED\n" +
    "GET TO THE CHOPPER var\n" +
    "HERE IS MY INVITATION @NO PROBLEMO\n" +
    "KNOCK KNOCK @NO PROBLEMO\n" +
    "KNOCK KNOCK @NO PROBLEMO\n" +
    "KNOCK KNOCK @NO PROBLEMO\n" +
    "KNOCK KNOCK @I LIED\n" +
    "ENOUGH TALK\n" +
    "TALK TO THE HAND var\n" +
    "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("0\n")
  }

    it should "False or False or False evaluates False" in {
    val code =
    "IT'S SHOWTIME\n" +
    "HEY CHRISTMAS TREE var\n" +
    "YOU SET US UP @I LIED\n" +
    "GET TO THE CHOPPER var\n" +
    "HERE IS MY INVITATION @I LIED\n" +
    "CONSIDER THAT A DIVORCE @I LIED\n" +
    "CONSIDER THAT A DIVORCE @I LIED\n" +
    "ENOUGH TALK\n" +
    "TALK TO THE HAND var\n" +
    "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("0\n")
  }

    it should "False or True and False evaluates False" in {
    val code =
    "IT'S SHOWTIME\n" +
    "HEY CHRISTMAS TREE var\n" +
    "YOU SET US UP @I LIED\n" +
    "GET TO THE CHOPPER var\n" +
    "HERE IS MY INVITATION @I LIED\n" +
    "CONSIDER THAT A DIVORCE @NO PROBLEMO\n" +
    "KNOCK KNOCK @I LIED\n" +
    "ENOUGH TALK\n" +
    "TALK TO THE HAND var\n" +
    "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("0\n")
  }

  it should "False And False Evaluate False" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE var\n" +
      "YOU SET US UP @I LIED\n" +
      "GET TO THE CHOPPER var\n" +
      "HERE IS MY INVITATION @I LIED\n" +
      "KNOCK KNOCK @I LIED\n" +
      "ENOUGH TALK\n" +
      "TALK TO THE HAND var\n" +
      "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("0\n")
  }

  it should "False Equals False evaluates True" in {
    val code =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE varfalse\n" +
        "YOU SET US UP @I LIED\n" +
        "HEY CHRISTMAS TREE varfalse2\n" +
        "YOU SET US UP @I LIED\n" +
        "GET TO THE CHOPPER varfalse\n" +
        "HERE IS MY INVITATION @I LIED\n" +
        "YOU ARE NOT YOU YOU ARE ME varfalse2\n" +
        "ENOUGH TALK\n" +
        "TALK TO THE HAND varfalse\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("1\n")
  }
  it should "True Equals False evaluates False" in {
    val code =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE varfalse\n" +
        "YOU SET US UP @I LIED\n" +
        "HEY CHRISTMAS TREE result\n" +
        "YOU SET US UP @I LIED\n" +
        "GET TO THE CHOPPER result\n" +
        "HERE IS MY INVITATION @NO PROBLEMO\n" +
        "YOU ARE NOT YOU YOU ARE ME varfalse\n" +
        "ENOUGH TALK\n" +
        "TALK TO THE HAND result\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("0\n")
  }

    it should "True Equals True Equals True evaluates True" in {
    val code =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE result\n" +
        "YOU SET US UP @I LIED\n" +
        "GET TO THE CHOPPER result\n" +
        "HERE IS MY INVITATION @NO PROBLEMO\n" +
        "YOU ARE NOT YOU YOU ARE ME @NO PROBLEMO\n" +
        "YOU ARE NOT YOU YOU ARE ME @NO PROBLEMO\n" +
        "ENOUGH TALK\n" +
        "TALK TO THE HAND result\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("1\n")
  }

   it should "(13 Equals 13) equals True evaluates True" in {
    val code =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE result\n" +
        "YOU SET US UP @I LIED\n" +
        "GET TO THE CHOPPER result\n" +
        "HERE IS MY INVITATION 13\n" +
        "YOU ARE NOT YOU YOU ARE ME 13\n" +