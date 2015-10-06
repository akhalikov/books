class Coffee(val shots:Int = 2,
             val decaf:Boolean = false,
             val milk:Boolean = false,
             val toGo:Boolean = false,
             val syrup:String = "") {

  var result = getCup()

  def getCup() = if (toGo) "ToGoCup " else "HereCup "

  def pourShots() {
    for (s <- 0 until shots)
      if (decaf)
        result += "decaf shot "
      else
        result += "shot "
  }

  def addMilk() {
    if (milk)
      result += "milk "
  }

  def addSyrup() {
    result += syrup
  }

  pourShots()
  addMilk()
  addSyrup()
}

val usual = new Coffee
usual.result

val mocha = new Coffee(decaf = true, toGo = true, syrup = "Chocolate")
mocha.result