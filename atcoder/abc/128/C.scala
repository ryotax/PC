import scala.io.StdIn._
object Main extends App {
  val Array(n, m) = readLine.split(" ").map(_.toInt)
  val lights = Array.fill(m)(readLine.split(" ").tail.map(_.toInt - 1))
  val conds = readLine.split(" ").map(_.toInt).zip(lights)

  def checkStatus(s: Int): Boolean = {
    def checkLight(cond: (Int, Array[Int])): Boolean = {
      cond._2.count(l => ((1 << l) & s) != 0) % 2 == cond._1
    }
    conds.forall(checkLight)
  }

  println((0 until (1 << n)).count(checkStatus))
}
