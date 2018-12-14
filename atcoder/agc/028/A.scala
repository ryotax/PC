import scala.io.StdIn._
object Main extends App {
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def lcm(a: Int, b: Int): Int = a * b / gcd(a, b)

  val Array(sl, tl) = readLine.split(" ").map{_.toInt}
  val s, t = readLine
  val lcmValue= lcm(sl, tl)

  def judge(xl: Int): Boolean = {
    val lsl = xl / sl
    val ltl = xl / tl
    val llcm = lcm(lsl, ltl)
    (llcm to xl by llcm).forall(i => s.charAt(i / lsl + 1) == t.charAt(i / ltl + 1))
  }

  val result: Int =
    if (tl % sl == 0 || sl % tl == 0) {
      if (judge(lcmValue)) lcmValue else -1
    } else (lcmValue to (sl * tl) by lcmValue).find(judge).getOrElse(-1)
  println(result)
}
