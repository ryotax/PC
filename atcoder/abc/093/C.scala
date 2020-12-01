object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, C = in.nextInt

  def count(a: Int, b: Int, c: Int, cnt: Int): Int = {
    val List(s, m, l) = List(a, b, c).sorted
    if (s == m && m == l) cnt
    else if (l > m) count(s + 1, m + 1, l, cnt + 1)
    else count(s + 2, m, l, cnt + 1)
  }

  println(count(A, B, C, 0))
}
