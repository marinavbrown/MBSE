// Welcome to Scala

// In this lesson you will learn about type constructors, which allow us to combine the basic types Int, String, etc. in new ways.

//===========================

// Cartesian Product

// The easiest example is the Cartesian product, which allows us to combine two (or more) types into one. In Scala, the product type of A and B is written with parentheses: (A,B)



type IntStringProduct = (Int,String)

// One use for products is to return multiple values from a function (e.g., two factors of  an integer)

def factor(x : Int) : (Int,Int) = {
  for (i <- 2 to x) {
    if (x % i == 0) return (i,x/i)
  }
  (1,x)
}


val pair = factor(15)

// In fact, when we define multi-input functions, Scala regards the input as a Cartesian product, too.

// You can access the entries of a pair or tuple using the following syntax:

pair._1
pair._2

// Notice that the indices for pairs/tuples are based at 1 (rather than 0) unlike Lists and other Scala constructs.

//=======================

// Dually, just like we can have functions that take no input, we can also have functions that give no output. In this case we use the "Unit" type to indicate that a function doesn't return a value.

// For example, the greeting we defined before returned a string, but we could have printed directly to the console and not returned anything.

def greet(): Unit = {
  print("What's your name? ")
  val name = scala.io.StdIn.readLine()
  println()
  println("Nice to meet you, " + name + "!")
}

// If you don't list a return type for a function, Scala will assume that it has Unit type (and your IDE might insert it for you explicitly).

// =====================================

// Function types

// Another important constructor is the function type A => B. This lets us represent methods as "first-class citizens" in our programs. This means, in particular, that we can take functions as arguments and return functions as values. Understanding how and why this works might take some time.

// Consider the following, noting that this is a val, not a def:

val isEven = (x : Int) => x % 2 == 0

// You should see that the type of this val is a *function* from Int to Boolean (here Boolean is inferred).

// We can still apply this val to an argument, though:

isEven(5)

isEven(6)

// We also have the option to give the function type explicitly. If we do this we don't need to specify the type of the variable again.

val isOdd : Int => Boolean = x => x % 2 == 1

// There is also a useful underscore notation for defining functions.:

val divisibleByThree : Int => Boolean = _ % 3 == 0

// Later on we'll use this often for manipulating lists.

// The main use for function types is to specify "callback functions". These let us use the same code to do many different things by changing the function that we apply in some step of the process.

def capitalizeByFilter(s : String, filter : Int => Boolean) : String = {
  var newString = ""
  for (index <- s.indices) {
    if (filter(index)) {
      newString += s(index).toUpper
    } else {
      newString += s(index)
    }
  }
  newString
}

capitalizeByFilter("hello world",isOdd)


// We can use this to easily define lots of special-purpose methods using one general-purpose method that takes a functional argument:

def wonky(s : String) = capitalizeByFilter(s,isEven)

wonky("hello world")

// The underscore notation is also useful here.

val capitalizeFirst = capitalizeByFilter(_, _ == 0)

capitalizeFirst("hello world")

// !! Warning !! The definition of capitalizeByFilter written above is really *bad* Scala code. We'll see a better way to do this using "map" in the next lesson.


// Higher-order functions

// Another use for the function type is to define higher-order functions, which takes a function as an argument, modifies it in some way, and returns the modified function.

// For example, the following function wraps a timer around a function to see how long it takes

def timed(f : Int => Int) : Int => Int = {
  x: Int => {
    val t1 = System.currentTimeMillis()
    val fVal = f(x)
    val t2 = System.currentTimeMillis()
    println(s"On input $x your program took ${t2 - t1} milliseconds to run.")
    fVal
  }
}

def waitToSquare(x : Int): Int = {
  Thread.sleep(5*x)
  x*x
}



timed(waitToSquare)(2)
timed(waitToSquare)(10)
timed(waitToSquare)(100)

//=================

// Homework

// Create a new Scala worksheet to store the answers to the following problems. Name the worksheet

//      YourLastName-Lesson3.sc



//=============================

// Problem 1) Implement a method parseName which takes a string argument (assumed to be someone's full name) and breaks it into three parts--first name, middle name(s) and last name--returned as a Cartesian product. For example we should get the following behavior:

// parseName("Spencer Joseph Breiner")
// ("Spencer","Joseph","Breiner")

// If fewer than three names are provided return empty strings for middle and (possibly) first name. If more than three names are provided, put any extras into the middle string:

// parseName("Spencer Breiner")
// ("Spencer","","Breiner")

// parseName("Breiner")
// ("","","Breiner")

// parseName("Spencer St. Cloud von Berthold Breiner")
// ("Spencer","St. Cloud von Berthold","Breiner")


// Bonus Point
// + Strip all non-letter characters (except possibly spaces in middle names) from all output strings.
// + Fix the capitalization of all names (including multiple middle names) so that the first letter is capitalized and the rest are not.

// parseName("speNCer St. Cloud von Berthold Breiner")
// ("Spencer","St Cloud Von Berthold","Breiner")

//==================

// Problem 2)

// Using your solution to problem 1, write a method buildFormLetter with the following signature:

// def buildFormLetter(name:String,income:Int):String

// Your method will:
// Check whether income is at least 100000
// If so, return the string
"Hello _______, I'm pleased to inform you ..."
// Otherwise, return the string
"Dear Mr./Ms. ______, I am sorry to inform you ..."

// For the first case, replace the blank with the first name parsed from the input string; in the second case, use the last name.

//=====================

// Problem 3)

// In Lesson 2, Problem 1 you implemented four methods using the def keyword.

// Reimplement those methods using the val keyword and function types. For methods 1 and 3, explicitly provide the type of the function (as in the definition of isOdd); for methods 2 and 4, leave the function type implicit (as in the definition of isEven)

//======================

// Problem 4)

// Implement a higher-order function with the following signature:

// def randomly(f : Int => Int, g : Int => Int) : Int => Int

// So randomly(f,g) is a function. When we evaluate this function on an input x, it should randomly return either f(x) or g(x).

// For example, we might get the following behavior:

// val h = randomly(x => x + x, x => x * x)
// h(3) = 9
// h(3) = 9
// h(3) = 6
// h(4) = 16
// h(4) = 8
// h(4) = 8

// Of course, if we run the program again we will likely get a different sequence of answers.

// Bonus Point

// Reimplement randomly so that it can take an arbitrary number of functions as arguments


