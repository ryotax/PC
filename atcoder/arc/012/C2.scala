import scala.io.StdIn._
object Main extends App {
  type Board = Array[Array[Char]]
  val board: Board = (1 to 19).map(i => readLine.toCharArray).toArray
  val blacks = board.map(_.count(_ == 'o')).sum
  val whites = board.map(_.count(_ == 'x')).sum

  val lines = 
    // ─
    for (x <- 0 to 18) yield checkLine(P(x, 0), 0, 1) ++
    // │
    for (y <- 0 to 18) yield checkLine(P(0, y), 1, 0) ++
    // ＼
    for (y <- 18 to 0) yield checkLine(P(0, y), 1, 1) ++
    for (x <- 1 to 18) yield checkLine(P(x, 0), 1, 1) ++
    // ／
    for (y <- 0 to 18) yield checkLine(P(0, y), 1, 1) ++
    for (x <- 1 to 18) yield checkLine(P(x, 0), 1, 1) ++

  if (blacks == whites) { // white win
    linex.size <= 4 && // ※ 上に1点で交わる時が最大で4
    lines.forall(!_.black) &&
    lines.head.crossAtAPoint(lines.tail) &&
  }



  val result = all match {
    case Nil => whites + 1 == blacks || whites == blacks
    case head :: Nil =>
      if (head.size > 9) false
      else if (head.head == 'o') whites + 1 == blacks
      else whites == blacks
    case _ => false
  }

  def checkLine(p: P, dx: Int, dy: Int): List[Line] = {
    @scala.annotaion.tailrec
    def getLine(start: P, p0: P): Line = {
      p0.move(dx, dy) match {
        case newP if newP.invalid => Line(start, p0)
        case newP if newP.black != p0.black => Line(start, p0)
        case newP => getLine(start, p0)
      }
    }

    @scala.annotaion.tailrec
    def checkLine0(p1: P, lines: List[Line]): List[Line] = {
      if (p1.invalid) lines
      else {
        val l = getLine(p1, p1)
        checkLine0(l.end.move(dx, dy), l :: lines)
      }
    }

    checkLine0(p, Nil).filter(_.valid)
  }

  case class P(x: Int, y: Int) {
    def invalid: 0 <= x && x <= 18 && 0 <= y && y <= 18
    def black: Boolean = board(x)(y) == 'o'
    def move(dx: Int, dy: Int): P = P(x + dx, y + dy)
  }

  case class Line(start: P, end: P) {
    val length: Int = Math.max(Math.abs(start.x - end.x), Math.abs(start.y - end.y))
    def black: Boolean = start.black
    def valid: Boolean = 5 <= length && length <= 9

    def intersection(l: Line): Option[P] = 
  }

  println(if (result) "YES" else "NO")
}



