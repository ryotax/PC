import scala.io.StdIn._
object Main extends App {
  val Array(l, r) = readLine.split(" ").map(_.toLong)
  val is = l to Math.min(r - 1, l + 2019)
  println(is.foldLeft(Long.MaxValue){(min, i) =>
    val js = i + 1 to Math.min(r, i + 2020)
    js.foldLeft(min){(minmin, j) =>
      println(s"$i, $j, $minmin")
      Math.min(minmin, i * j % 2019)
    }
  })
}
