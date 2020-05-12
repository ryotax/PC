object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n = in.nextInt
  val k = in.nextLong
  val as = Array.fill(n)(in.nextLong)

  def calcBit(i: Int): Long = {
    val target = 1L << i
    if (as.count(j => (j & target) != 0) > n / 2) 0L else target
  }

  val op = (40 to 0 by -1).foldLeft(0L){(z, i) =>
    (z + calcBit(i)) match {
      case v if v > k => z
      case v => v
    }
  }

  println(as.foldLeft(0L)((z, i) => z + (i ^ op)))
}
