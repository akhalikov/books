def show(n:Int):Unit = {
  println("> " + n)
}

val v = Vector(1, 2, 3, 4)
v.foreach(show)

// Rockets
v.foreach(n => println("> " + n))
val duck = "Duck".toVector
duck.foreach(c => print("_" + c + "_"))

// Assigning anonymous function to a variable
val cmon = (s:String) => println(s"$s, come on!")
cmon("Helen")