object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K = in.nextInt
  val Hs = Array.fill(N)(in.nextLong).sorted
  println(Hs.take(N - K).sum)
}

