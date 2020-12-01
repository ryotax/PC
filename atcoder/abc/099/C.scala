object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt

  val dp = Array.tabulate(N + 1)(identity)

  def seq(i: Int): LazyList[Int] = i #:: seq(i).map(_ * i)

  def doDp(i: Int): Unit = {
    for {
      u <- seq(i).takeWhile(_ <= N)
      n <- 1 to i
      i <- 0 to (N - n * u)
    } {
      dp(i + n * u) = dp(i + n * u) min (dp(i) + n)
    }
  }

  doDp(6)
  doDp(9)
  println(dp(N))
}
