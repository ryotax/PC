import scala.io.StdIn._

object Main extends App {
  val p = readDouble
  def time(y: Double): Double = y + p / Math.pow(2, y / 1.5)
  val zeroToTen = (0 to 10).toArray
  def search(lower: Double, higher: Double, count: Int): Double = {
    val years: Array[Double] = zeroToTen.map(lower + (higher - lower) / 10 * _)
    val times: Array[Double] = years.map(time)
    val min = times.min
    if (count == 0) min
    else {
      val minIndex = times.indexOf(min)
      search(years(Math.max(minIndex - 1, 0)), years(Math.min(minIndex + 1, 10)), count - 1)
    }
  }
  println(search(0, p, 40))
}

