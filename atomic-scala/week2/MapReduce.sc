// map
val v1 = Vector(1, 2, 3, 4)
v1.map(n => n + 1)

// reduce
val v2 = Vector(1, 10, 100, 1000)
v2.reduce((sum, n) => sum + n)

(1 to 100).reduce((sum, n) => sum + n)

val v3 = Vector("D", "u", "c", "k")
v3.reduce((sum, n) => sum + n)

// Exercise 1
val v4 = v1.map(n => n*11 + 10)
assert(v4 == Vector(21, 32, 43, 54))

// Exercise 6
def sumIt(args:Int*):Int = {
  args.reduce((sum, n) => sum + n)
}
assert(sumIt(1, 2, 3) == 6)
assert(sumIt(45, 45, 45, 60) == 195)