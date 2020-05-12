object Main extends App {
  val in = new java.util.Scanner(System.in)
  val a, b = in.nextInt
  println(if (b / a * a == b) a + b else b - a)
}
