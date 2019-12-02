import scala.io.StdIn._

object Main extends App {
  val Array(a, b) = readLine.split(" ").map(_.toLong)

  def gcd(l: Long, r: Long): Long = if (r == 0) l else gcd(r, l % r)

  def div(n: Long, d: Int, cnt: Int): Int = {
    if (d > 1000000) {
      cnt + (if (n == 1) 1 else 2)
    } else {
      def divP(l: Long): Long = if (l % d == 0) divP(l / d) else l
      divP(n) match {
        case `n` => div(n, d + 1, cnt)
        case other => div(other, d + 1, cnt + 1)
      }
    }
  }

  println(div(gcd(a, b), 2, 0))
}
