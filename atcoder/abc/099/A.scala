object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  println(if (N <= 999) "ABC" else "ABD")
}
