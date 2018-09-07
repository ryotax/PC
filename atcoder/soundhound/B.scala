import scala.io.StdIn._
object Main extends App {
  val s = readLine
  val w = readLine.toInt
  println(s.zipWithIndex.withFilter(_._2 % w == 0).map(_._1).mkString)
}


