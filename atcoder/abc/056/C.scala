import scala.io.StdIn._
object Main extends App {
  val x = readLong
  println(binSearch(500000000, 1, 1000000000))

  @scala.annotation.tailrec
  def binSearch(n: Long, l: Long, r: Long): Long = {
    // println((n, l, r))
    val (min, max) = range(n)
    if (min < x && x <= max) n
    else if (x <= min) binSearch((l + n) / 2, l, n)
    else binSearch((r + n) / 2, n, r)
  }

  def range(n: Long): (Long, Long) = {
    val sum = n * (n + 1) / 2
    (sum - n, sum)
  }
}
