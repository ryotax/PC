object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val counts = Array.fill(N + 1)(0L)
  val As = Array.fill(N)(in.nextInt)
  As.foreach(a => counts(a) += 1)
  val sum = counts.map(c => c * (c - 1) / 2).sum
  println(As.map(a => sum - counts(a) + 1).mkString("\n"))
}

