object Main extends App {
  val in = new java.util.Scanner(System.in)
  val K = in.nextInt

  def calc(k: Int, r: Int = 1, cnt: Int = 1): Int = {
    val newR = r * 10 % k
    if (newR == 1) cnt
    else calc(k, newR, cnt + 1)
  }

  println(
    if (K % 2 == 0 || K % 5 == 0) -1
    else if (K % 7 == 0) calc(9 * K / 7)
    else calc(9 * K)
  )
}
