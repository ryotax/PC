object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  val Hs = Array.fill(N)(in.nextInt).sorted
  val Ws = Array.fill(M)(in.nextInt).sorted
  def diff(i: Int, j: Int) = math.abs(i - j)
  def diffBest(t: Int, i: Int): Int = {
    if (i == Ws.size - 1) i
    else if (diff(t, Ws(i)) < diff(t, Ws(i + 1))) i
    else diffBest(t, i + 1)
  }

  val g0 = 0 +: Hs.grouped(2).toArray.init.map(a => diff(a(0), a(1)))
  val g1 = 0 +: Hs.tail.grouped(2).toArray.map(a => diff(a(0), a(1)))

  def next(min: Int, prevWithoutMe: Int, i: Int, wi: Int): Int = {
    if (i == N / 2 + 1) min
    else {
      val bestWi = diffBest(Hs(i * 2), wi)
      val mine = diff(Hs(i * 2), Ws(bestWi))
      val withoutMe = prevWithoutMe - g1(i) + g0(i)
      next(math.min(min, withoutMe + mine), withoutMe, i + 1, bestWi)
    }
  }

  println(next(Int.MaxValue, g1.sum, 0, 0))
}
