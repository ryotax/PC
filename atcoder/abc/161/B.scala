object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  val As = Array.fill(N)(in.nextInt).sorted.reverse
  println(if (As.take(M).last * 4 * M >= As.sum) "Yes" else "No")
}

