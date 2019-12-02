import scala.io.StdIn._
object Main extends App {
  val Array(n, m) = readLine.split(" ").map(_.toInt)
  val arr: Array[List[Int]] = Array.fill(n)(Nil)
  (0 until m).foreach { i =>
    val Array(a, b) = readLine.split(" ").map(_.toInt - 1)
    arr(a) = b :: arr(a)
    arr(b) = a :: arr(b)
  }
  arr.zipWithIndex.foreach { case (l, i) =>
    println(((l.flatMap(arr(_)).toSet - i) -- l).size)
  }
}

