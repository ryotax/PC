object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B = in.nextInt
  val n = B - A
  println((1 + n) * n / 2 - B)
}
