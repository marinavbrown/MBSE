// Welcome to Scala

// Lists are one example of a more general class of type constructors called collection types. Here we will introduce some of the more important examples built into the Scala language. This is mostly a reference for you.

// =====================================

// Sets

// In terms of collections, lists have the following properties:
// - Repetition is allowed
// - Order matters

// Sets are the opposite: unordered and deduplicated:

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

// Maps are collections that represent functions. Whereas List and Set each have one type variable, Map has two:

val myMap : Map[Int,String] = Map(
  1 -> "one",
  2 -> "two",
  3 -> "three",
  4 -> "four",
)

// You can apply a map just like a function

myMap(1)

// The Ints on the left are called "keys" and the strings on the right are "values".
//map.toList



//If you convert a Map into a List or Set, you get a collection of key-value pairs.
// Conversely, if you want to convert a list into a map, the list values must have a product type or Scala will yell at you:


//List(1,2,3).toMap

List((1,true),(2,true),(3,false)).toMap

// You can apply a map just like a function.















// Vectors are similar to lists (ordered, multiplicity), but they are implemented differently, leading to different run-times.

// Lists are better for:
// - Adding a new first element (the head)
// - Sequential access/operations
// - Recursive algorithms using a head/tail decomposition.

// Vectors are better for:
// - Accessing/updating random elements
// - Splitting and recombining (e.g., parallelized algorithms)

// Let's test some of these out using methods written for generic sequences:

// The first method will create a sequence of lists/vectors, then modify the first element of each one to see how long that takes:

def testHeadUpdate(): Unit = {

  var listSeq: Seq[List[Int]] = for (i <- 1 to 1000) yield List(1,2,3)

  val t1: Long = System.nanoTime()
  val newListSeq = listSeq.map(
    innerList => 0 :: innerList
  )
  val t2: Long = System.nanoTime()
  println(s"testHeadUpdate took ${t2 - t1} seconds to modify the sequence of lists.")

  var vectSeq: Seq[Vector[Int]] = for (i <- 1 to 1000) yield Vector(1,2,3)
  val t3: Long = System.nanoTime()
  val newVectSeq = vectSeq.map(
    innerVect => 0 +: innerVect
  )
  val t4: Long = System.nanoTime()
  println(s"testHeadUpdate took ${t4 - t3} seconds to modify the sequence of vectors.")

  println(s"The vector sequence took ${(t4-t3).toDouble/(t2-t1)} times as long as the list sequence.")

}

testHeadUpdate()

def testRandomAccess(): Unit = {

  val testIndices = for (i <- 1 to 100) yield (Math.random()*1000).toInt

  println(testIndices.slice(0,10))

  var l: List[Int] = (1 to 1000).toList
  var v : Vector[Int] = (1 to 1000).toVector


  val t1: Long = System.nanoTime()
  val newListSeq = for (i <- testIndices) yield l(i)
  val t2: Long = System.nanoTime()

  val t3: Long = System.nanoTime()
  val newVectSeq = for (i <- testIndices) yield v(i)
  val t4: Long = System.nanoTime()

  println(s"testRandomAccess took ${t2 - t1} seconds to access 100 random elements in the list.")
  println(s"testRandomAccess took ${t4 - t3} seconds to access 100 random elements in the vector.")
  println(s"The list operations took ${(t2-t1).toFloat/(t4 - t3)} times as long as the vector operation")

}


testRandomAccess()

def testSequentialUpdate() = {
  val testList = (1 to 1000).toList
  val testVect = (1 to 1000).toVector


  val t1: Long = System.nanoTime()
  val newListSeq = testList.map(_ + 1)
  val t2: Long = System.nanoTime()

  val t3: Long = System.nanoTime()
  val newVectSeq = testVect.map(_ + 1)
  val t4: Long = System.nanoTime()

  println(s"testSequentialUpdate took ${t2 - t1} seconds to modify all elements in the list.")
  println(s"testSequentialUpdate took ${t4 - t3} seconds to modify all elements in the vector.")
  println(s"The list operations took ${(t2-t1).toFloat/(t4 - t3)} times as long as the vector operation")

}


testSequentialUpdate()


// As collections, Lists are distinguished by the fact that (i) they are ordered and (ii) they allow the same entry multiple times.

// In contrast, Sets are unordered and each element appears only once. Although they may display differently in the response (e.g., elements ordered differently), Scala regards the following sets as equal.

val s = Set(1,2,3)

val ss = Set(1,3,1,2,2)

s == ss



