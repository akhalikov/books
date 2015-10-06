val whole:Int = 5

// compile error trying to reassign val
//whole = 11

var v1:Int = 5
v1 = 10

val constantv1 = v1
println(constantv1)

v1 = 15
println(constantv1) // prints 10: the value of constantv1 is not changed

var v2 = v1
println("v2=", v2)

v1 = 20
println("v2=", v2)