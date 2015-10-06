val c = {
  val i1 = 2
  val j1 = 4/i1
  i1 * j1  
}
println(c)

val feetPerMile = 5280
var yardsPerMile = feetPerMile / 3.0
val d1 = 2000 / yardsPerMile
println("d1", d1)

var d2 = {
  val fpm = 5280
  val ypm = fpm / 3.0
  2000 / ypm
}
println("d2", d2)
