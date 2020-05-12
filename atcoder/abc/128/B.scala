import scala.io.StdIn._
object Main extends App {
  val rs = (Array.tabulate(readInt){i =>
    val Array(name, score) = readLine.split(" ")
    (name, -score.toInt, i + 1)
  }).sorted

  println(rs.map(_._3).mkString("\n"))
}
