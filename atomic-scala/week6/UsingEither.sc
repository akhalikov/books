def f(i:Int) =
  if(i == 0)
    Left("Divide by zero")
  else
    Right(24/i)

def test(n:Int) =
  f(n) match {
    case Left(why) => s"Failed: $why"
    case Right(result) => result
  }

test(4)
test(0)