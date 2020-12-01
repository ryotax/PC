object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = Array.fill(N)(in.nextLong)

  def check(l: Int, r: Int, cur: Long, cnt: Long): Long = {
    if (r == N) cnt + (r - l).toLong * (r - l + 1) / 2
    else {
      if ((cur & As(r)) == 0) check(l, r + 1, cur + As(r), cnt)
      else check(l + 1, r, cur - As(l), cnt + r - l)
    }
  }

  println(check(0, 0, 0, 0))
}
