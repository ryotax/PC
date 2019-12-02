import scala.io.StdIn._

object Main extends App {
  val Array(n, k) = readLine.split(" ").map(_.toLong)
  val as = readLine.split(" ").map(_.toInt).sorted
  val fs = readLine.split(" ").map(_.toInt).sorted.reverse
  val zip = as.zip(fs)

  def available(cost: Long): Boolean = 
    zip.foldLeft(k){case (trainings, (a, f)) => trainings - Math.max(0, a - cost / f)} >= 0

  def binSearch(min: Long, max: Long): Long = {
    if (max - min <= 1) max
    else {
      val cur = (min + max) / 2
      if (available(cur)) binSearch(min, cur) else binSearch(cur, max)
    }
  }

  println(binSearch(-1, 1000000000000L))
}
