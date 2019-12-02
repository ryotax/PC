import scala.io.StdIn._
object Main extends App {
  val n = readInt
  val hs = readLine.split(" ").map(_.toInt)

  def check(i: Int, pre: Int): Boolean = {
    if (i == n) true
    else {
      if (hs(i) < pre) false
      else if (hs(i) == pre) check(i + 1, pre)
      else check(i + 1, hs(i) - 1)
    }
  }

  println(if (check(0, 0)) "Yes" else "No")
}
