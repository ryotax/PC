object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B = in.nextInt
  println(if (A <= 8 && B <= 8) "Yay!" else ":(")
}
