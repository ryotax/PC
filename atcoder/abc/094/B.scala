object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M, X = in.nextInt
  val As = Array.fill(M)(in.nextInt)
  println(math.min(As.count(_ < X), As.count(_ > X)))
}
