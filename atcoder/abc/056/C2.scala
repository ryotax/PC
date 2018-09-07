import scala.io.StdIn._
object Main extends App {
  val x = readInt
  println(count(1, 0))

  @scala.annotation.tailrec
  def count(i: Int, sum: Int): Int = i + sum match {
    case n if n >= x => i
    case n => count(i + 1, n)
  }
}
