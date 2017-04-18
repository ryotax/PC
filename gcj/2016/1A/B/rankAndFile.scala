// import scala.io.StdIn._
def exec(rows: Seq[Array[Int]]) = {
  val grouped = rows.flatten groupBy{i => i}
  (grouped filter {tpl => (tpl._2.size & 1) == 1}).keySet.toSeq.sorted
}

val n = readInt
(1 to n) foreach {i =>
  val m = 2 * readInt - 1
  val result = exec((1 to m) map {j => readLine.split(" ") map {_.toInt}})
  println(s"Case #${i}: ${result.mkString(" ")}")
}



