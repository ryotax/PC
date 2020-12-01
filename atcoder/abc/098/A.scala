object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B = in.nextInt

  println((A + B) max (A - B) max (A * B))
}
