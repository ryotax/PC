object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B = in.nextInt
  println(if (A < B) A.toString * B else B.toString * A)
}
