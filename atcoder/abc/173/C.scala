object Main extends App {
  val in = new java.util.Scanner(System.in)
  val H, W, K = in.nextInt
  val grid = Array.fill(H)(in.next)

  def check(h: Int, w: Int): Boolean = {
    (for {
      hi <- 0 until H
      if ((1 << hi) & h) != 0
      wi <- 0 until W
      if ((1 << wi) & w) != 0
    } yield if (grid(hi).charAt(wi) == '#') 1 else 0).sum == K
  }

  println((for {
    h <- 0 until (1 << H)
    w <- 0 until (1 << W)
  } yield check(h, w)).count(_ == true))
}
