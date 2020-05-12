object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  println((1 to N).filterNot(i => i % 3 == 0 || i % 5 == 0).foldLeft(0L)(_ + _))
}
