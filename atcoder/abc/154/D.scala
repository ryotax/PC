object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K = in.nextInt
  val Ps = Array.fill(N)(in.nextInt)
  val sums = (0 until N - K).scanLeft(Ps.take(K).sum)((z, i) => z - Ps(i) + Ps(K + i))
  println((sums.max.toDouble + K) / 2)
}
