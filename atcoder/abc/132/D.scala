import scala.io.StdIn._
import scala.collection.mutable.{HashMap => MMap}
import java.io.PrintWriter
object Main extends App {
  val Mod = 1000000007L
  val map = new MMap[(Int, Int), Long]
  val Array(n, b) = readLine.split(" ").map(_.toInt)

  val invs = new Array[Long](n + 1)
  invs(1) = 1
  (2 to n).foreach {i =>
    invs(i) = Mod - (Mod / i) * invs((Mod % i).toInt) % Mod
  }

  val r = n - b
  def nCk(n: Int, k: Int): Long = {
    map.getOrElse((n, k), {
      val numer = (n - k + 1 to n).foldLeft(1L)((z, i) => z * i % Mod)
      (2 to k).foldLeft(numer)((z, i) => invs(i) * z % Mod)
    })
  }

  val pw = new PrintWriter(System.out)
  for (i <- 1 to b) {
    pw.println(nCk(r + 1, i) * nCk(b - 1, i - 1) % Mod)
  }
  pw.flush()
}
