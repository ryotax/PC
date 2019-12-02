import scala.io.StdIn._
object Main extends App {
  val Array(n, t) = readLine.split(" ").map(_.toInt)

  @scala.annotation.tailrec
  def next(list: List[Int], cur: Long, until: Long): Long =
    list match {
      case Nil => cur
      case x :: xs => next(xs, cur + t - (if (x < until) until - x else 0), x + t)
    }

  println(next(readLine.split(" ").map(_.toInt).toList, 0, 0))
}
