object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, N = in.nextLong
  val x = (N + 1) / B * B - 1 match {
    case x if x > 0 => x
    case _ => N
  }
  println(A * x / B - A * (x / B))
}


