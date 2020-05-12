object Main extends App {
  val in = new java.util.Scanner(System.in)
  val H, W, N = in.nextInt
  val x = H max W
  println((N + x - 1) / x)
}
