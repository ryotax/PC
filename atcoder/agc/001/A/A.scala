import scala.io.StdIn._
object Main extends App {
  readLine
  val input = readLine.split(" ") map {_.toInt}
  println((input.sorted.grouped(2) map {_.head}).sum)
}

