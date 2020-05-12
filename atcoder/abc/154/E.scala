object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.next
  val K = in.nextInt

  def count(i: Int, a: Array[Long]): Long = {
    if (i == N.size) a[K - 1]
    else {
      val d = N.charAt(i) - '0'
      val next = new Array[Long](K)
      for {
        k <- 0 until K
        d <- 0 to 9
      } {
        next[k] += a[0]
      }
    }
  }
}
