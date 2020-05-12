object Main extends App {
  val in = new java.util.Scanner(System.in)
  val K, N = in.nextInt
  val As = Array.fill(N)(in.nextInt)
  val max = As.zip(As.tail).foldLeft(As(0) + K - As(N - 1)){case (max, (l, r)) => math.max(r - l, max)}
  println(K - max)
}
