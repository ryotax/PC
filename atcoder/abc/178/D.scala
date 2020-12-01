object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.nextInt

  def calc(i: Int, p1: Int, p2: Int, p3:Int): Int = {
    val cur = (p1 + p3) % 1_000_000_007
    if (i == S) cur else calc(i + 1, cur, p1, p2)
  }

  println(if (S == 1 || S == 2) 0 else calc(3, 0, 0, 1))
}
