object Main extends App {
  val in = new java.util.Scanner(System.in)
  val X, K, D = in.nextLong
  val x = math.abs(X)
  val n = x / D
  val r = x % D

  println(
    if (n >= K) x - K * D
    else {
      if ((K - n) % 2 == 1) D - r
      else r
    }
  )
}
