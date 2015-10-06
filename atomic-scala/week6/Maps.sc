// Maps

val constants = Map(
  "Pi" -> 3.141, "e" -> 2.718, "phi" -> 1.618)

constants.keys
constants.values
constants("e")

// Iterating map
(for (pair <- constants)
  yield pair.toString)

for (pair <- constants)
  println(pair.toString)

// Unpacking
(for ((k,v) <- constants)
  yield k + ": " + v)