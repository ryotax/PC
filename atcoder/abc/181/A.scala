object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  println(if (N % 2 == 1) "Black" else "White")
}
