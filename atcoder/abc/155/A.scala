object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, C = in.nextInt
  val result =
    (A == B && B != C) ||
    (B == C && C != A) ||
    (C == A && A != B)

  println(if (result) "Yes" else "No")
}

