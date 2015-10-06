// Exercise 1
case class Person(
                   first:String,
                   last:String,
                   email:String) {

  val fullName = s"$first $last"
}

val p = Person("John", "Smith", "john@smith.com")
p.fullName
p.first
p.email

// Esercise 2
val people = Vector(
  p,
  new Person("Alan", "Wats", "alan@wats.com"),
  new Person("Endy", "Dwarf", "andy@dwarf.com")
)

assert(people.size == 3)

// Exercise 3
val sorted = people.sortBy(_.last)