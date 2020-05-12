object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, K = in.nextLong

  val newA = math.max(A - K, 0)
  val newB = math.min(B, math.max(B - (K - A), 0))
  println(s"$newA $newB")
}
