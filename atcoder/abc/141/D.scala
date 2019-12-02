import scala.io.StdIn._
import scala.collection.mutable.PriorityQueue

object Main extends App {
  val Array(n, m) = readLine.split(" ").map(_.toInt)
  val prices = PriorityQueue(readLine.split(" ").map(_.toLong): _*)
  (1 to m).foreach { i => prices.enqueue(prices.dequeue / 2)}
  println(prices.sum)
}

