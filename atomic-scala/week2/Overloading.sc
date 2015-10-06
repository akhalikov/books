/**
 * Created by artur on 06.01.15.
 */
class Overloading1 {
  def f():Int = { 88 }
  def f(n:Int):Int = { n+2 }
}

class Overloading2 {
  def f():Int = { 99 }
  def f(n:Int) = { n + 3 }
}

val mo1 = new Overloading1
val mo2 = new Overloading2
mo1.f()
mo1.f(11)

mo2.f()
mo2.f(11)

