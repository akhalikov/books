// Exercise 4
trait Contact {
  val email:String
}

class Person(val first:String, val last:String) {
  override def toString = s"$first $last"
}

class Friend(first:String, last:String, val email:String)
  extends Person(first:String, last:String) with Contact

val friends = Vector(
  new Friend("John", "Smith", "john@smith.com"),
  new Friend("Alan", "Wats", "alan@wats.com"),
  new Friend("Endy", "Dwarf", "endy@dwarf.com")
)

val sorted = friends.sortBy(_.email)