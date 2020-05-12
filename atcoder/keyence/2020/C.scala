object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K, S = in.nextInt
  val nS = if (S == 1000000000) S - 1 else S + 1
  println((Array.fill(K)(S) ++ Array.fill(N - K)(nS)).mkString(" "))
}
