import scala.io.StdIn._
object Main extends App {
  val n = readLine.toInt
  val surveys = (1 to n).map{i => readLine.split(" ").map{_.toInt}}.toList
  val Array(x1, y1, h1) = surveys.find(_(2) != 0).get

  val candidates = (for {
    xi <- 0 to 100
    yi <- 0 to 100
    hi = h1 + Math.abs(x1 - xi) + Math.abs(y1 - yi)
  } yield (xi, yi, hi)).toList

  val (cx, cy, ch) = eliminate(candidates, surveys)
  println(s"$cx $cy $ch")

  def eliminate(candidates: List[(Int, Int, Int)], surveys: List[Array[Int]]): (Int, Int, Int) = {
    candidates match {
      case Nil => throw new Exception("impossible")
      case c :: Nil => c
      case c :: cs => 
        val Array(x, y, h) = surveys.head
        val filtered = candidates.filter{ c =>
          val calculatedH = c._3 - Math.abs(c._1 - x) - Math.abs(c._2 - y)
          if (h > 0) calculatedH == h else calculatedH <= 0
        }
        eliminate(filtered, surveys.tail)
    }
  }
}

