//import util.Random
//import util._
import util.{Random, Properties}

class SailBoat { 
  def raise() = {
    println("Sails raised")    
  }
  
  def lower() = {
    println("Sails lowered")
  }
}

class MotorBoat {
  def on() = {
    println("Motor On")
  }

  def off() = {
    println("Motor Off")
  }
}

object Classes {
  def main(args: Array[String]) {
    println("Main method")
    
    val s = new SailBoat()
    s.raise()
    s.lower()
    
    val m = new MotorBoat()
    m.on()
    m.off()
    
    val rand = new Random()
    println(rand.nextInt(100))

    val prop = Properties
    println(prop)
  }
}
