object Main extends App {
  val in = new java.util.Scanner(System.in)
  val D, N = in.nextInt
  println(math.pow(100, D).toInt * (if (N == 100) 101 else N))
}
