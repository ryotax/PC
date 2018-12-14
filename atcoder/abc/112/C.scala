import scala.io.StdIn._
object Main extends App {
  val n = readLine.toInt
  val surveys = (1 to n).map{i => readLine.split(" ").map{_.toInt}}
  val Array(x1, y1, h1) = surveys.find(_(2) != 0).get

  val candidates = for {
    xi <- 0 to 100
    yi <- 0 to 100
    hi = h1 + Math.abs(x1 - xi) + Math.abs(y1 - yi)
  } yield (xi, yi, hi)
  val (cx, cy, ch) = eliminate(candidates, surveys)
  println(s"$cx $cy $ch")

  def eliminate(candidates: Seq[(Int, Int, Int)], surveys: Seq[Array[Int]]): (Int, Int, Int) = {
    if (candidates.lengthCompare(1) == 0) candidates.head
    else {
      val Array(x, y, h) = surveys.head
      eliminate(candidates.filter(c => h + Math.abs(c._1 - x) + Math.abs(c._2 - y) == c._3), surveys.tail)
    }
  }
}

