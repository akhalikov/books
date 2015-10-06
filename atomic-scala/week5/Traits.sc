// Traits

trait Color
trait Texture
trait Hardness

class Fabric

class Cloth extends Fabric with Color
  with Texture with Hardness

class Paint extends Color with Texture
  with Hardness

// Exercise 1
trait BatteryPower {
  def monitor(value:Int):String = {
    if (value >= 40) "green"
    else if (value >= 20 && value < 40) "yellow"
    else "red"
  }
}

class EnergySource
class Battery
  extends EnergySource with BatteryPower {
}

val b = new Battery
b.monitor(80)

// Exercise 2
class Toy
class BatteryPoweredToy
  extends Toy with BatteryPower
val toy = new BatteryPoweredToy
toy.monitor(50)

// Exercise 3
val toy2 = new Toy with BatteryPower
toy2.monitor(50)