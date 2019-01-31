// Welcome to Scala

// Classes and related ideas from *object oriented programming* allow us to create new types. This lesson will walk through some of the most important Scala syntax related to classes. For this lesson we will work in a *.scala file rather than a worksheet, and we'll also see how to use Scala from the command line.



// Classes contain data elements (called attributes) and methods that operate on them.

class Counter {
  var count: Int = 0

  def announce(): Unit = println(s"The current count is $count")

  def increment(): Unit = {
    count += 1
    println(s"The count has increased to $count")
  }

  def reset(): Unit = {
    println("Counter reset")
    count = 0
  }
}

// To use the class, open up a terminal, navigate to the directory containing this file and open the REPL.

// In the REPL, type the following
//  scala> :load Lesson6-classes.scala

// You should get a message saying, among other things, "defined class Counter"

// Now try out the following sequence of commands:
// scala> val c = new Counter   | c: Counter = Counter@XXXXXX
// scala> c.announce            | The current count is 0
// scala> c.increment           | The count has increased to 1
// scala> c.announce            | The current count is 1
// scala> c.reset               | Counter reset
// scala> c.announce            | The current count is 0
// scala> val cc = new Counter  | cc: Counter = Counter@XXXXXX
// scala> c == cc               | false

// The last two lines show that equality in the new class is calculated by reference (i.e., c and cc refer to different memory locations) rather than by internal values (both c and cc have the same internal count value).

// ===========================================================

// A class declaration can also take arguments, corresponding to information that must be provided to the class constructor (i.e., new XXXXX). By default the parameters are immutable and inaccessible from outside the class (private), but you can make them visible (public) by putting val in front (resp. visible and mutable by putting var in front):

class AlertCounter(var alertLevel : Int) {

  var count: Int = 0

  def announce(): Unit = println(s"The current count is $count")

  def reset(): Unit = {
    println("Counter reset")
    count = 0
  }

  def setAlert(n : Int): Unit = {
    if (n > 0) {
      alertLevel = n
      println(s"Alert level set to $alertLevel")
    }
  }

  def increment(): Unit = {
    if (count >= alertLevel) println("We're all going to die!")
    else println(s"The current count is $count")

    count += 1
  }
}


// Try out these commands in the REPL
// scala> val ac = new AlertCounter   | ac: AlertCounter = AlertCounter@XXXXXX
// scala> ac.announce                 | The current count is 0
// scala> ac.setAlert(2)              | Alert level set to 2
// scala> ac.increment                | The count has increased to 1
// scala> ac.increment                | We're all going to die!
// scala> ac.announce                 | The current count is 2

// There was a lot of duplicate code between our two counters. A better way to handle this situation is through subclassing, using the "extends" keyword. This makes all the code in the superclass (here Counter) available inside the subclass, but we can also override superclass methods if they need modification.

class AlertCounter2(var alertLevel : Int) extends Counter {

  def setAlert(n : Int): Unit = {
    if (n > 0) {
      alertLevel = n
      println(s"Alert level set to $alertLevel")
    }
  }

  override def increment(): Unit = {
    if (count >= alertLevel) println("We're all going to die!")
    else println(s"The current count is $count")

    count += 1
  }
}

//============================================================================


// We often use classes to package together some specific (typed) pieces of information. Scala provides a nice syntax for this usage called a "case class":

case class Book(title: String, author: String, year: Int)

// Try these out in the REPL:
// scala> val b = Book("Frankenstein","Mary Shelley",1818)
// scala> b.title
// scala> b.author
// scala> b.year

// scala> val bb = Book("Frankenstein","Mary Shelley",1818)
// scala> b == bb

// Some things to note:
// - We don't need the "new" keyword to construct a case class element
// - Parameters are accessible as public vals
// - Equality is computed by parameter values rather than by reference

// One of the main reason to use case classes is that they interact very nicely with pattern matching:

def respondToBook(b : Book) : String = b match {
  case Book("Frankenstein","Mary Shelley",y) => "I loved that book"
  case Book(bb,"Mary Shelley",_) => s"I loved Frankenstein. Maybe I should read $bb"
  case Book(_,_,y) => if (y < 1800) "I don't like old books" else "That might be OK"
}

// In the REPL:
// scala> respondToBook(b)
// scala> respondToBook(Book("The Last Man", "Mary Shelley", 1826))
// scala> respondToBook(Book("Dracula", "Bram Stoker", 1897))
// scala> respondToBook(Book("Candide", "Voltaire", 1759))