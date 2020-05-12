object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val counts = Array.ofDim[Int](10, 10)

  (1 to N).map { i =>
    val s = i.toString
    counts(s.head - '0')(s.last - '0') += 1
  }

  println((for {
    i <- 1 to 9
    j <- 1 to 9
  } yield counts(i)(j) * counts(j)(i)).sum)
}
