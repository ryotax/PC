import scala.io.StdIn._
import scala.collection.mutable.{ArrayBuffer, PriorityQueue}
object Main extends App {
  val Array(n, m) = readLine.split(" ").map(_.toInt)
  val arbeits = Array.fill(100001)(new ArrayBuffer[Int]())
  for (i <- 1 to n) {
    val Array(a, b) = readLine.split(" ").map(_.toInt)
    arbeits(a) += b
  }

  val possible = PriorityQueue[Int]()
  def exec(day: Int, income: Int): Int = {
    if (day > m) income
    else {
      possible ++= arbeits(day)
      exec(day + 1, income + (if (possible.isEmpty) 0 else possible.dequeue()))
    }
  }

  println(exec(1, 0))
}
