object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, A, B = in.nextLong
  println(N / (A + B) * A + Math.min(N % (A + B), A))
}
