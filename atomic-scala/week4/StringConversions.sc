class JackDaniels(val name:String) {
  override def toString = s"Jack Daniels $name"
}

val good = new JackDaniels("TENNESSEE HONEY")

// Usual class has no auto formatting
class Bicycle(riders:Int)
val forTwo = new Bicycle(2)

// Case classes provide nice formatting
case class Bicycle2(riders:Int)
val forThree = new Bicycle2(3)



