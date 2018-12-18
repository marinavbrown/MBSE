// Welcome to Scala

// In this lesson you will learn how about type constructors, which allow us to combine the basic types Int, String, ... in new ways.

// The easiest example is the Cartesian product, which allows us to combine two (or more) types into one. In Scala, the product type of A and B is written with parentheses: (A,B)

// One use for products is to return multiple values from a function (e.g., two factors of  an integer)

def factor(x : Int) : (Int,Int) = {
  for (i <- (2 to x)) {
    if (x % i == 0) return (i,x/i)
  }
  return (1,x)
}


val pair = factor(15)

// In fact, when we define multi-input functions, Scala regards the input as a Cartesian product, too.

// You can access the entries of a pair or tuple using the following syntax:

pair._1
pair._2

// Notice that the indices for pairs/tuples are based at 1 (rather than 0) unlike Lists and other Scala constructs.


// Dually, just like we can have functions that take no input, we can also have functions that give no output. In this case we use the "Unit" type to indicate that a function doesn't return a value.

// For example, the greeting we defined before returned a string, but we could have print to the console and not returned anything.

def greet(): Unit = {
  print("What's your name? ")
  val name = scala.io.StdIn.readLine()
  println()
  println("Nice to meet you, " + name + "!")
}

// If you don't list a return type for a function, Scala will assume that it has Unit type (and your IDE might insert it for you explicitly).

// =====================================


// Another important constructor is the function type A => B. This lets us represent methods as "first-class citizens" in our programs. This means, in particular, that we can take functions as arguments and return functions as values. Understanding how and why this works might take some time.

// Consider the following, noting that this is a val, not a def:

val isEven = (x : Int) => x % 2 == 0

// You should see that the type of this val is a *function* from Int to Boolean (here Boolean is inferred).

// We can still apply this val to an argument, though:

isEven(5)

isEven(6)

// We also have the option to give the function type explicitly. In this case we don't need to specify the type of the variable again.

val isOdd : Int => Boolean = x => x % 2 == 1

// There is also a useful underscore notation for defining functions.:

val divisibleByThree : Int => Boolean = _ % 3 == 0

// Later on we'll use this often for manipulating lists

// The main use for function types is to specify "callback functions". These let us use the same code to do many different things by changing the function that we apply in some step of the process.

def capitalizeByFilter(s : String, filter : Int => Boolean) : String = {
  var newString = "";
  for (index <- s.indices) {
    if (filter(index)) {
      newString += s(index).toUpper
    } else {
      newString += s(index)
    }
  }
  return newString
}

capitalizeByFilter("hello world",isOdd)


// We can use this to easily define lots of special-purpose methods using one general-purpose method that takes a functional argument:

def wonky(s : String) = capitalizeByFilter(s,isEven)

wonky("hello world")

// The underscore notation is also useful here.

val capitalizeFirst = capitalizeByFilter(_, _ == 0)

capitalizeFirst("hello world")





// !! Warning !! The definition of capitalizeByFilter written above is really *bad* Scala code. We'll see a better way to do this using "map" in the next lesson.


