// Welcome to Scala - Lesson 2 - Methods

// This lesson will take place in a Scala worksheet, so you will need to open this file in the Intellij IDE.

// You can think of a worksheet as the transcript of a REPL session which we can edit and run as many times as we like. Press the play button above to run the worksheet (Note: you will get an error). You should get a split screen with the expressions on the left and their types and values on the right.

// Our goal in this lesson is to learn about defining methods in Scala. Method definitions in Scala look like this:

def squareLength(s: String): Int = s.length * s.length

// This involves four pieces of information
// (i) the method name
// (ii) *Typed* input variable(s)
// (iii) A return type
// (iv) An expression involving the input variables which has the return type

// We can then *apply* the method to an *argument*, to get a new element of the return type:

val squareLengthOfOne: Int= squareLength("one")

squareLength("hello")


// However, if we try to enter an argument of the wrong type, we get a type mismatch error.

// Notice that the input 3 is underlined in red, indicating the source of the error. If you hover your mouse over the input, you should get a pop-up message:

// "Type mismatch, expected: String, actual: Int"

// Comment out the line below, or change the input to a string in order to proceed.

//squareLength(3)

// Scala can use *type inference* to figure out the return type of a method just by looking at the expression you give, so most of the time you don't need to provide that information explicitly:

def square(x : Int) = x*x

//=============================

// We are free to include as many input variables for a method as we like:

def max(x : Int, y : Int) = if (x > y) x else y


max(10,100)

// We can also assign default values so that some variables are optional.

def total(price : Double, tax: Double = 0) = (1 + .01*tax)*price

val priceInTX = total(5.50)

val priceInNY = total(5.50,10)

// Scala also has a syntax for methods which accept variable numbers of arguments, which are provided as a list (lesson 5). Note that you can only use this trick once, at the end of the variable list:

def avg(numbers : Double*) = {
  if (numbers.length == 0) 0.0
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

def diceRoll(): Int = {
  // A random number (Double) between 0 and 6
  val randomNumber = 6 * Math.random()

  //

  return 1 + randomNumber.toInt
}

diceRoll()

diceRoll()

diceRoll()

// Notice that the three calls to diceRoll() gave different answers (probably). If you kill your session (the trashcan next to the play button) and run it again, you should get all new answers.


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

// For more iterative interaction we can use a while loop. This is actually how the REPL works under the hood.

def guessMyNumber() : Int = {

  val randomInt : Int = 1 + (100 * Math.random()).toInt

  var guess : Int = 0

  println("Guess a number between 1 and 100.")

  while (guess != randomInt) {
    var guessString = scala.io.StdIn.readLine()
    try {
      guess = guessString.toInt
      guess match {
        case x if x < 1 => println(s"$guess is less than 1. Try again.")
        case x if x > 100 => println(s"$guess is more than 100. Try again.")
        case x if x > randomInt => println(s"Your guess $guess was too high. Try again.")
        case x if x < randomInt => println(s"Your guess $guess was too low. Try again.")
        case x if x == randomInt => println(s"You got it! My secret number was $randomInt.")
      }
    } catch {
      case error : java.lang.NumberFormatException => println(s"I didn't understand your guess $guessString. Try again.")
    }
  }
  return randomInt
}


//================================

// Homework

// Create a new Scala worksheet to store the answers to the following problems. Name the worksheet

//      YourLastName-Lesson2.sc

// Problem 1)

// Declare four methods with the following input/output types. Explain what each method does (in a comment), and demonstrate its usage by evaluating it on three different arguments.

// For the first two methods use an explicit return type; for the last two, leave the return type implicit.

//    Input             Output
// 1  Int               Int
// 2  Int               String
// 3  Int and String    String
// 4  Int and String    Boolean

// Problem 2)

// Implement a method

// randomCard() : String

// which randomly chooses a card from a standard deck and returns a string name for that card (e.g., "Ace of Hearts", "Nine of Diamonds", etc.)

// Evaluate the method at least 3 times to see it in action and verify the random output.

// Problem 3)
//
// Implement a method

// randomLetter(input : String) : Char

// which takes a a string argument and returns a random letter (of type Char) from the given string.

// Evaluate the method at least 3 times to see it in action and verify the random output.

// Problem 4)

// Implement a method

// getRandomLetter() : Char

// which takes a string input from the user and returns a random character from the user's string. For full credit, call the method randomLetter from problem 3 rather than rewriting that part of your code.


// a method with IO
