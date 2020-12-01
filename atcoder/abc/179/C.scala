object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  println((1 to N - 1).map((N - 1) / _).sum)
}
