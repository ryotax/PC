import scala.io.StdIn._

object Main extends App {
  def pow(base: Long, exp: Int, result: Long = 1): Long =
    if (exp == 0) result
    else pow(base, exp - 1, result * base % 998244353)

  def count(l: List[(Int, Int)], cur: Int, nPre: Int, result: Long): Long = l match {
    case Nil => result
    case (`cur`, n) :: xs => count(xs, cur + 1, n, result * pow(nPre, n) % 998244353)
    case _ => 0
  }

  readLine
  val ds = readLine.split(" ").map(_.toInt)
  val sorted: List[(Int, Int)] = ds.groupBy(identity).mapValues(_.size).toList.sorted
  println(if (sorted.head._2 != 1) 0 else count(sorted, 0, 1, 1))
}
