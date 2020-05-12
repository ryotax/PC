object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n = in.nextInt
  val as = Array.fill(n)(in.nextInt)
  def gcd(l: Int, r: Int): Int = if (r == 0) l else gcd(r, (l % r))
  println(as.reduceLeft(gcd))
}
