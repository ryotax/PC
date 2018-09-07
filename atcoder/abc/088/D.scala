import scala.collection.mutable.{HashSet => MSet}
import scala.io.StdIn._
object Main extends App {
  val Dirs = Seq((-1, 0), (1, 0), (0, -1), (0, 1))
  val checked = MSet[(Int, Int)]()

  val Array(h, w) = readLine.split(" ").map{_.toInt}
  val field: Array[String] = (1 to h).map{i => readLine}.toArray
  val Blacks = field.map{_.count(_ == '#')}.sum

  def valid(x: Int, y: Int): Boolean =
    0 < x && x <= w && 0 < y && y <= h && field(y - 1).charAt(x - 1) == '.' && !checked(x, y)

  @scala.annotation.tailrec
  def check(pos: Set[(Int, Int)], step: Int = 1): Int = {
    val valids = (for {
      (x, y) <- pos
      (dx, dy) <- Dirs if (valid(x + dx, y + dy))
    } yield (x + dx, y + dy)).toSet
    checked ++= valids
    if (checked(w, h)) w * h - (Blacks + step + 1)
    else if (valids.size == 0) -1
    else check(valids, step + 1)
  }

  println(check(Set((1, 1))))
}
