import scala.io.StdIn._
object Main extends App {
  val week = Array("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
  println(7 - week.indexOf(readLine))
}

