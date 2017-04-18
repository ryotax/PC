// import scala.io.StdIn._
@scala.annotation.tailrec
def exec(cur: String, remain: String): String = {
  if (remain.isEmpty) cur
  else {
    exec(remain.head match {
      case s if cur.head > s => cur + s.toString
      case s                  => s.toString + cur
    }, remain.tail)
  }
}

val n = readInt
(1 to n) foreach {i =>
  val s = readLine
  println(s"Case #${i}: ${exec(s.head.toString, s.tail)}")
}



