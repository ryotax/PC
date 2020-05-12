import scala.io.StdIn._
object Main extends App {
  val Array(n, m) = readLine.split(" ").map(_.toInt)
  val stairs = new Array[Boolean](n + 1)
  (1 to m).foreach{i => stairs(readInt) = true}

  def step(stair: Int, cur: Long, pre: Long): Long = {
    if (stair > n) cur
    else step(stair + 1, if (stairs(stair)) 0 else (cur + pre) % 1000000007, cur)
  }

  println(step(1, 1, 0))
}
