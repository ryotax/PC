object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K, M = in.nextInt
  val As = Array.fill(N - 1)(in.nextInt)
  println((M * N - As.sum) match {
    case s if s <= 0 => 0
    case s if s <= K => s
    case _ => -1
  })
}
