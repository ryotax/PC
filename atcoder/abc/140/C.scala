import scala.io.StdIn._

object Main extends App {
  readLine
  val arr = readLine.split(" ").map(_.toInt)
  println(arr.head + arr.zip(arr.tail).map{case (l, r) => Math.min(l, r)}.sum + arr.last)
}
