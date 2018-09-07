import scala.io.StdIn._

object Main extends App {
  val orderMap = scala.collection.mutable.SortedMap[Long, Long]
  val Array(q, k) = readLine.split(" ") map {_.toInt}
  val qs = (1 to q) foreach {parse(readLine.split(" ") map {_.toLong})}

  def parse(a: Array[Long]) = a match {
    case Array(1, day, order) => orderMap.put(day, orderMap.getOrElse(day, 0) + order)
    case Array(2, day) => println(count(orderMap takeWhile {_._1 <= day}, 0, 0, 0))
  }

  @scala.annotation.tailrec
  def count(orders: Seq[(Long, Long)], prevDay: Long, stocks: Long, deliveries: Long): Long = {
    orders match {
      case Nil => deliveries
      case _ =>
        val (day, order) = orders.head
        val curStocks = k * (day - prevDay) + stocks
        val curDeliveries = curStocks min order
        count(orders.tail, day, curStocks - curDeliveries, deliveries + curDeliveries)
    }
  }
}

