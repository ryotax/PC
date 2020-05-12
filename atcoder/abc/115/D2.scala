object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val X = in.nextLong

  val ls = (1 to N).scanLeft(1L)((z, i) => z * 2 + 3).toArray
  val ps = (1 to N).scanLeft(1L)((z, i) => z * 2 + 1).toArray

  def count(l: Int, eat: Long): Long = {
    if (l == 0) (if (eat <= 0) 0 else 1)
    else if (eat <= 1 + ls(l - 1)) count(l - 1, eat - 1)
    else ps(l - 1) + 1 + count(l - 1, eat - ls(l - 1) - 2)
  }

  println(count(N, X))
}
