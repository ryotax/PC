object Main extends App {
  val in = new java.util.Scanner(System.in)
  val a, b, q = in.nextInt
  val Max = 10000000000L
  val ss = (-2 * Max) +: Array.fill(a)(in.nextLong) :+ (3 * Max)
  val ts = (-2 * Max) +: Array.fill(b)(in.nextLong) :+ (3 * Max)
  val xs = Array.fill(q)(in.nextLong)

  def search(a: Array[Long], l: Int, r: Int, x: Long): (Long, Long) = {
    val m = (l + r) / 2
    if (x < a(m)) search(a, l, m, x)
    else if (x >= a(m + 1)) search(a, m, r, x)
    else (x - a(m), a(m + 1) - x)
  }

  println(xs.map{x =>
    val (sl, sr) = search(ss, 0, ss.size, x)
    val (tl, tr) = search(ts, 0, ts.size, x)
    Array(
      sl max tl,
      sr max tr,
      sl * 2 + tr,
      tl * 2 + sr,
      sl + tr * 2,
      tl + sr * 2).min
  }.mkString("\n"))
}
