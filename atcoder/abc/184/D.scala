object Main extends App {
  val in = new java.util.Scanner(System.in)
  val X, Y, Z = in.nextInt

  val tbl = Array.tabulate[Double](101, 101, 101){case (x, y, z) =>
    if (x == 100 || y == 100 || z == 100) 0.0
    else -1.0
  }

  def calc(x: Int, y: Int, z: Int): Double = {
    val sum = x + y + z
    if (tbl(x)(y)(z) < 0) {
      tbl(x)(y)(z) = 
        x.toDouble / sum * (calc(x + 1, y, z) + 1) +
        y.toDouble / sum * (calc(x, y + 1, z) + 1) +
        z.toDouble / sum * (calc(x, y, z + 1) + 1)
    }
    tbl(x)(y)(z)
  }

  println(calc(X, Y, Z))
}
