import scala.io.StdIn._
object Main extends App {
  val Array(t1, t2), Array(a1, a2), Array(b1, b2) = readLine.split(" ").map(_.toLong)
  val la1 = a1 * t1
  val la2 = a2 * t2
  val lb1 = b1 * t1
  val lb2 = b2 * t2
  val (f1, f2, s1, s2) = if (la1 + la2 > lb1 + lb2) (la1, la2, lb1, lb2) else (lb1, lb2, la1, la2)

  println(
    if (f1 + f2 == s1 + s2) "infinity"
    else if (f1 > s1) 0
    else {
      val diff1 = s1 - f1
      val diff = f1 + f2 - s1 - s2
      if (diff1 % diff == 0) diff1 / diff * 2 else diff1 / diff * 2 + 1
    })
}
