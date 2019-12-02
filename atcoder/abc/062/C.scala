import scala.io.StdIn._
object Main extends App {
  val Array(hh, ww) = readLine.split(" ").map(_.toInt)

  def divHolizontal(h: Int, w: Int): Int = if (h % 3 == 0) 0 else w

  def divT(h: Int, w: Int): Int = {
    def largeSide = (w + 1) / 2

    def minTopDiff: Int = {
      val top = h / 3
      val bottom = h - top
      largeSide * bottom - Math.min(w * top, (w - largeSide) * bottom)
    }

    def maxTopDiff: Int = {
      val top = (h + 2) / 3
      val bottom = h - top
      Math.max(w * top, largeSide * bottom) - (w - largeSide) * bottom
    }

    Math.min(minTopDiff, maxTopDiff)
  }
  println(divHolizontal(hh, ww)
     .min(divHolizontal(ww, hh))
     .min(divT(hh, ww))
     .min(divT(ww, hh)))
}
