object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, C, K = in.nextInt

  def twice(n: Int, cnt: Int = K): Int = if (cnt == 0) n else twice(n * 2, cnt - 1)
  println((twice(A) + B + C) max (A + twice(B) + C) max (A + B + twice(C)))
}

