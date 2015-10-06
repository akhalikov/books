import javafx.scene.Camera

trait Aerobic {
  val age:Int
  def minAerobic = .5 * (220 - age)
  def isAerobic(heartRate:Int) =
    heartRate >= minAerobic
}

trait Activity {
  val action:String
  def go:String
}

class Person(val age:Int)

class Exerciser(age:Int,
               val action:String = "Running",
               val go:String = "Run!") extends
Person(age) with Activity with Aerobic

val bob = new Exerciser(44)
bob.isAerobic(180)
bob.isAerobic(80)
bob.minAerobic

// Exercise 1
trait WiFi {
  val address:String
  def reportStatus:String
}

class Camera {
  def showImage:String = "Showing Video"
}

class WiFiCamera(val address:String = "192.168.0.200",
                val reportStatus:String = "working")
  extends Camera with WiFi

val webCam = new WiFiCamera
webCam.showImage
webCam.address
webCam.reportStatus