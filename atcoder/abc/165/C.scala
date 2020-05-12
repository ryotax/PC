object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M, Q = in.nextInt
  val Qs = Array.fill(Q)((1 to 4).map(_ => in.nextInt).toArray)

  def enumerate(ar: Array[Array[Int]]): Array[Array[Int]] =
    if (ar.head.size == N) ar
    else enumerate(ar.flatMap(a => (a.last to M).map(a.appended(_))))

  val seqs = enumerate((1 to M).map(i => Array(i)).toArray)

  println(seqs.map{s =>
    Qs.map{case Array(a, b, c, d) => if (s(b - 1) - s(a - 1) == c) d else 0}.sum
  }.max)
}
