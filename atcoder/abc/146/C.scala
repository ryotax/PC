import scala.io.StdIn._
object Main extends App {
  val Array(a, b, x) = readLine.split(" ").map(_.toLong)

  println((1 to 9).find(i => a * Math.pow(10, i) + b * (i + 1) > x) match {
    case None => 1000000000
    case Some(c) => Math.min((x - b * c) / a, Math.pow(10, c).toLong - 1)
  })
}
