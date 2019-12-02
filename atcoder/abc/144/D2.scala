import scala.io.StdIn._

object Main extends App {
  val Array(a, b, x) = readLine.split(" ").map(_.toDouble)
  val area = x / a
  println(Math.toDegrees(Math.atan(
    if (a * b > area * 2) b * b / area / 2  // area = 1 / tan * b * b / 2
    else (a * b - area) * 2 / a / a // area = a * b - a * a * tan / 2
  )))
}
