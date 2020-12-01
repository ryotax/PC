object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = Array.fill(N)(in.nextInt)

  def findMax(i: Int, sum: Long, pre: Long, max: Long, lineMax: Long): Long = {
    if (i == As.size) max
    else {
      val cur = pre + As(i)
      findMax(i + 1, sum + cur, cur, List(max, sum + cur, sum + lineMax).max, List(lineMax, cur).max)
    }
  }

  println(findMax(0, 0, 0, 0, 0))
}
