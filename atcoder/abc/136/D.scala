import scala.io.StdIn._
object Main extends App {
  def count(rl: String): Array[Int] = {
    val Array(r, l) = rl.split("(?=L)", 2).map(_.size)
    val ret = new Array[Int](rl.size)
    ret(r - 1) = (r + 1) / 2 + l / 2
    ret(r) = r / 2 + (l + 1) / 2
    ret
  }

  println(readLine.split("(?=R)(?<=L)").flatMap(count).mkString(" "))
}
