import scala.io.StdIn._
object Main extends App {
  readLine
  val hs = readLine.split(" ").map(_.toInt)
  val possible = (hs.scanLeft(0){(pre, h) =>
    if (h < pre) -1
    else if (h == pre) h
    else h - 1
  }).forall(_ >= 0)

  println(if (possible) "Yes" else "No")
}
