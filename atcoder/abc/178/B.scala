object Main extends App {
  val in = new java.util.Scanner(System.in)
  val a, b, c, d = in.nextLong
  println((a * c) max (a * d) max (b * c) max (b * d))
}
