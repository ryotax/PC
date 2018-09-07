import scala.io.StdIn._
object Main extends App {
  val Array(n, k) = readLine.split(" ").map{_.toInt}

  a % b >= k

  b > k
    a = n * b + k  ～  n * b + (b - 1) => (n + 1) * (b - k)個

(k to n).map{a => 

  def count(b: Int, n: Int, k: Int): Int = {
    val patterns = n / b

  }

  val table: Map[Int, (Int, Int)] = ((0 until h).flatMap{y =>
    readLine.split(" ").zipWithIndex.map{case (v, x) => v.toInt -> (x, y)}
  }).toMap

  (1 to readLine.toInt).foreach{i =>
    val Array(l, r) = readLine.split(" ").map{_.toInt}
    println(((l to r by d).sliding(2).map{l =>
      val lPos = table(l.head)
      val rPos = table(l.last)
      Math.abs(lPos._1 - rPos._1) + Math.abs(lPos._2 - rPos._2)
    }).sum)
  }
}


