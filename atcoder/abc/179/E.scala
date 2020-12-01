import scala.collection.mutable.{Map => MMap}
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, X, M = in.nextLong
  val map = MMap[Long, Int]()
  val arr = new Array[Long](M.toInt + 1)
  def sum(from: Int, until: Int): Long = (from until until).map(arr).sum

  def an(n: Long): Long = n * n % M

  def calc(n: Long, i: Int): Long = {
    arr(i) = n
    map(n) = i
    val nn = an(n)
    if (i == N - 1 || nn == 0) arr.sum
    else map.get(nn) match {
      case None =>
        calc(nn, i + 1)
      case Some(idx) =>
        sum(0, idx) +
        (N - idx) / (i - idx + 1) * sum(idx, i + 1) +
        sum(idx, idx + ((N - idx) % (i - idx + 1)).toInt)
    }
  }

  println(calc(X, 0))
}
