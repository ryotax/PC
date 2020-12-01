object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val Xs = Array.fill(N)(in.nextInt)
  val sorted = Xs.sorted

  println(
    (0 until N).map { i =>
      if (Xs(i) < sorted(N / 2)) sorted(N / 2) else sorted(N / 2 - 1)
    }.mkString("\n"))
}
