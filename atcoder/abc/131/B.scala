import scala.io.StdIn._
object Main extends App {
  val Array(n, l) = readLine.split(" ").map(_.toInt)
  println((
    if (l >= 0) (l + 1 to l + n - 1)
    else if (-l < n) (l to l + n - 1)
    else (l to l + n - 2)
  ).sum)
}
