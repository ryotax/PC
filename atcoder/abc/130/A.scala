import scala.io.StdIn._
object Main extends App {
  val Array(x, a) = readLine.split(" ").map(_.toInt)
  println(if (x < a) 0 else 10)
}
