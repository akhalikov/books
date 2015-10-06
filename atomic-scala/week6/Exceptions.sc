// Exceptions
// Example 1
class Problem(val msg:String)
  extends Exception

def f(i:Int) =
  if (i == 0)
    throw new Problem("Divide by zero")
  else
    24/i

def test(n:Int) =
  try {
    f(n)
  } catch {
    case err:Problem =>
      s"Failed: ${err.msg}"
  }

test(4)
test(0)