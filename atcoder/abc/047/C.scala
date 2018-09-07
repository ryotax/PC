import scala.io.StdIn._
object Main extends App {
  println(readLine.split("((?<=B)(?=W)|(?<=W)(?=B))").size - 1)
}
