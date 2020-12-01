object Main extends App {
  val in = new java.util.Scanner(System.in)
  val L, R, D = in.nextInt
  println((L to R).count(_ % D == 0))
}
