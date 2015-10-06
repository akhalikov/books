import week5.Name

class Element extends Name {
  def interact(other:Element) =
    s"$this interact $other"
}

class Inert extends Element
class Wall extends Inert

trait Material {
  def resilience: String
}