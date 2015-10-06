// Type constraints example
class WithF {
  def f(n:Int) = n * 11
}

class CallF[T <: WithF](t:T) {
  def g(n:Int) = t.f(n)
}

new CallF(new WithF).g(2)

new CallF(new WithF {
  override def f(n:Int) = n * 7
}).g(2)

// Exercise 2
def callF2[T <: WithF](t:T, n:Int) = {
  t.f(n)
}

callF2(new WithF, 4)