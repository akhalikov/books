// example1
case class Person(name:String)

// Using "Any"
def acceptAnything(x:Any):String = {
  x match {
    case s:String => "A String: " + s
    case i:Int if(i < 20) =>
      s"An Int Less than 20: $i"
    case i:Int => s"Some Other Int: $i"
    case p:Person => s"A person ${p.name}"
    case _ => "I don't know what that is!"
  }
}

acceptAnything(5)
acceptAnything(25)
acceptAnything("Some text")

val bob = Person("Bob")
acceptAnything(bob)

acceptAnything(Vector(1, 2, 5))

// exercise 2
def convertToSize(x:Any):Int = {
  x match {
    case s:String => s.length
    case i:Int => i
    case f:Float => math.round(f)
    case d:Double => math.round(d)
    case p:Person => 1
    case _ => 0
  }
}
convertToSize(45)
convertToSize("Bucharest")
convertToSize(45.6F)
convertToSize(45.6D)
convertToSize(Vector(1, 2, 3, 4))