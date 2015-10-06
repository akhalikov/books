def evenGt5(v:Vector[Int]):Vector[Int] = {
  // 'var' so we can reassign 'result':
  var result = Vector[Int]()
  for {
    n <- v
    if n > 5
    if n % 2 == 0
  } result = result :+ n
  result
}

val v = Vector(1,2,3,5,6,7,8,10,13,14,17)
evenGt5(v)

val v2 = Vector(1,6,7,8)
evenGt5(v2)

// Yielding and definition
def oddGt5(v:Vector[Int]):Vector[Int] = {
  val result = for {
    n <- v
    if n > 5
    isOdd = (n % 2 != 0)
    if isOdd
  } yield n
  result
}

oddGt5(v)
oddGt5(v2)