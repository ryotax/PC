import scala.io.StdIn._
object Main extends App {
  val n = readInt
  val abs = Array.fill(n)(readLine.split(" ").map(_.toLong)).sortBy(_(1))
  val result = abs.foldLeft(0L){case (z, Array(a, b)) => if (z + a > b) Int.MaxValue else z + a}
  println(if (result == Int.MaxValue) "No" else "Yes")
}
