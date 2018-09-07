import scala.io.StdIn._
import scala.collection.mutable.PriorityQueue

object Main extends App {
  def exec(netaOnly: PriorityQueue[Sushi], remain: List[Sushi], max: Int) = {
    remain match {
      case Nil => max
      case h :: r =>
        netaOnly += push(h)
        if (netaOnly.length > size) {
          val removed = netaOnly.dequeue
        }
    }
  }
  def calc(garden: Garden): Seq[Long] = {
    val memo = Array.ofDim[Long](garden.w, garden.w)
    // val memo = Array.tabulate(garden.w){x => Array.fill(garden.w)(Long.MinValue)}

    def max(rows: Int): Long = {
      var result = Long.MinValue
      for (l <- 0 until garden.w) {
        var rowSum = 0L
        for (r <- l until garden.w) {
          rowSum = rowSum + garden.v(rows, r)
          // print(s"$l, $r = ${memo(l)(r)} => ")
          memo(l)(r) = memo(l)(r) match {
            case i if i <= 0 => rowSum
            case i => i + rowSum
          }
          // println(s"${memo(l)(r)}")
          result = result max memo(l)(r)
        }
      }
      // println(memo.deep)
      result
    }

    ((0 until garden.h - 1).scanLeft(Long.MinValue){(z, n) => z max max(n)}).tail
  }

  def calcMax(garden: Array[Array[Long]]): Long = {
    val zipped = calc(new Garden(garden)) zip calc(new Garden(garden.reverse)).reverse
    // println(zipped)
    (zipped map {case (u, d) => u + d}).max
  }

  val Array(h, w) = readLine.split(" ") map {_.toInt}
  val orig = Array.tabulate(h){x => readLine.split(" ") map {_.toLong}}
  println(calcMax(orig) max calcMax(orig.transpose))
}

case class Sushi(neta: Int, all: Int) {
  def diff = neta - all
}

