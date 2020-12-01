object Main extends App {
  val in = new java.util.Scanner(System.in)
  val X, Y, A, B = in.nextLong
  val threshold = B.toDouble / (A - 1)

  def takeA(x: Long, cnt: Int): (Long, Int) =
    if (x < threshold && x * A < Y) takeA(x * A, cnt + 1)
    else (x, cnt)

  val (mx, mc) = takeA(X, 0)
  println(mc + (Y - 1 - mx) / B)
}
