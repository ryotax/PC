object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, X, T = in.nextInt
  println((N + X - 1) / X * T)
}

