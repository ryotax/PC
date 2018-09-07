import scala.io.StdIn._

object Main extends App {
  val Array(h, w) = readLine.split(" ").map{_.toInt}
  val canvas: List[String] = (("." * (w + 2)) +: (1 to h).map{hh => "." + readLine + "."} :+ ("." * (w + 2))).toList
  def black(x: Int, y: Int): Boolean = canvas(y).charAt(x) == '#'
  val checks = for {x <- 1 to w; y <- 1 to h} yield {
    !black(x, y) ||
    (black(x, y - 1) || black(x, y + 1) || black(x - 1, y) || black(x + 1, y))
  }

  println(if (checks.forall(identity)) "Yes" else "No")
}
