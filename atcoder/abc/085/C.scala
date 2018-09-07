import scala.io.StdIn._
object Main extends App {
  val Array(n, y) = readLine.split(" ").map{_.toInt}
  val results = for {
    man <- 0 to n
    gosen <- 0 to (n - man) if man * 10000 + gosen * 5000 + (n - man - gosen) * 1000 == y
  } yield s"${man} ${gosen} ${n - man - gosen}"
  println(results.headOption.getOrElse("-1 -1 -1"))
}
