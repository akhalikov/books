package week5

/**
 * Created by artur on 01.02.15.
 */
trait Resilience

object Bounciness extends Enumeration {
  case class _Val() extends Val with Resilience
  type Bounciness = _Val
  val level1, level2, level3 = _Val()
}

import Bounciness._

object Flexibility extends Enumeration {
  case class _Val() extends Val with Resilience
  type Flexibility = _Val
  val type1, type2, type3 = _Val()
}

import Flexibility._

trait Spring[R <: Resilience] {
  val res:R
}

case class BouncingBall(res: Bounciness)
  extends Spring[Bounciness]

//BouncingBall(level2)