import scala.io.StdIn._
object Main extends App {
  val Array(from, to) = readLine.split(" ").map(_.toInt)
  val arr = new Array[Boolean](41)

  @scala.annotation.tailrec
  def next(curs: Set[Int], step: Int): Int = {
    if (curs.contains(to)) step
    else next(candidates(curs), step + 1)
  }

  def candidates(curs: Set[Int]): Set[Int] = {
    val results = curs.flatMap(cur => Set(cur + 1, cur - 1, cur + 5, cur - 5, cur + 10, cur - 10))
      .filter(n => 0 <= n && n <= 40 && !arr(n))
    results.foreach(arr(_) = true)
    results
  }

  println(next(Set(from), 0))
}


