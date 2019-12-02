import scala.io.StdIn._
object Main extends App {
  val Max = 1000000000L
  val Array(a, b, x) = readLine.split(" ").map(_.toLong)

  def d(n: Long): Long = if (n == 0) 0 else n.toString.size
  def judge(n: Long): Boolean = a * n + b * d(n) <= x

  def binSearch(l: Long, r: Long): Long = {
    val mid = (l + r) / 2
    if (judge(mid)) {
      if (r - mid <= 1) mid
      else binSearch(mid, r)
    } else binSearch(l, mid)
  }

  println(if (judge(Max)) Max else binSearch(0, Max))
}
