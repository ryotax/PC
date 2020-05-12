object Main extends App {
  val in = new java.util.Scanner(System.in)
  val H, W, K = in.nextInt

  val fibList: Stream[Int] = 1 #:: 1 #:: fibList.zip(fibList.tail).map(t => t._1 + t._2)
  def fib(i: Int): Int = if (i < 0 || W - 1 < i) 1 else fibList(i)
  val Mod = 1000000007

  def next(step: Int, counts: Array[Long]): Array[Long] = {
    if (step == H) counts
    else {
      val nextCounts = Array.fill(W)(0L)
      (0 until W).foreach {i =>
        if (i > 0)     nextCounts(i - 1) += counts(i) * fib(i - 1) * fib(W - i - 1)
                       nextCounts(i    ) += counts(i) * fib(i - 0) * fib(W - i - 1)
        if (i < W - 1) nextCounts(i + 1) += counts(i) * fib(i - 0) * fib(W - i - 2)
      }
      next(step + 1, nextCounts.map(_ % Mod))
    }
  }

  println(next(0, Array.tabulate(W)(i => if (i == 0) 1L else 0L))(K - 1))
}
