import scala.io.StdIn._

object Main extends App {
  val Array(n, k) = readLine.split(" ").map(_.toInt)
  val s = readLine

  def countSeq(i: Int, prev: Char, nSeq: Int): Int = {
    if (i == n) nSeq
    else s.charAt(i) match {
      case `prev` => countSeq(i + 1, prev, nSeq + 1)
      case other => countSeq(i + 1, other, nSeq)
    }
  }

  val nSeq = countSeq(1, s.charAt(0), 0)
  println(Math.min(n - 1, nSeq + k * 2))
}
