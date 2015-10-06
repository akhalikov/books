/**
 * Lesson from http://twitter.github.io/scala_school/
 *
 */

// One line function
def addOne(m: Int): Int = m + 1
val five = addOne(4)
println("five=" + five)

// Function without arguments
def four() = 2 + 2
println("four=" + four())

// Anonymous function saved into val
val addTwo = (x: Int) => x + 2
println("three=" + addTwo(1))

// Partial application (underscore can be thought as unnamed magical wildcard)
def adder(m: Int, n: Int) = m + n
val add2 = adder(2, _:Int)
println("add2=" + add2)
println(add2(3))

// Curried functions
def multiply(m: Int)(n: Int): Int = m * n
println("multiply(2)(3)=" + multiply(2)(3))

val timesTwo = multiply(2) _
println("curried multiply =" + timesTwo)

val curriedAdd = (adder _).curried
println("curried add=" + curriedAdd)

val addThree = curriedAdd(3)
println("addThree(4)=" + addThree(4))

// Variable length arguments
def capitalizeAll(args: String*) = {
  args.map { arg =>
    arg.capitalize
  }
}
println(capitalizeAll("hello", "scala"))