// Example
object Level extends Enumeration {
  type Level = Value
  val Overflow, High, Medium, Low, Empty = Value
}
import Level._

// Lopping over enumeration
{
  for (n <- Range(0, Level.maxId))
  yield (n, Level(n))
}

{
  for (lev <- Level.values)
    yield lev
}.toIndexedSeq

def checkLevel(level: Level) = level match {
  case Overflow => ">>> Overflow!"
  case Empty => "Alert: Empty"
  case other => s"Level $level OK"
}

println(checkLevel(Overflow))