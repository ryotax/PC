import scala.io.StdIn._
object Main extends App {
  val Array(n, m) = readLine.split(" ").map(_.toInt)
  val as = readLine.split(" ").map(i => (i.toLong, 1))
  val bs = Array.fill(m) {
    val b = readLine.split(" ")
    (b(1).toLong, b(0).toInt)
  }
  val all = (as :++ bs).sorted.reverse

  def count(i: Int, cards: Int, sum: Long): Long = {
    val (cost, num) = all(i)
    if (num < cards) count(i + 1, cards - num, sum + cost * num)
    else sum + cost * cards
  }

  println(count(0, n, 0))
}
