import scala.io.StdIn._
object Main extends App {
  val Array(w, h, x, y) = readLine.split(" ").map(_.toInt)
  println(s"${w.toDouble * h / 2} ${if (x * 2 == w && y * 2 == h) 1 else 0}")
}
