import scala.io.StdIn._
import scala.math.BigInt
object Main extends App {
  val Array(n, a, b) = readLine.split(" ") map {_.toInt}
  val vs = (readLine.split(" ") map {_.toLong}).sorted.reverse
  println("%.6f".format(vs.take(a).sum.toDouble / a))
  val borderValue = vs.take(a).last
  val borders = vs.count(_ == borderValue)
  val overBorders = vs.count(_ > borderValue)
  println(overBorders match {
    case 0 => ((a to (b min borders)) map {i => countCombinations(borders, i)}).sum
    case _ => countCombinations(borders, a - overBorders)
  })

  def countCombinations(n: Long, r: Long): Long = (f(n) / f(r) / f(n - r)).toLong
  @scala.annotation.tailrec
  def f(n: BigInt, base: BigInt = 1): BigInt = {if (n == 0 || n == 1) base else f(n - 1, base * n)}
}
