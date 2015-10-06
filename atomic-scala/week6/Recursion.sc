// Example 1
def rPrint(s:Seq[Char]):Unit = {
  print(s.head)
  if (s.tail.nonEmpty)
    rPrint(s.tail) // Recursive call
}
rPrint("Recursion")

// Example 2
def sumIt(toSum:List[Int], sum:Int= 0):Int =
  if(toSum.isEmpty)
    sum
  else
    sumIt(toSum.tail, sum + toSum.head)

sumIt(List(10, 20, 30, 40, 50))