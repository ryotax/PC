import scala.io.StdIn._
object Main extends App {
  val n = readInt
  val ds = readLine.split(" ").map(_.toInt).sorted
  println(ds(n / 2 - 1) - ds(n / 2))
}
