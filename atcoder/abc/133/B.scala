import scala.io.StdIn._
object Main extends App {
  case class Point(cs: Array[Int]) {
    def isIntDistance(p: Point): Boolean = {
      val sum = cs.zip(p.cs).map{case (c1, c2) => (c1 - c2) * (c1 - c2)}.sum
      val sqrt = Math.sqrt(sum).toInt
      sqrt * sqrt == sum
    }
  }

  val Array(n, d) = readLine.split(" ").map(_.toInt)
  val ps = Array.fill(n)(Point(readLine.split(" ").map(_.toInt)))

  println((0 until n - 1).foldLeft(0){(z, i) =>
    z + (i + 1 until n).count(j => ps(i).isIntDistance(ps(j)))
  })
}
