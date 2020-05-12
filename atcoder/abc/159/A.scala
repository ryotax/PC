object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  println((N * (N - 1) + M * (M - 1)) / 2)
}
