import scala.io.StdIn._
object Main extends App {
  val Array(n, k) = readLine.split(" ").map(_.toLong)
  val as = readLine.split(" ").map(_.toInt)

  def count(from: Int, to: Int, sum: Long, num: Long): Long = {
    if (sum >= k) {
      val newNum = num + n - to + 1
      if (from == n) newNum
      else count(from + 1, to, sum - as(from), newNum)
    } else {
      if (to == n) num
      else count(from, to + 1, sum + as(to), num)
    }
  }

  println(count(0, 0, 0, 0))
}
