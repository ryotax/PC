import scala.io.StdIn._

object Main extends App {
  val Array(a, b, x) = readLine.split(" ").map(_.toDouble)
  val limitTan = b / a
  val limitArea = x / a

  def area(rad: Double): Double = Math.tan(rad) match {
    case tan if tan > limitTan => 1 / tan * b * b / 2
    case tan => a * b - a * a * tan / 2
  }
  def angle(rad: Double): Double = rad * 180 / Math.PI

  def binSearch(min: Double, max: Double, cnt: Int): Double = {
    val mid =(max + min) / 2
    if (cnt == 0) mid
    else {
      if (area(mid) < limitArea) binSearch(min, mid, cnt - 1)
      else binSearch(mid, max, cnt - 1)
    }
  }

  println(angle(binSearch(0, Math.PI / 2, 50)))
}
