
package org.arnoldc

import org.parboiled.scala._
import org.parboiled.errors.{ErrorUtils, ParsingException}
import org.arnoldc.ast._

class ArnoldParser extends Parser {


  val ParseError = "WHAT THE FUCK DID I DO WRONG"

  val DeclareInt = "HEY CHRISTMAS TREE"
  val SetInitialValue = "YOU SET US UP"
  val BeginMain = "IT'S SHOWTIME"
  val PlusOperator = "GET UP"
  val MinusOperator = "GET DOWN"
  val MultiplicationOperator = "YOU'RE FIRED"
  val DivisionOperator = "HE HAD TO SPLIT"
  val EndMain = "YOU HAVE BEEN TERMINATED"
  val Print = "TALK TO THE HAND"
  val Read = "I WANT TO ASK YOU A BUNCH OF QUESTIONS AND I WANT TO HAVE THEM ANSWERED IMMEDIATELY"
  val AssignVariable = "GET TO THE CHOPPER"
  val SetValue = "HERE IS MY INVITATION"
  val EndAssignVariable = "ENOUGH TALK"
  val False = "I LIED"
  val True = "NO PROBLEMO"
  val EqualTo = "YOU ARE NOT YOU YOU ARE ME"
  val GreaterThan = "LET OFF SOME STEAM BENNET"
  val Or = "CONSIDER THAT A DIVORCE"
  val And = "KNOCK KNOCK"
  val If = "BECAUSE I'M GOING TO SAY PLEASE"
  val Else = "BULLSHIT"
  val EndIf = "YOU HAVE NO RESPECT FOR LOGIC"
  val While = "STICK AROUND"
  val EndWhile = "CHILL"
  val DeclareMethod = "LISTEN TO ME VERY CAREFULLY"
  val MethodArguments = "I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE"
  val Return = "I'LL BE BACK"
  val EndMethodDeclaration = "HASTA LA VISTA, BABY"
  val CallMethod = "DO IT NOW"
  val NonVoidMethod = "GIVE THESE PEOPLE AIR"
  val AssignVariableFromMethodCall = "GET YOUR ASS TO MARS"
  val Modulo = "I LET HIM GO"

  val EOL = zeroOrMore("\t" | "\r" | " ") ~ "\n" ~ zeroOrMore("\t" | "\r" | " " | "\n")
  val WhiteSpace = oneOrMore(" " | "\t")

  def Root: Rule1[RootNode] = rule {