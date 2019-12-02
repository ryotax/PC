import scala.io.StdIn._

object Main extends App {
  val Array(n, k, q) = readLine.split(" ").map(_.toInt)
  val map = (1 to q).map(i => readLine.toInt).groupBy(identity).mapValues(_.size)
  val w = new java.io.PrintWriter(System.out)
  (1 to n).foreach { i => w.println(if (k - (q - map.getOrElse(i, 0)) > 0) "Yes" else "No")}
  w.flush
}
