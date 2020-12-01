object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, W = in.nextInt
  val T = new Array[Long](200_001)
  (1 to N).foreach {i =>
    val s, t, p = in.nextInt
    T(s) += p
    T(t) -= p
  }
  println(if (T.scanLeft(0L)(_ + _).forall(_ <= W)) "Yes" else "No")
}
