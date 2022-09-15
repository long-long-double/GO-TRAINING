
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