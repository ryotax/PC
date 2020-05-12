object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K = in.nextInt
  val Hs = Array.fill(N)(in.nextInt).sorted

  println((0 to N - K).map(i => Hs(i + K - 1) - Hs(i)).min)
}
