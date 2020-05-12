object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val a, b = sc.nextLong

  def xor(l: Long): Long =
    if (l % 2 == 0) (l / 2) % 2 + l
    else ((l + 1) / 2) % 2

  println(xor(a - 1) ^ xor(b))
}
