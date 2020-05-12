import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextInt
  val as = Array.fill(n)(sc.nextInt)
  def gcd(l: Int, r: Int): Int = if (r == 0) l else if (l % r == 0) r else gcd(r, l % r)
  val gcdsL = as.scanLeft(0)((z, a) => gcd(z, a))
  val gcdsR = as.scanRight(0)((a, z) => gcd(z, a))
  println(gcdsL.zip(gcdsR.tail).map(z => gcd(z._1, z._2)).max)
}
