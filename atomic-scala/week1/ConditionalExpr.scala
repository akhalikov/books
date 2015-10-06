val x:Boolean = {1 > 0}
if (x)
  println("It's true")

val a = 1
val b = 5
if (a < b) {
  println("a is less than b")
} else {
  println("a is not less than b")  
}

if (a > 2) {
  println("a is greater than 2")  
} else {
  println("a is less than 2")  
}

val c = 5
if (a <= c && b <= c) {
  println("both a and b are less than or equal than c")  
} else if (a <= c) {
  println("only a is less than or equal than c")
} else if (b <= c) {
  println("only b is less than or equal than c")
}