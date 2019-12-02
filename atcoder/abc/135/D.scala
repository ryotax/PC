import scala.io.StdIn._
object Main extends App {
  val s = readLine

  def dp(rems: Array[Long], d: Char): Array[Long] = {
    val ret = new Array[Long](13)
    val is = if (d == '?') (0 to 9) else Seq((d - '0').toInt)
    for {
      i <- is
      j <- (0 to 12)
    } {
      ret((j * 10 + i) % 13) += rems(j)
      ret((j * 10 + i) % 13) %= 1000000007
    }
    ret
  }

  val init = Array.tabulate(13)(i => if (i == 0) 1L else 0L)
  val result = s.foldLeft(init)(dp)
  println(result(5))
}
