import scala.io.StdIn._
import scala.collection.JavaConverters._

object Main extends App {
  val orderMap = new java.util.TreeMap[Long, Long]
  val Array(q, k) = readLine.split(" ") map {_.toInt}
  val qs = (1 to q) foreach {i => parse(readLine.split(" ") map {_.toLong})}

  def parse(a: Array[Long]) = a match {
    case Array(1, day, order) => {
      orderMap.put(day, (if (orderMap.containsKey(day)) orderMap.get(day) else 0) + order)
    }
    case Array(2, day) => println(count(orderMap.headMap(day, true).asScala.toSeq, 0, 0, 0))
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

