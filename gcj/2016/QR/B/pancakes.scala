// import scala.io.StdIn._
def count(s: String) = s.split("(?<=(.))(?!\\1)").size + (if (s.last == '-') 0 else -1)

val n = readInt
(1 to n) foreach {i =>
  println(s"Case #${i}: ${count(readLine)}")
}


