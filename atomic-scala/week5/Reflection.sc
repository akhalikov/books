import week5.Name

// Example 1
class Something extends Name
val s = new Something
println(s)
class Something2(val size:Int) extends Name {
  override def toString =
    s"${super.toString}($size)"
}

val s2 = new Something2(47)
println(s2)

// Excercise 1
case class Temp(name:String)
val t = Temp("hello")
println(t)

case class Temp2(name:String) extends Name
val t2 = new Temp2("hello")
println(t2)