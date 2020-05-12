import scala.io.StdIn._
object Main extends App {
  val n = readInt
  val ws = readLine.split(" ").map(_.toInt)
  val sums = ws.scanLeft(0)(_ + _)
  println(sums.map(s => Math.abs(sums.last - 2 * s)).min)
}
