object Main extends App {
  val in = new java.util.Scanner(System.in)
  val H, N = in.nextInt
  val magics = Array.fill(N)((in.nextInt, in.nextInt))
  val dp = new Array[Int](H + 1)

  (1 to H).foreach{ i =>
    dp(i) = magics.map{ case (damage, mp) =>
      dp(Math.max(i - damage, 0)) + mp
    }.min
  }
  println(dp(H))
}
