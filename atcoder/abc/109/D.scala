import scala.io.StdIn._
object Main extends App {
  val Array(h, w) = readLine.split(" ").map{_.toInt}
  val board = Array.fill(h){readLine.split(" ").map{_.toInt}}
  val moves = scala.collection.mutable.ArrayBuffer[String]()

  def pos(i: Int): (Int, Int) = {
    val y = i / w
    val x = if ((y & 1) == 0) i % w else w - 1 - i % w
    (x, y)
  }

  for {
    i <- (0 until h * w - 1)
  } {
    val (x, y) = pos(i)
    if ((board(y)(x) & 1) == 1) {
      val (xx, yy) = pos(i + 1)
      board(yy)(xx) += 1
      moves += (s"${y + 1} ${x + 1} ${yy + 1} ${xx + 1}")
    }
  }
  println(moves.size)
  println(moves.mkString("\n"))
}
