import scala.io.StdIn._
object Main extends App {
  val ca = readLine.toCharArray
  val patterns = Seq("dream","dreamer","erase","eraser").map{_.toCharArray}

  @scala.annotation.tailrec
  def removeTail(size: Int): Int = {
    patterns.filter{_.size <= size}.find(p => (0 until p.size).forall{n => p(n) == ca(size - p.size + n)}) match {
      case None => size
      case Some(p) => removeTail(size - p.size)
    }
  }
  println(if (removeTail(ca.size) == 0) "YES" else "NO")
}
