object Main extends App {
  val in = new java.util.Scanner(System.in)
  val X = in.nextInt
  println(X / 500 * 1000 + X % 500 / 5 * 5)
}
