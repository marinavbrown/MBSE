## Welcome to Scala

### Lesson 1 - REPL Expressions


This lesson will introduce you to the Scala language using the the Read-Eval-Print Loop (REPL).

You should already have Scala and Intellij installed; if not, go to the installation instructions [here](https://github.com/sjbreiner/MBSE/blob/master/src/WelcomeToScala/Installation.md).

Start by opening up a terminal. One way to do this is to use the IDE's integrated terminal by clicking the "Terminal" button at the bottom of the Intellij window.

Now type "scala" at the terminal prompt. You should get a greeting and a new prompt:

    scala>

---

An *expression* is a segment of computer code that can be *evaluated* (i.e., computed) to give a *return value*.

Try typing a simple expression like

    scala> 3+5

and hitting return.

You should get a response that looks like this:

    res0: Int = 8

The Scala compiler **R**eads your input from the prompt, **E**valuates the expression, **P**rints the return value and then **L**oops back to the prompt. Hence REPL.

Now try entering each of the following:

    scala> 3<5

    scala> "Hello world".length

    scala> res2 + 5

In the statement above "res2" refers to the result from the previous computation. We'll see more about this in the section on variables below.

---

The simplest expressions are called *literals* and are built into the programming language. Try entering each of these into the REPL:

    scala> 157

    scala> 157.35

    scala> "Hello World!"

    scala> true

Each expression has a *type*. Basic types include the integers (```Int```), (double-precision) floating point numbers (```Double```), strings (```String```) and Booleans (```Boolean```). The REPL gives you the type of an expression with its return value.

A *variable* is a name associated with an element of data, allowing us to refer to it in later computations. Try entering the following sequence of commands:

    scala> var a = 12

    scala> a / 3

    scala> a + 3

---

Scala has two kinds of variables: mutable and immutable. Mutable variables (indicated by the ```var``` keyword) can be reassigned to different values. Immutable variables (indicated by ```val```) cannot change after they are assigned.

    scala> a = 5

    scala> a + 3

You should get 8 for the last value, because Scala replaced the original value ```a=12``` with the new value ```a=5```.

Note that ```a``` was declared as a ```var```. Now try these:

    scala> val b = 12

    scala> b / 3

    scala>  b = 5

At this point, the compiler will throw an error ```reassignment to val``` telling us that this operation is not allowed. This might seem like an annoyance. The main advantage is that code using mutable data structures is harder to reason about.

Scala computes a type for every expression, but we can also assign types explicitly using a colon (```:```). We can use this, e.g., to turn an ```Int``` into a ```Double```:

    scala> var c : Int = 15

    scala> var d : Double = 15

However, if we try to assign a value to a variable that has the wrong type, the compiler will throw a ```type mismatch``` error:

    scala> c = "Fifteen"

You may have wondered about the names ```res0```, ```res1```, ... listed in some of the REPL's return values. In a REPL, every expression which isn't explicitly saved to a variable is assigned a brand-new variable of its own that lets us refer back to computations that we've already done. We already used this above when we evaluated the expression

    scala> res2 + 5

If you type that in again you should get the same answer, and both will refer to the ```Int``` value 11, which is the value of the expression ```"Hello World".length```.


---

#### Homework

The official API for the Scala language is available at scala-lang.org.

Below we have listed a variety of type-specific operations associated with types like ```Int``` and ```Boolean```.

Look through the following web-pages to identify the Scala syntax for all the operations, and try each one out in your REPL.

When you are done, copy the transcript of your session and save it as a text file ```YourLastName-Lesson1.txt```.

---

Scala API References

Integers - https://www.scala-lang.org/api/current/scala/Int.html

Math library - https://www.scala-lang.org/api/current/scala/math/index.html

Strings - https://www.scala-lang.org/api/current/scala/collection/immutable/StringOps.html

Booleans - https://www.scala-lang.org/api/current/scala/Boolean.html

---

##### Problem 1) Integer Operations

- equality
- inequality
- greater than
- greater than or equal to
- plus
- times
- minus
- integer division (e.g, 14 divided by 3 = 4)
- remainder (e.g., 14 remainder 3 = 2)
- floating-point division (e.g., 1 divided by 4 = 0.25)
- maximum
- minimum
- power/exponent
- square root

##### Problem 2) String Operations

String operations:
- equality
- inequality
- concatenation
- length
- character containment (e.g.- does "The quick brown fox" contain the character "a")
- capitalization
- initial segment (e.g.- what are the first 10 characters of "The quick brown fox")
- substring
- split a string into a list (e.g, split a sentence into a list of words using " " as a token
- string interpolation (do a google search for this)


##### Problem 3) Boolean Operations

Boolean operations
- equality
- and
- or
- Xor (exclusive or)
- ordering/implication