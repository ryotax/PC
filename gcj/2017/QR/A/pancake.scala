import scala.io.StdIn._

def count(line: String): String = {
  val Array(s, k) = line.split(" ")
  val row = (s map {c => if (c == '-') false else true}).toArray
  val range = k.toInt

  @scala.annotation.tailrec
  def flip(row: Array[Boolean], pos: Int, flips: Int): String = {
    if (pos + range > row.size) {
      if ((0 until range - 1) forall {i => row(pos + i)}) flips.toString
      else "IMPOSSIBLE"
    } else {
      if (row(pos)) flip(row, pos + 1, flips)
      else {
        (0 until range) foreach {i => row(pos + i) = !row(pos + i)}
        flip(row, pos + 1, flips + 1)
      }
    }
  }
  flip(row, 0, 0)
}

val n = readInt
(1 to n) foreach {i =>
  println(s"Case #${i}: ${count(readLine)}")
}

