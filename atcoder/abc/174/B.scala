object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, D = in.nextInt
  val Ps = Array.fill(N)((in.nextLong, in.nextLong))
  val sq = D.toLong * D

  println(Ps.count{case (x, y) => x * x + y * y <= sq})
}
