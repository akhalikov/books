val activity = "ice skating"
val hour = 10
val temperature = 10

val isOpen = {
  if (activity == "swimming" || activity == "ice skating") {
    val opens = 9
    val closes = 20
    println("Operating hours: " + opens + " - " + closes)
    if (hour >= opens && hour <= closes) {
      true
    } else {
      false
    }
  } else {
    true
  }
}

val goodTemperature = {
  if (activity == "swimming") {
    val low = 25
    val high = 32
    if (temperature >= low && temperature <= high) { 
      true
    } else {
      false
    }
  } else if (activity == "ice skating") {
    val low = 5
    val high = 15
    if (temperature >= low && temperature <= high) { 
      true 
    } else {
      false
    }
  } else {
    true
  }
}

val doActivity = isOpen && goodTemperature
println(activity + ": Open=" + isOpen + ", Temperature=" + goodTemperature + ", Doing=" + doActivity)