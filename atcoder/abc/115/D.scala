object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val X = in.nextLong
  val lStream: Stream[Long] = 1L #:: lStream.map(_ * 2 + 3)
  val ls = lStream.take(N + 1).toArray
  val pStream: Stream[Long] = 1L #:: pStream.map(_ * 2 + 1)
  val ps = pStream.take(N + 1).toArray

  def count(l: Int, eat: Long): Long = {
    lazy val ll = ls(l - 1)
    if (eat == 1) (if (l == 0) 1 else 0)
    else if (eat <= 1 + ll) count(l - 1, eat - 1)
    else if (eat == 1 + ll + 1) ps(l - 1) + 1
    else if (eat <= 1 + ll + 1 + ll) ps(l - 1) + 1 + count(l - 1, eat - ll - 2)
    else ps(l - 1) * 2 + 1
  }

  println(count(N, X))
}
