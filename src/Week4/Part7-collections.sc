// Welcome to Scala

// Lists are one example of a more general class of type constructors called collection types. Here we will introduce some of the more important examples built into the Scala language. This is mostly a reference for you.

// =====================================

// Sets

// In terms of collections, lists have the following properties:
// - Repetition is allowed
// - Order matters

// Sets are the opposite, unordered and deduplicated:

val s1 = Set(1,2,3)

val s2 = Set(2,1,3)

val s3 = Set(1,1,2,3)

s1 == s2

s1 == s3

// Most of the operators that we used for lists work for other collections too:

s1 + 4

s1.map(x => x*x)

s1.filter(_ > 1)

val setOfSets = Set(
  Set(1,2),
  Set(1,3,4),
  Set(4,5,6)
)

setOfSets.flatten

// You can also transform between different kinds of collections. We can use this, e.g., to deduplicate a list (but the order may not be preserved!):

val dupList = List(1,4,1,2,2,3,4)

dupList.toSet

dupList.toSet.toList


//====================================

// Maps

// Maps are collections that represent functions. Whereas List and Set each have one type variable Map has two, corresponding to the type of the input and the type of the output, respectively:

val myMap : Map[Int,String] = Map(
  1 -> "one",
  2 -> "two",
  3 -> "three",
  4 -> "four",
)

// The Ints on the left are called "keys" and the strings on the right are "values". You can apply a map to a key and it will return the value, just like a function.

myMap(1)

myMap(3)

// However, if you try to evaluate on a key that isn't contained in the map, you will get a runtime error (NoSuchElementException).

try {
  myMap(10)
} catch {
  case _ : Exception => "Got an error"
}

//If you convert a Map into a List or Set, you get a collection of key-value pairs.
// Conversely, if you want to convert a list into a map, the list values must have a product type or Scala will yell at you:


List((1,true),(2,true),(3,false)).toMap

//List(1,2,3).toMap

// To add a new key-value pair to a map:

myMap + (5 -> "five")

// However, keys cannot be duplicated, so adding a new key-value with an old key will replace the previous value:

myMap + (1 -> "not one")

// You can also remove a key-value pair by "subtracting" the key:

myMap - 2

//====================================

// Option and Either

// The Option type is very restrictive: an option collection either contains a single element or nothing. This is good for situations where some operation might fail, and goes well with the try...catch construction

// There are two ways to construct an Option:
// - For any type A, we have None:Option[A]
// - If a:A, then Some(a):Option[A]


def getListElt(ls : List[String],index : Int) : Option[String] = {
  try {
    val elt = ls(index)
    return Some(elt)
  } catch {
    case _ : Exception => None
  }
}

val ls = List("one","two","three","four")

val os1 = getListElt(ls,2)

val os2 = getListElt(ls,15)

// We can also use this for if statements without an else clause:

def positive(x : Int) : Option[Int] = {
  if (x > 0) Some(x)
  else None
}

positive(5)

positive(-5)

// To use an Option argument, break it up with a match statement:

def printOption(os : Option[String]) = os match {
  case Some(s) => s
  case None => "You didn't give me a string"
}

printOption(os1)

printOption(os2)

// Similarly, the type Either[A,B] consists of elements from either A or B. This also has two constructors: Right(a) and Left(b)

// Either types are useful for if...else statements that return different types

def either(x : Int) : Either[Int,String] = {
  if (x > 0) Left(x)
  else Right("negative")
}

// We can break up Either types using matches, just like above

def handleEither(intOrString : Either[Int,String]) : String = intOrString match {
  case Left(x) => s"You gave me an integer $x"
  case Right(s) => s"You gave me a string $s"
}

handleEither(either(15))

handleEither(either(-5))

