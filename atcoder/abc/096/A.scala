object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B = in.nextInt
  println(if (A <= B) A else A - 1)
}
