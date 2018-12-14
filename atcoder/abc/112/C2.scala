import scala.io.StdIn._
object Main extends App {
  case class Point(x: Int, y: Int, h: Int) {
    def this(arr: Array[Int]) = this(arr(0), arr(1), arr(2))
    def this(line: String) = this(line.split(" ").map{_.toInt})
    def peakHeight(xi: Int, yi: Int): Int = h + Math.abs(x - xi) + Math.abs(y - yi)
  }

  val n = readLine.toInt
  val surveys = (1 to n).map{i => new Point(readLine)}
  val p1 = surveys.find(_.h != 0).get

  val peakCandidates = for {
    xi <- 0 to 100
    yi <- 0 to 100
  } yield Point(xi, yi, p1.peakHeight(xi, yi))
  val p = eliminate(peakCandidates, surveys)
  println(s"${p.x} ${p.y} ${p.h}")

  def eliminate(candidates: Seq[Point], surveys: Seq[Point]): Point = {
    if (candidates.lengthCompare(1) == 0) candidates.head
    else eliminate(candidates.filter(c => surveys.head.peakHeight(c.x, c.y) == c.h), surveys.tail)
  }
}

