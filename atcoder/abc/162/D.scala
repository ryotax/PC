object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val S = in.next
  val nR = S.count(_ == 'R')
  val nG = S.count(_ == 'G')
  val nB = N - nR - nG

  @inline 
  def c(i: Int) = S.charAt(i)

  val un = (for {
    i <- 0 to N - 3
    j <- i + 1 to N - 2 if 2 * j - i < N
  } yield if (c(i) != c(j) && c(i) != c(2 * j - i) && c(j) != c(2 * j - i)) 1 else 0).sum

  println(nR.toLong * nG * nB - un)
}


