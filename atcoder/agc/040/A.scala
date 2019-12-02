import scala.io.StdIn._

object Main extends App {
  def sumTo(n: Long): Long = n * (n + 1) / 2
  def calc(s: String): Array[Long] = s.split("(?<=>)(?=<)").map {
     _.split("(?<=<)(?=>)") match {
      case Array(l, r) => 
        val max = Math.max(l.size, r.size)
        val min = Math.min(l.size, r.size)
        sumTo(max) + sumTo(min - 1)
      case Array(u) => sumTo(u.size)
     }
  }
  println(calc(readLine).sum)
}
