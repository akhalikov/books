// Example 1
// Companion object for class X
object X {
  var n:Int = 0; // variable should be initialized
}

class X {
  def increment() = { X.n += 1; X.n }
}

var a = new X
var b = new X
a.increment()
b.increment()
a.increment()

///////////////////////////////////////////////////////
// Example 2
class Y

object Y {
  var n:Int = 0
  def increment() = { n+= 1; n }
  def count() = increment()
}

Y.increment()
Y.increment()
Y.count()

///////////////////////////////////////////////////////
// Example 3: counting instances

object Count {
  var n = -1
  def id() = { n += 1; n }
}

class Count() {
  val id = Count.id()
  override def toString = s"Count$id"
}

val v = Vector(new Count, new Count, new Count, new Count, new Count)

///////////////////////////////////////////////////////
// Exercise 1
class WalkActivity

object WalkActivity {
  var log:String = "";

  def start(name:String) = {
    println(s"$name started!")
    log += s"[$name] Activity started "
  }

  def stop(name:String) = {
    log += s"[$name] Activity stopped "
  }
}

val wa = WalkActivity
wa.start("trecking")
WalkActivity
  .start("running")

wa.log