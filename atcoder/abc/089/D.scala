import scala.io.StdIn._
object Main extends App {
  val Array(h, w, d) = readLine.split(" ").map{_.toInt}
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
