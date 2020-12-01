object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = Array.fill(N)(in.nextInt)
  def gcd(l: Int, r: Int): Int = if (l % r == 0) r else gcd(r, l % r)
  println(As.reduceLeft(gcd))
}
