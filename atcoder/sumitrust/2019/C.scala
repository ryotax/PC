import scala.io.StdIn._
object Main extends App {
  val x = readInt

  def check(min: Int, max: Int): Int = {
    val newMin = min + 100
    val newMax = max + 105
    if (newMin > x) 0
    else if (newMin <= x && x <= newMax) 1
    else check(newMin, newMax)
  }

  println(check(0, 0))
}
