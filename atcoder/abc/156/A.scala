object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, R = in.nextInt
  println(R + 100 * (10 - Math.min(10, N)))
}

