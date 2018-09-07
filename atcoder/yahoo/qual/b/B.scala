import scala.io.StdIn._

object Main extends App {
  val Array(n, k) = readLine.split(" ") map {_.toInt}
  val results = (readLine.split(" ") map {_.toLong}).sorted
  println(results.take(k).sum + k.toLong * (k - 1) / 2)
}
