object Main extends App {
  val in = new java.util.Scanner(System.in)
  val K = in.nextInt
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val gcds = for {
    a <- 1 to K
    b <- 1 to K
    c <- 1 to K
  } yield gcd(gcd(a, b), c)

  println(gcds.sum)
}
