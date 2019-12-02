import scala.io.StdIn._

object Main extends App {
  readLine
  println(readLine.replaceAll("(.)\\1*", "$1").size)
}
