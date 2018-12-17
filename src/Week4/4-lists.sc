// Welcome to Scala

// Lists

val li = List(1,2,3)

var ls = List("one","two","three")

// Notice the types of li & ls. List[A] is the type of lists with elements from A.

// Trying to assign a list with the wrong type of elements generates an error:

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//ls = List(1,2,3)

// Refer to elements of the list as a function of the index (based at 0)

li(2)

ls(0)

//If we want to specify the type of a list, we write it in *square* brackets

val lb : List[Boolean] = List(true,true,false,true)

// Imperative vs. Declarative programming

// Imperative: Tell the computer what to do

// Considered bad style in Scala.
// Requires mutable data types & modifies state.

var lm = scala.collection.mutable.MutableList(1,2,3,4,5)

var i = 0
while (i < lm.length) {
  println(lm(i)*lm(i))
  i = i + 1
}

// Declarative: Tell the computer what things are

val lss = List(1,2,3,4,5)

for(i <- lss) {   // Read "for i in lss ..."
  println(lss(i)*lss(i))
}


// If we want to collect the returned values into a list we

// There is lots of nice syntax for co


lss.map(square).map(plusOne)

// Using anonymous function notations

lss.map(x => x*x).map(_ + 1)

// Intermediate

