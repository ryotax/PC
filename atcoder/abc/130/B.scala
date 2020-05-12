import scala.io.StdIn._
object Main extends App {
  val Array(n, x) = readLine.split(" ").map(_.toInt)
  val ls = readLine.split(" ").map(_.toInt)
  println(ls.scanLeft(0){(z, l) => z + l}.indexWhere(_ > x) match {
    case -1 => n + 1
    case b => b
  })
}
