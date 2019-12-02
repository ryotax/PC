import scala.io.StdIn._
object Main extends App {
  val n = readInt
  val as = 0 +: readLine.split(" ").map(_.toInt)
  val ans = new Array[Int](n + 1)

  (n to 1 by -1).foreach {i =>
    val cnt = (i * 2 to n by i).count(j => ans(j) == 1)
    ans(i) = (cnt & 1) ^ as(i)
  }
  val is = ans.zipWithIndex.collect{case (a, i) if a == 1 => i}
  println(is.size)
  println(is.mkString(" "))
}
