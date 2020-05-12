object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K = in.nextLong
  val mod = N % K
  println(mod min K - mod)
}
