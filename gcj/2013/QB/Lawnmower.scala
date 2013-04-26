import scala.io.Source
import scala.annotation.tailrec

val input = Source.fromFile("B-small-attempt.in")
                  .getLines
                  .toList
                  .tail

exec(1, input)

@tailrec
def exec(i: Int, list: List[String]) {
  val rows = list.head.split(" ")(0).toInt
  val (cur, next) = list.tail.splitAt(rows)
  println("Case #" + i + ": " + (if (judge(cur)) "YES" else "NO"))

  if (next.size >= 2) {
    exec(i + 1, next)
  }
}

def judge(sLawn: List[String]): Boolean = {
  val lawn: Array[Array[Int]] = sLawn.toArray.map(_.split(" ").map(_.toInt))
  for (n <- 0 until lawn.size; m <- 0 until lawn(0).size) {
    val cur = lawn(n)(m)
    if (lawn(n).exists(_ > cur) && lawn.map(_(m)).exists(_ > cur)) {
      return false
    }
  }
  return true
}
