import scala.io.StdIn._

object Main extends App {
  val Array(n, k) = readLine.split(" ") map {_.toInt}
  val results = (readLine.split(" ") map {_.toInt}).toSet
  val words = (1 to n) map {i => (i, readLine)}

  println(exec(results, words))

  def exec(results: Set[Int], words: Seq[(Int, String)]): String = {
    val (hits, not) = words partition {case (index, word) => results.contains(index)}

    if (not.size == 0) ""
    else {
      val sortedHits = (hits map {_._2}).sorted
      val len = (sortedHits.head.zip(sortedHits.last) takeWhile {tpl => tpl._1 == tpl._2}).size
      val resultCandidate = sortedHits.head.take(len)
      (not map {n => matchesLength(n._2, resultCandidate)}).max match {
        case n if n == len => "-1"
        case n => resultCandidate.take(n + 1)
      }
    }
  }

  def matchesLength(l: String, r: String): Int = {
    (l.zip(r) takeWhile {tpl => tpl._1 == tpl._2}).size
  }
}
