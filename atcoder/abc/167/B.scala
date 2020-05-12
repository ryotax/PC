object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, C, K = in.nextInt
  println(
    if (K <= A) K
    else if (K <= A + B) A
    else A - (K - A - B)
  )
}
