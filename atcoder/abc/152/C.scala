object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val Ps = Array.fill(N)(in.nextInt)
  val (_, count) = Ps.foldLeft((N + 1, 0)){ case ((min, count), i) =>
    if (i < min) (i, count + 1) else (min, count)
  }
  println(count)
}
