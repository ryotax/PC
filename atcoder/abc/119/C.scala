import scala.math.abs
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n, A, B, C = in.nextInt
  val ls = Array.fill(n)(in.nextInt)

  def dfs(i: Int, a: Int, b: Int, c: Int): Int = {
    if (i == n) {
      if (a == 0 || b == 0 || c == 0) 100000000
      else abs(A - a) + abs(B - b) + abs(C -c) - 30
    } else {
      Array(
        dfs(i + 1, ls(i) + a, b, c) + 10,
        dfs(i + 1, a, ls(i) + b, c) + 10,
        dfs(i + 1, a, b, ls(i) + c) + 10,
        dfs(i + 1, a, b, c)).min
    }
  }

  println(dfs(0, 0, 0, 0))
}
