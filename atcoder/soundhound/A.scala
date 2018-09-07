import scala.io.StdIn._
object Main extends App {
  val Array(a, b) = readLine.split(" ") map {_.toInt}
  println(if (a + b == 15) "+" else if (a * b == 15) "*" else "x")
}

