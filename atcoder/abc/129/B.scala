import scala.io.StdIn._
object Main extends App {
  val n = readInt
  val ws = readLine.split(" ").map(_.toInt)
  val sum = ws.sum
  val (_, min) = (0 until n).foldLeft(0, sum){case ((left, min), i) =>
    val newLeft = left + ws(i)
    (newLeft, Math.min(min, Math.abs(sum - 2 * newLeft)))
  }
  println(min)
}
