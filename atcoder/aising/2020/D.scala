object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val X = BigInt(in.next, 2)
  
  def f(n: Int, cnt: Int): Int = {
    if (n == 0) cnt
    else f(n % Integer.bitCount(n), cnt + 1)
  }

  val bitOff = X.mod(X.bitCount + 1)
  val bitOn = X.mod(X.bitCount - 1)

  println(((N - 1 to 0 by -1).map {i =>
    if (X.testBit(i)) 
    (bits + (if (X.testBit(i)) -1 else 1)) match {
      case 0 => 0
      case newBits => f(X.flipBit(i).mod(newBits).toInt, 1)
    }
  }).mkString("\n"))
}
