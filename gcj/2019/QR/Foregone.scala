import scala.io.StdIn._

object Foregone extends App {
  def toString(cs: Seq[Char]): String = BigInt(cs.mkString("")).toString
  def solve(n: String): String = {
    val ab = n.map{
      case '4' => ('2', '2')
      case other => (other, '0')
    }.unzip
    toString(ab._1) + " " + toString(ab._2)
  }

  val n = readInt
  (1 to n) foreach {i =>
    println(s"Case #${i}: ${solve(readLine)}")
  }
}
