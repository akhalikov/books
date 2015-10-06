// Exercise 1
class Exclaim(var s:String) {
  def parens() = s + "!"
  def noParens = s + "!"
}

val e = new Exclaim("yes")
e.parens()
e.noParens

// Exercise 2
class Exclaim2(var s:String) {
  val noParens = s + "!"
  def parens() = s + "!"
}
val e2 = new Exclaim("yes")
e2.parens()
e2.noParens

// Exercise 3
class Exclaim3(var s:String) {
  def parens = s + "!"
}
val e3 = new Exclaim("yes")
e3.parens()

// Exercise 4
class Exclaim4(var s:String) {
  var count:Int = 0;

  def parens() = {
    count += 1
    s + "!"
  }
}
val e4 = new Exclaim4("yes")
e4.parens()
e4.count

e4.parens()
e4.count