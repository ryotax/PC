object Main extends App {
  val in = new java.util.Scanner(System.in)
  val a, b = in.nextLong
  def gcd(l: Long, r: Long): Long = if (r == 0) l else if (l % r == 0) r else gcd(r, l % r)
  println(a * b / gcd(a, b))
}
