// Welcome to Scala

// In this lesson we will review the Scala syntax for control operators like if...then, and for loops. This is mainly a reference for you.

//==================================

// if/then/else

// In Scala, unlike many other languages, the if/then/else construction is a function, meaning that it returns a value by default. Consider the following method:

def abs(x : Int) = if (x>0) {
  x
} else {
  -x
}

abs(10)

abs(-10)

// Scala knows that whichever way the conditional evaluates, the overall statement will return a string. However:

def positive(x:Int) = if (x>0) {
  x
} else {
  "negative"
}

positive(5)

positive(-5)

// Even though positive and abs return exactly the same value, it has a different type. When an if statement mixes types, the return type will be the nearest common superclass of the two. Here "Any" means that String and Boolean have no common parent class. We'll see a better way to handle this sort of situation using "Either" types in the lesson on collections.

// Something similar happens if we leave off the else clause::

def positive2(x:Int) = if (x>0) {
  x
}


// Some other nice syntax includes:

// One-line definitions:

def abs2(x:Int) = if (x>0) x else -x

// Chained clauses

def stringSize(s:String) = if (s.length > 12) {
  "long"
} else if (12 > s.length && s.length > 5) {
  "medium"
} else {
  "short"
}

// If you find yourself writing a long string of if...else if...else if..., you can also try out the "match" operator (similar to a switch statement), which lets you perform different actions depending on characteristics of the input. The cases can use a variety of pattern matching approaches as demonstrated below:

def IEatAnything(x : Any):String = x match {

  // You can match against constant values
  case 0 => "zero"
  case "lion" => "tiger"

  // You can combine constants (or other patterns) using the or stroke:

  case 2 | 4 | 6 => "small even number"

  // You can match tuples. The second example uses string interpolation.
  case (a, b) => s"Two inputs: $a and $b"
  case (_, _, _) => s"Three inputs that I don't use"

  case i: Int => s"Some non-zero integer $i"
  case _: Boolean => "Unused boolean"
  case d: Double => s"Twice $d is ${2 * d}"

  // You can match lists and other collections (lessons 5 and 7)
  case List(0, _, _*) => "A list with 2 or more elements, starting with zero"
  case _: List[_] => "Some other type of list"

  // In most cases you should close a match statement with an underscore ("wildcard") case to catch any other cases. If you leave it out, you may get a runtime error

  case _ => "I don't know what that is."
}

IEatAnything(0)
IEatAnything(4)
IEatAnything(5)

// Notice that only one case triggers, even though either 0 or 4 could have triggered case i: Int

IEatAnything("lion")
IEatAnything("bear")

IEatAnything(true)
IEatAnything(12.3)

// To get rid of the MatchError, uncomment the default case in the match statement above

IEatAnything(5,"five")
IEatAnything(5,"five",'V')

IEatAnything(List(0,1,2,3))
IEatAnything(List(1,2,3))
IEatAnything(List("one","two","three"))




//======================================

// For "loops" are used to repeat some operation on a list of values or indices:

for (i <- 1 to 5) {
  println(i)
}

// We can put multiple ranges into the same for statement. Notice that "to" generates an inclusive range and "until" leaves off the last element:

for (i <- 1 until 4; j <- 1 to 10) {
  print((i,j))
  if (j == 10) println()
}

// We can also use one variable in the range of another:

for (i <- 1 to 5; j <- 1 to i) {
  print((i,j))
  if (i == j) println()
}

// Another useful feature is the ability to build conditions (called guards) into the for clause:

for (i <- 1 to 4; j <- 1 to 10; if (i + j) % 2 == 0) {
  print((i,j))
  if (j >= 9) println()
}

// If the condition in the for statement gets too long, you can put it in curly braces on multiple lines:

for {
  i <- 1 to 5
  j <- 1 to 5
  k <- 1 to 5
  if (i + j) % 2 == 0
  if (i + k) % 2 == 0
  if (j + k) % 2 == 0
} {
  println((i,j,k,i+j+k))
}

// Finally, we can turn the for statement into a function that outputs a Vector (see next lesson) by adding the "yield" keyword at the end of the for statement:

for (i <- 1 to 5) yield 5*i


