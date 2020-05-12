object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n, k = in.nextInt
  val tds = Array.fill(n)((in.nextInt, in.nextInt)).sortBy(_._2).reverse
  val qs = Array.fill(n + 1)(new PriorityQueue[Int]())
  val (sel, not) = tds.splitAt(k)

  def count(l: List[(Int, Int)], dels: Long, types: Long): (Long, Long) = l match {
    case Nil => (dels, types)
    case (t, d) :: xs =>
      val newTypes = types + (if (qs(t).isEmpty) 1 else 0)
      qs(t) ++= d
      count(xs, dels + d, newTypes)
  }

  val (dels, types) = count(sel, 0, 0)

}
