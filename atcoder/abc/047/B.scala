import scala.io.StdIn._
object Main extends App {
  case class Rectangle(maxX: Int, minX: Int, maxY: Int, minY: Int) {
    def area = ((maxX - minX) max 0) * ((maxY - minY) max 0)
  }

  def exec(r: Rectangle, x: Int, y: Int, a: Int) = {
    a match {
      case 1 => r.copy(minX = r.minX max x)
      case 2 => r.copy(maxX = r.maxX min x)
      case 3 => r.copy(minY = r.minY max y)
      case 4 => r.copy(maxY = r.maxY min y)
    }
  }

  val Array(w, h, n) = readLine.split(" ") map {_.toInt}
  val rect = (1 to n).foldLeft(Rectangle(w, 0, h, 0)){(r, i) =>
    val Array(x, y, a) = readLine.split(" ") map {_.toInt}
    exec(r, x, y, a)
  }
  println(rect.area)
}
