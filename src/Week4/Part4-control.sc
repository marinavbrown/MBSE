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

// Even though positive and abs return exactly the same value, it has a different type. When an if statement mixes types, the return type will be the nearest common superclass of the two. Here "Any" means that String and Boolean have no common parent class.

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

// If you find yourself writing a long string of if...else if...else if..., you can also try out the "match" operator, which lets you match an input against a variety of cases, which can be described by types and Boolean conditions. This is often called a switch statement in other languages:

def typeName(x : Any) = x match {
  case x : String => "string"
  case x : Float  => "float"
  case x : Double => "double"
  case x : Int    => "integer"
case _            => "I don't know"   // The underscore indicates a default case that will catch anything that hasn't already matched one of the other cases
}

typeName("Spencer")

typeName(5.0)

typeName(5)


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


