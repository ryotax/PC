object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val robots = Array.fill(N)((in.nextInt, in.nextInt)).sortBy(_._1)

  val (_, cnt) = robots.foldLeft((Int.MinValue, 0)){case ((right, count), (pos, len)) =>
    if (right <= pos - len) (pos + len, count)
    else (Math.min(right, pos + len), count + 1)
  }
  println(N - cnt)
}
