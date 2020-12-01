object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = List.fill(N)(in.nextLong)
  val sums = As.scanRight(0L)(_ + _)
  println(As.zip(sums.tail).foldLeft(0L){case (s, (l, sum)) => (s + sum % 1_000_000_007 * l) % 1_000_000_007})
}
