import scala.io.StdIn._

object Main extends App {
  readLine
  println(readLine.split(" ").map(_.toInt).zipWithIndex.sortBy(_._1).map(_._2 + 1).mkString(" "))
}
