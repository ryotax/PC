object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val S = in.next.toSeq

  val sizes = (1 until N).map {i =>
    val (l, r) = S.splitAt(i)
    l.distinct.intersect(r.distinct).size
  }
  println(sizes.max)
}
