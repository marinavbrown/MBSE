// Welcome to Scala

// This lesson will take place in a Scala worksheet. You can think of this like the transcript of a REPL session which we can edit and run as many times as we like. Press the play button above to run the worksheet (Note: you will get an error). You should get a split screen with the expressions on the left and their types and values on the right.


// Our goal in this lesson is to learn about methods in Scala. We define methods using the "def" keyword:

def square(x : Int) : Int = x*x

// We can then *apply* the method to an *argument*.

square(1)

square(2)

square(3)

// If we try to enter an argument of the wrong type, you will get a type mismatch error. Comment out the line below to proceed.

 square("four")

// Each method definition involves three parts
// (i) a name (square)
// (ii) *Typed* input variables (x : Int)
// (iii) an output type (Int)

// Scala will infer the type of the definition you give, and if it doesn't match the declaration, you get another "type mismatch" error:


// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
def square2(x : Int) : String = x*x

// In fact, because of type inference, we usually don't need to explicitly give the type of a method (but if we don't the compiler will sometimes get confused)

def square3(x : Int) = (x * x).toString

// Notice the declaration

//    square3: (x: Int)String

// to the right. This tells us that the compiler correctly inferred that the method returns a string output.

square3(5)

// ====================================================================

// We are free to include as many input variables as we like:

def max(x : Int, y : Int) = if (x > y) x else y


max(10,100)

// We can also assign default values so that some variables are optional.

def total(price : Double, tax: Double = 0) = (1 + .01*tax)*price

total(5.50)

total(5.50,10)

//=====================================

// We can also create methods that don't take any arguments at all. Usually (but not always) these involve some sort of modification to the computational state. Two examples we'll look at below are randomness and input/output. Other important examples include processes for manipulating files or data in a hard drive or database.

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



