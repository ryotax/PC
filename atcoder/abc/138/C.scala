import scala.io.StdIn._
object Main extends App {
  readLine
  val vs = readLine.split(" ").map(_.toDouble).sorted
  println(vs.tail.foldLeft(vs.head){(z, v) => (z + v) / 2})
}
