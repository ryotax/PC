import scala.io.StdIn._

object Main extends App {
  val n = readLong
  val limit = Math.sqrt(n).toInt + 1
  def check(d: Int, min: Long): Long = {
    if (d > limit) min
    else check(d + 1, if (n % d == 0) Math.min(min, n / d + d - 2) else min)
  }
  println(check(1, Long.MaxValue))
}
