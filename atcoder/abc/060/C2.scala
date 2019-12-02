import scala.io.StdIn._
object Main extends App {
  val Array(_, t) = readLine.split(" ").map(_.toInt)
  val (_, sum) = readLine.split(" ").map(_.toInt).foldLeft((0, 0)){case ((until, cur), x) =>
    (x + t, cur + t - (if (x < until) until - x else 0))
  }
  println(sum)
}
