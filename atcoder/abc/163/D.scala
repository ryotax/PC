object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K = in.nextInt
  val Mod = 1_000_000_007
  def sum(min: Long, max: Long): Long = (min + max) * (max - min + 1) / 2
  val ans = (K to N + 1).foldLeft(0L){(s, k) =>
    (s + sum(N + 1 - k, N) - sum(0, k - 1) + 1) % Mod
  }
  println(ans)
}

