import scala.io.StdIn._
object Main extends App {
  val Array(n, m) = readLine.split(" ").map{_.toInt}
  def check(i: Int): Int = if (m % i == 0) i else check(i - 1)
  println(check(m / n))
}
