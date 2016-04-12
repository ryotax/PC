// import scala.io.StdIn._

def count(start: Long): String = {
  @scala.annotation.tailrec
  def count0(used: Set[Int], cur: Long): Long = {
    val next = used ++ (cur.toString.split("").tail map {_.toInt})
    if (next.size == 10) cur
    else count0(next, cur + start)
  }

  if (start == 0) "INSOMNIA"
  else count0(Set.empty, start).toString
}

val n = readInt
(1 to n) foreach {i =>
  println(s"Case #${i}: ${count(readLong)}")
}

