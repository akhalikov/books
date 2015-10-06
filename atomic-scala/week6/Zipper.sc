// Example 1
val left = Vector("a", "b", "c", "d")
val right = Vector("q", "r", "s", "t")

left.zip(right)
left.zip(0 to 4)
left.zipWithIndex

// Example 2
val s = "Love"
Range(0, s.length).zip(s)

// Example 3
case class Person(name:String, ID:Int)
val names = Vector("Bob", "Jill", "Jim")
val IDs = Vector(1731, 9274, 8378)

// The case statement unpacks each tuple
// and passes the values to the Person constructor.
names.zip(IDs).map {
  case (n, id) => Person(n, id)
}