val r1 = Range(0, 10)
println(r1.step, r1)

val r2 = Range(0, 10, 2)
println(r2.step, r2)

val s:String = "This is an experiment"
val words = s.split(" ")

def stringEqualityTest(s1:String, s2:String) = {
  if (s1.equals(s2)) {
    println("s1 and s2 are equal")
  } else {
    println("s1 and s2 are not equal")
  }
}

var s1 = "Sally"
var s2 = "Sally"
stringEqualityTest(s1, s2)
s2 = "Sam"
stringEqualityTest(s1, s2)