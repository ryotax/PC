object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K = in.nextInt
  val T = Array.fill(N)(Array.fill(N)(in.nextInt))

  println((1 until N).permutations.count{route =>
    (0 +: route :+ 0).sliding(2).map(r => T(r.head)(r.last)).sum == K
  })
}
