import scala.io.StdIn._
object Main extends App {
  val Array(a, b, c, d) = readLine.split(" ").map(_.toLong)
  def gcd(l: Long, r: Long): Long = if (l % r == 0) r else gcd(r, l % r)
  val lcm = c * d / gcd(c, d)
  def num(div: Long): Long = b / div - (a - 1) / div
  println(b - (a - 1) - (num(c) + num(d) - num(lcm)))
}
