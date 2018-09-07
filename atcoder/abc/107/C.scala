import scala.io.StdIn._
object Main extends App {
  val Array(n, k) = readLine.split(" ").map{_.toInt}
  val x = readLine.split(" ").map{_.toInt}
  println((0 to (n - k)).map{i => calc(x(i), x(i + k - 1))}.min)

  def calc(head: Int, last: Int): Int = last - head + Math.min(Math.abs(head), Math.abs(last))
}
