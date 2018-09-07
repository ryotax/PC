import scala.io.StdIn._
object Main extends App {
  val Array(a, b, c) = readLine.split(" ") map {_.toInt}
  println(if (a == b + c || b == a + c || c == a + b) "Yes" else "No")
}

