object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K, R, S, P = in.nextInt
  val T = in.next

  case class Rsp(r: Int, s: Int, p: Int)

  def score(i: Int, pre: Rsp): Int = {
    if (i >= N) pre.r max pre.s max pre.p
    else {
      val cur = curScore(i)
      score(i + K, Rsp(
        math.max(pre.s + cur.r, pre.p + cur.r),
        math.max(pre.r + cur.s, pre.p + cur.s),
        math.max(pre.r + cur.p, pre.s + cur.p)))
    }
  }

  def curScore(i: Int): Rsp = T.charAt(i) match {
    case 'r' => Rsp(0, 0, P)
    case 's' => Rsp(R, 0, 0)
    case 'p' => Rsp(0, S, 0)
  }

  println((0 until K).map(i => score(i + K, curScore(i))).sum)
}
