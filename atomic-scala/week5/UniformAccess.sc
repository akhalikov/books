trait Base {
  def f1:Int
  def f2:Int

  val d1:Int
  val d2:Int
  var d3:Int
  var n = 42
}

class Derived extends Base {
  def f1 = 1
  val f2 = 2

  val d1 = 10

  // Can't do this
  //def d2 = 0
  val d2 = 20
  def d3 = n
  def d3_= (newVal:Int) = n = newVal
}

val d = new Derived
d.f1
d.f2
d.d1
d.d2
d.d3

d.d3 = 99
d.d3