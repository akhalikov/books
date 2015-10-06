/**
 * Created by artur on 05.01.15.
 */
val v1 = Vector(3, 11, 7, 13, 1, 5)
v1(4)

// traversing a vector
var result = ""
for(i <- v1) {
  result += i + " "
}
result

// Reverse of a Vector
v1.reverse
// Sorting
v1.sorted

// Head
("Head", v1.head)

// Tail
("Tail", v1.tail)

// sum, min, max of integer Vector
val vi = Vector(5, 6, 1, 3, -12)
("sum", vi.sum)
("max", vi.max)
("min", vi.min)

// sum, min, max of double Vector
val vd = Vector(5.31d, 6.00d, 1.0001d, 30.00d, -12.998d)
("sum", vd.sum)
("max", vd.max)
("min", vd.min)

// // sum, min, max of string Vector
val vs = Vector("Bucharest", "Krakow", "Moscow", "Kiev", "San-Francisco")
("sum", vs.sum) // not working
("max", vs.max)
("min", vs.min)