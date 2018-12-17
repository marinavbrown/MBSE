// Welcome to Scala

// Functions

// We define functions in Scala using the def keyword.

def square(x : Int) : Int = x*x

// We must provide
// (i) a name for the function
// (ii) Typed input variables for the function
// (iii) an output type for the function


// Scala will infer the type of the definition you give, and if it doesn't match the declaration, you get another "type mismatch" error:


// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//def square2(x : Int) : String = x*x


// In fact, because of type inference, we usually don't need to explicitly give the type of a function (but if we don't the compiler will sometimes get confused)

def square3(x : Int) = (x * x).toString()

// Notice the declaration "square3: (x: Int)String" to the right. This tells us that the compiler correctly inferred that the function returns a string output.


// We can include as many input variables as we like:

def max(x : Int, y : Int) = if (x > y) x else y


max(10,100)



// We can also create functions that don't take any arguments at all. Usually (but not always) these involve some sort of modification to the computational state including. Let's look at several examples:

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


def greet(): Unit = {
  print("What's your name? ")
  val name = scala.io.StdIn.readLine()
  println()
  println("Nice to meet you, " + name + "!")
}

greet()




//    Timing
//    Modifying mutable variables (Avoid this!)



