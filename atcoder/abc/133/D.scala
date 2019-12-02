import scala.io.StdIn._
object Main extends App {
  val n = readInt
  val as = readLine.split(" ").map(_.toInt)
  val (odds, evens) = as.zipWithIndex.partition(_._2 % 2 == 0)
  val first = odds.map(_._1).sum - evens.map(_._1).sum
  def rains(l: Int): Array[Int] = as.scanLeft(l)((z, a) => (a - z / 2) * 2).init
  println(rains(first).mkString(" "))
}
