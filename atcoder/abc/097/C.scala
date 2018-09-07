import scala.io.StdIn._
object Main extends App {
  val s = readLine
  val k = readInt
  val ss = (0 to s.size - 1).map(i => s.slice(i, i + k)).sorted.take(k)
  val sorted = ss.flatMap(_.inits).distinct.sorted.tail // remove "" by tail
  println(sorted(k - 1))
}
