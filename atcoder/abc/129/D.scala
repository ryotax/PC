import scala.io.StdIn._
object Main extends App {
  val Array(h, w) = readLine.split(" ").map(_.toInt)
  val grid = Array.fill(h)(readLine)

  val l, r, u, d = Array.ofDim[Int](h + 2, w + 2)

  for {
    x <- 1 to w
    y <- 1 to h
  } {
    if (grid(y - 1).charAt(x - 1) == '.') {
      l(y)(x) = l(y)(x - 1) + 1
      d(y)(x) = d(y - 1)(x) + 1
    } else {
      l(y)(x) = 0
      d(y)(x) = 0
    }
  }

  for {
    x <- w to 1 by -1
    y <- h to 1 by -1
  } {
    if (grid(y - 1).charAt(x - 1) == '.') {
      r(y)(x) = r(y)(x + 1) + 1
      u(y)(x) = u(y + 1)(x) + 1
    } else {
      r(y)(x) = 0
      u(y)(x) = 0
    }
  }

  var result = 0
  for {
    x <- 1 to w
    y <- 1 to h
  } result = Math.max(result, l(y)(x) + r(y)(x) + d(y)(x) + u(y)(x))

  println(result - 3)
}
