import scala.io.StdIn._
object Main extends App {
  def gcd(l: Int, r: Int): Int = if (r == 0) l else gcd(r, (l % r))
  val Array(n, x) = readLine.split(" ").map{_.toInt}
  val xs = readLine.split(" ").map{xi => Math.abs(xi.toInt - x)}
  println(xs.reduce{gcd(_, _)})
}

