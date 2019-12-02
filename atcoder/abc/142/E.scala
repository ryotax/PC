import scala.io.StdIn._

object Main extends App {
  type Cost = Int
  type Boxes = Int
  val Array(n, m) = readLine.split(" ").map(_.toInt)
  val boxPatterns = 1 << n
  val allKeys: Seq[(Cost, Boxes)] = (1 to m).map { i =>
    val Array(a, b) = readLine.split(" ").map(_.toInt)
    (a, readLine.split(" ").map(_.toInt).foldLeft(0){(z, bb) => z + (1 << (bb - 1))})
  }

  val Impossible = -1
  def dp(keys: List[(Cost, Boxes)], prev: Array[Int]): Int = {
    keys match {
      case Nil => prev(boxPatterns - 1)
      case (cost, boxes) :: ks =>
        val cur = new Array[Int](boxPatterns)
        (0 until boxPatterns).foreach { b =>
          cur(b) =
            if ((b & boxes) == 0) prev(b)
            else {
              (prev(b), prev(b - (b & boxes))) match {
                case (Impossible, Impossible) =>
                  if ((b | boxes) == boxes) cost
                  else Impossible
                case (Impossible, y) => y + cost
                case (x, Impossible) => Math.min(x, cost)
                case (x, y) => Math.min(x, y + cost)
              }
            }
        }
        dp(ks, cur)
    }
  }

  println(dp(allKeys.toList, Array.fill(boxPatterns)(Impossible)))
}
