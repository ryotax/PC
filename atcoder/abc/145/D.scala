import scala.io.StdIn._
object Main extends App {
  val Array(x, y) = readLine.split(" ").map(_.toInt)
  val Mod = 1000000007
  if (((x + y) % 3 != 0) || (x * 2 < y || y * 2 < x)) {
    println(0)
  } else {
    val n = (x + y) / 3
    val r = x - n
    println(nCr(n, r))
  }

  def nCr(n: Int, r: Int): BigInt = {
    val m = (n - r + 1 to n).foldLeft(1L){(z, l) => z * l % Mod}
    val BIMod = BigInt(Mod)
    (BigInt(2) to BigInt(r)).foldLeft(BigInt(m)){(z, l) => l.modInverse(BIMod) * z % Mod}
  }
}
