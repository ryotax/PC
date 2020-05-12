object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B = in.nextInt
  println((1 to 1000).find(n => (n * 0.08).toInt == A && (n * 0.1).toInt == B).getOrElse(-1))
}
