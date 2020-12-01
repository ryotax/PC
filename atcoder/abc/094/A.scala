object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, X = in.nextInt
  println(if (A <= X && X <= A + B) "YES" else "NO")
}

