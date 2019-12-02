import scala.io.StdIn._
object Main extends App {
  val n = readDouble
  val x = Math.ceil(n / 1.08)
  println(if ((x * 1.08).toInt == n) x.toInt else ":(")
}
