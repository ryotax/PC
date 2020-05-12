import scala.io.StdIn._
object Main extends App {
  val Array(a, p) = readLine.split(" ").map(_.toInt)
  println((a * 3 + p) / 2)
}
