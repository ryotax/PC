object Main extends App {
  val n = scala.io.StdIn.readLong
  val target = ((1 to Math.sqrt(n).toInt).reverse find {n % _ == 0}).get
  println((n / target).toString.size)
}
