object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  def mod(l: Long) = l % 1_000_000_007

  def calc(i: Int, both: Long, either: Long, neither: Long): Int =
    if (i == N) both.toInt
    else calc(i + 1, mod(both * 10 + either), mod(either * 9 + neither * 2), mod(neither * 8))

  println(calc(1, 0, 2, 8))
}
