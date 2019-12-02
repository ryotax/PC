import scala.io.StdIn._

object Main extends App {
  val n = readInt
  val sticks = readLine.split(" ").map(_.toInt).sorted

  def binSearch(n: Int, min: Int, max: Int): Int = {
    if (max - min <= 1) min
    else {
      val mid = (min + max) / 2
      if (sticks(mid) < n) binSearch(n, mid, max)
      else binSearch(n, min, mid)
    }
  }

  val result = for {
    i <- 0 until n
    j <- (i + 1) until n
  } yield binSearch(sticks(j) + sticks(i), j, n) - j
  println(result.sum)
}
