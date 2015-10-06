package week5.sodafountain

/**
 * Created by artur on 01.02.15.
 */
object Quantity extends Enumeration {
  type Quantity = Value
  val None, Small, Regular, Extra, Super = Value
}

object Holder extends Enumeration {
  type Holder = Value
  val Bowl, Cup, Cone, WaffleCone = Value
}

trait Flavor

object Syrop extends Enumeration {
  case class _Val() extends Val with Flavor
  type Syrop = _Val
  val Chocolate, HotFudge, Butterscotch, Caramel = _Val()
}

import Quantity._
import Holder._
import Syrop._

object IceCream extends Enumeration {
  case class _Val() extends Val with Flavor
  type IceCream = _Val
  val Chocolate, Vanilla, Strawberry, Coffee,
    MochaFudge, RumRaisin, ButterPecan = _Val()
}

import IceCream._

object Sprinkle extends Enumeration {
  case class _Val() extends Val with Flavor
  type Sprinkle = _Val
  val None, Chocolate, Rainbow = _Val()
}

import Sprinkle._

trait Amount {
  val quant: Quantity
}

trait Taste[F <: Flavor] extends Amount {
  val flavor:F
}

case class Scoop(quant: Quantity, flavor: IceCream)
  extends Taste[IceCream]

trait Topping

case class Sprinkles(quant: Quantity, flavor: Sprinkle)
  extends Taste[Sprinkle] with Topping

case class Sauce(quant: Quantity, flavor: Syrop)
  extends Taste[Syrop] with Topping

case class WhippedCream(quant: Quantity)
  extends Amount with Topping

case class Nuts(quant: Quantity)
  extends Amount with Topping

class Cherry extends Topping