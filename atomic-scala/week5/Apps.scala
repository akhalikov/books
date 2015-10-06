/**
 * Created by artur on 29.01.15.
 */

object HelloApp extends App {
  hi("Mr. Duck")

  println(new java.util.Date())

  if (args.length > 0)
    for (arg <- args)
      println(arg)

  def hi(name:String) = println("Hello, It's " + name)
}