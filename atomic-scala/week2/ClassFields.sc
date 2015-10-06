class Info(val name:String = "",
           var description:String,
           var priority:Int = 10) {
}

val info = new Info("stuff", "something")
assert(info.name == "stuff")
assert(info.description == "something")
info.description = "Something else"
assert(info.description == "Something else")

assert(info.priority == 10)
info.priority = 0
assert(info.priority == 0)
