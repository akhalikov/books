// example 1
case class Passenger(
                      first: String,
                      last: String)

case class Train(
                  travelers: Vector[Passenger],
                  line: String)

case class Bus(
                passengers: Vector[Passenger],
                capacity: Int)

def travel(transport: Any): String = {
  transport match {
    case Train(travelers, line) => s"Train line $line $travelers"
    case Bus(travelers, seats) => s"Bus size $seats $travelers"
    case Passenger => "Walking along"
    case what => s"$what is in limbo!"
  }
}

val travelers = Vector(
  Passenger("Harvey", "Rabbit"),
  Passenger("Dorothy", "Gale"))

val trip = Vector(
  Train(travelers, "Reading"),
  Bus(travelers, 100))

travel(trip(0))
travel(trip(1))