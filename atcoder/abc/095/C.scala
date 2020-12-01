object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, C, X, Y = in.nextInt

  println(List(
    A * X + B * Y,
    C * (X * 2) + math.max(0, (Y - X) * B),
    C * (Y * 2) + math.max(0, (X - Y) * A)).min)
}
