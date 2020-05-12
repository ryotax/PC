object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  val As = Array.fill(M)(in.nextInt)
  println(N - As.sum match {
    case n if n < 0 => -1
    case n => n
  })
}
