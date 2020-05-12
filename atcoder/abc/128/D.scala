import scala.io.StdIn._
object Main extends App {
  val Array(n, k) = readLine.split(" ").map(_.toInt)
  val vs = readLine.split(" ").map(_.toInt)
  val sums = vs.scanLeft(0)(_ + _)
  val total = sums(n)
  val minuss = vs.zipWithIndex.filter(_._1 < 0).sorted
  var max = 0
  for {
    l <- (0 to Math.min(n, k))
    r <- (0 to Math.min(n, k) - l)
  } {
    val sum = sums(l) + total - sums(n - r)
    val nDrop = Math.min(k - l - r, l + r)
    val inRange: Int => Boolean = (i => (0 <= i && i < l) || (n - r < i && i <= n))
    val drops = minuss.filter(z => inRange(z._2)).take(nDrop).map(_._1).sum
    max = Math.max(max, sum - drops)
  }

  println(max)
}
