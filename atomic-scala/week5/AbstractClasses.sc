// Examples
abstract class Animal {
  def templateMethod =
    s"The $animal goes $sound and eats $food"

  // Abstract methods (no method body):
  def animal:String
  def sound:String
  def food:String
}

class Duck extends Animal {
  def animal = "Duck"

  // "override" is optional here:
  override def sound = "Quack"
  override def food = "plants"
}

class Cow extends Animal {
  def animal = "Cow"
  override def sound = "Muuuuu"
  override def food = "grass"
}

(new Duck).templateMethod
(new Cow).templateMethod