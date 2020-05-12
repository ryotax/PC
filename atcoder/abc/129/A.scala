import scala.io.StdIn._
object Main extends App {
  val ts = readLine.split(" ").map(_.toInt)
  println(ts.sum - ts.max)
}
