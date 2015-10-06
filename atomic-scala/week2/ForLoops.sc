/**
 * Created by artur on 05.01.15.
 */

// for loop with "to" keyword
var result = ""
for (i <- 0 to 9) {
  result += i + " "
}
result

// for loop with "until" keyword (same as "to")
result = ""
for (i <- 0 until 10) {
  result += i + " "
}
result

// for loop using Range
result = ""
for (i <- Range(0, 10)) {
  result += i + " "
}
result


