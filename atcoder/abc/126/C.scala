import java.util.Scanner
import scala.math._
object Main extends App {
  val sc = new Scanner(System.in)
  val n, k = sc.nextInt
  val Ln2 = log(2)
  println(((1 to n).map {i =>
    val coins = ceil(log(k.toDouble / i) / Ln2).toInt
    if (coins > 0) 1 / pow(2, coins) else 1
  }).sum / n)
}
