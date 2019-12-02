import scala.io.StdIn._

object Main extends App {
  val n = readInt
  val lr = (1 to n) map {i =>
    val Array(l, r) = readLine.split(" ").map(_.toInt)
    (l, r)
  }
  val sorted = lr.sortWith{(l, r) => if (l._1 == r._1) r._2 < l._2 else l._1 < r._1}
  val headRight = sorted.head._2
  val lastLeft = sorted.last._1
  println(sorted.zip(sorted.tail).foldLeft(0){case (max, (l, r)) =>
    println(s"$max, ($l, $r)")
    println(l._1 - headRight)
    println(lastLeft - r._2)
    Math.max(max, Math.max(0, headRight - l._1 + 1) + Math.max(0, r._2 - lastLeft + 1))
  })
}
