import scala.io.StdIn._

object Main extends App {
  val p = readDouble
  def y = (3 * Math.log(p * Math.log(2) / 1.5)) / Math.log(4)
  println(if (y < 0) p else y + p / Math.pow(2, y / 1.5))
}


