Welcome to Scala

This lesson will introduce you to the Scala language using the REPL: the Read-Eval-Print Loop.

Start by opening up a terminal. One way to do this is to click the "Terminal" button at the bottom of the Intellij IDE.

Type "scala" at the terminal prompt. You should get 

// An *expression* is a segment of
// computer code that can be
// *evaluated* (i.e., computed) to
// yield a *return value*.
//
// To evaluate the code in a Scala
// worksheet like this one, click
// the Play button above.

3+5

3<5

"Hello world".length

res2 + 5

// The simplest terms are called *literals* and are built into the programming language:

157

157.35

"Hello World!"

true

// Each expression has a *type*. Basic types include the integers (Int), (double-precision) floating point numbers (Double), strings (String) and Booleans (Boolean)

// A *variable* is a name associated with an element of data, allowing us to refer to it in later computations.

var a = 12

a / 3

a + 3

// Scala has two kinds of variables: mutable and immutable. Mutable variables (indicated by the var keyword) can be reassigned to different values. Immutable variables cannot change after they are assigned.

a = 5

a + 3

val b = 12

b / 3

 b = 5

// At this point, the compiler will throw an error "reassignment to val" telling us that this operation is not allowed. Comment out the line "b = 5" above to proceed.


// We can assign a type to a variable using a colon. If we try to assign a value that is not of that type, the compiler will throw an error "type mismatch"

// Notice that the editor highlights programming errors with red underlining

var c : Int = 15

 c = "Hello World"


// You can find the official API for Scala at scala-lang.org.

// Look through the following webpages to find the Scala syntax for the various typed operations

// Integers
// https://www.scala-lang.org/api/current/scala/Int.html

// Math library
// https://www.scala-lang.org/api/current/scala/math/index.html

// Give examples of equality, inequality, greater than, greater than or equal to, plus, times, minus, integer division, remainder, maximum, minimum, power/exponent, square root.
// Feel free to combine several into a single statement.

// Note: You can convert from integers to doubles by adding a "d" at the end of a number, or just write it as a decimal

32d

17.0

// Use this to get the exact floating point value for 1/4=0.25




// Strings
// https://www.scala-lang.org/api/current/scala/collection/immutable/StringOps.html

// Give examples of string equality, inequality, concatenation, length, character containment, capitalization, initial segment, substring


// Booleans
// https://www.scala-lang.org/api/current/scala/Boolean.html

// Give examples of boolean equality, and, or