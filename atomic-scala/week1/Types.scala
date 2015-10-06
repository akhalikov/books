var whole:Int = 5
var text:String = "ABC1234"

println(text)

var d:Double = 5.4
println(d)

var logical:Boolean = true
println(logical)

var multilineString = "This is gonna be a " +
  "multiline string";
println(multilineString)

// Compile error trying to save string into Boolean variable
//logical = "Maybe"

// Compile error trying to save double to int variable
//whole = 5.4

// OK to save integer literal to double variable. Prints: 15.0
d = 15
println(d)

