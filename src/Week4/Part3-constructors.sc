// Welcome to Scala

// Type constructors

// We just saw how to create a function with multiple inputs.

// How do we create a function with multiple outputs?

// Answer: Cartesian product
// Two outputs a:A and b:B are the same as a single output pair:A x B

// In Scala, the product type is denoted (A,B), and an expression is written (a,b).

// Example: factor will take an integer and return a pair of integers which are factors.

def factor(x : Int) : (Int,Int) = {
  for (i <- (2 to x)) {
    if (x % i == 0) return (i,x/i)
  }
  return (1,x)
}


factor(15)



