import scala.io.StdIn._
object Main extends App {
  @scala.annotation.tailrec
  def possible(t: Int, x: Int, y: Int, i: Int): Boolean = {
    if (i == 0) true
    else {
      val Array(ti, xi, yi) = readLine.split(" ").map{_.toInt}
      val manhattan = Math.abs(x - xi) + Math.abs(y - yi)
      if (manhattan <= ti - t && ((ti - t - manhattan) & 1) == 0) possible(ti, xi, yi, i - 1) else false
    }
  }
  println(if (possible(0, 0, 0, readInt)) "Yes" else "No")
}
