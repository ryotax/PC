import scala.io.StdIn._
object Main extends App {
  val Array(n, m, d) = readLine.split(" ").map(_.toLong)
  val ans = Double.box((n - d).toDouble * (if (d == 0) 1 else 2) / (n * n) * (m - 1))
  println(String.format("%1$.10f", ans))
}



