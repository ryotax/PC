object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.next
  val k = N.size
  def canDiv(n: Int): Boolean = k > n && N.toSeq.combinations(k - n).exists(_.toString.toLong % 3 == 0)
  println((0 to 2).find(canDiv).getOrElse(-1))
}
