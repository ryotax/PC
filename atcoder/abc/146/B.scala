import scala.io.StdIn._
object Main extends App {
  val n = readInt
  println(readLine.map{c => ('A' + (c - 'A' + n) % 26).toChar})
}

