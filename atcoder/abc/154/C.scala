object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = Array.fill(N)(in.nextInt)
  println(if (As.toSet.size == N) "YES" else "NO")
}

