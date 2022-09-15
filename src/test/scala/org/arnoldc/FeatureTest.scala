
package org.arnoldc

class FeatureTest extends ArnoldGeneratorTest {

  it should "print fibonacci numbers from 1 to 10" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE prev\n" +
      "YOU SET US UP -1\n" +
      "HEY CHRISTMAS TREE result\n" +
      "YOU SET US UP 1\n" +
      "HEY CHRISTMAS TREE sum\n" +
      "YOU SET US UP 0\n" +
      "HEY CHRISTMAS TREE loop\n" +
      "YOU SET US UP @NO PROBLEMO\n" +
      "HEY CHRISTMAS TREE index\n" +
      "YOU SET US UP 0\n" +
      "HEY CHRISTMAS TREE limit\n" +
      "YOU SET US UP 10\n" +
      "\nSTICK AROUND loop\n" +
      "\tGET TO THE CHOPPER sum\n" +
      "\tHERE IS MY INVITATION result\n" +
      "\tGET UP prev\n" +
      "\tENOUGH TALK\n" +
      "\n\tGET TO THE CHOPPER prev\n" +
      "\tHERE IS MY INVITATION result\n" +
      "\tENOUGH TALK\n\t" +
      "\n\tGET TO THE CHOPPER result\n" +
      "\tHERE IS MY INVITATION sum\n" +
      "\tENOUGH TALK\n\t" +
      "\n\tGET TO THE CHOPPER index\n" +
      "\tHERE IS MY INVITATION index\n" +
      "\tGET UP 1\n" +
      "\tENOUGH TALK\n\t" +
      "\n\tGET TO THE CHOPPER loop\n" +
      "\tHERE IS MY INVITATION limit\n" +
      "\tLET OFF SOME STEAM BENNET index\n" +
      "\tENOUGH TALK\n\t" +
      "\n\tTALK TO THE HAND sum\n" +
      "CHILL\n" +
      "\nYOU HAVE BEEN TERMINATED"

    getOutput(code) should equal("0\n1\n1\n2\n3\n5\n8\n13\n21\n34\n")
  }


  it should "print fibonacci when using recursion" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE result\n" +
      "YOU SET US UP 0\n" +
      "GET YOUR ASS TO MARS result\n" +
      "DO IT NOW fib 9\n" +
      "TALK TO THE HAND result\n" +
      "YOU HAVE BEEN TERMINATED\n" +
      "\nLISTEN TO ME VERY CAREFULLY fib\n" +
      "I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE val\n" +
      "GIVE THESE PEOPLE AIR\n" +
      "\tHEY CHRISTMAS TREE endrecursion\n" +
      "\tYOU SET US UP @I LIED\n" +
      "\tGET TO THE CHOPPER endrecursion\n" +
      "\tHERE IS MY INVITATION 2\n" +
      "\tLET OFF SOME STEAM BENNET val\n" +
      "\tENOUGH TALK\n\n" +
      "\tBECAUSE I'M GOING TO SAY PLEASE endrecursion\n" +
      "\t\tI'LL BE BACK val\t\n" +
      "\tBULLSHIT\n" +
      "\t\tHEY CHRISTMAS TREE temp1\n" +
      "\t\tYOU SET US UP 0\n" +
      "\t\tHEY CHRISTMAS TREE temp2\n" +
      "\t\tYOU SET US UP 0\n\n" +
      "\t\tGET TO THE CHOPPER val\n" +
      "\t\tHERE IS MY INVITATION val\n" +
      "\t\tGET DOWN 1\n" +
      "\t\tENOUGH TALK\n" +
      "\t\tGET YOUR ASS TO MARS temp1\n" +
      "\t\tDO IT NOW fib val\n" +
      "\t\tGET TO THE CHOPPER val\n" +
      "\t\tHERE IS MY INVITATION val\n" +
      "\t\tGET DOWN 1\n" +
      "\t\tENOUGH TALK\n" +
      "\t\tGET YOUR ASS TO MARS temp2\n" +
      "\t\tDO IT NOW fib val\n" +
      "\t\tGET TO THE CHOPPER val\n" +