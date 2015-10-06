// Tuple definition and unpacking
def f = (1, 3.14, "Mouse", false, "Altitude")
val (n, d, a, b, h) = f

a

// Class unpacking
case class Employee(name:String, ID:Int)
val empA = Employee("Bob", 1130)
val Employee(nm, id) = empA
nm



