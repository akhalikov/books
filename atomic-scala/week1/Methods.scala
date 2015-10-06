def getSquare(x:Int):Int = {
  x * x  
}

assert(getSquare(3) == 9)
assert(getSquare(5) == 25)
assert(getSquare(6) == 36)

println("getSquare OK")

def getSquareDouble(x:Double):Double = {
  x * x
}

assert(getSquareDouble(1.2) == 1.44)
assert(getSquareDouble(5.7) == 32.49)

println("getSquareDouble OK")

def manyTimesString(s:String, times:Int):String = {
   s * times
}

assert(manyTimesString("abc", 1) == "abc")
assert(manyTimesString("123", 2) == "123123")
assert(manyTimesString("hey ", 3) == "hey hey hey ")

println("manyTimesString OK")