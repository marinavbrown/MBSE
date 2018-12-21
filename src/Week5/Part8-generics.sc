// Welcome to Scala

// In this lesson we will see how to use generic types to write simpler, more flexible code.

// Sometimes in functional programming the code that we write doesn't really depend on the types involved. A good example is the higher-order function "timed" that we saw in lesson 3 (slightly modified):

def timed(f : Int => Int) : Int => Int = {
  x: Int => {
    val t1 = System.nanoTime()
    val fVal = f(x)
    val t2 = System.nanoTime()
    println(s"Your program took ${t2 - t1} nanoseconds to run.")
    fVal
  }
}

// Here it doesn't matter at all that f is a function Int => Int; exactly the same code would work for something String => String, or String => Int, or anything else.

// A better approach is to provide the method with generic type arguments, indicated by square brackets:

def genericTimed[A,B](f : A => B) : A => B = {
  x: A => {
    val t1 = System.nanoTime()
    val fVal = f(x)
    val t2 = System.nanoTime()
    println(s"Your program took ${t2 - t1} nanoseconds to run.")
    fVal
  }
}

def squares(li : List[Int]) = li.map(x => x*x)

def concats(ls : List[String]) = ls.map(x => x + x)


def timedSquares = genericTimed(squares)

def timedConcats = genericTimed(concats)

timedSquares( (1 to 30).toList)

timedConcats( (1 to 30).toList.map(_.toString) )


//==================================

// We can also provide generic types in class definitions.

// This approach is used to define the collection types that we saw in lessons 5 and 7. E.g., this is what allows us to distinguish between List[Int] and List[String].

// To demonstrate, we can define a class of multi-sets that keep track of multiplicity but not of order:

