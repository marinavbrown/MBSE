// Welcome to Scala

// This lesson will take place in a Scala worksheet. You can think of this like the transcript of a REPL session which we can edit and run as many times as we like. Press the play button above to run the worksheet (Note: you will get an error). You should get a split screen with the expressions on the left and their types and values on the right.


// Our goal in this lesson is to learn about methods in Scala. Method definitions in Scala look like this:

def squareLength(s: String): Int = s.length * s.length

// This involves four pieces of information
// (i) the method name
// (ii) *Typed* input variable(s)
// (iii) A return type
// (iv) An expression involving the input variables which has the return type

// We can then *apply* the method to an *argument*, to get a new element of the return type:

val sqlen: Int= squareLength("one")

squareLength("hello")


// However, if we try to enter an argument of the wrong type, we get a type mismatch error. Comment out the line below to proceed.

//squareLength(3)


// Scala can use *type inference* to figure out the return type of a method just by looking at the expression you give, so most of the time you don't need to provide that information:

def square(x : Int) = x*x

// ====================================================================

// We are free to include as many input variables as we like:

def max(x : Int, y : Int) = if (x > y) x else y


max(10,100)

// We can also assign default values so that some variables are optional.

def total(price : Double, tax: Double = 0) = (1 + .01*tax)*price

val priceInTX = total(5.50)

val priceInNY = total(5.50,10)

// Scala also has a syntax for methods which accept variable numbers of arguments, which are provided as a list (lesson 5). Note that you can only use this trick once, at the end of the variable list:

def avg(numbers : Double*) = {
  if (numbers.length == 0) 0
  else numbers.sum/numbers.length
}

avg(1,2,3)

avg(1,3,5,7,9,11,13)




//=====================================

// We can also create methods that don't take any arguments at all. Usually (but not always) these involve some sort of modification to the computational state. Three examples we'll look at below are timing, randomness and input/output. Other important examples include processes for manipulating files or data in a hard drive or database.

// Timing

// Obviously we can't store the current time because it's always changing. That means that we need a method to access that information, and we can get it without providing any inputs:

import java.util.Calendar

def currentTime() : String = {
  val now = Calendar.getInstance().getTime()
  return s"The current time is $now."
}

currentTime()

currentTime()

//============================

//    Randomness

def randomCard(): String = {
  val suit = Map(
    0 -> "Hearts",
    1 -> "Spades",
    2 -> "Diamonds",
    3 -> "Clubs"
  )

  val face = Map(
    0 -> "King",
    1 -> "Ace",
    2 -> "Two",
    3 -> "Three",
    4 -> "Four",
    5 -> "Five",
    6 -> "Six",
    7 -> "Seven",
    8 -> "Eight",
    9 -> "Nine",
    10 -> "Ten",
    11 -> "Jack",
    12 -> "Queen"
  )

  val cardNumber : Int = (52 * Math.random()).toInt

  return face(cardNumber % 13) + " of " + suit(cardNumber / 13)

}


randomCard()

randomCard()

randomCard()

// Notice that the three calls to randomCard() gave three different values. If you kill your session (the trashcan next to the play button) and run it again, you should get all new answers.


//    Input/Output


def greet(): String = {
  print("What's your name? ")
  val name = scala.io.StdIn.readLine()
  println()
  return "Nice to meet you, " + name + "!"
}

// Unfortunately, we can't do IO inside a worksheet. Instead, open up your terminal and paste in the definition given above.

// Then try entering

//  scala> greet()

// The program will wait until you enter a string (Note: your typing may not show up in the console), and then return a string built from your input.



