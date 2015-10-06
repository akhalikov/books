// exercise 1
def assignResult(arg:Boolean):Int = {
  val result = if(arg) 42 else 47
  result
}

def assignResult1(arg:Boolean):Int = {
  if(arg) 42 else 47
}
assert(assignResult1(true) == 42)
assert(assignResult1(false) == 47)

// exercise 2
def assignResult2(arg:Boolean):Int = if (arg) 42 else 47
assert(assignResult2(true) == 42)
assert(assignResult2(false) == 47)

// exercise 3
def assignResult3(arg:Boolean) = if (arg) 42 else 47
assert(assignResult2(true) == 42)
assert(assignResult2(false) == 47)