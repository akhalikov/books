import week5.sodafountain._
import week5.sodafountain.Holder._
import week5.sodafountain.Syrop._
import week5.sodafountain.Sprinkle._
import week5.sodafountain.Quantity._
import week5.sodafountain.IceCream._

/**
 * Created by artur on 01.02.15.
 */
case class Scoops(holder: Holder, scoops: Scoop*)

val iceCreamCone = Scoops(
  WaffleCone,
  Scoop(Extra, MochaFudge),
  Scoop(Extra, ButterPecan),
  Scoop(Extra, IceCream.Chocolate))

println(iceCreamCone)
