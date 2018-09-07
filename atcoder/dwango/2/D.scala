import scala.io.StdIn._

object Main extends App {
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

class Garden(garden: Array[Array[Long]]) {
  val h = garden.length
  val w = garden(0).length
  def v(x: Int, y: Int) = garden(x)(y)
}
